import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurant restaurant = new Restaurant("Chez GPT");

        int choix;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Ajouter un plat");
            System.out.println("2. Ajouter un client");
            System.out.println("3. Ajouter un serveur");
            System.out.println("4. Passer une commande");
            System.out.println("5. Afficher le menu");
            System.out.println("6. Afficher les clients");
            System.out.println("7. Afficher les serveurs");
            System.out.println("8. Afficher les commandes");
            System.out.println("9. Quitter");
            System.out.print("Choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {

                case 1:
                    System.out.print("Nom du plat : ");
                    String nomPlat = sc.nextLine();
                    System.out.print("Prix : ");
                    double prix = sc.nextDouble();
                    sc.nextLine();
                    restaurant.ajouterPlat(new Plat(nomPlat, prix));
                    break;

                case 2:
                    System.out.print("Nom du client : ");
                    restaurant.ajouterClient(new Client(sc.nextLine()));
                    break;

                case 3:
                    System.out.print("Nom du serveur : ");
                    restaurant.ajouterServeur(new Serveur(sc.nextLine()));
                    break;

                case 4:
                    if (restaurant.getClients().isEmpty() || restaurant.getServeurs().isEmpty() || restaurant.getPlats().isEmpty()) {
                        System.out.println("⚠ Il faut ajouter client, serveur et plats avant !");
                        break;
                    }

                    System.out.println("Choisir client :");
                    int i = 1;
                    for (Client c : restaurant.getClients()) {
                        System.out.println(i++ + ". " + c.getNom());
                    }
                    int cliIndex = sc.nextInt() - 1;

                    System.out.println("Choisir serveur :");
                    i = 1;
                    for (Serveur s : restaurant.getServeurs()) {
                        System.out.println(i++ + ". " + s.getNom());
                    }
                    int servIndex = sc.nextInt() - 1;

                    Commande cmd = new Commande(
                            restaurant.getClients().get(cliIndex),
                            restaurant.getServeurs().get(servIndex)
                    );

                    int choixPlat;
                    do {
                        System.out.println("Choisir plat (0 pour finir) :");
                        i = 1;
                        for (Plat p : restaurant.getPlats()) {
                            System.out.println(i++ + ". " + p.getNom());
                        }
                        choixPlat = sc.nextInt();

                        if (choixPlat > 0) {
                            cmd.ajouterPla(restaurant.getPlats().get(choixPlat - 1));
                        }

                    } while (choixPlat != 0);

                    restaurant.getClients().get(cliIndex).ajouterCommend(cmd);
                    restaurant.getServeurs().get(servIndex).prendreCommande(cmd);
                    restaurant.ajouterCommande(cmd);

                    break;

                case 5:
                    restaurant.afficherMenu();
                    break;

                case 6:
                    restaurant.afficherClients();
                    break;

                case 7:
                    restaurant.afficherServeurs();
                    break;

                case 8:
                    restaurant.afficherCommandes();
                    break;

                case 9:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 9);
    }
}
