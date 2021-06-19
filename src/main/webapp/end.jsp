<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="mainBean" scope="session" class="main.MainClass" />
<html>
<head>
    <title>Финишная страница</title>
</head>
<body>
    <h1>Результаты: </h1>
    <table>
        <tr>
            <td>Массив:</td>
            <td><jsp:getProperty name="mainBean" property="mainArray"/></td>
        </tr>
        <tr>
            <td>Список чётных и положительных:</td>
            <td><jsp:getProperty name="mainBean" property="evenAndPositiveArray"/></td>
        </tr>
        <tr>
            <td>Сумма 1:</td>
            <td><jsp:getProperty name="mainBean" property="sumOfEvenAndPositive"/></td>
        </tr>

        <tr>
            <td>Список нечётных и отрицательных:</td>
            <td><jsp:getProperty name="mainBean" property="oddAndNegativeArray"/></td>
        </tr>
        <tr>
            <td>Сумма 2:</td>
            <td><jsp:getProperty name="mainBean" property="sumOfOddAndNegative"/></td>
        </tr>
    </table>
    <a href="main.jsp">Вернуться на главную</a>
</body>
</html>
