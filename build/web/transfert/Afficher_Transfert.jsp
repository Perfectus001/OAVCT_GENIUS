<%-- 
    Document   : Afficher_Transfert
    Created on : 23 juin 2024, 19:29:25
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Transfert" %>
<%@page import="java.util.List" %>
<%@page import="model.User" %>
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
                            <h3 class="page-title"> Liste de Transfert </h3>
                        </div>
                        <%
                        if(((User)session.getAttribute("models"))!=null){
                        us = (User)session.getAttribute("models");
                        }else{
                        response.sendRedirect("login.jsp");
                        }
                        %>
                        <div class="row">
                            <div class="mx-auto col-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body table-responsive">
                                        <%List<Transfert> list = (List<Transfert>)request.getAttribute("listes");
                                        if(list != null && !list.isEmpty()){%>
                                        <table class="table table-striped">
                                            <thead class="thead-dark">
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Id vehicule</th>
                                                    <th>Id ancient proprietaire</th>
                                                    <th>Id nouveau proprietaire</th>
                                                    <th>motif transfert</th>
                                                    <th>Date transfert</th>
                                                    <%if(us.getUsername().equalsIgnoreCase("admin")){%>
                                                    <th>Action</th>
                                                    <%}%>
                                                </tr>
                                            </thead>
                                            <tbody>    
                                                <%
                                                for(Transfert t:list){%>
                                                <tr>
                                                    <td><%= t.getId() %></td>
                                                    <td><%= t.getIdVehicule() %></td>
                                                    <td><%= t.getIdExProprietaire() %></td>
                                                    <td><%= t.getIdNewProprietaire() %></td>
                                                    <td><%= t.getMotifTransfert() %></td>
                                                    <td><%= t.getDateTransfert() %></td>
                                                    <%if(us.getUsername().equalsIgnoreCase("admin")){
                                                        if(!t.getEtat().equalsIgnoreCase("A")){%>

                                                    <td>
                                                        <a title="Approuve" href="${pageContext.request.contextPath}/TransfertServlet?id=<%=t.getId()+ "&opt=approuv"%>"><i class="mdi mdi-checkbox-marked-circle-outline mr-2" style="color:green; font-size: large;"></i></a> ---
                                                        <a title="Non Approuve" href="${pageContext.request.contextPath}/TransfertServlet?id=<%=t.getId()+ "&opt=napprouv"%>"><i class="mdi mdi-close ml-2" style="color: red; font-size: large;"></i></a>
                                                    </td>
                                                    <%}else{%>
                                                    <td><i class="mdi mdi-lock-outline"></i></td>
                                                    <%}}%>
                                                </tr>
                                                <%}}else{%>
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
