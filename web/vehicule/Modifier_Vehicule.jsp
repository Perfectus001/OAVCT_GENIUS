<%-- 
    Document   : Modifier_Vehicule
    Created on : 19 juin 2024, 00:49:16
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="model.Vehicule" %>
<%@page import="model.Proprietaire" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
        Vehicule v = (Vehicule)request.getAttribute("vehicules");
        Proprietaire p = (Proprietaire)request.getAttribute("proprietaires");
        %>

        <form action="${pageContext.request.contextPath}/VehiculeServlet" method="post" enctype="multipart/form-data">
            
            <input type="hidden" name="id2" value="<%=p!=null?p.getId():""%>">
            <input type="hidden" name="id" value="<%=v!=null?v.getId():""%>">
            <p>
                <label for="marque">Marque</label>
                <input type="text" name="marque" value="<%= v!=null?v.getMarque():"" %>">
                <% if (errors != null && errors.containsKey("marque")) { %>
                    <br><span style="color: red;"><%= errors.get("marque") %></span>
                <% } %>
            </p>   
            <p>
                <label for="modele">Modele</label>
                <input type="text" name="modele" value="<%=v!=null?v.getModele():""%>">
                <% if (errors != null && errors.containsKey("modele")) { %>
                    <br><span style="color: red;"><%= errors.get("modele") %></span>
                <% } %>                
            </p>
            <p>
                <label for="couleur">Couleur</label>
                <input type="text" name="couleur" value="<%=v!=null?v.getCouleur():""%>">
                <% if (errors != null && errors.containsKey("couleur")) { %>
                    <br><span style="color: red;"><%= errors.get("couleur") %></span>
                <% } %>                
            </p>
            <p>
                <label for="noMoteur">No. Moteur</label>
                <input type="text" name="noMoteur" value="<%=v!=null?v.getNoMoteur():""%>">
                <% if (errors != null && errors.containsKey("noMoteur")) { %>
                    <br><span style="color: red;"><%= errors.get("noMoteur") %></span>
                <% } %>
            </p>
            <p>
                <label for="nbCylindre">Nombre Cylindre</label>
                <input type="number" name="nbCylindre" value="<%=v!=null?v.getNbCylindre():""%>">
                <% if (errors != null && errors.containsKey("nbCylindre")) { %>
                    <br><span style="color: red;"><%= errors.get("nbCylindre") %></span>
                <% } %>
            </p>
            <p>
                <label for="typeTransmission">Type Transmission</label>
                <select name="typeTransmission">
                    <option value="Manuelle" <%= v!=null && v.getTypeTransmission().equalsIgnoreCase("Manuelle")?"selected":""%>>Manuelle</option>
                    <option value="Automatique" <%= v!=null && v.getTypeTransmission().equalsIgnoreCase("Automatique")?"selected":""%>>Automatique</option>
                </select>
                <% if (errors != null && errors.containsKey("typeTransmission")) { %>
                    <br><span style="color: red;"><%= errors.get("typeTransmission") %></span>
                <% } %>
            </p>
            <p>
                <label for="typeEssence">Type Essence</label>
                <select name="typeEssence">
                    <option value="Gasoline" <%= v!=null && v.getTypeEssence().equalsIgnoreCase("Gasoline")?"selected":""%>>Gasoline</option>
                    <option value="Diesel" <%= v!=null && v.getTypeEssence().equalsIgnoreCase("Diesel")?"selected":""%>>Diesel</option>
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
                <input type="text" name="plaqueImmatriculation" value="<%=v!=null?v.getPlaqueImmatriculation():""%>">
                <% if (errors != null && errors.containsKey("plaqueImmatriculation")) { %>
                    <br><span style="color: red;"><%= errors.get("plaqueImmatriculation") %></span>
                <% } %>
            </p>
            <p>
                <label for="nomProprietaire">Nom</label>
                <input type="text" name="nomProprietaire" value="<%=p!=null?p.getNom():""%>">
                <% if (errors != null && errors.containsKey("nomProprietaire")) { %>
                    <br><span style="color: red;"><%= errors.get("nomProprietaire") %></span>
                <% } %>
            </p>
            <p>
                <label for="prenomProprietaire">Prenom</label>
                <input type="text" name="prenomProprietaire" value="<%=p!=null?p.getPrenom():""%>">
                <% if (errors != null && errors.containsKey("prenomProprietaire")) { %>
                    <br><span style="color: red;"><%= errors.get("prenomProprietaire") %></span>
                <% } %>
            </p>
            <p>
                <label for="sexeProprietaire">sexe</label>
                <select name="sexeProprietaire">
                    <option value="M" <%= p!=null && p.getSexe().equalsIgnoreCase("M")?"selected":""%>>M</option>
                    <option value="F"<%= p!=null && p.getSexe().equalsIgnoreCase("F")?"selected":""%>>F</option>
                </select>
                <% if (errors != null && errors.containsKey("sexeProprietaire")) { %>
                    <br><span style="color: red;"><%= errors.get("sexeProprietaire") %></span>
                <% } %>
            </p>
            <p>
                <label for="telProprietaire">Telephone</label>
                <input type="text" name="telProprietaire" value="<%=p!=null?p.getTel():""%>">
                <% if (errors != null && errors.containsKey("telProprietaire")) { %>
                    <br><span style="color: red;"><%= errors.get("telProprietaire") %></span>
                <% } %>
            </p>
            <p>
                <label for="adresseProprietaire">Adresse</label>
                <input type="text" name="adresseProprietaire" value="<%=p!=null?p.getAdresse():""%>">
                <% if (errors != null && errors.containsKey("adresseProprietaire")) { %>
                    <br><span style="color: red;"><%= errors.get("adresseProprietaire") %></span>
                <% } %>
            </p>
            <p>
                <label for="typePieceProp">Piece Proprietaire</label>
                <select name="typePieceProp">
                    <option value="licence" <%= p!=null && p.getTypePiece().equalsIgnoreCase("licence")?"selected":""%>>Licence</option>
                    <option value="CarteIdentification" <%= p!=null && p.getTypePiece().equalsIgnoreCase("CarteIdentification")?"selected":""%>>Carte d'Identification</option>
                    <option value="Passeport" <%= p!=null && p.getTypePiece().equalsIgnoreCase("Passeport")?"selected":""%>>Passeport</option>
                </select>
                <% if (errors != null && errors.containsKey("typePieceProp")) { %>
                    <br><span style="color: red;"><%= errors.get("typePieceProp") %></span>
                <% } %>
            </p>
            <p>
                <label for="noPiece">No. Piece</label>
                <input type="text" name="noPiece" value="<%=p!=null?p.getNoPiece():""%>">
                <% if (errors != null && errors.containsKey("noPiece")) { %>
                    <br><span style="color: red;"><%= errors.get("noPiece") %></span>
                <% } %>
            </p>
            <p>
                <label for="annee">Annee</label>
                <input type="text" name="annee" value="<%=v!=null?v.getAnnee():""%>">
                <% if (errors != null && errors.containsKey("annee")) { %>
                    <br><span style="color: red;"><%= errors.get("annee") %></span>
                <% } %>
            </p>
            <p>
                <label for="courrielProprietaire">courriel</label>
                <input type="text" name="courrielProprietaire" value="<%=p!=null?p.getCourriel():""%>">
                <% if (errors != null && errors.containsKey("courrielProprietaire")) { %>
                    <br><span style="color: red;"><%= errors.get("courrielProprietaire") %></span>
                <% } %>
            </p>
           <p>
                <label for="alerte">Alerte</label>
                <input type="radio" name="alerte" value="true" <%= v!=null && v.isAlerte()?"checked":""%>>
                <input type="radio" name="alerte" value="false" <%= v!=null && v.isAlerte()?"":"checked"%>>
                <% if (errors != null && errors.containsKey("alerte")) { %>
                    <br><span style="color: red;"><%= errors.get("alerte") %></span>
                <% } %>
            </p>
            <!--<p>
                <label for="dateAlerte">Date Alerte</label>
                <input type="date" name="dateAlerte" value="<%=v!=null?v.getDateAlerte():""%>">
            </p>-->
            <p>
                <input type="submit" name="opt" value="Modifier">
            </p> 
        </form>
    </body>
</html>
