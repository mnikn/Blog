<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes"
        trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ attribute name="htmlTitle" type="java.lang.String" required="true" %>
<%@ attribute name="headContent" fragment="true"%>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title><c:out value="${htmlTitle}" /></title>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/stylesheet/main.css" /> ">
    <jsp:invoke fragment="headContent" />
</head>
<body>
    <jsp:doBody />
</body>
</html>