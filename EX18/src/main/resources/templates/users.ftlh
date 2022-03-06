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

<form method="post">
    <label>
        Фамилия:
        <input type="text" name="lastName">
    </label>
    <br>
    <br>
    <label>
        Имя:
        <input type="text" name="firstName">
    </label>
    <br>
    <br>
    <label>
        Отчество:
        <input type="text" name="middleName">
    </label>
    <br>
    <br>
    <label>
        Дата рождения:
        <input type="text" name="birthDate">
    </label>
    <button type="submit">Сохранить</button>
</form>
<br>
<br>
<br>
<#list users as user>
    <div>
        <span>${user.firstName} ${user.middleName} ${user.lastName} ${user.birthDate}</span>
        <form action="/users/${user.id}" method="post">
            <button type="submit">Удалить</button>
        </form>
    </div>
<#else>
    <span>Нет пользователей</span>
</#list>
</body>
</html>