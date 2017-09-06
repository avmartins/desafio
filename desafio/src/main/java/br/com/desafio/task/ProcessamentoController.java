package br.com.desafio.task;

import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.desafio.entity.ItemVenda;
import br.com.desafio.entity.Processamento;
import br.com.desafio.entity.Venda;
import br.com.desafio.service.ProcessamentoManager;
import br.com.desafio.service.VendaManager;
import br.com.desafio.util.Constantes;
import br.com.desafio.util.DateUtils;
import br.com.desafio.util.ExporterUtils;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ProcessamentoController {

    private static final Logger LOGGER = Logger.getLogger(ProcessamentoController.class.getName());
    
    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 60;
    
    @Autowired(required=true)
	private ProcessamentoManager processamentoManager;
	
	@Autowired(required=true)
	private VendaManager vendaManager;

    @Value("c:\\processados")
    private String OUTPUT_PATH;

    private static final String MASK_FILE = "%s_out_sale_%s.txt";

    static AtomicInteger fileNameCount = new AtomicInteger(1);
   
    @Scheduled(fixedDelay=6000)
    public void doPerformAction() {

    	if (OUTPUT_PATH == null || OUTPUT_PATH.equals("")) {
            try {
                OUTPUT_PATH = Constantes.URL_WINDOWS;
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Fechando a apliccação...", ex);
                System.exit(0);
            }
        }

        Long currentLine = 0l;

        try {
        	
            ItemVenda item = (ItemVenda)vendaManager.getAllItemVendas(Constantes.NPROCESSADO).get(0);

            if (item == null){
                LOGGER.log(Level.INFO, "Não Existe dados para processar...");
                return ;
            }

            List<ItemVenda> itens = vendaManager.getAllItemVendas(item.getVendaId());

            StringBuilder fileNames = new StringBuilder();

            String fileName = getFileName(fileNameCount.get());

            fileNames.append(fileName);

            if (Files.exists(Paths.get(fileName), LinkOption.NOFOLLOW_LINKS)){
                currentLine = Files.lines(Paths.get(fileName)).count();
            }
            LOGGER.log(Level.INFO, " O arquivo {0} contem {1} linhas.", new Object [] {fileName, currentLine});

            FileOutputStream outputStream = createOrOpenFileName(fileNameCount, false);

            if (currentLine == 10) {
                LOGGER.log(Level.INFO, "O Arquivo comtém {0} linhas. Creando o arquivo. ", 10);
                outputStream = createOrOpenFileName(fileNameCount, true);
            }

            for (int i = 0; i < itens.size(); i++) {

                outputStream.write(writeLine(itens.get(i)));
                currentLine++;

                LOGGER.log(Level.INFO,"Resultado {0} corrente linha atual % 10 :{1} ", new Object [] {currentLine, currentLine % 10});
                if (currentLine % 10 == 0){
                    LOGGER.log(Level.INFO,"Linhas {0} de arquivo conseguidas. Criando um novo arquivo.", 10);
                    outputStream.close();
                    outputStream  = createOrOpenFileName(fileNameCount,true);

                    fileNames.append(",").append(getFileName(fileNameCount.get()));

                    currentLine = 0L;
                }

            }

            outputStream.close();

            FechandoVenda(item.getVendaId(), fileNames.toString());


        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

    }

    private String getFileName(int i) {
        String maskedFileName = String.format(MASK_FILE, DateUtils.toYYYYMMDDDateFormat(), i);
        String fileName= String.format(OUTPUT_PATH + File.separator + maskedFileName);
        return fileName;
    }

    private FileOutputStream createOrOpenFileName(AtomicInteger fileNameCount, boolean newFile) throws FileNotFoundException {

        int count= fileNameCount.get();

        if (newFile){
            count = fileNameCount.incrementAndGet();
        }


        String fileName = getFileName(count);

        LOGGER.log(Level.INFO, "Abre o arquivo {0} para edição", fileName);

        FileOutputStream outputStream = new FileOutputStream(fileName, true);//Creating a new file
        return outputStream;
    }

    private boolean checkItemVenda(ItemVenda item) {
        if (item == null) {
            LOGGER.log(Level.INFO, "Não existe item de saída");
            return true;
        }
        return false;
    }

    private byte[] writeLine(ItemVenda item) {
        Venda venda = vendaManager.getVenda(item.getItemVendaId());

        StringBuilder tmp = new StringBuilder();

        tmp.append(ExporterUtils.doLPADZero(venda.getId(), 10));
        tmp.append(ExporterUtils.toDateString(venda.getData(), ExporterUtils.FORMATTER.DDMMYYYY));
        tmp.append(ExporterUtils.doLPADZero(venda.getLoja(), 4));
        tmp.append(ExporterUtils.doLPADZero(venda.getPdv(), 3));
        tmp.append(ExporterUtils.doRPAD(item.getProduto(), 10));
        tmp.append(ExporterUtils.doLPADZero(item.getPrecoUnitario(), 5, 2));
        tmp.append(ExporterUtils.doLPADZero(item.getValorDesconto(), 5, 2));
        tmp.append(ExporterUtils.doLPADZero(item.getValorTotal(), 5, 2));
        tmp.append("\n");

        return tmp.toString().getBytes();

    }

    public void FechandoVenda(Integer vendaId, String fileName) {
    	
    	Venda venda = vendaManager.getVenda(vendaId);
    	venda.setStatus("OK");
		vendaManager.updateVenda(venda);
		
        Processamento processamento = new Processamento();
        
        processamento.setData(new Date());
        processamento.setLoja(venda.getLoja());
        processamento.setPdv(venda.getPdv());
        processamento.setNomeArquivo(fileName);
        processamento.setStatus("OK");
		
		processamentoManager.addProcessamento(processamento);

    }
}
