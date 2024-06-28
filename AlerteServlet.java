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
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import model.Alerte;
/**
 *
 * @author Christina SARILUS
 */


@WebServlet("/EnregistrerAlerteServlet")
public class EnregistrerAlerteServlet extends HttpServlet {

    @EJB
    private AlerteVehiculeService alerteService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<>();
        String idvehicule = request.getParameter("idvehicule");
        String typeAlerte = request.getParameter("typeAlerte");
        String lieuIncident = request.getParameter("lieuIncident");
        String dateincidentStr = request.getParameter("dateincident");
        String heureIncidentStr = request.getParameter("heureIncident");
        String nomDeclarant = request.getParameter("nomDeclarant");
        String prenomDeclarant = request.getParameter("prenomDeclarant");
        String telDeclarant = request.getParameter("telDeclarant");
        String description = request.getParameter("description");

        if (idvehicule == null || idvehicule.trim().isEmpty()) {
            errors.put("idvehicule", "ID Véhicule est requis.");
        }
        if (typeAlerte == null || typeAlerte.trim().isEmpty()) {
            errors.put("typeAlerte", "Type d'alerte est requis.");
        }
        if (lieuIncident == null || lieuIncident.trim().isEmpty()) {
            errors.put("lieuIncident", "Lieu de l'incident est requis.");
        }
        Date dateincident = null;
        try {
            dateincident = Date.valueOf(dateincidentStr);
        } catch (IllegalArgumentException e) {
            errors.put("dateincident", "Date de l'incident invalide.");
        }
        Timestamp heureIncident = null;
        try {
            heureIncident = Timestamp.valueOf(LocalTime.parse(heureIncidentStr) + ":00");
        } catch (DateTimeParseException e) {
            errors.put("heureIncident", "Heure de l'incident invalide.");
        }
        if (nomDeclarant == null || nomDeclarant.trim().isEmpty()) {
            errors.put("nomDeclarant", "Nom du déclarant est requis.");
        }
        if (prenomDeclarant == null || prenomDeclarant.trim().isEmpty()) {
            errors.put("prenomDeclarant", "Prénom du déclarant est requis.");
        }
        if (telDeclarant == null || telDeclarant.trim().isEmpty()) {
            errors.put("telDeclarant", "Téléphone du déclarant est requis.");
        }

        if (errors.isEmpty()) {
            Alerte alerte = new Alerte();
            alerte.setIdvehicule(idvehicule);
            alerte.setTypeAlerte(typeAlerte);
            alerte.setLieuIncident(lieuIncident);
            alerte.setDateIncident(dateincident);
            alerte.setHeureIncident(heureIncident);
            alerte.setNomDeclarant(nomDeclarant);
            alerte.setPrenomDeclarant(prenomDeclarant);
            alerte.setTelDeclarant(telDeclarant);
            alerte.setDescription(description);

            alerteService.saveAlerte(alerte);
            response.sendRedirect("success.jsp");
        } else {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/Enregistrer_Alerte.jsp").forward(request, response);
        }
    }
}

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
        processRequest(request, response);
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
        processRequest(request, response);
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
