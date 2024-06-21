/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.ProprietaireDao;
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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Vehicule;
import model.Proprietaire;

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
    Proprietaire modelp = null;
    VehiculeDao dao = new VehiculeDao();
    ProprietaireDao pdao = new ProprietaireDao();
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
        String action = request.getParameter("opt");
        if(action == null){
            try {
                display(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            String id = request.getParameter("id");
            switch(action){
                case "search":{
                    try {
                        Vehicule vehicule = dao.get(id);
                        
                        if(vehicule != null){
                            Proprietaire proprietaire = pdao.get(vehicule.getIdProprietaire());
                            if (proprietaire != null) {
                                request.setAttribute("proprietaires", proprietaire);
                                request.setAttribute("vehicules", vehicule);
                                request.getRequestDispatcher("/vehicule/Recherche_Vehicule.jsp?").forward(request, response);
                            }
                        }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "mod":{
                    try {
                        Vehicule vehicule = dao.get(id);
                        
                        if(vehicule != null){
                            Proprietaire proprietaire = pdao.get(vehicule.getIdProprietaire());
                            if (proprietaire != null) {
                                request.setAttribute("proprietaires", proprietaire);
                                request.setAttribute("vehicules", vehicule);
                                request.getRequestDispatcher("/vehicule/Modifier_Vehicule.jsp?").forward(request, response);
                            }
                        }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "sup":{
                    try {
                        Vehicule vehicule = dao.get(id);
                        
                        if(vehicule != null){
                            if(dao.delete(id) > 0){
                                System.out.println("Suppression effectuee avec succes !");
                                display(request,response);
                            }else{
                                System.out.println("Impossible de supprimer ce vehicule !");
                            }
                        }else{
                            System.out.println("ID introuvable");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "dalt":{
                    try {
                        Vehicule vehicule = dao.get(id);
                        
                        if(vehicule != null){
                            if(dao.desactiverAlerte(vehicule) > 0){
                                System.out.println("Desactivation de l'alerte effectuee avec succes !");
                                display(request,response);
                            }else{
                                System.out.println("Impossible de desactiver l'alerte de ce vehicule !");
                            }
                        }else{
                            System.out.println("ID introuvable");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "alt":{
                    try {
                        Vehicule vehicule = dao.get(id);
                        
                        if(vehicule != null){
                            if(dao.activerAlerte(vehicule) > 0){
                                System.out.println("Activation de l'alerte effectuee avec succes !");
                                display(request,response);
                            }else{
                                System.out.println("Impossible d'activer l'alerte de ce vehicule !");
                            }
                        }else{
                            System.out.println("ID introuvable");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                }
                default:
            }
        }

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
                        //display(request,response);
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                } 
                case "Modifier":
                {
                    try {
                        update(request,response);
                        display(request,response);
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                } 
                default:
                {
                    try {
                        display(request,response);
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }
    
    protected void save(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        model = new Vehicule();
        modelp = new Proprietaire();
        // Map pour stocker les messages d'erreur
        Map<String, String> errors = new HashMap<>();
        
        if(!request.getParameter("marque").isEmpty()){
            model.setMarque(request.getParameter("marque"));
        } else {
            errors.put("marque", "Erreur d'insertion");
        }
        System.out.println(model.getMarque());
        if(!request.getParameter("modele").isEmpty()){
            model.setModele(request.getParameter("modele"));
        } else {
            errors.put("modele", "Erreur d'insertion");
        }
        if(!request.getParameter("couleur").isEmpty()){
            model.setCouleur(request.getParameter("couleur"));
        } else {
            errors.put("couleur", "Erreur d'insertion");
        }
        
        if(!request.getParameter("noMoteur").isEmpty()){
            model.setNoMoteur(request.getParameter("noMoteur"));
        } else {
            errors.put("noMoteur", "Erreur d'insertion");
        }
        
        if(testRegex(request.getParameter("nbCylindre"), "^\\d+$")){
            model.setNbCylindre(Integer.parseInt(request.getParameter("nbCylindre")));
        }else{
            errors.put("nbCylindre", "Erreur d'insertion");
        }
        
        if(!request.getParameter("typeTransmission").isEmpty()){
            model.setTypeTransmission(request.getParameter("typeTransmission"));
        } else {
            errors.put("typeTransmission", "Erreur d'insertion");
        }
        
        if(!request.getParameter("typeEssence").isEmpty()){
            model.setTypeEssence(request.getParameter("typeEssence"));
        } else {
            errors.put("typeEssence", "Erreur d'insertion");
        }
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
        } else{
            errors.put("photo", "Erreur d'insertion");
        }
        
        if(!request.getParameter("plaqueImmatriculation").isEmpty()){
            model.setPlaqueImmatriculation(request.getParameter("plaqueImmatriculation"));
        } else {
            errors.put("plaqueImmatriculation", "Erreur d'insertion");
        }
        
        if(testRegex(request.getParameter("nomProprietaire"), "^[A-Z]+(?:[- ][A-Z]+)*$")){
            modelp.setNom(request.getParameter("nomProprietaire"));
        }else{
            errors.put("nomProprietaire", "Erreur d'insertion");
        }
        
        if(testRegex(request.getParameter("prenomProprietaire"), "^[A-Z][a-zÀ-ÿ]*(?:[-\\s][A-Z][a-zÀ-ÿ]*)*$")){
            modelp.setPrenom(request.getParameter("prenomProprietaire"));
        }else{
            errors.put("prenomProprietaire", "Erreur d'insertion");
        }
        
        if(!request.getParameter("sexeProprietaire").isEmpty()){
            modelp.setSexe(request.getParameter("sexeProprietaire"));
        } else {
            errors.put("sexeProprietaire", "Erreur d'insertion");
        }
        
        if(testRegex(request.getParameter("telProprietaire"), "^(3[0-9]|4[0-46-9]|55)\\d{6}$")){
            modelp.setTel(request.getParameter("telProprietaire"));
        }else{
            errors.put("telProprietaire", "Erreur d'insertion");
        }
        
        if(!request.getParameter("adresseProprietaire").isEmpty()){
            modelp.setAdresse(request.getParameter("adresseProprietaire"));
        } else {
            errors.put("adresseProprietaire", "Erreur d'insertion");
        }
        
        if(!request.getParameter("typePieceProp").isEmpty()){
            modelp.setTypePiece(request.getParameter("typePieceProp"));
        } else {
            errors.put("typePieceProp", "Erreur d'insertion");
        }
        
        if(!request.getParameter("noPiece").isEmpty()){
            modelp.setNoPiece(request.getParameter("noPiece"));
        } else {
            errors.put("noPiece", "Erreur d'insertion");
        }
        
        if(testRegex(request.getParameter("annee"), "^\\d{4}$")){
            model.setAnnee(Integer.parseInt(request.getParameter("annee")));
        }else{
            errors.put("annee", "Erreur d'insertion");
        }
        
        
        if(request.getParameter("alerte") != null){
            if(request.getParameter("alerte").equalsIgnoreCase("true")){
                model.setAlerte(true);
            }
            else{
                model.setAlerte(false);
            }
        }
        
        if(testRegex(request.getParameter("courrielProprietaire"), "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            modelp.setCourriel(request.getParameter("courrielProprietaire"));
        }else{
            errors.put("courrielProprietaire", "Erreur d'insertion");
        }
        
        if(!errors.isEmpty()){
            request.setAttribute("errors", errors);
            // Redirection vers la page du formulaire
            request.getRequestDispatcher("/vehicule/Enregistrement_Vehicule.jsp").forward(request, response);
        }else{
            try {
                String idProprietaire = pdao.saveP(modelp);
                if(idProprietaire != null){
                    try {
                        if (dao.saveV(model, idProprietaire) > 0) {
                            System.out.println("OK!!!");
                        }
                    }catch (ClassNotFoundException ex) {
                        System.out.println("Erreur 2:" + ex.getMessage());
                    }
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("Erreur Proprietaire:" + ex.getMessage());
            }
        }      
    }
    
        protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        model = new Vehicule();
        modelp = new Proprietaire();
        // Map pour stocker les messages d'erreur
        Map<String, String> errors = new HashMap<>();
        
        model.setId(request.getParameter("id"));
        System.out.println(request.getParameter("id2"));
        modelp.setId(request.getParameter("id2"));
        
        if(!request.getParameter("marque").isEmpty()){
            model.setMarque(request.getParameter("marque"));
        } else {
            errors.put("marque", "Erreur d'insertion");
        }
        System.out.println(model.getMarque());
        if(!request.getParameter("modele").isEmpty()){
            model.setModele(request.getParameter("modele"));
        } else {
            errors.put("modele", "Erreur d'insertion");
        }
        if(!request.getParameter("couleur").isEmpty()){
            model.setCouleur(request.getParameter("couleur"));
        } else {
            errors.put("couleur", "Erreur d'insertion");
        }
        
        if(!request.getParameter("noMoteur").isEmpty()){
            model.setNoMoteur(request.getParameter("noMoteur"));
        } else {
            errors.put("noMoteur", "Erreur d'insertion");
        }
        
        if(testRegex(request.getParameter("nbCylindre"), "^\\d+$")){
            model.setNbCylindre(Integer.parseInt(request.getParameter("nbCylindre")));
        }else{
            errors.put("nbCylindre", "Erreur d'insertion");
        }
        
        if(!request.getParameter("typeTransmission").isEmpty()){
            model.setTypeTransmission(request.getParameter("typeTransmission"));
        } else {
            errors.put("typeTransmission", "Erreur d'insertion");
        }
        
        if(!request.getParameter("typeEssence").isEmpty()){
            model.setTypeEssence(request.getParameter("typeEssence"));
        } else {
            errors.put("typeEssence", "Erreur d'insertion");
        }
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
        } else{
            errors.put("photo", "Erreur d'insertion");
        }
        
        if(!request.getParameter("plaqueImmatriculation").isEmpty()){
            model.setPlaqueImmatriculation(request.getParameter("plaqueImmatriculation"));
        } else {
            errors.put("plaqueImmatriculation", "Erreur d'insertion");
        }
        
        if(testRegex(request.getParameter("nomProprietaire"), "^[A-Z]+(?:[- ][A-Z]+)*$")){
            modelp.setNom(request.getParameter("nomProprietaire"));
        }else{
            errors.put("nomProprietaire", "Erreur d'insertion");
        }
        
        if(testRegex(request.getParameter("prenomProprietaire"), "^[A-Z][a-zÀ-ÿ]*(?:[-\\s][A-Z][a-zÀ-ÿ]*)*$")){
            modelp.setPrenom(request.getParameter("prenomProprietaire"));
        }else{
            errors.put("prenomProprietaire", "Erreur d'insertion");
        }
        
        if(!request.getParameter("sexeProprietaire").isEmpty()){
            modelp.setSexe(request.getParameter("sexeProprietaire"));
        } else {
            errors.put("sexeProprietaire", "Erreur d'insertion");
        }
        
        if(testRegex(request.getParameter("telProprietaire"), "^(3[0-9]|4[0-46-9]|55)\\d{6}$")){
            modelp.setTel(request.getParameter("telProprietaire"));
        }else{
            errors.put("telProprietaire", "Erreur d'insertion");
        }
        
        if(!request.getParameter("adresseProprietaire").isEmpty()){
            modelp.setAdresse(request.getParameter("adresseProprietaire"));
        } else {
            errors.put("adresseProprietaire", "Erreur d'insertion");
        }
        
        if(!request.getParameter("typePieceProp").isEmpty()){
            modelp.setTypePiece(request.getParameter("typePieceProp"));
        } else {
            errors.put("typePieceProp", "Erreur d'insertion");
        }
        
        if(!request.getParameter("noPiece").isEmpty()){
            modelp.setNoPiece(request.getParameter("noPiece"));
        } else {
            errors.put("noPiece", "Erreur d'insertion");
        }
        
        if(testRegex(request.getParameter("annee"), "^\\d{4}$")){
            model.setAnnee(Integer.parseInt(request.getParameter("annee")));
        }else{
            errors.put("annee", "Erreur d'insertion");
        }
        
        
        if(request.getParameter("alerte") != null){
            if(request.getParameter("alerte").equalsIgnoreCase("true")){
                model.setAlerte(true);
            }
            else{
                model.setAlerte(false);
            }
        }
        
        if(testRegex(request.getParameter("courrielProprietaire"), "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            modelp.setCourriel(request.getParameter("courrielProprietaire"));
        }else{
            errors.put("courrielProprietaire", "Erreur d'insertion");
        }
        
        /*if(!request.getParameter("dateAlerte").isEmpty()){
            LocalDate dateAlerte = LocalDate.parse(request.getParameter("dateAlerte"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            model.setDateAlerte(dateAlerte);
        }else{
            model.setDateAlerte(null);
        }*/
        
        if(!errors.isEmpty()){
            request.setAttribute("errors", errors);
            // Redirection vers la page du formulaire
            request.getRequestDispatcher("/vehicule/Modifier_Vehicule.jsp").forward(request, response);
        }else{
            try {
                if (pdao.update(modelp) > 0) {
                    System.out.println("OK!!!");
                }
            }catch (ClassNotFoundException ex) {
                System.out.println("Erreur 2:" + ex.getMessage());
            }
            try {
                if (dao.update(model) > 0) {
                    
                    System.out.println("OK!!!");
                }
            }catch (ClassNotFoundException ex) {
                System.out.println("Erreur 2:" + ex.getMessage());
            }
        }      
    }
    
    protected void display(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            List<Proprietaire> listeP = pdao.getAll();
            List<Vehicule> liste = dao.getAll();
            
            request.setAttribute("proprietaires", listeP);
            request.setAttribute("vehicules", liste);
            
            // redirection vers la page afficher
            request.getRequestDispatcher("/vehicule/Afficher_Vehicule.jsp?").forward(request, response);
        } catch (SQLException ex) {
            System.out.println("Erreur 1:" + ex.getMessage());

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean testRegex(String str1, String str2){
        
        // Compile le regex en un objet Pattern
        Pattern pattern = Pattern.compile(str2);
        
        // Crée un objet Matcher pour effectuer la correspondance
        Matcher matcher = pattern.matcher(str1);
        
        return matcher.matches();
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
