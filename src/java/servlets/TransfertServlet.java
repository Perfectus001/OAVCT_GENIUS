/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.ProprietaireDao;
import dao.TransfertDao;
import dao.VehiculeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Proprietaire;
import model.Transfert;
import model.Vehicule;

/**
 *
 * @author Perfectus
 */
public class TransfertServlet extends HttpServlet {

    Vehicule model = null;
    Proprietaire modelp = null;
    Transfert modelt = null;
    VehiculeDao dao = new VehiculeDao();
    ProprietaireDao pdao = new ProprietaireDao();
    TransfertDao tdao = new TransfertDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        if (action == null) {
            try {
                display(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String id = request.getParameter("id");
            switch (action) {
                case "approuv": {
                    try {
                        Transfert transfert = tdao.get(id);

                        if (transfert != null) {
                            model = dao.get(transfert.getIdVehicule());
                            transfert.setEtat("A");
                            if (tdao.update(transfert) > 0) {
                                model.setIdProprietaire(transfert.getIdNewProprietaire());
                                if (dao.updateVT(model) > 0) {
                                    System.out.println("OK");
                                    display(request, response);
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "napprouv": {
                    try {
                        Transfert transfert = tdao.get(id);
                        if (transfert != null) {
                            if (tdao.delete(id) > 0) {
                                if (dao.getProprietaire(transfert.getIdNewProprietaire())) {
                                    pdao.get(transfert.getIdNewProprietaire());
                                }
                                System.out.println("Suppression effectuee avec succes !");
                                display(request, response);
                            } else {
                                System.out.println("Impossible de supprimer ce vehicule !");
                            }
                        } else {
                            System.out.println("ID introuvable");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                default: {
                    try {
                        display(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(TransfertServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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
        String idV = request.getParameter("id1");
        if (action == null) {
            Logger.getLogger(AssuranceServlet.class.getName()).log(Level.SEVERE, "Action is null");
        } else {
            switch (action) {
                case "Enregistrer": {
                    System.out.println(action);
                    try {
                        save(request, response);
                        display(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "Recherche": {
                    if (!idV.isEmpty()) {
                        try {
                            Vehicule vehicule = dao.get(idV);
                            if (vehicule.getId() != null) {
                                request.setAttribute("IDVehicule", vehicule.getId());
                                request.getRequestDispatcher("/transfert/Enregistrement_Transfert.jsp?").forward(request, response);
                            } else {
                                request.setAttribute("error", "Aucun vehicule trouve!!!");
                                request.getRequestDispatcher("/transfert/Enregistrement_Transfert.jsp?").forward(request, response);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AssuranceServlet.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(AssuranceServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        request.setAttribute("error", "Une erreur s'est produite");
                        request.getRequestDispatcher("/transfert/Enregistrement_Transfert.jsp?").forward(request, response);
                    }
                    break;
                }
                default: {
                    try {
                        display(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(AssuranceServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }

        }
    }

    protected void save(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        model = new Vehicule();
        modelp = new Proprietaire();
        modelt = new Transfert();
        // Map pour stocker les messages d'erreur
        Map<String, String> errors = new HashMap<>();

        if (!request.getParameter("idVehicule").isEmpty()) {
            modelt.setIdVehicule(request.getParameter("idVehicule"));
        } else {
            errors.put("idVehicule", "Erreur d'insertion");
        }
        if (testRegex(request.getParameter("nomProprietaire").toUpperCase(), "^[A-Z]+(?:[- ][A-Z]+)*$")) {
            modelp.setNom(request.getParameter("nomProprietaire"));
        } else {
            errors.put("nomProprietaire", "Erreur d'insertion");
        }

        if (testRegex(Proprietaire.prenom(request.getParameter("prenomProprietaire")), "^[A-Z][a-zÀ-ÿ]*(?:[-\\s][A-Z][a-zÀ-ÿ]*)*$")) {
            modelp.setPrenom(request.getParameter("prenomProprietaire"));
        } else {
            errors.put("prenomProprietaire", "Erreur d'insertion");
        }

        if (!request.getParameter("sexeProprietaire").isEmpty()) {
            modelp.setSexe(request.getParameter("sexeProprietaire"));
        } else {
            errors.put("sexeProprietaire", "Erreur d'insertion");
        }

        if (testRegex(request.getParameter("telProprietaire"), "^(3[0-9]|4[0-46-9]|55)\\d{6}$")) {
            modelp.setTel(request.getParameter("telProprietaire"));
        } else {
            errors.put("telProprietaire", "Erreur d'insertion");
        }

        if (!request.getParameter("adresseProprietaire").isEmpty()) {
            modelp.setAdresse(request.getParameter("adresseProprietaire"));
        } else {
            errors.put("adresseProprietaire", "Erreur d'insertion");
        }

        if (!request.getParameter("typePieceProp").isEmpty()) {
            modelp.setTypePiece(request.getParameter("typePieceProp"));
        } else {
            errors.put("typePieceProp", "Erreur d'insertion");
        }

        if (!request.getParameter("noPiece").isEmpty()) {
            modelp.setNoPiece(request.getParameter("noPiece"));
        } else {
            errors.put("noPiece", "Erreur d'insertion");
        }

        if (testRegex(request.getParameter("courrielProprietaire"), "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            modelp.setCourriel(request.getParameter("courrielProprietaire"));
        } else {
            errors.put("courrielProprietaire", "Erreur d'insertion");
        }

        if (!request.getParameter("motifTransfert").isEmpty()) {
            modelt.setMotifTransfert(request.getParameter("motifTransfert"));
        } else {
            errors.put("motifTransfert", "Erreur d'insertion");
        }

        if (!request.getParameter("etat").isEmpty()) {
            modelt.setEtat(request.getParameter("etat"));
        } else {
            modelt.setEtat("E");
        }

        if (!errors.isEmpty()) {
            request.setAttribute("idV2", modelt.getIdVehicule());
            request.setAttribute("errors", errors);
            // Redirection vers la page du formulaire
            request.getRequestDispatcher("/transfert/Enregistrement_Transfert.jsp").forward(request, response);
        } else {
            try {
                if (modelt.getEtat().equalsIgnoreCase("A")) {
                    String idProprietaire = pdao.getExist(modelp.getTypePiece(), modelp.getNoPiece());
                    if (idProprietaire == null) {
                        idProprietaire = pdao.saveP(modelp);
                    }
                    if (idProprietaire != null) {
                        try {
                            model = dao.get(modelt.getIdVehicule());
                            if (model != null && !model.isAlerte()) {
                                modelt.setIdExProprietaire(model.getIdProprietaire());
                                model.setIdProprietaire(idProprietaire);
                                if (tdao.saveT(modelt, idProprietaire) > 0) {
                                    if (dao.updateVT(model) > 0) {
                                        System.out.println("OK!!!");
                                    }
                                }
                            }
                        } catch (ClassNotFoundException ex) {
                            System.out.println("Erreur 2:" + ex.getMessage());
                        }
                    }
                } else {
                    String idProprietaire = pdao.getExist(modelp.getTypePiece(), modelp.getNoPiece());
                    if (idProprietaire == null) {
                        idProprietaire = pdao.saveP(modelp);
                    }
                    if (idProprietaire != null) {
                        model = dao.get(modelt.getIdVehicule());
                        if (model != null) {
                            modelt.setIdExProprietaire(model.getIdProprietaire());
                            if (tdao.saveT(modelt, idProprietaire) > 0) {
                                System.out.println("OK!==!!");
                            }
                        }
                    }
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("Erreur Proprietaire:" + ex.getMessage());
            }
        }
    }

    protected void display(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            List<Transfert> liste = tdao.getAll();

            request.setAttribute("listes", liste);
            if(!response.isCommitted()){
                // redirection vers la page afficher
                request.getRequestDispatcher("/transfert/Afficher_Transfert.jsp?").forward(request, response);   
            }
        } catch (SQLException ex) {
            System.out.println("Erreur 3:" + ex.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean testRegex(String str1, String str2) {

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
