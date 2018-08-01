<%@ page pageEncoding="UTF8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: kykysik
  Date: 21.07.18
  Time: 23:25
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
<footer><h1 align="center"><fmt:message key="output.title"/></h1></footer>
<p style="color: red;">${error}</p>
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>EN</option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}>RU</option>
        <option value="ua" ${language == 'ua' ? 'selected' : ''}>UA</option>
    </select>
</form>



<form method="post" action="${pageContext.request.contextPath}/home">
    <table border="0">

        <tr>
            <td><label for="min"><fmt:message key="input.speed.range" /></label></td>
        </tr>
        <tr>
            <td><label for="min"><fmt:message key="input.min" /></label></td>
        </tr>
        <td><input required type="number" min="0" max="500" id="min" name="min"/> </td>


        <tr>
            <td><label for="min"><fmt:message key="input.max" /></label></td>
        </tr>
        <td><input required type="number" min="min" max="500" name="max" /> </td>

        <tr>
            <td colspan ="2">
                <fmt:message key="login.button.submit" var="buttonValue" />

                <input type="submit" name="submit" value="${buttonValue}">
                <input hidden name="lang" value="${language}">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
