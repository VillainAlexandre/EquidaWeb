package test;

import model.CategVente;
import model.Cheval;
import model.Enchere;
import model.Lot;
import model.Race;
import model.Vente;

public class TestRace
{
    public static void main (String args[]){
       CategVente c = new CategVente();
       c.setCode(7);
       c.setLibelle("hiver");
       
       Vente v1 = new Vente();
       v1.setId(5);
       v1.setNom("vente 1");
       v1.setDateDebutVente("le 9 septembre");
       
       Vente v2 = new Vente();
       v2.setId(8);
       v2.setNom("vente 2");
       v2.setDateDebutVente("le 10 septembre");
       
       c.addVente(v1);
       c.addVente(v2);
       
       System.out.println("La categorie de vente est " + c.getLibelle() + " et il y a donc la vente " + v1.getNom()+ " du " + v1.getDateDebutVente() + " mais aussi la vente " + v2.getNom()+ " du " + v2.getDateDebutVente());
       System.out.println("Liste des Ventes de la categorie de vente : ");
       
       for (Vente v : c.getLesVentes()){
            System.out.println("Vente numéro : " + v.getId() + " " + v.getNom());
       }
       
       
       Lot lo = new Lot();
       lo.setId(7);
       lo.setPrixDepart("254");
       
       Enchere e1 = new Enchere();
       e1.setNumero(6);
       e1.setMontant(569);
       
       
       Enchere e2 = new Enchere();
       e2.setNumero(3);
       e2.setMontant(954);
       
       lo.addEnchere(e1);
       lo.addEnchere(e2);
       
       System.out.println("Le Lot est " + lo.getId()+ " au prix de depart de " + lo.getPrixDepart()+ " de l'Enchere " + e1.getNumero()+ " mais aussi de l'enchere " + e2.getNumero());
       System.out.println("Liste des Ventes de la categorie de vente : ");
       
       for (Enchere e : lo.getLesEncheres()){
            System.out.println("Enchere numéro : " + e.getNumero()+ " " + e.getMontant());
       }
        /*// instantiation d'une race
        Race r = new Race();
        r.setId(4);
        r.setNom("Andalou");

        // instanciation de 2 chevaux c1 et c2
        // ajout des chevaux c1 et c2 à l'arraylist des chevaux grâce
        // à la relation OneToMany
        Cheval c1 = new Cheval();
        c1.setId(1);
        c1.setNom("Eclipse");
        r.addCheval(c1);

        Cheval c2 = new Cheval();
        c2.setId(7);
        c2.setNom("Comète");
        r.addCheval(c2);

        //Affichage des informations de la race
        System.out.println("La race est " + r.getId() + " " + r.getNom() + " et contient " + r.getLesChevaux().size() + " chevaux" );
        System.out.println("Liste des chevaux de la race : ");

		// Affichage des informations sur chevaux liées à la race
        for (Cheval c : r.getLesChevaux()){
            System.out.println("Cheval numéro : " + c.getId() + " " + c.getNom());
        }*/
    }
}
