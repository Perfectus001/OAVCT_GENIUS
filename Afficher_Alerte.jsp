<%-- 
    Document   : Afficher_Alerte
    Created on : Jun 23, 2024, 11:26:00 PM
    Author     : Christina SARILUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Alerte" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des Alertes</title>
    </head>
    <body>
        <h3>Liste des Alertes</h3>
        <hr>

        <%
            List<Alerte> alertes = (List<Alerte>)request.getAttribute("alertes");
            if(alertes != null && !alertes.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ID Véhicule</th>
                    <th>Type Alerte</th>
                    <th>Lieu Incident</th>
                    <th>Date Incident</th>
                    <th>Heure Incident</th>
                    <th>Nom Déclarant</th>
                    <th>Prénom Déclarant</th>
                    <th>Téléphone Déclarant</th>
                    <th>Description</th>
                    <th>Date Enregistrement</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(Alerte alerte : alertes) {
                %>
                <tr>
                    <td><%= alerte.getID() %></td>
                    <td><%= alerte.getIdvehicule() %></td>
                    <td><%= alerte.getTypeAlerte() %></td>
                    <td><%= alerte.getLieuIncident() %></td>
                    <td><%= alerte.getDateIncident() %></td>
                    <td><%= alerte.getHeureIncident() %></td>
                    <td><%= alerte.getNomDeclarant() %></td>
                    <td><%= alerte.getPrenomDeclarant() %></td>
                    <td><%= alerte.getTelDeclarant() %></td>
                    <td><%= alerte.getDescription() %></td>
                    <td><%= alerte.getDateEnregistrement() %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <% } else { %>
            <p>Aucune alerte trouvée.</p>
        <% } %>
    </body>
</html>

