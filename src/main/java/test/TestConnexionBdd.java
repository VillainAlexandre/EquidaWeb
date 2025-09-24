package test;

import java.sql.Connection;
import java.util.ArrayList;

import database.Connexionbdd;
import database.DaoCheval;
import database.DaoVente;

public class TestConnexionBdd {

    public static void main (String args[]) {

        Connection cnx = Connexionbdd.ouvrirConnexion();
        /*System.out.println ("nombre de chevaux = " + DaoCheval.getLesChevaux(cnx).size());
        
       
        System.out.println ("un cheval = " + DaoCheval.getLeCheval(cnx, 16).getNom());
        System.out.println ("dont la race est = " + DaoCheval.getLeCheval(cnx, 16).getRace());*/
       
        
        System.out.println ("liste des ventes = " + DaoVente.getListerVentes(cnx).size());
        System.out.println ("une vente = " + DaoVente.getConsulterVente(cnx, 1).getNom());

    }

}
