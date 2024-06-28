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
        <%@include file="../layout/headInfo.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="model.User" %>
        <div class="container-scroller">
            <%@include file="../layout/navbar.jsp" %>
            <div class="container-fluid page-body-wrapper">
                <%@include file="../layout/sidebar.jsp" %>
                <div class="main-panel">
                    <div class="content-wrapper">
                        <div class="page-header">
                            <h3 class="page-title"> Liste de Véhicule </h3>
                        </div>
                        <div class="row">
                            <div class="mx-auto col-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body table-responsive">
                                        <%List<Vehicule> list = (List<Vehicule>)request.getAttribute("vehicules");
                                        List<Proprietaire> listP = (List<Proprietaire>)request.getAttribute("proprietaires");
                                        if(list != null && listP !=null && !list.isEmpty() && !listP.isEmpty()){%>
                                        <table class="table table-striped">
                                            <thead class="thead-dark">
                                                <tr>
                                                    <th class="text-center">ID</th>
                                                    <th class="text-center">Marque</th>
                                                    <th class="text-center">Modele</th>
                                                    <th class="text-center">Couleur</th>
                                                    <th class="text-center">Plaque imm</th>
                                                    <th class="text-center">Alerte</th>
                                                    <th class="text-center">Plus</th>
                                                </tr>
                                            </thead>
                                            <tbody>    
                                                <%
                                                for(Vehicule v:list){
                                                    for(Proprietaire p:listP){
                                                        if(v.getIdProprietaire().equalsIgnoreCase(p.getId())){%>
                                                <tr>
                                                    <td class="text-center"><%= v.getId() %></td>
                                                    <td class="text-center"><%= v.getMarque() %></td>
                                                    <td class="text-center"><%= v.getModele() %></td>
                                                    <td class="text-center"><%= v.getCouleur() %></td>
                                                    <td class="text-center"><%= v.getPlaqueImmatriculation() %></td>
                                                    <td class="text-center"><%= v.isAlerte() %></td>
                                                    <td class="text-center"><a title="Plus detail" href="${pageContext.request.contextPath}/VehiculeServlet?id=<%=v.getId()+ "&opt=search"%>"><i class="mdi mdi-dots-horizontal" style="color:#bc0301; font-size: larger;"></i></a></td>
                                                </tr>
                                                <%}}}}else{%>
                                            <p>Aucune donnee a ete trouve</p>
                                            <%}%>
                                            </tbody>
                                        </table>
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
