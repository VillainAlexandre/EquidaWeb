package test;

import java.util.HashSet;
import java.util.Set;
import model.Cheval;
import model.Race;
import model.Vente;
import model.Lieu;
import model.Enchere;
import model.Lot;
import model.CategVente;


public class TestCheval {

    public static void main (String args[]){
        Vente v = new Vente();
        v.setId(1);
        v.setNom("VenteCheval");
        
        Lieu l = new Lieu();
        l.setId(1);
        l.setNbBoxes(8);
        
        Enchere e = new Enchere();
        e.setNumero(1);
        e.setMontant(555);
        
        Lot lo = new Lot();
        lo.setId(1);
        lo.setPrixDepart("52000");
        
        CategVente c = new CategVente();
        c.setCode(2);
        c.setLibelle("vente hiver");
        
        v.setLieu(l);
        e.setLot(lo);
        lo.setVente(v);
        v.setCategvente(c);
        
        System.out.println("la vente " + v.getNom()+ " " + v.getId() + " auras lieu dans le box " + l.getNbBoxes());
        
        System.out.println("l'Enchere " + e.getNumero()+ " du montant " + e.getMontant() + " pour le lot " + lo.getId() + " au prix de depart de " + lo.getPrixDepart());

        System.out.println("le lot " + lo.getId()+ " de la vente " + v.getId());
        
        
        
        /*
        // création d'une instance de cheval nommée c
        Cheval c = new Cheval();
        c.setId(2);
        c.setNom("Houri");

        // création d'une instance de race nommée r
        Race r = new Race();
        r.setId(1);
        r.setNom("pur-sang");

        //affectation de  la race au cheval grâce à la relation ManyToOne
        c.setRace(r);

        // Affichage des informations dans la console
        //voir notamment du nom de la race du cheval
        System.out.println("Cheval : " + c.getId() + " " + c.getNom() + " "
                + c.getRace().getId() + " " + c.getRace().getNom());*/
    }
    
    
}
