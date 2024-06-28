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
        <%@include file="../layout/headInfo.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-scroller">
            <%@include file="../layout/navbar.jsp" %>
            <div class="container-fluid page-body-wrapper">
                <%@include file="../layout/sidebar.jsp" %>
                <div class="main-panel">
                    <div class="content-wrapper">
                        <div class="page-header">
                            <h3 class="page-title"> Liste de Paiement </h3>
                        </div>
                        <div class="row">
                            <div class="mx-auto col-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body table-responsive">
                                        <h4 class="card-title">Tableau d'assurance</h4>    
                                        <hr>
                                        <%List<Assurance> list = (List<Assurance>)request.getAttribute("listes");
                                        if(list != null && !list.isEmpty()){%>
                                        <table class="table table-striped">
                                            <thead class="thead-dark">
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Id vehicule</th>
                                                    <th>Montant assurance</th>
                                                    <th>Date paiement</th>
                                                    <th>Date fin assurance</th>
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
                                       <a class="btn btn-primary mt-3 mr-2" href="${pageContext.request.contextPath}/VehiculeServlet">Retour</a>
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
