<%-- 
    Document   : Afficher_Transfert
    Created on : 23 juin 2024, 19:29:25
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Transfert" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Liste de Transfert</h2>
        <hr>
        <%List<Transfert> list = (List<Transfert>)request.getAttribute("listes");
                if(list != null && !list.isEmpty()){%>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>ID VEHICULE</th>
                    <th>ID ANCIENT PROPRIETAIRE</th>
                    <th>ID NOUVEAU PROPRIETAIRE</th>
                    <th>MOTIF TRANSFERT</th>
                    <th>DATE TRANSFERT</th>
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
                    <%if(!t.getEtat().equalsIgnoreCase("A")){%>
                                        
                    <td>
                        <a href="${pageContext.request.contextPath}/TransfertServlet?id=<%=t.getId()+ "&opt=approuv"%>">A</a>|
                        <a href="${pageContext.request.contextPath}/TransfertServlet?id=<%=t.getId()+ "&opt=napprouv"%>">E</a>
                    </td>
                     <%}else{%>
                     <td>---</td>
                <%}%>
                </tr>
                <%}}else{%>
                    <p>Aucune donnee a ete trouve</p>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
