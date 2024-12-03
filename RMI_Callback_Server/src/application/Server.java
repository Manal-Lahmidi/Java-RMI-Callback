package application;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Créer une instance du serveur de chat
            ServerImpl server = new ServerImpl();

            // Démarrer le RMI Registry sur le port 1099 (par défaut)
            Registry registry = LocateRegistry.createRegistry(1099);

            // Enregistrer le serveur dans le registre sous le nom "ChatServer"
            registry.rebind(ServerInterface.LOOKUP_NAME, server);

            System.out.println("Serveur de chat démarré !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}