<%-- 
    Document   : Afficher_Assurance
    Created on : 21 juin 2024, 17:39:40
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Assurance" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<h2>Liste de Paiement</h2>
<h4>Renouvellement assurance</h4>
        <hr>
                <%List<Assurance> list = (List<Assurance>)request.getAttribute("listes");
                if(list != null && !list.isEmpty()){%>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ID VEHICULE</th>
                    <th>MONTANT ASSURANCE</th>
                    <th>DATE PAIEMENT</th>
                    <th>DATE FIN ASSURANCE</th>
                </tr>
            </thead>
            <tbody>    
                <%
                for(Assurance a:list){%>
                <tr>
                    <td><%= a.getId() %></td>
                    <td><%= a.getIdVehicule() %></td>
                    <td><%= a.getMontantAssurance() %></td>
                    <td><%= a.getDatePaiement() %></td>
                    <td><%= a.getDateFinAssurance() %></td>
                </tr>
                <%}}else{%>
                    <p>Aucune donnee a ete trouve</p>
                <%}%>
            </tbody>
        </table>
        <button><a href="${pageContext.request.contextPath}/VehiculeServlet">Retour</a></button>
    </body>
</html>
