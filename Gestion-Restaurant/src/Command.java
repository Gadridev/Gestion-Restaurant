import java.util.ArrayList;
import java.util.List;

public class Command {

        private  int idCommande;
        private Client client;
        private List<Plat> plats;
        private Serveur serveur;

        public Commande( Client client,Serveur serveur) {
            this.serveur=serveur;
            this.client = client;
            this.plats=new ArrayList<>();
        }
        public void  ajouterPla(Plat p){
            if (!plats.contains(p)){
                plats.add(p);
                p.ajouterCommend(this);
            }
        }

        public Serveur getServers() {
            return serveur;
        }

        public void setServers(Serveur serveur) {
            this.serveur = serveur;
        }
        public double calculerTotal(){
            double total=0;
            for (Plat p: plats){
                total +=p.getPrix();
            }
            return total;
        }
        public void afficherDetails(){
            if (serveur != null) {
                System.out.println("Serveur : " + serveur.getNom());
            } else {
                System.out.println("Serveur : Aucun");
            }
            for (Plat p:plats){
                System.out.println("plats "+p.getNom() +"le prix est :"+p.getPrix());
            }
            System.out.println("le total est :" +calculerTotal());
        }
        public int getIdCommande() {
            return idCommande;
        }
        public void setIdCommande(int idCommande) {
            this.idCommande = idCommande;
        }
        public Client getClient() {
            return client;
        }
        public void setClient(Client client) {
            this.client = client;
        }
        @Override
        public String toString() {
            return "Commande{" +
                    "idCommande=" + idCommande +
                    ", client=" + client +
                    '}';
        }
    }


