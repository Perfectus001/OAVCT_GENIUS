<%-- 
    Document   : Afficher_Vehicule
    Created on : 17 juin 2024, 17:04:31
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Vehicule" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Vehicule</h3>
        <hr>

                <%List<Vehicule> list = (List<Vehicule>)request.getAttribute("vehicules");
                if(list != null && !list.isEmpty()){%>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>MARQUE</th>
                    <th>MODELE</th>
                    <th>COULEUR</th>
                    <th>PLAQUE D'IMMATRICULATION</th>
                    <th>NOM PROPRIETAIRE</th>
                    <th>PRENOM PROPRIETAIRE</th>
                    <th>SEXE PROPRIETAIRE</th>
                    <th>TELEPHONE</th>
                    <th>COURRIEL</th>
                    <th>ALERTE</th>
                    <th>ACTIONS</th>
                </tr>
            </thead>
            <tbody>    
                <%
                for(Vehicule v:list){%>
                <tr>
                    <td><%= v.getId() %></td>
                    <td><%= v.getMarque() %></td>
                    <td><%= v.getModele() %></td>
                    <td><%= v.getCouleur() %></td>
                    <td><%= v.getPlaqueImmatriculation() %></td>
                    <td><%= v.getNomProprietaire() %></td>
                    <td><%= v.getPrenomProprietaire() %></td>
                    <td><%= v.getSexeProprietaire() %></td>
                    <td><%= v.getTelProprietaire() %></td>
                    <td><%= v.getCourrielProprietaire() %></td>
                    <td><%= v.isAlerte() %></td>
                    <td><a href="${pageContext.request.contextPath}/VehiculeServlet?id=<%=v.getId()+ "&opt=search"%>"> plus</a></td>
                </tr>
    <%}}else{%>
                    <p>Aucune donnee a ete trouve</p>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
