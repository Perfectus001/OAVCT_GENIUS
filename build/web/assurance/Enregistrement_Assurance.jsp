<%-- 
    Document   : Enregistrement_Assurance
    Created on : 21 juin 2024, 16:50:35
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
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
                            <h3 class="page-title"> Enregistrement Assurance </h3>
                        </div>
                        <div class="row">
                            <div class="mx-auto col-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <%
                                            String id2 = (String) request.getAttribute("idV2");
                                            String id = (String) request.getAttribute("IDVehicule");
                                            String error = (String) request.getAttribute("error");
                                            Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
                                            if(id == null && errors == null){                                            
                                        %>

                                        <form class="forms-sample" action="${pageContext.request.contextPath}/AssuranceServlet" method="post">
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

                                        <% 
                                        }else{    
                                            if(id2 != null){
                                                id = id2;   
                                            }
                                        %>

                                        <form action="${pageContext.request.contextPath}/AssuranceServlet" method="post">
                                            <h3><%=id!=null?id:""%></h3>

                                            <input type="hidden" name="idVehicule" value="<%=id!=null?id:""%>">


                                            <div class="form-group">
                                                <label for="montantAssurance">Montant Assurance</label>
                                                <input class="form-control" type="text" name="montantAssurance">
                                                <% if (errors != null && errors.containsKey("montantAssurance")) { %>
                                                <br><span style="color: red;"><%= errors.get("montantAssurance") %></span>
                                                <% } %>                
                                            </div>
                                            <p>
                                                <input class="btn btn-primary mr-2" type="submit" name="opt" value="Enregistrer">
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
