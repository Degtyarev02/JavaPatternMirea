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

<form method="get">
    <label>
        Поле:
        <input type="text" name="field">
    </label>
    <label>
        Значение:
        <input type="text" name="value">
    </label>
        <button type="submit">Найти</button>
</form>
<br>
<br>
<br>
<#list users as user>
    <div>
        <span>${user.firstName} ${user.middleName} ${user.lastName} ${user.birthDate}</span>
    </div>
<#else>
    <span>Нет пользователей</span>
</#list>
</body>
</html>