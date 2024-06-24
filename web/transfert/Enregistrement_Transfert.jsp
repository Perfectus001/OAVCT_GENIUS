<%-- 
    Document   : Enregistrement_Transfert
    Created on : 23 juin 2024, 07:56:04
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="model.Transfert" %>
<%@page import="model.Proprietaire" %>
<%@page import="model.Vehicule" %>
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
        
        <form action="${pageContext.request.contextPath}/TransfertServlet" method="post">
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
        <%}else{%>

        <form action="${pageContext.request.contextPath}/TransfertServlet" method="post">
            <h3><%=id!=null?id:""%></h3>
            
            <input type="hidden" name="idVehicule" value="<%=id!=null?id:""%>">
            <p>
                <label for="nomProprietaire">Nom</label>
                <input type="text" name="nomProprietaire">
                <% if (errors != null && errors.containsKey("nomProprietaire")) { %>
                    <br><span style="color: red;"><%= errors.get("nomProprietaire") %></span>
                <% } %>
            </p>
            <p>
                <label for="prenomProprietaire">Prenom</label>
                <input type="text" name="prenomProprietaire">
                <% if (errors != null && errors.containsKey("prenomProprietaire")) { %>
                    <br><span style="color: red;"><%= errors.get("prenomProprietaire") %></span>
                <% } %>
            </p>
            <p>
                <label for="sexeProprietaire">sexe</label>
                <select name="sexeProprietaire">
                    <option value="M">M</option>
                    <option value="F">F</option>
                </select>
                <% if (errors != null && errors.containsKey("sexeProprietaire")) { %>
                    <br><span style="color: red;"><%= errors.get("sexeProprietaire") %></span>
                <% } %>
            </p>
            <p>
                <label for="telProprietaire">Telephone</label>
                <input type="text" name="telProprietaire">
                <% if (errors != null && errors.containsKey("telProprietaire")) { %>
                    <br><span style="color: red;"><%= errors.get("telProprietaire") %></span>
                <% } %>
            </p>
            <p>
                <label for="adresseProprietaire">Adresse</label>
                <input type="text" name="adresseProprietaire">
                <% if (errors != null && errors.containsKey("adresseProprietaire")) { %>
                    <br><span style="color: red;"><%= errors.get("adresseProprietaire") %></span>
                <% } %>
            </p>
            <p>
                <label for="typePieceProp">Piece Proprietaire</label>
                <select name="typePieceProp">
                    <option value="licence">Licence</option>
                    <option value="CarteIdentification">Carte d'Identification</option>
                    <option value="Passeport">Passeport</option>
                </select>
                <% if (errors != null && errors.containsKey("typePieceProp")) { %>
                    <br><span style="color: red;"><%= errors.get("typePieceProp") %></span>
                <% } %>
            </p>
            <p>
                <label for="noPiece">No. Piece</label>
                <input type="text" name="noPiece">
                <% if (errors != null && errors.containsKey("noPiece")) { %>
                    <br><span style="color: red;"><%= errors.get("noPiece") %></span>
                <% } %>
            </p>
            <p>
                <label for="courrielProprietaire">courriel</label>
                <input type="text" name="courrielProprietaire">
                <% if (errors != null && errors.containsKey("courrielProprietaire")) { %>
                    <br><span style="color: red;"><%= errors.get("courrielProprietaire") %></span>
                <% } %>
            </p>
            <p>
                <label for="motifTransfert">Motif Transfert</label>
                <textarea name="motifTransfert" rows="5" cols="10"></textarea>
                <% if (errors != null && errors.containsKey("motifTransfert")) { %>
                    <br><span style="color: red;"><%= errors.get("motifTransfert") %></span>
                <% } %>
            </p>
            <p>
                <label for="etat">Etat</label>
                <select name="etat">
                    <option value="E" translate="no">E</option>
                    <option value="A" translate="no">A</option>
                </select>
                <% if (errors != null && errors.containsKey("etat")) { %>
                    <br><span style="color: red;"><%= errors.get("etat") %></span>
                <% } %>
            </p>
            <p>
                <input type="submit" name="opt" value="Enregistrer" translate="no">
            </p> 
        </form>
        <%}%>
    </body>
</html>
