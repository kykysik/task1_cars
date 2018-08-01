<%@ page pageEncoding="UTF8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kykysik
  Date: 01.08.18
  Time: 2:32
  To change this template use File | Settings | File Templates.
--%>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources" />

<!DOCTYPE html>
<html lang="${language}">
<head>
    <meta charset="UTF-8">
    <title>TaxiPark</title>
</head>
<body>
<footer> <span><a href="/home"><fmt:message key="output.return"/></a></span>
    <h1  align="center"><fmt:message key="output.title"/></h1></footer>

<td><h4><fmt:message key="output.park.price" />: ${price}$</h4></td>
<td><h3><fmt:message key="output.speed.range" /></h3></td>


<table>
    <td><fmt:message key="output.consumption.electric" /></td>

    <table border="3">
        <c:forEach var="cars" items="${electricList}">
            <tr><td>${cars.name()}</td><td>${cars.getSpeed()}</td></tr>
        </c:forEach>
    </table>

    <td><fmt:message key="output.consumption.gasoline" /></td>

    <table  border="3">
        <c:forEach var="cars" items="${gasolineList}">
            <tr><td>${cars.name()}</td><td>${cars.getSpeed()}</td></tr>
        </c:forEach>
    </table>
</table>


<td><h3><fmt:message key="output.electric" /></h3></td>

<table> <th><td><fmt:message key="output.consumption.electric" /></td></th>

    <table border="3">
        <c:forEach var="cars" items="${electricCompare}">
            <tr><td>${cars.name()}</td><td>${cars.getConsumption()}</td></tr>
        </c:forEach>
    </table>
</table>

<td><h3><fmt:message key="output.gasoline"  /></h3></td>

<table>
    <th><td ><fmt:message key="output.consumption.gasoline" /></td></th>

    <table border="3">
        <c:forEach var="cars" items="${gasolineCompare}">
            <tr><td>${cars.name()}</td><td>${cars.getConsumption()}</td></tr>
        </c:forEach>
    </table>
</table>





</body>
</html>
