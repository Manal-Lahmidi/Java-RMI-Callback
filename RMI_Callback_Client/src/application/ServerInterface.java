package application;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    String LOOKUP_NAME = "ChatServer";

    void sendToAll(String senderName, String message) throws RemoteException;
    void sendToOne(String senderName, String receiverName, String message) throws RemoteException;
    void signIn(ClientInterface client) throws RemoteException;
    void signOut(ClientInterface client, String message) throws RemoteException;
}
