package Client;

import Service.Menu;
import Interface.IBusiness;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Client {
    public static void main (String[] args){
        try{
            IBusiness iBusiness = (IBusiness) Naming.lookup("business");
            ClientActionsHandler actionsHandler = new ClientActionsHandler();
            int choice = 0;
            while (choice!= 4) {
                choice = Menu.execute();
                actionsHandler.executeAction(choice,iBusiness);
            }
        }catch (NotBoundException | NullPointerException | IOException e){
            System.out.println("Error:"+ e);
        }
    }
}
