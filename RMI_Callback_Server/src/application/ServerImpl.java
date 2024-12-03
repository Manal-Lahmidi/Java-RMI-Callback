package application;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
    private final List<ClientInterface> clients;

    protected ServerImpl() throws RemoteException {
        clients = new ArrayList<>();
    }

    @Override
    public synchronized void signIn(ClientInterface client) throws RemoteException {
        clients.add(client);
        System.out.println(client.getNameDistant() + " has joined the chat.");
        sendToAll("Server", client.getNameDistant() + " has joined the chat.");
    }

    @Override
    public synchronized void signOut(ClientInterface client, String message) throws RemoteException {
        clients.remove(client);
        sendToAll("Server", message);
        System.out.println(client.getNameDistant() + " has logged out.");
    }

    @Override
    public void sendToAll(String senderName, String message) throws RemoteException {
        for (ClientInterface client : clients) {
            client.receiveMessage(senderName + ": " + message);
        }
    }

    @Override
    public void sendToOne(String senderName, String receiverName, String message) throws RemoteException {
        for (ClientInterface client : clients) {
            if (client.getNameDistant().equals(receiverName)) {
                client.receiveMessage(senderName + " (private): " + message);
                return;
            }
        }
        System.out.println("Client not found: " + receiverName);
    }
}

