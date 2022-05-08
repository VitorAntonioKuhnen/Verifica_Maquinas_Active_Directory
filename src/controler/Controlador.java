/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author vitor.kuhnen
 */
public class Controlador {

    String t = "";

    public static boolean SalvaTxt(String lines) throws FileNotFoundException {
        //valida se a variavel "lines" está vazil
        if (!lines.isEmpty()) {
            //cria o arquivo.txt no destino escolhido
            PrintWriter writer = new PrintWriter(new File("C:\\Users\\vitor.kuhnen\\Documents\\Manual\\Outros Vítor\\arquivo.txt"));
            //escreve no Txt conforme definido na variavel "lines"
            writer.write(lines);
            writer.flush();
            writer.close();
            return false;
        } else {
            return true;
        }
    }

    public static String AnalisaMaquinas(String line, String lines) {
        if (line.contains("TI-") || line.contains("NS")) {
            
            System.out.println("Maquina administradora " + line);
            return lines;

        }else {
            File arquivo = new File("S:\\Documentos\\_Temporaria_\\TI\\PC\\" + line.trim() + ".txt");
            if (arquivo.exists()) {
                String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date(arquivo.lastModified()));  
                if (!dates(date)) {
                    lines += line + " " + date + "\n";
                    return lines;
                } else {
                    return lines;
//                    System.out.println("Maquina Ativa");
                }
            } else {
                lines += line.trim() + " Maquinas não Logadou" + "\n";
                return lines;
            }
        }

    }

    public static boolean dates(String date) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        LocalDate datalog = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        calendar.add(Calendar.MONTH, -2);
        calendar.add(Calendar.DAY_OF_MONTH, 20);
        LocalDate twoMonthBefore = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (datalog.isBefore(twoMonthBefore) || datalog.isEqual(twoMonthBefore)) {
            return false;

        } else {
            return true;
        }
    }
}
