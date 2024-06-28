<%-- 
    Document   : login
    Created on : 19 juin 2024, 23:04:15
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/layout/headInfo.jsp" %>
        <title>JSP Page</title>
    </head>
    <div class="container-scroller">
        <div class="container-fluid page-body-wrapper full-page-wrapper">
            <div class="content-wrapper d-flex align-items-center auth">
                <div class="row flex-grow">
                    <div class="col-lg-4 mx-auto">
                        <div class="auth-form-light text-left p-5">
                            <div class="brand-logo d-flex justify-content-center" >
                                <img src="${pageContext.request.contextPath}/assets/images/oavct.png" class="img-fluid rounded-circle w-50">
                            </div>
                            <h4>Bienvenue sur l'application OAVCT</h4>
                            <form class="pt-3" method="post" action="${pageContext.request.contextPath}/LoginServlet">
                                <div class="form-group">
                                    <input type="text"  name="username" class="form-control form-control-lg" id="exampleInputEmail1" placeholder="Username">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="pwd" class="form-control form-control-lg" id="exampleInputPassword1" placeholder="Password">
                                </div>
                                <div class="mt-3 mb-3">
                                    <input type="submit" class="btn btn-block btn-lg font-weight-medium auth-form-btn" style="background-color: #bc0301; color: #fff;" value="Connecter">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
        </div>
        <!-- page-body-wrapper ends -->
    </div>
    <%@include file="layout/footer.jsp" %>
</body>
</html>
