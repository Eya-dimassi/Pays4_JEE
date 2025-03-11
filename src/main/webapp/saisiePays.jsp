<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Saisie des Pays</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="header.jsp"%>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">Saisie des Pays</div>
            <div class="card-body">
                <form action="save.do" method="post">
                    <div class="form-group">
                        <label class="control-label">Nom Pays :</label> 
                        <input type="text" name="nomPays" class="form-control" required />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Population :</label> 
                        <input type="number" name="population" class="form-control" required />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Continent :</label> 
                        <input type="text" name="continent" class="form-control" required />
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
