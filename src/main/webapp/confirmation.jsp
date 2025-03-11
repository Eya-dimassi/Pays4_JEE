<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<body>
    <%@include file="header.jsp" %>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Confirmation Ajout Pays
            </div>
            <div class="card-body">

                <div class="form-group">
                    <label class="control-label">ID :</label>
                    <input type="text" class="form-control" value="${pays.idPays}" readonly />

                    <label class="control-label">Nom Pays :</label>
                    <input type="text" class="form-control" value="${pays.nomPays}" readonly />
                </div>

                <div class="form-group">
                    <label class="control-label">Population :</label>
                    <input type="text" class="form-control" value="${pays.population}" readonly />
                </div>

                <div class="form-group">
                    <label class="control-label">Continent :</label>
                    <input type="text" class="form-control" value="${pays.continent}" readonly />
                </div>
            </div>
        </div>
    </div>
</body>
</html>