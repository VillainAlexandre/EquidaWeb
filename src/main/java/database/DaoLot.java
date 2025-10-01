/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cheval;
import model.Lot;

/**
 *
 * @author sio2
 */
public class DaoLot {
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Lot> getLesLots(Connection cnx) {
        ArrayList<Lot> lesChevaux = new ArrayList<Lot>();
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT l.id as l_id, l.prixdepart as l_prixdepart FROM Lot l  "    
            );
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
                Lot l = new Lot();
                l.setId(resultatRequete.getInt("l_id"));
                l.setPrixDepart(resultatRequete.getString("l_prixdepart"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesChevaux a généré une exception SQL");
        }
        return lesChevaux;
    }
    
    public static Lot getConsulterLot(Connection cnx, int idCheval) {
        Lot l = null;
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT l.id as l_id, l.prixdepart as l_prixdepart, c.id as c_id FROM Lot l INNER JOIN Cheval c ON c.id = l.id WHERE l.id = ?"
            );
            requeteSql.setInt(1, idCheval);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                l = new Lot();
                l.setId(resultatRequete.getInt("l_id"));
                l.setPrixDepart(resultatRequete.getString("l_prixdepart"));
              
                
               /* Cheval c = new Cheval();
                c.setId(resultatRequete.getInt("c_id"));
                c.setNom(resultatRequete.getString("c_nom"));*/
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLeCheval a généré une exception SQL");
        }
        return l;
    }
}
