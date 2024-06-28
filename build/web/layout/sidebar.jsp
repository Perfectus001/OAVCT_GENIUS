<%-- 
    Document   : sidebar
    Created on : 24 juin 2024, 02:11:34
    Author     : Perfectus
--%>


<!-- partial:../../partials/_sidebar.html -->
<%@page import="model.User" %>
<style>
    .menu-title:active{
        color: #bc0301;
    }
    .menu-title:active~div {
        color: #bc0301;
    }
    .menu-arrow {
        color: #bc0301;
    }

</style>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
        <li class="nav-item nav-category">Menu</li>
        <li class="nav-item">
            <a class="nav-link" href="index.html">
                <span class="icon-bg"><i class="mdi mdi-cube menu-icon" style="color:white; font-size: large; "></i></span>
                <span class="menu-title">Dashboard</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                <span class="icon-bg"><i class="mdi mdi-car" style="color:white; font-size: large; "></i></span>
                <span class="menu-title">Véhicule</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/vehicule/Enregistrement_Vehicule.jsp">Enregistrer</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/VehiculeServlet">Afficher</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/vehicule/Modifier_Vehicule.jsp">Modifier</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/vehicule/Supprimer_Vehicule.jsp">Supprimer</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#transf" aria-expanded="false" aria-controls="transf">
                <span class="icon-bg"><i class="mdi mdi-account-switch" style="color:white; font-size: large; "></i></span>
                <span class="menu-title">Transfert Véhicule</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="transf">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/transfert/Enregistrement_Transfert.jsp">Enregistrer</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/TransfertServlet">Afficher</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#alt" aria-expanded="false" aria-controls="alt">
                <span class="icon-bg"><i class="mdi mdi-bell-ring" style="color:white; font-size: large; "></i></span>
                <span class="menu-title">Alerte</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="alt">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/alerte/Enregistrement_Alerte.jsp">Enregistrer</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/AlerteServlet">Afficher</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/AlerteServlet">Modifier</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/AlerteServlet">Supprimer</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#renou" aria-expanded="false" aria-controls="renou">
                <span class="icon-bg"><i class="mdi mdi-refresh" style="color:white; font-size: large; "></i></span>
                <span class="menu-title">Rénouveler Assurance</span>
                <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="renou">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/assurance/Enregistrement_Assurance.jsp">Enregistrer</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/AssuranceServlet">Afficher</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item sidebar-user-actions mt-5">
            <div class="user-details">
                <div class="d-flex justify-content-between align-items-center">
                    <div>
                        <div class="d-flex align-items-center">
                            <div class="sidebar-profile-text">
                                <%
                                User us = ((User)session.getAttribute("models"));
                                if(((User)session.getAttribute("models"))!=null){%>
                                <p class="mb-1"> <span class="icon-bg"><i class="mdi mdi-account-circle mr-5" style="color:white; font-size: large; "></i></span> <%= us.getUsername() %></p>
                                <%}else{
                                response.sendRedirect("login.jsp");
                                }
                                %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li class="nav-item sidebar-user-actions">
            <div class="sidebar-user-menu">
                <a href="#" class="nav-link"><i class="mdi mdi-settings menu-icon"></i>
                    <span class="menu-title">Settings</span>
                </a>
            </div>
        </li>
        <li class="nav-item sidebar-user-actions">
            <div class="sidebar-user-menu">
                <a href="#" class="nav-link"><i class="mdi mdi-speedometer menu-icon"></i>
                    <span class="menu-title">Take Tour</span></a>
            </div>
        </li>
        <li class="nav-item sidebar-user-actions">
            <div class="sidebar-user-menu">
                <a href="${pageContext.request.contextPath}/LoginServlet" class="nav-link"><i class="mdi mdi-logout menu-icon"></i>
                    <span class="menu-title">Deconnection</span></a>
            </div>
        </li>
    </ul>
</nav>