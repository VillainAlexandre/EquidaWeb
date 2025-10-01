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
import model.Vente;

/**
 *
 * @author sio2
 */
public class DaoVente {
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Vente> getListerVentes(Connection cnx) {
        ArrayList<Vente> listerVentes = new ArrayList<Vente>();
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT v.id as v_id, v.nom as v_nom, " +
                " v.dateDebutVente as v_dateDebutvente " +
                "FROM vente v"
            );
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
                Vente v = new Vente();
                v.setId(resultatRequete.getInt("v_id"));
                v.setNom(resultatRequete.getString("v_nom"));
                v.setDateDebutVente(resultatRequete.getDate("v_dateDebutVente"));
                listerVentes.add(v);
                /*c.setId(resultatRequete.getInt("c_id"));
                c.setNom(resultatRequete.getString("c_nom"));
                Race r = new Race();
                r.setId(resultatRequete.getInt("r_id"));
                r.setNom(resultatRequete.getString("r_nom"));
                c.setRace(r);
                lesChevaux.add(c);*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getListerVentes a généré une exception SQL");
        }
        return listerVentes;
    }
        public static Vente getConsulterVente(Connection cnx, int idVente) {
        Vente v = null;
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT v.id as v_id, v.nom as v_nom, v.dateDebutVente as v_dateDebutvente, l.id as l_id FROM vente v INNER JOIN lot l ON v.idLot = l.id WHERE v.id = ?"
            );
            requeteSql.setInt(1, idVente);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                v = new Vente();
                v.setId(resultatRequete.getInt("v_id"));
                v.setNom(resultatRequete.getString("v_nom"));
                v.setDateDebutVente(resultatRequete.getDate("v_dateDebutVente"));
                Lot l = new Lot();
                l.setId(resultatRequete.getInt("l_id"));
                
             
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getConsulterVente a généré une exception SQL");
        }
        return v;
    }
    public static boolean ajouterVente(Connection cnx, Vente vente) {
    try {
        requeteSql = cnx.prepareStatement(
            "INSERT INTO vente (nom, dateDebutVente) VALUES (?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS
        );
        requeteSql.setString(1, vente.getNom());
        
        // Gestion de la date de debut de vente
        if (vente.getDateDebutVente() != null) {
            //requeteSql.setDate(2, java.sql.Date.valueOf(vente.getDateDebutVente()));
        } else {
            requeteSql.setNull(2, java.sql.Types.DATE);
        }
        
        requeteSql.setInt(3, vente.getId());
        
        int result = requeteSql.executeUpdate();
        
        if (result == 1) {
            // Récupération de l'id auto-généré
            ResultSet rs = requeteSql.getGeneratedKeys();
            if (rs.next()) {
                vente.setId(rs.getInt(1));
            }
            return true;
        }
        return false;
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erreur lors de l'ajout d'une vente");
        return false;
    }
    
}}
