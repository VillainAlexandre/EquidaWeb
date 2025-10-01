/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import database.DaoLot;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.DaoVente;
import database.DaoRace;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.sql.Date;
import model.Vente;
import model.Race;
import java.time.LocalDate;
import model.Cheval;
import model.Lot;

/**
 *
 * @author sio2
 */
@WebServlet(name = "venteServlet", value = "/vente-servlet/*")
public class VenteServlet extends HttpServlet {

    Connection cnx;
    
    @Override
    public void init() {
        ServletContext servletContext = getServletContext();
        cnx = (Connection)servletContext.getAttribute("connection");
        try {
            System.out.println("INIT SERVLET=" + cnx.getSchema());
        } catch (SQLException ex) {
            Logger.getLogger(VenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getPathInfo();
        System.out.println("PathInfo: " + path);

        if ("/list".equals(path)) {
            ArrayList<Vente> lesVentes = DaoVente.getListerVentes(cnx);
            request.setAttribute("pLesVentes", lesVentes);
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/Vente/list.jsp").forward(request, response);
        }
        if ("/show".equals(path)) {
            try {
                int idVente = Integer.parseInt(request.getParameter("idVente"));
                Vente laVente = DaoVente.getConsulterVente(cnx, idVente);

                if (laVente != null) {
                    request.setAttribute("pLaVente", laVente);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/Vente/show.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/vente-servlet/lister");
                }
                
             } catch (NumberFormatException e) {
                System.out.println("Erreur : l'id de Vente n'est pas un nombre valide");
                response.sendRedirect(request.getContextPath() + "/vente-servlet/lister");
            }

        }
        if ("/show".equals(path)) {
            try {
                int idLot = Integer.parseInt(request.getParameter("idLot"));
                Lot leLot = DaoLot.getConsulterLot(cnx, idLot);
                
                if (leLot != null) {
                    request.setAttribute("pLeLot", leLot);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/vente/show.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/vente-servlet/lister");
                }
                
             } catch (NumberFormatException e) {
                System.out.println("Erreur : l'id de Vente n'est pas un nombre valide");
                response.sendRedirect(request.getContextPath() + "/vente-servlet/lister");
            }

        }/*if ("/show".equals(path)) {
            try {
                int idVente = Integer.parseInt(request.getParameter("idVente"));
                Vente laVente = DaoVente.getConsulterVente(cnx, idVente);

                if (laVente != null) {
                    request.setAttribute("pLaVente", laVente);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/Vente/show.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/vente-servlet/lister");
                }
                
                int idLot = Integer.parseInt(request.getParameter("idLot"));
                Lot leLot = DaoLot.getConsulterLot(cnx, idLot);
                
                if (leLot != null) {
                    request.setAttribute("pLeLot", leLot);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/views/vente/show.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/vente-servlet/lister");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur : l'id de Vente n'est pas un nombre valide");
                response.sendRedirect(request.getContextPath() + "/vente-servlet/lister");
            }

        }*/

        


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();

        if ("/add".equals(path)) {
            try {
                // Récupération des données du formulaire
               // int id = request.getParameter("id");
                String nom = request.getParameter("nom");
                //Date dateDebutVente = request.getParameter("dateDebutVente");
                //int raceId = Integer.parseInt(request.getParameter("race"));

                // Création d'un nouveau Vente
                Vente nouvelleVente = new Vente();
                nouvelleVente.setNom(nom);

                /*// Gestion de la date de naissance
                if (dateNaissanceStr != null && !dateNaissanceStr.isEmpty()) {
                    LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr);
                    nouvelleVente.setDateNaissance(dateNaissance);
                }*/

                // Récupération et attribution de lot
                /*Lot lot = DaoLot.getRaceById(cnx, raceId);
                if (lot != null) {
                    nouveauLot.setLot(lot);
                } else {
                    throw new Exception("La race sélectionnée n'existe pas");
                }*/

                // Tentative d'ajout en base de données
                if (DaoVente.ajouterVente(cnx, nouvelleVente)) {
                    // Redirection vers la page de consultation du Vente nouvellement créé
                    response.sendRedirect(request.getContextPath() + "/Vente-servlet/show?idVente=" + nouvelleVente.getId());
                } else {
                    throw new Exception("Erreur lors de l'enregistrement du Vente");
                }

            } catch (NumberFormatException e) {
                request.setAttribute("message", "Erreur : la race sélectionnée n'est pas valide");
                request.setAttribute("pLesRaces", DaoRace.getLesRaces(cnx));
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/vente/add.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("message", "Erreur : " + e.getMessage());
                request.setAttribute("pLesRaces", DaoRace.getLesRaces(cnx));
                this.getServletContext().getRequestDispatcher("/WEB-INF/views/vente/add.jsp").forward(request, response);
            }
        }
    }

    public void destroy() {
    }
}
