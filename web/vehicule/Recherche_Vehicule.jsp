<%-- 
    Document   : Recherche_Vehicule
    Created on : 18 juin 2024, 23:16:10
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Vehicule" %>
<%@page import="model.Proprietaire" %>
<%@page import="model.User" %>
<%@page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Vehicule v = (Vehicule)request.getAttribute("vehicules");
            Proprietaire p = (Proprietaire)request.getAttribute("proprietaires");
        if(v != null && p != null){
        %>
        <h3><%=v.getId()%></h3>
        <hr>
        <div>
            <div></div>
            <div>
                <ul>
                    <li><strong>MARQUE: </strong><%=v.getMarque()%></li>
                    <li><strong>COULEUR: </strong><%=v.getCouleur()%></li>
                    <li><strong>MODELE: </strong><%=v.getModele()%></li>
                    <li><strong>ANNEE: </strong><%=v.getAnnee()%></li>
                    <li><strong>NO. MOTEUR: </strong><%=v.getNoMoteur()%></li>
                    <li><strong>NBRE CYLINDRE: </strong><%=v.getNbCylindre()%></li>
                    <li><strong>TYPE TRANSMISSION: </strong><%=v.getTypeTransmission()%></li>
                    <li><strong>TYPE ESSENCE: </strong><%=v.getTypeEssence()%></li>
                    <li><strong>PLAQUE D'IMMATRICULATION: </strong><%=v.getPlaqueImmatriculation()%></li>
                    <li><strong>NOM PROPRIETAIRE: </strong><%=p.getNom()%></li>
                    <li><strong>PRENOM PROPRIETAIRE: </strong><%=p.getPrenom()%></li>
                    <li><strong>SEXE PROPRIETAIRE: </strong><%=p.getSexe()%></li>
                    <li><strong>TEL PROPRIETAIRE: </strong><%=p.getTel()%></li>
                    <li><strong>ADRESSE PROPRIETAIRE: </strong><%=p.getAdresse()%></li>
                    <li><strong>TYPE PIECE PROPRIETAIRE: </strong><%=p.getTypePiece()%></li>
                    <li><strong>NO PIECE: </strong><%=p.getNoPiece()%></li>
                    <li><strong>COURRIEL PROPRIETAIRE: </strong><%=p.getCourriel()%></li>
                    <li><strong>ALERTE: </strong><%=v.isAlerte()%></li>
                    <li><strong>DATE ALERTE: </strong><%=v.getDateAlerte()%></li>
                    <li><strong>DATE ENREGISTREMENT: </strong><%=v.getDateEnregistrement().toLocalDateTime().toLocalDate()%></li>
                    <button><a href="${pageContext.request.contextPath}/VehiculeServlet?id=<%=v.getId()+ "&opt=mod" + "&id2="+ p.getId()%>"> Modifier</a></button>
                    <%if(v.isAlerte()){
                    %>
                    <button><a href="${pageContext.request.contextPath}/VehiculeServlet?id=<%=v.getId()+ "&opt=dalt"%>"> Desactiver Alerte</a></button>
                    <%}else{%>
                    <button><a href="${pageContext.request.contextPath}/VehiculeServlet?id=<%=v.getId()+ "&opt=alt"%>"> Activer Alerte </a></button>
                    <%}%>
                    
                    <%
                    User us = null;
                    if(session.getAttribute("models")!=null){
                    us = (User)session.getAttribute("models");
                    if(us.toString().equalsIgnoreCase("admin")){
                    if(v.calculeDifferenceHeure() < 14400){%>
                    <button><a href="${pageContext.request.contextPath}/VehiculeServlet?id=<%=v.getId()+ "&opt=sup"%>"> Supprimer</a></button>
                    <%}}}%>
                </ul>
            </div>
        </div>
        <%}%>
    </body>
</html>
