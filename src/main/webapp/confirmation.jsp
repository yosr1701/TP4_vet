<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmation Ajout Vetement</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="container mt-4">
        <div class="card">
            <div class="card-header text-center">Confirmation Ajout Vetement</div>
            <div class="card-body">
                <c:if test="${not empty vetement}">
                    <div class="form-group">
                        <label class="control-label">ID :</label>
                        <input type="text" name="idVet" class="form-control" value="${vetement.idVet}" readonly />
                    </div>

                    <div class="form-group">
                        <label class="control-label">Nom Vetement :</label>
                        <input type="text" name="nomVet" class="form-control" value="${vetement.nomVet}" readonly />
                    </div>

                    <div class="form-group">
                        <label class="control-label">Taille :</label>
                        <input type="text" name="taille" class="form-control" value="${vetement.taille}" readonly />
                    </div>

                    <div class="form-group">
                        <label class="control-label">Prix :</label>
                        <input type="text" name="prix" class="form-control" value="${vetement.prix}" readonly />
                    </div>
                </c:if>

            </div>
        </div>
    </div>
</body>
</html>
