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
        <%@include file="../layout/headInfo.jsp" %>
        <title>JSP Page</title>
        <style>
            .list-unstyled {
                list-style: none;
                padding-left: 0;
            }
            .label {
                font-weight: bold;
            }
            .info {
                margin-bottom: 15px;
            }
            .img-thumbnail {
                max-width: 100px;
                height: auto;
            }
        </style>
    </head>
    <body>
        <div class="container-scroller">
            <%@include file="../layout/navbar.jsp" %>
            <div class="container-fluid page-body-wrapper">
                <%@include file="../layout/sidebar.jsp" %>
                <%
                    Vehicule v = (Vehicule)request.getAttribute("vehicules");
                    Proprietaire p = (Proprietaire)request.getAttribute("proprietaires");
                if(v != null && p != null){
                %>
                <div class="main-panel">
                    <div class="content-wrapper">
                        <div class="page-header">
                            <h3 class="page-title">Enregistrer vehicule</h3>
                        </div>
                        <div class="row">
                            <div class="col-12 grid-margin">
                                <div class="card">
                                    <div class="card-body">
                                        <h3><%=v.getId()%></h3>
                                        <hr>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <img src="path_to_image.jpg" alt="Logo" class="img-thumbnail rounded-circle">
                                                <div class="info"><span class="label">MARQUE:</span> <%=v.getMarque()%></div>
                                                <div class="info"><span class="label">COULEUR:</span> <%=v.getCouleur()%></div>
                                                <div class="info"><span class="label">MODELE:</span> <%=v.getModele()%></div>
                                                <div class="info"><span class="label">ANNEE:</span> <%=v.getAnnee()%></div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="info"><span class="label">NO. MOTEUR:</span> <%=v.getNoMoteur()%></div>
                                                <div class="info"><span class="label">NBRE CYLINDRE:</span> <%=v.getNbCylindre()%></div>
                                                <div class="info"><span class="label">TYPE TRANSMISSION:</span> <%=v.getTypeTransmission()%></div>
                                                <div class="info"><span class="label">TYPE ESSENCE:</span> <%=v.getTypeEssence()%></div>
                                                <div class="info"><span class="label">PLAQUE D'IMMATRICULATION:</span> <%=v.getPlaqueImmatriculation()%></div>
                                                <div class="info"><span class="label">ALERTE:</span> <%=v.isAlerte()%></div>
                                                <div class="info"><span class="label">DATE ALERTE:</span> <%=v.getDateAlerte()%></div>
                                                <div class="info"><span class="label">DATE ENREGISTREMENT:</span> <%=v.getDateEnregistrement().toLocalDateTime().toLocalDate()%></div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="info"><span class="label">NOM PROPRIETAIRE:</span> <%=p.getNom()%></div>
                                                <div class="info"><span class="label">PRENOM PROPRIETAIRE:</span> <%=p.getPrenom()%></div>
                                                <div class="info"><span class="label">SEXE PROPRIETAIRE:</span> <%=p.getSexe()%></div>
                                                <div class="info"><span class="label">TEL PROPRIETAIRE:</span> <%=p.getTel()%></div>
                                                <div class="info"><span class="label">ADRESSE PROPRIETAIRE:</span> <%=p.getAdresse()%></div>
                                                <div class="info"><span class="label">TYPE PIECE PROPRIETAIRE:</span> <%=p.getTypePiece()%></div>
                                                <div class="info"><span class="label">NO PIECE:</span> <%=p.getNoPiece()%></div>
                                                <div class="info"><span class="label">COURRIEL PROPRIETAIRE:</span> <%=p.getCourriel()%></div>
                                            </div>
                                        </div>
                                        <div class="text-center mt-4">
                                            <a href="${pageContext.request.contextPath}/VehiculeServlet?id=<%=v.getId()+ "&opt=mod" + "&id2="+ p.getId()%>" class="text-blue"><i class="mdi mdi-pencil"></i> Modifier</a>
                                            <% if (v.isAlerte()) { %>
                                            <a href="${pageContext.request.contextPath}/VehiculeServlet?id=<%=v.getId()+ "&opt=dalt"%>" class="text-blue ml-3 mr-3"><i class="mdi mdi-bell-off" style="color:red;"></i> Alerte</a>
                                            <% } else { %>
                                            <a href="${pageContext.request.contextPath}/VehiculeServlet?id=<%=v.getId()+ "&opt=alt"%>" class="text-blue ml-3 mr-3"><i class="mdi mdi-bell-ring" style="color:red;"></i> Alerte</a>
                                            <% } %>
                                            <%
                                                us = (User)session.getAttribute("models");
                                                if (us != null && us.getFonction().equalsIgnoreCase("admin") && v.calculeDifferenceHeure() < 14400 && !v.isAlerte()) {
                                            %>
                                            <a href="${pageContext.request.contextPath}/VehiculeServlet?id=<%=v.getId()+ "&opt=sup"%>" class="text-blue"><i class="mdi mdi-delete" style="color:black;"></i> Supprimer</a>
                                            <% } %>
                                        </div>
                                        <% } %>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../layout/footer.jsp" %>
    </body>
</html>
