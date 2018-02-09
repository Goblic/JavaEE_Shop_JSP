<%-- 
    Document   : create_category
    Created on : 03.02.2018, 15:22:30
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Удалить категорию</title>
    </head>
    <body>
         <h3>Удалить категорию</h3>
        <form action="/Shop/deletecategory" method="post">
            <table class="tdata">
                <tr>
                    <td width="1%"> Введите Код: </td><td><input type="text" name="code"></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td> <input type="submit" value="Удалить"></td>
                </tr>
            </table>
        </form>         
    </body>
</html>
