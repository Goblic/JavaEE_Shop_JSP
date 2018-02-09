<%-- 
    Document   : categories
    Created on : 03.02.2018, 11:50:51
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Категории продуктов</title>        
        <link rel="stylesheet" href="style.css">        
    </head>
    <body>
        <h3>Категории продуктов</h3>
        
        <a href="/Shop/create_category.jsp">Создать новую категорию</a>
         <a href="/Shop/delete_category.jsp">Удалить категорию</a>
        <table class="tdata">
            <tr>
                <th width="1%">Идентификатор</th>
                <th>Код</th>
                <th>Название</th>
            </tr>
            <c:forEach var="category" items="${categories}">
                <tr>
                    <td width="1%"><a href="/Shop/category?cid=${category.id}">${category.id}</a></td>
                    <td><a href="/Shop/category?cid=${category.id}">${category.code}</a></td>
                    <td><a href="/Shop/category?cid=${category.id}">${category.name}</a></td>
                </tr>
            </c:forEach>                          
        </table>        
    </body>
</html>
