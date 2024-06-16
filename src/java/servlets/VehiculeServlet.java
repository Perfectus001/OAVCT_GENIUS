/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.VehiculeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Vehicule;

/**
 *
 * @author Perfectus
 */

/**
 * Servlet pour gérer les téléchargements de fichiers
 */
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)

public class VehiculeServlet extends HttpServlet {

    Vehicule model = null;
    VehiculeDao dao = new VehiculeDao();
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("opt");
        if (action == null) {
            
        } else {
           // String id=request.getParameter("id");
            switch (action) {
                case "Enregistrer":
                {
                    try {
                        save(request,response);
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;
                case "Modifier":
                    //update(request,response);
                    break;
                default:
                    //display(request,response);
            }
        }
    }
    
    protected void save(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        model = new Vehicule();
        model.setMarque(request.getParameter("marque"));
        model.setModele(request.getParameter("modele"));
        model.setCouleur(request.getParameter("couleur"));
        model.setNoMoteur(request.getParameter("noMoteur"));
        model.setNbCylindre(Integer.parseInt(request.getParameter("nbCylindre")));
        model.setTypeTransmission(request.getParameter("typeTransmission"));
        model.setTypeEssence(request.getParameter("typeEssence"));
        // Récupérez et traitez les autres paramètres ici
        
        // Récupérez l'image
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            try (InputStream inputStream = filePart.getInputStream();
                 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                }
                model.setPhotoVehicule(byteArrayOutputStream.toByteArray());
            }
        }
        model.setPlaqueImmatriculation(request.getParameter("plaqueImmatriculation"));
        model.setNomProprietaire(request.getParameter("nomProprietaire"));
        model.setPrenomProprietaire(request.getParameter("prenomProprietaire"));
        model.setSexeProprietaire(request.getParameter("sexeProprietaire"));
        model.setTelProprietaire(request.getParameter("telProprietaire"));
        model.setAdresseProprietaire(request.getParameter("adresseProprietaire"));
        model.setTypePieceProp(request.getParameter("typePieceProp"));
        model.setNoPiece(request.getParameter("noPiece"));
        model.setAnnee(Integer.parseInt(request.getParameter("annee")));
        if(request.getParameter("alerte") != null){
            if(request.getParameter("alerte").equalsIgnoreCase("true")){
                model.setAlerte(true);
            }
            else{
                model.setAlerte(false);
            }
        }

        model.setCourrierProprietaire(request.getParameter("courrierProprietaire"));
        LocalDate dateAlerte = LocalDate.parse(request.getParameter("dateAlerte"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        model.setDateAlerte(dateAlerte);
        try {
            if (dao.save(model) > 0) {
                System.out.println("OK!!!");
            }
        }catch (ClassNotFoundException ex) {
            System.out.println("Erreur 2:" + ex.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
