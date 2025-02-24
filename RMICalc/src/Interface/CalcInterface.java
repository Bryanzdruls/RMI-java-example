/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author hrecaman
 */
public interface CalcInterface extends Remote{
    public float calculate(float a, float b, int choice) throws RemoteException;
    
}
