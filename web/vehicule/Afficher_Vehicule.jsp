<%-- 
    Document   : Afficher_Vehicule
    Created on : 17 juin 2024, 17:04:31
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Vehicule" %>
<%@page import="model.Proprietaire" %>
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
                List<Proprietaire> listP = (List<Proprietaire>)request.getAttribute("proprietaires");
                if(list != null && listP !=null && !list.isEmpty() && !listP.isEmpty()){%>
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
                for(Vehicule v:list){
                    for(Proprietaire p:listP){
                        if(v.getIdProprietaire().equalsIgnoreCase(p.getId())){%>
                <tr>
                    <td><%= v.getId() %></td>
                    <td><%= v.getMarque() %></td>
                    <td><%= v.getModele() %></td>
                    <td><%= v.getCouleur() %></td>
                    <td><%= v.getPlaqueImmatriculation() %></td>
                    <td><%= p.getNom() %></td>
                    <td><%= p.getPrenom() %></td>
                    <td><%= p.getSexe() %></td>
                    <td><%= p.getTel() %></td>
                    <td><%= p.getCourriel() %></td>
                    <td><%= v.isAlerte() %></td>
                    <td><a href="${pageContext.request.contextPath}/VehiculeServlet?id=<%=v.getId()+ "&opt=search"%>"> plus</a></td>
                </tr>
                <%}}}}else{%>
                    <p>Aucune donnee a ete trouve</p>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
