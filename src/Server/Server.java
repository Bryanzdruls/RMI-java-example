package Server;

import Service.BusinessService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String []args) throws RemoteException {
        Registry reg= LocateRegistry.createRegistry(1099);
        BusinessService businessService = new BusinessService();
        reg.rebind("business", businessService);
        System.out.println("servidor iniciado");
    }
}
