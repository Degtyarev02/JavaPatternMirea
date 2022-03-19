<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Users</title>
</head>
<body>
<#list users as user>
    <div>
        <span>${user.username}</span>
        <br>
        <form action="/users/${user.id}" method="post">
            <button type="submit">Удалить</button>
        </form>
    </div>
<#else>
    <span>Нет пользователей</span>
</#list>
</body>
</html>