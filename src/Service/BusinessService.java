package Service;

import Interface.IBusiness;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class BusinessService extends UnicastRemoteObject implements IBusiness {
    private MatrixWrapper matrizPagos;
    private int numeroEmpleados;
    private int numeroMeses;

    public BusinessService() throws RemoteException {
        this.matrizPagos = null;
        this.numeroEmpleados = 0;
        this.numeroMeses = 0;
    }

    @Override
    public String llenarMatrizSalarios(int numeroEmpleados, int numeroMeses) {
        int[][] matrizAux = new int[numeroEmpleados][numeroMeses];
        this.numeroEmpleados = numeroEmpleados;
        this.numeroMeses = numeroMeses;
        Random random = new Random();
        for (int i = 0; i < numeroEmpleados; i++) {
            for (int j = 0; j < numeroMeses; j++) {
                matrizAux[i][j] = random.nextInt(3500001) + 1300000;
            }
        }
        this.matrizPagos = new MatrixWrapper(matrizAux);
        return informarClienteTotalPagado();
    }

    @Override
    public String informarClienteTotalPagado() {
        StringBuilder respuesta = new StringBuilder("Matriz de salarios generada:\n");
        for (int i = 0; i < numeroEmpleados; i++) {
            for (int j = 0; j < numeroMeses; j++) {
                respuesta.append(this.matrizPagos.getMatrixIndex(i,j)).append("\t");
            }
            respuesta.append("\n");
        }
        return respuesta.toString();
    }

    @Override
    public String promedioMesPorPago() {
        int numeroEmpleados = matrizPagos.getMatrix().length; // Número de filas
        int numeroMeses = matrizPagos.getMatrix()[0].length;  // Número de columnas
        StringBuilder respuesta = new StringBuilder("Promedio de salarios por mes:\n");
        for (int j = 0; j < numeroMeses; j++) {
            int suma = 0;
            for (int i = 0; i < numeroEmpleados; i++) {
                suma += matrizPagos.getMatrixIndex(i,j);
            }
            respuesta.append("Mes ").append(j+1).append(": ").append((float) suma / numeroEmpleados).append("\n");
        }

        return respuesta.toString();
    }

    @Override
    public String totalPagadoMatriz() {
        int[][] matriz = matrizPagos.getMatrix();
        StringBuilder respuesta = new StringBuilder("Total pagado a los empleados:\n");
        int total = 0;
        for (int[] fila : matriz) {
            for (int pago : fila) {
                total += pago;
            }
        }
        respuesta.append(total);
        return respuesta.toString();
    }
}
