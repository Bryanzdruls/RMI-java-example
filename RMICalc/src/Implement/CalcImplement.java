/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Interface.CalcInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author hrecaman
 */
public class CalcImplement extends UnicastRemoteObject implements CalcInterface {

    public float num1;
    public float num2;

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }
    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public CalcImplement(float num1, float num2) throws RemoteException {
        this.num1 = num1;
        this.num2 = num2;
    }


    @Override
    public float calculate(float a, float b, int choice) throws RemoteException {
        return switch (choice) {
            case 1 -> a + b;
            case 2 -> a - b;
            case 3 -> a * b;
            case 4 -> a / b;
            default -> {
                System.out.println("ERROR");
                yield 0;
            }
        };
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
