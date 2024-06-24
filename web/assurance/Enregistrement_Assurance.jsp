<%-- 
    Document   : Enregistrement_Assurance
    Created on : 21 juin 2024, 16:50:35
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id = (String) request.getAttribute("IDVehicule");
            String error = (String) request.getAttribute("error");
            Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
            if(id == null){
        %>
       
        <form action="${pageContext.request.contextPath}/AssuranceServlet" method="post">
           <p>
                <label for="id1">ID du vehicule</label>
                <input type="text" name="id1">
                <% if (error != null) { %>
                    <br><span style="color: red;"><%= error %></span>
                <% } %>
            </p>
            <p>
                <input type="submit" name="opt" value="Recherche">
            </p>
        </form>
        
        <% 
        }else{    
        
        %>

        <form action="${pageContext.request.contextPath}/AssuranceServlet" method="post">
            <h3><%=id!=null?id:""%></h3>
            
            <input type="hidden" name="idVehicule" value="<%=id!=null?id:""%>">

            
            <p>
                <label for="montantAssurance">Montant Assurance</label>
                <input type="text" name="montantAssurance">
                <% if (errors != null && errors.containsKey("montantAssurance")) { %>
                    <br><span style="color: red;"><%= errors.get("montantAssurance") %></span>
                <% } %>                
            </p>
            <p>
                <label for="datePaiement">Date Paiement</label>
                <input type="date" name="datePaiement">
                <% if (errors != null && errors.containsKey("datePaiement")) { %>
                    <br><span style="color: red;"><%= errors.get("datePaiement") %></span>
                <% } %>                
            </p>
            <p>
                <label for="dateFinAssurance">Date Fin Assurance</label>
                <input type="date" name="dateFinAssurance">
                <% if (errors != null && errors.containsKey("dateFinAssurance")) { %>
                    <br><span style="color: red;"><%= errors.get("dateFinAssurance") %></span>
                <% } %>
            </p>
            <p>
                <input type="submit" name="opt" value="Enregistrer">
            </p>
        </form>
            <%}%>
    </body>
</html>
