<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Liste des Vêtements</title>
</head>
<body>
    <form action="controleur" method="post">
        <input type="text" name="motCle" value="${modele.motCle}">
        <input type="submit" value="Rechercher">
    </form>

    <table border="1" width="80%">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Taille</th>
            <th>Prix</th>
        </tr>
        <c:forEach items="${modele.vetements}" var="v">
            <tr>
                <td>${v.idVet}</td>
                <td>${v.nomVet}</td>
                <td>${v.taille}</td>
                <td>${v.prix} €</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
