<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Liste des Pays</title>
</head>
<body>
    <h2>Recherche des Pays</h2>
    <form action="controleur" method="post">
        <label>Mot Clé :</label>
        <input type="text" name="motCle" value="${modele.motCle}">
        <input type="submit" value="Rechercher">
    </form>

    <table border="1" width="80%">
        <tr>
            <th>ID</th> <th>Nom</th> <th>Population</th> <th>Continent</th><th>Suppression</th><th>Edition</th>
        </tr>
        <c:forEach items="${modele.paysList}" var="p">
            <tr>
                <td>${p.idPays}</td>
                <td>${p.nomPays}</td>
                <td>${p.population}</td>
                <td>${p.continent}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
