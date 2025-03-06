<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Saisie des Vêtements</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
    <div class="card">
        <div class="card-header">
            Saisie des Vêtements
        </div>
        <div class="card-body">
            <form action="save.do" method="post">
                <div class="form-group">
                    <label class="control-label">Nom Vêtement</label>
                    <input type="text" name="nomVet" class="form-control" required/>
                </div>

                <div class="form-group">
                    <label class="control-label">Taille</label>
                    <select name="taille" class="form-control" required>
                        <option value="" disabled selected>Choisir une taille</option>
                        <option value="XS">XS</option>
                        <option value="S">S</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                        <option value="XL">XL</option>
                        <option value="XXL">XXL</option>
                    </select>
                </div>

                <div class="form-group">
                    <label class="control-label">Prix</label>
                    <input type="text" name="prix" class="form-control" required/>
                </div>

                <div>
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
