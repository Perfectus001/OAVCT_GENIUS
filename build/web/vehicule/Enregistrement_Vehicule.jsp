<%-- 
    Document   : Enregistrement_Vehicule
    Created on : 16 juin 2024, 04:32:02
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
        Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
        %>

        <form action="${pageContext.request.contextPath}/VehiculeServlet" method="post" enctype="multipart/form-data">
           <p>
                <label for="marque">Marque</label>
                <input type="text" name="marque">
                <% if (errors != null && errors.containsKey("marque")) { %>
                    <br><span style="color: red;"><%= errors.get("marque") %></span>
                <% } %>
            </p>   
            <p>
                <label for="modele">Modele</label>
                <input type="text" name="modele">
                <% if (errors != null && errors.containsKey("modele")) { %>
                    <br><span style="color: red;"><%= errors.get("modele") %></span>
                <% } %>                
            </p>
            <p>
                <label for="couleur">Couleur</label>
                <input type="text" name="couleur">
                <% if (errors != null && errors.containsKey("couleur")) { %>
                    <br><span style="color: red;"><%= errors.get("couleur") %></span>
                <% } %>                
            </p>
            <p>
                <label for="noMoteur">No. Moteur</label>
                <input type="text" name="noMoteur">
                <% if (errors != null && errors.containsKey("noMoteur")) { %>
                    <br><span style="color: red;"><%= errors.get("noMoteur") %></span>
                <% } %>
            </p>
            <p>
                <label for="nbCylindre">Nombre Cylindre</label>
                <input type="number" name="nbCylindre">
                <% if (errors != null && errors.containsKey("nbCylindre")) { %>
                    <br><span style="color: red;"><%= errors.get("nbCylindre") %></span>
                <% } %>
            </p>
            <p>
                <label for="typeTransmission">Type Transmission</label>
                <select name="typeTransmission">
                    <option value="Manuelle">Manuelle</option>
                    <option value="Automatique">Automatique</option>
                </select>
                <% if (errors != null && errors.containsKey("typeTransmission")) { %>
                    <br><span style="color: red;"><%= errors.get("typeTransmission") %></span>
                <% } %>
            </p>
            <p>
                <label for="typeEssence">Type Essence</label>
                <select name="typeEssence">
                    <option value="Gasoline">Gasoline</option>
                    <option value="Diesel">Diesel</option>
                </select>
                <% if (errors != null && errors.containsKey("typeEssence")) { %>
                    <br><span style="color: red;"><%= errors.get("typeEssence") %></span>
                <% } %>
            </p>
            <p>
                <label for="photo">Photo Vehicule</label>
                <input input type="file" accept="image/*" name="photo">
                <% if (errors != null && errors.containsKey("photo")) { %>
                    <br><span style="color: red;"><%= errors.get("photo") %></span>
                <% } %>
            </p>            
            <p>
                <label for="plaqueImmatriculation">Plaque d'immatriculation</label>
                <input type="text" name="plaqueImmatriculation">
                <% if (errors != null && errors.containsKey("plaqueImmatriculation")) { %>
                    <br><span style="color: red;"><%= errors.get("plaqueImmatriculation") %></span>
                <% } %>
            </p>
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
                <label for="annee">Annee</label>
                <input type="text" name="annee">
                <% if (errors != null && errors.containsKey("annee")) { %>
                    <br><span style="color: red;"><%= errors.get("annee") %></span>
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
                <label for="alerte">Alerte</label>
                <input type="radio" name="alerte" value="true">
                <input type="radio" name="alerte" value="false">
                <% if (errors != null && errors.containsKey("alerte")) { %>
                    <br><span style="color: red;"><%= errors.get("alerte") %></span>
                <% } %>
            </p>
            <!--<p>
                <label for="dateAlerte">Date Alerte</label>
                <input type="date" name="dateAlerte">
            </p>-->
            <p>
                <input type="submit" name="opt" value="Enregistrer">
            </p> 
        </form>
    </body>
</html>
