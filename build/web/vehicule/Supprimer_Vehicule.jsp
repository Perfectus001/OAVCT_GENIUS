<%-- 
    Document   : Supprimer_Vehicule
    Created on : 28 juin 2024, 12:43:11
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Vehicule" %>
<%@page import="model.Proprietaire" %>
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
                            <h3 class="page-title">Modifier vehicule</h3>
                        </div>
                        <div class="row">
                            <div class="col-12 grid-margin">
                                <div class="card">
                                    <div class="card-body">
                                        <% 
                                        String error = (String) request.getAttribute("error");
                                        Vehicule v = (Vehicule)request.getAttribute("vehicules");
                                        Proprietaire p = (Proprietaire)request.getAttribute("proprietaires");
                                        Vehicule v2 = (Vehicule)request.getAttribute("V2");
                                        Proprietaire p2 = (Proprietaire)request.getAttribute("P2");
                                        if(v == null && p == null){
                                        %>
                                        <form class="forms-sample" action="${pageContext.request.contextPath}/VehiculeServlet" method="post">
                                            <div class="form-group">
                                                <label for="id1">ID du vehicule</label>
                                                <input class="form-control" type="text" name="id1">
                                                <% if (error != null) { %>
                                                <br><span style="color: red;"><%= error %></span>
                                                <% } %>
                                            </div>
                                            <p>
                                                <input class="btn btn-primary mr-2" type="submit" name="opt" value="Recherche">
                                            </p>
                                        </form>
                                            <%}%>
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
