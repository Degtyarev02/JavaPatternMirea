<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div class="init-container">
    <div class="init-form">
        <h2 class="sign-in-label">Зарегистрироваться</h2>
        <form action="/registration" method="post" class="login-form">
            <input type="text" name="username" placeholder="Username"/>
            <input type="password" name="password" placeholder="Password"/>
            <div><input type="password" name="password2" placeholder="Confirm password"/></div>
            <input type="submit" value="Подтвердить" class="submit"/>
            <a href="/login" class="registration">Войти</a>
        </form>
    </div>
</div>
</body>
</html>