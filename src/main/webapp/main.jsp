<%@ page import="main.MainClass" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="mainBean" scope="session" class="main.MainClass" />
<jsp:setProperty name="mainBean" property="count"/>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<h1>Счётчик  <jsp:getProperty name="mainBean" property="count" /></h1>

<%
    mainBean.clear();
    if (request.getParameter("list") != null){
        mainBean.prepareArr(mainBean, request.getParameter("list"));
        response.sendRedirect("end.jsp");
    } else {
        mainBean.increaseCount();
    }
%>
    <h1>Данные</h1>
    <form action="main.jsp">
        <input type="text" name="list" value="">
        <%-- 10 2 4 -5 -3 -2 0 15 --%>
        <button type="submit">Вычислить</button>
    </form>
</body>
</html>
