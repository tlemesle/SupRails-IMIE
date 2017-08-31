<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SupRails - Add a station</title>
    </head>
    <body>
        <form method="POST">
            <div>
                <label for="name">Firstname</label>
                <input type="text" id="firstName" name="firstName" />
            </div>
            <div>
                <label for="address">Lastname</label>
                <input type="text" id="lastName" name="lastName" />
            </div>
            <div>
                <label for="city">email</label>
                <input type="text" id="email" name="email" />
            </div>
            <div>
                <input type="submit" value="Add" />
            </div>
            <div>
                <input type="hidden" value="${id}" name="id"/>
            </div>
        </form>
    </body>
</html>
