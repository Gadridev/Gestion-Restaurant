
import java.util.ArrayList;
import java.util.List;

public class Serveur {
    private  String nom;
    private List<Commande> commandes;

    public Serveur(String nom) {
        this.nom = nom;

        this.commandes=new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }
    public void prendreCommande(Commande commande) {
        if(commande==null){
            System.out.println("Aucune commande fournie.");
            return;
        }
        if(commandes.contains(commande)){
            System.out.println(" Cette commande est déjà prise par ce serveur.");
            return;
        }
        commandes.add(commande);
        commande.setServers(this);
        System.out.println("Serveur " + nom + " a pris la commande #" + commande.getIdCommande());

    }
    public void afficher() {
        System.out.println("Serveur : " + nom);
    }
}
