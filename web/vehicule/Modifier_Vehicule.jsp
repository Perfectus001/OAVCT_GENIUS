<%-- 
    Document   : Modifier_Vehicule
    Created on : 19 juin 2024, 00:49:16
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
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
                                        Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
                                        String error = (String) request.getAttribute("error");
                                        Vehicule v = (Vehicule)request.getAttribute("vehicules");
                                        Proprietaire p = (Proprietaire)request.getAttribute("proprietaires");
                                        Vehicule v2 = (Vehicule)request.getAttribute("V2");
                                        Proprietaire p2 = (Proprietaire)request.getAttribute("P2");
                                        if(v == null && p == null && errors == null){
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
                                        <%
                                        }else{
                
                                        if(v2 != null && p2 != null){
                                            v = v2;
                                            p = p2;
                                        }
                                        %>
                                        <form class="form-sample" action="${pageContext.request.contextPath}/VehiculeServlet" method="post" enctype="multipart/form-data">
                                            <input type="hidden" name="id2" value="<%=p!=null?p.getId():""%>">
                                            <input type="hidden" name="id" value="<%=v!=null?v.getId():""%>">

                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Marque</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="marque" class="form-control" value="<%= v!=null?v.getMarque():"" %>">
                                                            <% if (errors != null && errors.containsKey("marque")) { %>
                                                            <br><span style="color: red;"><%= errors.get("marque") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Modele</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="modele" class="form-control" value="<%=v!=null?v.getModele():""%>">
                                                            <% if (errors != null && errors.containsKey("modele")) { %>
                                                            <br><span style="color: red;"><%= errors.get("modele") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Couleur</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="couleur" class="form-control" value="<%=v!=null?v.getCouleur():""%>">
                                                            <% if (errors != null && errors.containsKey("couleur")) { %>
                                                            <br><span style="color: red;"><%= errors.get("couleur") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Annee</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="annee" class="form-control" value="<%=v!=null?v.getAnnee():""%>">
                                                            <% if (errors != null && errors.containsKey("annee")) { %>
                                                            <br><span style="color: red;"><%= errors.get("annee") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">No. Moteur</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="noMoteur" class="form-control" value="<%=v!=null?v.getNoMoteur():""%>">
                                                            <% if (errors != null && errors.containsKey("noMoteur")) { %>
                                                            <br><span style="color: red;"><%= errors.get("noMoteur") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Nombre Cylindre</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="nbCylindre" class="form-control" value="<%=v!=null?v.getNbCylindre():""%>">
                                                            <% if (errors != null && errors.containsKey("nbCylindre")) { %>
                                                            <br><span style="color: red;"><%= errors.get("nbCylindre") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Type Transmission</label>
                                                        <div class="col-sm-9">
                                                            <select class="form-control" name="typeTransmission">
                                                                <option value="Manuelle" <%= v!=null && v.getTypeTransmission().equalsIgnoreCase("Manuelle")?"selected":""%>>Manuelle</option>
                                                                <option value="Automatique" <%= v!=null && v.getTypeTransmission().equalsIgnoreCase("Automatique")?"selected":""%>>Automatique</option>
                                                            </select>
                                                            <% if (errors != null && errors.containsKey("typeTransmission")) { %>
                                                            <br><span style="color: red;"><%= errors.get("typeTransmission") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Type Essence</label>
                                                        <div class="col-sm-9">
                                                            <select class="form-control" name="typeEssence">
                                                                <option value="Gasoline" <%= v!=null && v.getTypeEssence().equalsIgnoreCase("Gasoline")?"selected":""%>>Gasoline</option>
                                                                <option value="Diesel" <%= v!=null && v.getTypeEssence().equalsIgnoreCase("Diesel")?"selected":""%>>Diesel</option>
                                                            </select>
                                                            <% if (errors != null && errors.containsKey("typeTransmission")) { %>
                                                            <br><span style="color: red;"><%= errors.get("typeTransmission") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Photo Vehicule</label>
                                                        <div class="col-sm-9">
                                                            <input type="file" accept="image/*" class="form-control" name="photo">
                                                            <% if (errors != null && errors.containsKey("photo")) { %>
                                                            <br><span style="color: red;"><%= errors.get("photo") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Plaque d'immatriculation</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="plaqueImmatriculation" class="form-control" value="<%=v!=null?v.getPlaqueImmatriculation():""%>">
                                                            <% if (errors != null && errors.containsKey("plaqueImmatriculation")) { %>
                                                            <br><span style="color: red;"><%= errors.get("plaqueImmatriculation") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <p class="card-description">Information Proprietaire</p>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Nom</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="nomProprietaire" class="form-control" value="<%=p!=null?p.getNom():""%>">
                                                            <% if (errors != null && errors.containsKey("nomProprietaire")) { %>
                                                            <br><span style="color: red;"><%= errors.get("nomProprietaire") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Prenom</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="prenomProprietaire" class="form-control" value="<%=p!=null?p.getPrenom():""%>">
                                                            <% if (errors != null && errors.containsKey("prenomProprietaire")) { %>
                                                            <br><span style="color: red;"><%= errors.get("prenomProprietaire") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">sexe</label>
                                                        <div class="col-sm-9">
                                                            <select class="form-control" name="sexeProprietaire">
                                                                <option value="M" <%= p!=null && p.getSexe().equalsIgnoreCase("M")?"selected":""%>>M</option>
                                                                <option value="F" value="F"<%= p!=null && p.getSexe().equalsIgnoreCase("F")?"selected":""%>>F</option>
                                                            </select>
                                                            <% if (errors != null && errors.containsKey("sexeProprietaire")) { %>
                                                            <br><span style="color: red;"><%= errors.get("sexeProprietaire") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Piece Proprietaire</label>
                                                        <div class="col-sm-9">
                                                            <select class="form-control" name="typePieceProp">
                                                                <option value="licence" <%= p!=null && p.getTypePiece().equalsIgnoreCase("licence")?"selected":""%>>Licence</option>
                                                                <option value="CarteIdentification" <%= p!=null && p.getTypePiece().equalsIgnoreCase("CarteIdentification")?"selected":""%>>Carte d'Identification</option>
                                                                <option value="Passeport" <%= p!=null && p.getTypePiece().equalsIgnoreCase("Passeport")?"selected":""%>>Passeport</option>
                                                            </select>
                                                            <% if (errors != null && errors.containsKey("typePieceProp")) { %>
                                                            <br><span style="color: red;"><%= errors.get("typePieceProp") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">No. Piece</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="noPiece" class="form-control" value="<%=p!=null?p.getNoPiece():""%>">
                                                            <% if (errors != null && errors.containsKey("noPiece")) { %>
                                                            <br><span style="color: red;"><%= errors.get("noPiece") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Telephone</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="telProprietaire" class="form-control" value="<%=p!=null?p.getTel():""%>">
                                                            <% if (errors != null && errors.containsKey("telProprietaire")) { %>
                                                            <br><span style="color: red;"><%= errors.get("telProprietaire") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Adresse</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="adresseProprietaire" class="form-control" value="<%=p!=null?p.getAdresse():""%>">
                                                            <% if (errors != null && errors.containsKey("adresseProprietaire")) { %>
                                                            <br><span style="color: red;"><%= errors.get("adresseProprietaire") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Courriel</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="courrielProprietaire" class="form-control" value="<%=p!=null?p.getCourriel():""%>">
                                                            <% if (errors != null && errors.containsKey("courrielProprietaire")) { %>
                                                            <br><span style="color: red;"><%= errors.get("courrielProprietaire") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <p>
                                                <input class="btn btn-primary mr-2" type="submit" name="opt" value="Modifier">
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
