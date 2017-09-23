package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thiago
 */
public class ParametroGeral {

    public static String caminhoArquivo = "C:\\Temp\\configSistemaPedidos.txt";
    Map<String, String> map = new HashMap<String, String>();

    public boolean CriarArquivo(String servidorBanco, String nomeBanco, String usuarioBanco, String senhaBanco) throws FileNotFoundException, IOException {

        try {
            File file = new File(caminhoArquivo);

            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
            }

            // Prepara para escrever no arquivo
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            StringBuilder str = new StringBuilder();
            str.append(servidorBanco);
            str.append(System.getProperty("line.separator"));
            str.append(nomeBanco);
            str.append(System.getProperty("line.separator"));
            str.append(usuarioBanco);
            str.append(System.getProperty("line.separator"));
            str.append(senhaBanco);

            // Escreve e fecha arquivo
            bw.write(str.toString());
            bw.close();

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Map<String, String> Ler() {
        try {
            int cont = 1;
            FileReader ler = new FileReader(caminhoArquivo);
            BufferedReader reader = new BufferedReader(ler);
            String linha;
            while ((linha = reader.readLine()) != null) {

                switch (cont) {
                    case 1:
                        map.put("SERVIDOR", linha);
                        break;
                    case 2:
                        map.put("BANCO", linha);
                        break;
                    case 3:
                        map.put("USUARIO", linha);
                        break;
                    case 4:
                        map.put("SENHA", linha);
                        break;
                    default:
                        break;
                }
                cont++;
            }

            return map;
        } catch (Exception e) {
            return null;
        }
    }
}
