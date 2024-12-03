# RMI_Callback: Chat Distribué avec Java RMI

Ce projet implémente un système de **chat distribué** en utilisant Java RMI (Remote Method Invocation). Les clients peuvent se connecter à un serveur, envoyer des messages publics ou privés, et se déconnecter proprement. Le serveur gère les connexions et la distribution des messages.

## Fonctionnalités
- Connexion des clients au serveur via RMI.
- Envoi de messages publics à tous les clients connectés.
- Envoi de messages privés à un client spécifique.
- Déconnexion propre des clients avec notification aux autres utilisateurs.

## Architecture
### Serveur
- Gère les connexions et la déconnexion des clients.
- Transmet les messages à tous les clients connectés ou à un client spécifique.
- Implémente l'interface `ServerInterface`.

### Client
- Se connecte au serveur via RMI.
- Envoie et reçoit des messages en temps réel.
- Implémente l'interface `ClientInterface`.

## Prérequis
- Java Development Kit (JDK) 8 ou supérieur.
- Variables d'environnement `JAVA_HOME` et `CLASSPATH` configurées.

## Structure du projet
### RMI_Callback_Server
- ServerInterface.java : Interface définissant les méthodes exposées par le serveur.
- ServerImpl.java : Implémentation des fonctionnalités du serveur.
- Server.java : Classe principale pour démarrer le serveur.

### RMI_Callback_Client
- ClientInterface.java : Interface définissant les méthodes exposées par le client.
- ClientImpl.java : Implémentation des fonctionnalités du client.
- ClientMain.java : Classe principale pour démarrer le client.

## Installation

### Étape 1 : Cloner le dépôt

git clone https://github.com/votre-utilisateur/RMI_Callback.git

cd Java-RMI-Callback

### Étape 2 : Compiler le projet
#### Serveur
cd RMI_Callback_Server/src/application

javac *.java

#### Client
cd RMI_Callback_Client/src/application

javac *.java

### Étape 3 : Démarrer le registre RMI
Dans un terminal séparé, lancez le registre RMI :

rmiregistry 1099

## Exécution
### Démarrer le serveur
- Dans un terminal, accédez au répertoire du serveur et lancez-le :

cd RMI_Callback_Server/src/application

java application.Server

### Démarrer le client
- Dans un autre terminal, accédez au répertoire du client et lancez-le :

cd RMI_Callback_Client/src/application

java application.ClientMain

## Auteurs

Manal : Développement complet du projet.