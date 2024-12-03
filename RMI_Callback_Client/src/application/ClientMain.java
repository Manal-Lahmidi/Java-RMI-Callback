package application;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Créer le scanner au début

        try {
            // Demander l'ID du client
            System.out.print("Entrez votre ID : ");
            String clientId = scanner.nextLine();  // Lecture de l'ID

            // Demander le nom du client
            System.out.print("Entrez votre nom : ");
            String clientName = scanner.nextLine();  // Lecture du nom

            // Connexion au registre RMI sur localhost (serveur local)
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Récupérer le stub du serveur de chat
            ServerInterface server = (ServerInterface) registry.lookup(ServerInterface.LOOKUP_NAME);

            // Créer une instance du client distant avec l'ID et le nom
            ClientImpl client = new ClientImpl(clientId, clientName);

            // Exporter le client comme objet distant
            client.export();

            // Inscrire le client au serveur
            server.signIn(client);
            System.out.println(clientName + " est connecté au serveur de chat.");

            // Demander à l'utilisateur s'il souhaite envoyer un message à tout le monde
            System.out.print("Entrez un message à envoyer à tous les autres clients : ");
            String message = scanner.nextLine();
            server.sendToAll(client.getNameDistant(), message);

            // Demander si l'utilisateur veut envoyer un message privé
            System.out.print("Souhaitez-vous envoyer un message privé à un autre client ? (oui/non) : ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("oui")) {
                System.out.print("Entrez le nom du destinataire : ");
                String receiverName = scanner.nextLine();
                System.out.print("Entrez votre message privé : ");
                String privateMessage = scanner.nextLine();
                server.sendToOne(client.getNameDistant(), receiverName, privateMessage);
            }

            // Attendre que l'utilisateur appuie sur Entrée pour se déconnecter
            System.out.print("Appuyez sur Entrée pour vous déconnecter... ");
            scanner.nextLine();  // Attendre l'input de l'utilisateur pour se déconnecter

            // Se déconnecter du serveur
            server.signOut(client, clientName + " a quitté le chat.");
            System.out.println(clientName + " s'est déconnecté.");

            // Désenregistrer le client et nettoyer
            client.unexport();

            // Fermer le scanner proprement
            scanner.close();

            // Terminer le programme
            System.exit(0);  // Force la fin du programme

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
