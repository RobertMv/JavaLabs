<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.MainClass" %>
<jsp:useBean id="mainBean" scope="session" class="main.MainClass"/>
<html>
<head>
    <title>Стартовая страница</title>
</head>
<body>
<form action="main.jsp">
    <h1>Мулюков Роберт Рустамович</h1>
    <h2>Задание: </h2>
    <p>
        В последовательности чисел найти сумму «чётных и положительных»
        и «нечётных и отрицательных» чисел.
    </p>
    <button type="submit">На главную</button>
</form>
</body>
</html>