<%-- 
    Document   : Enregistrement_Transfert
    Created on : 23 juin 2024, 07:56:04
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="model.Transfert" %>
<%@page import="model.Proprietaire" %>
<%@page import="model.Vehicule" %>
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
                            <h3 class="page-title"> Enregistrement Transfert </h3>
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

                                        <form class="forms-sample" action="${pageContext.request.contextPath}/TransfertServlet" method="post">
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
                                        <%}else{
                                            if(id2 != null){
                                                id = id2;   
                                            }
                                        %>
                                        <h3 class="card-title"><%=id!=null?id:""%></h3>
                                        <form class="forms-sample" action="${pageContext.request.contextPath}/TransfertServlet" method="post">
                                            <input type="hidden" name="idVehicule" value="<%=id!=null?id:""%>">
                                            <div class="form-group">
                                                <label for="nom">Nom</label>
                                                <input id="nom" class="form-control" type="text" name="nomProprietaire">
                                                <% if (errors != null && errors.containsKey("nomProprietaire")) { %>
                                                <br><span style="color: red;"><%= errors.get("nomProprietaire") %></span>
                                                <% } %>
                                            </div>
                                            <div class="form-group">
                                                <label for="prenom">Prenom</label>
                                                <input id="prenom" class="form-control" type="text" name="prenomProprietaire">
                                                <% if (errors != null && errors.containsKey("prenomProprietaire")) { %>
                                                <br><span style="color: red;"><%= errors.get("prenomProprietaire") %></span>
                                                <% } %>
                                            </div>
                                            <div class="form-group">
                                                <label for="sexe">sexe</label>
                                                <select id="sexe" class="form-control" name="sexeProprietaire">
                                                    <option value="M">M</option>
                                                    <option value="F">F</option>
                                                </select>
                                                <% if (errors != null && errors.containsKey("sexeProprietaire")) { %>
                                                <br><span style="color: red;"><%= errors.get("sexeProprietaire") %></span>
                                                <% } %>
                                            </div>
                                            <div class="form-group">
                                                <label for="tel">Telephone</label>
                                                <input id="tel" class="form-control" type="text" name="telProprietaire">
                                                <% if (errors != null && errors.containsKey("telProprietaire")) { %>
                                                <br><span style="color: red;"><%= errors.get("telProprietaire") %></span>
                                                <% } %>
                                            </div>
                                            <div class="form-group">
                                                <label for="adresse">Adresse</label>
                                                <input id="adresse" class="form-control" type="text" name="adresseProprietaire">
                                                <% if (errors != null && errors.containsKey("adresseProprietaire")) { %>
                                                <br><span style="color: red;"><%= errors.get("adresseProprietaire") %></span>
                                                <% } %>
                                            </div>
                                            <div class="form-group">
                                                <label for="typePiece">Piece Proprietaire</label>
                                                <select id="typePiece" class="form-control" name="typePieceProp">
                                                    <option value="licence">Licence</option>
                                                    <option value="CarteIdentification">Carte d'Identification</option>
                                                    <option value="Passeport">Passeport</option>
                                                </select>
                                                <% if (errors != null && errors.containsKey("typePieceProp")) { %>
                                                <br><span style="color: red;"><%= errors.get("typePieceProp") %></span>
                                                <% } %>
                                            </div>
                                            <div class="form-group">
                                                <label for="noPiece">No. Piece</label>
                                                <input id="noPiece" class="form-control" type="text" name="noPiece">
                                                <% if (errors != null && errors.containsKey("noPiece")) { %>
                                                <br><span style="color: red;"><%= errors.get("noPiece") %></span>
                                                <% } %>
                                            </div>
                                            <div class="form-group">
                                                <label for="courrielProprietaire">courriel</label>
                                                <input class="form-control" type="text" name="courrielProprietaire">
                                                <% if (errors != null && errors.containsKey("courrielProprietaire")) { %>
                                                <br><span style="color: red;"><%= errors.get("courrielProprietaire") %></span>
                                                <% } %>
                                            </div>
                                            <div class="form-group">
                                                <label for="motifTransfert">Motif Transfert</label>
                                                <textarea class="form-control" name="motifTransfert" rows="5" cols="10"></textarea>
                                                <% if (errors != null && errors.containsKey("motifTransfert")) { %>
                                                <br><span style="color: red;"><%= errors.get("motifTransfert") %></span>
                                                <% } %>
                                            </div>
                                            <p>
                                                <label for="etat">Etat</label>
                                                <select class="form-control" name="etat">
                                                    <option value="E" translate="no">E</option>
                                                    <option value="A" translate="no">A</option>
                                                </select>
                                                <% if (errors != null && errors.containsKey("etat")) { %>
                                                <br><span style="color: red;"><%= errors.get("etat") %></span>
                                                <% } %>
                                            </p>
                                            <p>
                                                <input class="btn btn-primary mr-2" type="submit" name="opt" value="Enregistrer" translate="no">
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
