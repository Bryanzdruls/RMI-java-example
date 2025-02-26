package Client;

import Interface.IBusiness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ClientActionsHandler {
    private final Map<Integer, Consumer<IBusiness>> actions = new HashMap<>();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public ClientActionsHandler(){
        initializeActions();
    }

    private  void initializeActions(){
        actions.put(1,this::handleLlenarMatriz);
        actions.put(2,this::handlePromedioMes);
        actions.put(3,this::handleTotalPagado);
    }

    private void handleLlenarMatriz(IBusiness business){
        int ne = getValidNumber("Número de empleados:");
        int nm = getValidNumber("Número de meses:");
        try {
            System.out.println(business.llenarMatrizSalarios(ne, nm));
        } catch (IOException e) {
            System.out.println("Error al leer entrada: " + e.getMessage());
        }
    }

    private void handlePromedioMes(IBusiness business) {
        try {
            System.out.println(business.promedioMesPorPago());
        } catch (RemoteException | NullPointerException e) {
            System.out.println("Primero debe llenar la matriz");
        }
    }

    private void handleTotalPagado(IBusiness business) {
        try {
            System.out.println(business.totalPagadoMatriz());
        } catch (RemoteException | NullPointerException e) {
            System.out.println("Primero debe llenar la matriz");
        }
    }

    private int getValidNumber(String message) {
        int number = 0;
        while (number < 1) {
            try {
                System.out.println(message);
                number = Integer.parseInt(br.readLine());
                if (number < 1) {
                    System.out.println("El valor debe ser mayor o igual a 1. Intente de nuevo.");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número entero.");
            }
        }
        return number;
    }

    public void executeAction(int choice, IBusiness business) {
        actions.getOrDefault(choice, b -> {}).accept(business);
    }
}
