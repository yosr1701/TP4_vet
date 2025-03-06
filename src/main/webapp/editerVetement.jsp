<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Modification des Vêtements</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp" %>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Modification des Vêtements
            </div>
            <div class="card-body">
                <form action="update.do" method="post">
                    <div class="form-group">
                        <label class="control-label">ID Vêtement :</label>
                        <input type="text" name="id" class="form-control" value="${vetement.idVet}" readonly/>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nom Vêtement :</label>
                        <input type="text" name="nomVet" class="form-control" value="${vetement.nomVet}"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Taille :</label>
                        <select name="taille" class="form-control">
                            <option value="XS" ${vetement.taille == 'XS' ? 'selected' : ''}>XS</option>
                            <option value="S" ${vetement.taille == 'S' ? 'selected' : ''}>S</option>
                            <option value="M" ${vetement.taille == 'M' ? 'selected' : ''}>M</option>
                            <option value="L" ${vetement.taille == 'L' ? 'selected' : ''}>L</option>
                            <option value="XL" ${vetement.taille == 'XL' ? 'selected' : ''}>XL</option>
                            <option value="XXL" ${vetement.taille == 'XXL' ? 'selected' : ''}>XXL</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Prix :</label>
                        <input type="text" name="prix" class="form-control" value="${vetement.prix}"/>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-primary">Modifier</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
