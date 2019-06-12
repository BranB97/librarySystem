/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcoms_package;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author acer
 */
public class RMIRegistry {

    public static void main(String[] args) throws RemoteException {
        runServer rs = new runServer();
        rs.run();
    }
}
//run server method
class runServer implements Runnable {

    @Override
    public void run() {
        try {
            Registry reg = LocateRegistry.createRegistry(1044);
            Server serv = new Server();
            reg.rebind("login", serv);
            reg.rebind("register", serv);
            reg.rebind("displayBooks", serv);
            reg.rebind("borrowlist", serv);
            reg.rebind("addbook", serv);

            System.out.println("Server ready!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
