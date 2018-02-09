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
        <title>Создать новую категорию</title>
    </head>
    <body>
         <h3>Создать новую</h3>
        <form action="/Shop/createcategory" method="post">
            <table class="tdata">
                <tr>
                    <td width="1%">Код: </td><td><input type="text" name="code"></td>
                </tr>
                <tr>
                    <td width="1%">Имя: </td><td><input type="text" name="name"></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td> <input type="submit" value="Сохранить"></td>
                </tr>
               
            </table>
        </form> 
         <form action="/Shop/categories" method="post">
              <tr>
                    <td> <input type="submit" value="Назад"></td>
                </tr>
         </form>
    </body>
</html>
