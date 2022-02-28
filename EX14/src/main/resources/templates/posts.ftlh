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
<form method="post">
    <input type="text" name="text">
    <button type="submit">Сохранить</button>
</form>
<div>
    <#list posts as post>
        <div><span>${post.id}: ${post.creationDate} - ${post.text}</span>
            <form action="/posts/${post.id}" method="post">
                <button type="submit">Удалить</button>
            </form>
        </div>
    <#else>
        <span>Нет постов</span>
    </#list>
</div>
</body>
</html>