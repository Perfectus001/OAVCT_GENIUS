<%-- 
    Document   : Enregistrer
    Created on : Jun 22, 2024, 9:14:38 PM
    Author     : Christina SARILUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Enregistrer une nouvelle alerte</h1>
    <form action="EnregistrerAlerteServlet" method="post">
        <table>
            <tr>
                <!<!--<td>ID:</td>
                <td><input type="text" name="ID" required /></td>--> 
            </tr>
            <tr>
                <td>ID Véhicule:</td>
                <td><input type="text" name="idvehicule" required />
                <% if (errors != null && errors.containsKey("idvehicule")) { %>
                    <br><span style="color: red;"><%= errors.get("idvehicule") %></span>
                <% } %>
                </td>
                
            </tr>
            <tr>
                <td>Type Alerte:</td>
                <td>
                    <select name="typeAlerte" required>
                        <option value="Vol">Vol</option>
                        <option value="Perte">Perte</option>
                        <option value="Trafics illicites">Trafics illicites</option>
                        <option value="Activités illégales">Activités illégales</option>
                        <!-- Ajoutez d'autres types d'alertes ici -->
                    </select>
                    <% if (errors != null && errors.containsKey("typeAlerte")) { %>
                    <br><span style="color: red;"><%= errors.get("typeAlerte") %></span>
                <% } %>
                </td>
            </tr>
            <tr>
                <td>Lieu Incident:</td>
                <td><input type="text" name="lieuIncident" required />
                <% if (errors != null && errors.containsKey("lieuIncident")) { %>
                    <br><span style="color: red;"><%= errors.get("lieuIncident") %></span>
                <% } %>
                </td>
            </tr>
            <tr>
                <td>Date Incident (YYYY-MM-DD):</td>
                <td><input type="date" name="dateincident" required />
                <% if (errors != null && errors.containsKey("dateincident")) { %>
                    <br><span style="color: red;"><%= errors.get("dateincident") %></span>
                <% } %>
                </td>
            </tr>
            <tr>
                <td>Heure Incident (HH:MM:SS):</td>
                <td><input type="time" name="heureIncident" step="1" required />
                <% if (errors != null && errors.containsKey("heureIncident")) { %>
                    <br><span style="color: red;"><%= errors.get("heureIncident") %></span>
                <% } %>
                </td>
            </tr>
            <tr>
                <td>Nom Déclarant:</td>
                <td><input type="text" name="nomDeclarant" required />
                <% if (errors != null && errors.containsKey("nomDeclarant")) { %>
                    <br><span style="color: red;"><%= errors.get("nomDeclarant") %></span>
                <% } %>
                </td>
            </tr>
            <tr>
                <td>Prénom Déclarant:</td>
                <td><input type="text" name="prenomDeclarant" required />
                <% if (errors != null && errors.containsKey("prenomDeclarant")) { %>
                    <br><span style="color: red;"><%= errors.get("prenomDeclarant") %></span>
                <% } %>
                </td>
            </tr>
            <tr>
                <td>Téléphone Déclarant:</td>
                <td><input type="text" name="telDeclarant" required />
                <% if (errors != null && errors.containsKey("telDeclarant")) { %>
                    <br><span style="color: red;"><%= errors.get("telDeclarant") %></span>
                <% } %>
                </td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><textarea name="description"></textarea>
                <% if (errors != null && errors.containsKey("description")) { %>
                    <br><span style="color: red;"><%= errors.get("description") %></span>
                <% } %></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Enregistrer" /></td>
            </tr>
        </table>
    </form>
    </body>
</html>
