<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Recherche des Pays</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Recherche des Pays
            </div>
            <div class="card-body">
                <form action="chercher.do" method="get">
                    <label>Mot Cl�</label>
                    <input type="text" name="motCle" value="${model.motCle}" />
                    <button type="submit" class="btn btn-primary">Chercher</button>
                </form>

                <table class="table table-striped">
                    <tr>
                        <th>ID</th><th>Nom Pays</th><th>Population</th><th>Continent</th>
                    </tr>
                    <c:forEach items="${model.paysList}" var="p">
                        <tr>
                            <td>${p.idPays}</td>
                            <td>${p.nomPays}</td>
                            <td>${p.population}</td>
                            <td>${p.continent}</td>
							<td><a onclick="return confirm('Etes-vous s�r ?')"
								href="supprimer.do?id=${p.idPays }">Supprimer</a></td>
							<td><a href="editer.do?id=${p.idPays }">Edit</a></td>
						</tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
