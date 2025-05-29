package com.example;

import com.example.Model.Conference;
import com.example.Model.Participant;
import com.example.service.GestionEvenements;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        GestionEvenements gestion = GestionEvenements.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Ajouter une conférence");
            System.out.println("2. Lister les événements");
            System.out.println("3. Ajouter un participant");
            System.out.println("4. Supprimer un événement");
            System.out.println("5. Sauvegarder (JSON)");
            System.out.println("6. Charger depuis JSON");
            System.out.println("0. Quitter");

            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // consommer le retour chariot

            try {
                switch (choix) {
                    case 1:
                        System.out.print("ID : ");
                        String id = scanner.nextLine();
                        System.out.print("Nom : ");
                        String nom = scanner.nextLine();
                        System.out.print("Lieu : ");
                        String lieu = scanner.nextLine();
                        System.out.print("Capacité max : ");
                        int capacite = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Sujet : ");
                        String sujet = scanner.nextLine();

                        Conference conf = new Conference(id, nom, LocalDateTime.now(), lieu, capacite, sujet);
                        gestion.ajouterEvenement(conf);
                        System.out.println(" Conférence ajoutée !");
                        break;

                    case 2:
                        System.out.println(" Événements :");
                        gestion.getEvenements().forEach((k, v) -> {
                            System.out.println("- " + v.getNom() + " (" + v.getId() + ")");
                        });
                        break;

                    case 3:
                        System.out.print("ID de l'événement : ");
                        String idEvt = scanner.nextLine();
                        System.out.print("Nom participant : ");
                        String nomP = scanner.nextLine();
                        System.out.print("Email participant : ");
                        String email = scanner.nextLine();
                        Participant p = new Participant(nomP, nomP, email);

                        gestion.rechercherEvenement(idEvt).ajouterParticiapant(p);
                        System.out.println(" Participant ajouté !");
                        break;

                    case 4:
                        System.out.print("ID à supprimer : ");
                        String idSupp = scanner.nextLine();
                        if (gestion.SupprimerEvenement(idSupp)) {
                            System.out.println(" Événement supprimé.");
                        } else {
                            System.out.println(" Événement non trouvé.");
                        }
                        break;

                    case 5:
                        gestion.EvenementJSON("liste.json");
                        System.out.println(" Données sauvegardées !");
                        break;

                    case 6:
                        gestion.chargerEvenementJSON("liste.json");
                        System.out.println(" Données chargées !");
                        break;

                    case 0:
                        continuer = false;
                        break;

                    default:
                        System.out.println(" Choix invalide.");
                        break;
                }
            } catch (Exception e) {
                System.out.println(" Erreur : " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Au revoir !");
    }
}
