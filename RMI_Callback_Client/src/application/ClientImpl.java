package application;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends Client implements ClientInterface {
    public ClientImpl(String id, String name) throws RemoteException {
        super(id, name);
        // Exporter l'objet manuellement comme objet distant
        //UnicastRemoteObject.exportObject(this, 0);//donne un step
    }
    public void export() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);//donne un step

    }
    public void unexport() throws RemoteException {
        UnicastRemoteObject.unexportObject(this,false);//donne un step

    }

    @Override
    public void receiveMessage(String message) throws RemoteException {
        System.out.println("[Message reçu] : " + message);
    }

    @Override
    public String getNameDistant() throws RemoteException {
        return getName();
    }

    @Override
    public String getIdDistant() throws RemoteException {
        return getId();
    }
}
