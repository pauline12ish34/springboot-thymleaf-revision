<jsp:include page="../components/header.jsp"/>

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
<p>add new student</p>
<form action="/items/create" method="post">
    <input type="text" name="name" placeholder="Enter firstName"/>
    <input type="text" name="quantity" placeholder="Enter quantity"/>
    <input type="text" name="price" placeholder="Enter price of 1 kg"/>
    <button class="btn btn-primary">save</button>
</form>
</body>
</html>