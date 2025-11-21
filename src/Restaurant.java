import java.util.ArrayList;

public class Restaurant {
    private String nom;
    private ArrayList<Plat> plats;
    private ArrayList<Client> clients;
    private ArrayList<Serveur> serveurs;
    private ArrayList<Commande> commandes;

    public Restaurant(String nom) {
        this.nom = nom;
        plats = new ArrayList<>();
        clients = new ArrayList<>();
        serveurs = new ArrayList<>();
        commandes = new ArrayList<>();
    }

    public void ajouterPlat(Plat p) {
        plats.add(p);
        System.out.println("Plat ajouté ✔");
    }

    public void ajouterClient(Client c) {
        clients.add(c);
        System.out.println("Client ajouté ✔");
    }

    public void ajouterServeur(Serveur s) {
        serveurs.add(s);
        System.out.println("Serveur ajouté ✔");
    }

    public void ajouterCommande(Commande c) {
        commandes.add(c);
        System.out.println("Commande enregistrée ✔");
    }

    public void afficherMenu() {
        System.out.println("------ MENU ------");
        for (Plat p : plats) { p.afficher(); }
        System.out.println("------------------");
    }

    public void afficherClients() {
        System.out.println("---- Clients ----");
        for (Client c : clients) c.afficher();
    }

    public void afficherServeurs() {
        System.out.println("---- Serveurs ----");
        for (Serveur s : serveurs) s.afficher();
    }

    public void afficherCommandes() {
        System.out.println("---- Commandes ----");
        for (Commande cmd : commandes) cmd.afficherDetails();
    }

    public ArrayList<Plat> getPlats() { return plats; }
    public ArrayList<Client> getClients() { return clients; }
    public ArrayList<Serveur> getServeurs() { return serveurs; }
}
