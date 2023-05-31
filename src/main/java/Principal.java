import com.manoelcampos.retornoboleto.EstrategiaBoletoFactory;
import com.manoelcampos.retornoboleto.LeituraRetorno;
import com.manoelcampos.retornoboleto.ProcessadorBoletos;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Executa a aplicação para ler um arquivo de
 * retorno de boleto e imprimir no terminal.
 * @author manoelcampos
 */
public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        //var processador = new ProcessadorBoletos(LeituraRetorno::processarLinhaBancoBrasil);
        var arquivos = new String[]{"banco-brasil-1.csv","bradesco-1.csv"};
        
        List.of("banco-brasil-1.csv","bradesco-1.csv")
            .stream()
            .forEach( nomeArquivoString -> {
                var processador = new ProcessadorBoletos();
                URI nomeArquivo;
                try {
                    nomeArquivo = Principal.class.getResource(nomeArquivoString).toURI();
                    processador.processar(nomeArquivo);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
    }
}