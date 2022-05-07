package controler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
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

        //String command = "powershell.exe  your command";
        //Getting the version
//        String command = "powershell.exe  Get-ADComputer -filter * | select name";
        // Executing the command
        String lines ="";
        try {
            Process powerShellProcess = Runtime.getRuntime().exec("powershell.exe  Get-ADComputer -filter * | select name");
            powerShellProcess.getOutputStream().close();
            String line;
            System.out.println("Standard Output:");
            BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
            while ((line = stdout.readLine()) != null) {
                lines = teste(line, lines);
//                System.out.println(line);
            }
            System.out.println("\n\n\n\nPassou " + lines);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
        
        
//            Scanner in = new Scanner(new FileReader("C:\\teste\\MaquinasAd.txt"));
//
//            while (in.hasNextLine()) {
//                String line = in.nextLine();
//                if (!line.isEmpty()) {
//                    File arquivo = new File("C:\\teste\\" + line.trim() + ".txt");
//                    if (arquivo.exists()) {
//                        System.out.println(line);
//                        DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
//
//                        String data = formatData.format(new Date(arquivo.lastModified()));
//                        System.out.println(data);
//                    } else {
//                        System.out.println(line + " Não existe");
//                    }
//
//                }
//            }
    }
    public static String teste(String line, String lines){
            if (!line.isEmpty()) {
                File arquivo = new File("S:\\Documentos\\_Temporaria_\\TI\\PC\\" + line.trim() + ".txt");
                if (arquivo.exists()) {
                    System.out.println(line);
                    DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");

                    String data = formatData.format(new Date(arquivo.lastModified()));
                    System.out.println(data);
                } else {
                    lines += line.trim() + " Maquina inativa"+ "\n" ;
//                    System.out.println(line + " Não existe");
                }
                
                

            }
            return lines;
            
        } 
    
}
