<%-- 
    Document   : Enregistrement_Vehicule
    Created on : 16 juin 2024, 04:32:02
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../layout/headInfo.jsp" %>
        <title>---------</title>
    </head>
    <body>
        <div class="container-scroller">
            <%@include file="../layout/navbar.jsp" %>
            <div class="container-fluid page-body-wrapper">
                <%@include file="../layout/sidebar.jsp" %>
                <% 
                Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
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
                                        <p class="card-description">Information vehicule</p>
                                        <form class="form-sample" action="${pageContext.request.contextPath}/VehiculeServlet" method="post" enctype="multipart/form-data">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Marque</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="marque" class="form-control">
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
                                                            <input type="text" name="modele" class="form-control">
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
                                                            <input type="text" name="couleur" class="form-control">
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
                                                            <input type="text" name="annee" class="form-control">
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
                                                            <input type="text" name="noMoteur" class="form-control">
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
                                                            <input type="text" name="nbCylindre" class="form-control">
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
                                                                <option value="Manuelle">Manuelle</option>
                                                                <option value="Automatique">Automatique</option>
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
                                                                <option value="Gasoline">Gasoline</option>
                                                                <option value="Diesel">Diesel</option>
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
                                                            <input type="text" name="plaqueImmatriculation" class="form-control">
                                                            <% if (errors != null && errors.containsKey("plaqueImmatriculation")) { %>
                                                            <br><span style="color: red;"><%= errors.get("plaqueImmatriculation") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label">Alerte</label>
                                                        <div class="col-sm-4">
                                                            <div class="form-check">
                                                                <label class="form-check-label">
                                                                    <input type="radio" class="form-check-input" name="alerte"
                                                                           id="membershipRadios1" value="true">
                                                                    Active
                                                                </label>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-5">
                                                            <div class="form-check">
                                                                <label class="form-check-label">
                                                                    <input type="radio" class="form-check-input" name="alerte"
                                                                           id="membershipRadios2" value="false" checked>
                                                                    Desactive
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <p class="card-description">Information Proprietaire</p>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label" for="nom">Nom</label>
                                                        <div class="col-sm-9">
                                                            <input id="nom" type="text" name="nomProprietaire" class="form-control">
                                                            <% if (errors != null && errors.containsKey("nomProprietaire")) { %>
                                                            <br><span style="color: red;"><%= errors.get("nomProprietaire") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label" for="prenom">Prenom</label>
                                                        <div class="col-sm-9">
                                                            <input id="prenom" type="text" name="prenomProprietaire" class="form-control">
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
                                                        <label class="col-sm-3 col-form-label" for="sexe">sexe</label>
                                                        <div class="col-sm-9">
                                                            <select id="sexe" class="form-control" name="sexeProprietaire">
                                                                <option value="M">M</option>
                                                                <option value="F">F</option>
                                                            </select>
                                                            <% if (errors != null && errors.containsKey("sexeProprietaire")) { %>
                                                            <br><span style="color: red;"><%= errors.get("sexeProprietaire") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label" for="typePiece">Piece Proprietaire</label>
                                                        <div class="col-sm-9">
                                                            <select id="typePiece" class="form-control" name="typePieceProp">
                                                                <option value="licence">Licence</option>
                                                                <option value="CarteIdentification">Carte d'Identification</option>
                                                                <option value="Passeport">Passeport</option>
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
                                                        <label class="col-sm-3 col-form-label" for="noPiece">No. Piece</label>
                                                        <div class="col-sm-9">
                                                            <input id="noPiece" type="text" name="noPiece" class="form-control">
                                                            <% if (errors != null && errors.containsKey("noPiece")) { %>
                                                            <br><span style="color: red;"><%= errors.get("noPiece") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label" for="tel">Telephone</label>
                                                        <div class="col-sm-9">
                                                            <input id="tel" type="text" name="telProprietaire" class="form-control">
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
                                                        <label class="col-sm-3 col-form-label" for="adresse">Adresse</label>
                                                        <div class="col-sm-9">
                                                            <input id="adresse" type="text" name="adresseProprietaire" class="form-control">
                                                            <% if (errors != null && errors.containsKey("adresseProprietaire")) { %>
                                                            <br><span style="color: red;"><%= errors.get("adresseProprietaire") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 col-form-label" for="courriel">Courriel</label>
                                                        <div class="col-sm-9">
                                                            <input id="courriel" type="text" name="courrielProprietaire" class="form-control">
                                                            <% if (errors != null && errors.containsKey("courrielProprietaire")) { %>
                                                            <br><span style="color: red;"><%= errors.get("courrielProprietaire") %></span>
                                                            <% } %>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <p>
                                                <input class="btn btn-primary mr-2" type="submit" name="opt" value="Enregistrer">
                                            </p> 
                                        </form>
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