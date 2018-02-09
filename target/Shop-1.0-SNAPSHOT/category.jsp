<%-- 
    Document   : category
    Created on : 03.02.2018, 14:00:28
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <title>Категория продуктов</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <table class="tdata">
            <tr>
                <th colspan="2" width="1%">Категория: <c:out value="${category.name}" /> </th>
            </tr>
            <tr>
                <td width="1%">Идентификатор</td>
                <td><c:out value="${category.id}" /></td>
            </tr>
            <tr>
                <td width="1%">Код</td>
                <td><c:out value="${category.code}" /></td>
            </tr>
            <tr>
                <td width="1%">Дата создания</td>
                <td><c:out value="${category.creationFullDateAsString}" /></td>
            </tr>
        </table>
            <br>
        <form action="/Shop/categories" method="post">
            <tr>
                <td> <input type="submit" value="Назад"></td>
            </tr>
        </form>
    </body>
</html>
