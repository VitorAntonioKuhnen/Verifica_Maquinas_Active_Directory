package controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author vitor.kuhnen
 */
public class AnalisadorTxt {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("C:\\teste\\MaquinasAd.txt"));

        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (!line.isEmpty()) {
                File arquivo = new File("C:\\teste\\" + line.trim() + ".txt");
                if (arquivo.exists()) {
                    System.out.println(line);
                    DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
                    
                    String data = formatData.format(new Date(arquivo.lastModified()));
                    System.out.println(data);
                } else{
                    System.out.println(line + " Não existe");
                }

            }
        }
    }
}
