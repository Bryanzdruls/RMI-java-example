package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static Integer execute(){
        try{
            int choice;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("1.Llenar matriz e informar al cliente el total pagado para cada empleado.");
            System.out.println("2.Promedio de cada mes    ");
            System.out.println("3.Total pagado");
            System.out.println("4.Salir    ");
            System.out.println("OPCIÓN:");
            choice = Integer.parseInt(br.readLine());
            return choice;
        }catch ( IOException  ex){
            System.out.println("An error occurred on method execute"+ex);
            return 0;
        }
    };
}
