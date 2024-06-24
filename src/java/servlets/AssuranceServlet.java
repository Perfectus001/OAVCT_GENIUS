/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assurance;
import dao.AssuranceDao;
import dao.VehiculeDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Date;
import model.Vehicule;

/**
 *
 * @author Perfectus
 */
public class AssuranceServlet extends HttpServlet {
    Assurance model = null;
    AssuranceDao adao = new AssuranceDao();

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
        try {
            display(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AssuranceServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } else{
            switch(action){
                case "Enregistrer":{
                    System.out.println(action);
                    try {
                        save(request,response);
                        display(request,response);
                    } catch (SQLException ex) {
                        Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case "Recherche":{
                    if(!idV.isEmpty()){
                        VehiculeDao dao = new VehiculeDao();
                        try {
                            Vehicule vehicule = dao.get(idV);
                            if(vehicule.getId()!=null){
                                request.setAttribute("IDVehicule", vehicule.getId());
                                request.getRequestDispatcher("/assurance/Enregistrement_Assurance.jsp?").forward(request, response);                                
                            }else{
                                request.setAttribute("error", "Aucun vehicule trouve!!!");
                                request.getRequestDispatcher("/assurance/Enregistrement_Assurance.jsp?").forward(request, response);  
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AssuranceServlet.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(AssuranceServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        request.setAttribute("error", "Une erreur s'est produite");
                        request.getRequestDispatcher("/assurance/Enregistrement_Assurance.jsp?").forward(request, response);
                    }
                    break;
                }
                default:{
                    try {
                        display(request,response);
                    } catch (SQLException ex) {
                        Logger.getLogger(AssuranceServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }                    
                }
            }
           // String id=request.getParameter("id");

        }
    }
    
    protected void save(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        model = new Assurance();
        // Map pour stocker les messages d'erreur
        Map<String, String> errors = new HashMap<>();
        
        if(!request.getParameter("idVehicule").isEmpty()){
            model.setIdVehicule(request.getParameter("idVehicule"));
        } else {
            errors.put("idVehicule", "Erreur d'insertion");
        }
        if(!request.getParameter("montantAssurance").isEmpty()){
            model.setMontantAssurance(Double.parseDouble(request.getParameter("montantAssurance")) );
        } else {
            errors.put("montantAssurance", "Erreur d'insertion");
        }
        if(!request.getParameter("datePaiement").isEmpty()){
            model.setDatePaiement(Date.valueOf(request.getParameter("datePaiement")) );
        } else {
            errors.put("datePaiement", "Erreur d'insertion");
        }
        
        if(!request.getParameter("dateFinAssurance").isEmpty()){
            model.setDateFinAssurance(Date.valueOf(request.getParameter("dateFinAssurance")));
        } else {
            errors.put("dateFinAssurance", "Erreur d'insertion");
        }
        
        if(!errors.isEmpty()){
            request.setAttribute("errors", errors);
            // Redirection vers la page du formulaire
            request.getRequestDispatcher("/vehicule/Enregistrement_Vehicule.jsp").forward(request, response);
        }else{
            try {
                if (adao.save(model) > 0) {
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
            List<Assurance> liste = adao.getAll();
            
            request.setAttribute("listes", liste);
            
            // redirection vers la page afficher
            request.getRequestDispatcher("/assurance/Afficher_Assurance.jsp?").forward(request, response);
        } catch (SQLException ex) {
            System.out.println("Erreur 1:" + ex.getMessage());

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(VehiculeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
