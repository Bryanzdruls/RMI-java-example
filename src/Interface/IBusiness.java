package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBusiness extends Remote {
    String llenarMatrizSalarios(int numeroEmpleados, int numeroMeses)throws RemoteException;
    String informarClienteTotalPagado()throws RemoteException;
    String promedioMesPorPago()throws RemoteException;
    String totalPagadoMatriz()throws RemoteException;
}
