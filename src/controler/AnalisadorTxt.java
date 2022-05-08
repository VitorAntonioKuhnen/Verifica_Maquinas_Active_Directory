package controler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 *
 * @author vitor.kuhnen
 */
public class AnalisadorTxt {

    public static void main(String[] args) throws FileNotFoundException {

        String computers = "";
        try {
            Process powerShellProcess = Runtime.getRuntime().exec("powershell.exe  Get-ADComputer -filter * | select name");
            powerShellProcess.getOutputStream().close();
            String line;
            System.out.println("Standard Output:");
            BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
            while ((line = stdout.readLine()) != null) {
                computers = Controlador.AnalisaMaquinas(line, computers);
            }
            Controlador.SalvaTxt(computers);
        } catch (Exception e) {
            System.out.println("Erro " + e);
        }
    }
}
