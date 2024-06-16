<%-- 
    Document   : Enregistrement_Vehicule
    Created on : 16 juin 2024, 04:32:02
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/VehiculeServlet" method="post" enctype="multipart/form-data">
           <p>
                <label for="marque">Marque</label>
                <input type="text" name="marque">
            </p>   
            <p>
                <label for="modele">Modele</label>
                <input type="text" name="modele">
            </p>
            <p>
                <label for="couleur">Couleur</label>
                <input type="text" name="couleur">
            </p>
            <p>
                <label for="noMoteur">No. Moteur</label>
                <input type="text" name="noMoteur">
            </p>
            <p>
                <label for="nbCylindre">Nombre Cylindre</label>
                <input type="number" name="nbCylindre">
            </p>
            <p>
                <label for="typeTransmission">Type Transmission</label>
                <select name="typeTransmission">
                    <option value="Manuelle">Manuelle</option>
                    <option value="Automatique">Automatique</option>
                </select>
            </p>
            <p>
                <label for="typeEssence">Type Essence</label>
                <select name="typeEssence">
                    <option value="Gasoline">Gasoline</option>
                    <option value="Diesel">Diesel</option>
                </select>
            </p>
            <p>
                <label for="photo">Photo Vehicule</label>
                <input input type="file" accept="image/*" name="photo">
            </p>            
            <p>
                <label for="plaqueImmatriculation">Plaque d'immatriculation</label>
                <input type="text" name="plaqueImmatriculation">
            </p>
            <p>
                <label for="nomProprietaire">Nom</label>
                <input type="text" name="nomProprietaire">
            </p>
            <p>
                <label for="prenomProprietaire">Prenom</label>
                <input type="text" name="prenomProprietaire">
            </p>
            <p>
                <label for="sexeProprietaire">sexe</label>
                <select name="sexeProprietaire">
                    <option value="M">M</option>
                    <option value="F">F</option>
                </select>
            </p>
            <p>
                <label for="telProprietaire">Telephone</label>
                <input type="text" name="telProprietaire">
            </p>
            <p>
                <label for="adresseProprietaire">Adresse</label>
                <input type="text" name="adresseProprietaire">
            </p>
            <p>
                <label for="typePieceProp">Piece Proprietaire</label>
                <select name="typePieceProp">
                    <option value="licence">Licence</option>
                    <option value="CarteIdentification">Carte d'Identification</option>
                    <option value="Passeport">Passeport</option>
                </select>
            </p>
            <p>
                <label for="noPiece">No. Piece</label>
                <input type="text" name="noPiece">
            </p>
            <p>
                <label for="annee">Annee</label>
                <input type="text" name="annee">
            </p>
            <p>
                <label for="courrielProprietaire">courriel</label>
                <input type="text" name="courrierProprietaire">
            </p>
            <p>
                <label for="alerte">Alerte</label>
                <input type="radio" name="alerte" value="true">
                <input type="radio" name="alerte" value="false">
            </p>
            <p>
                <label for="dateAlerte">Date Alerte</label>
                <input type="date" name="dateAlerte">
            </p>
            <p>
                <input type="submit" name="opt" value="Enregistrer">
            </p> 
        </form>
    </body>
</html>
