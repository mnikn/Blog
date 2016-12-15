<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes"
        trimDirectiveWhitespaces="true" %>
<%@ attribute name="htmlTitle" type="java.lang.String" %>
<%@ attribute name="headContent" fragment="true" required="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title><c:out value="${htmlTitle}" /></title>
    <link rel="stylesheet"
          href="<c:url value="/WEB-INF/resources/stylesheet/base.css" /> ">
    <jsp:invoke fragment="headContent" />
</head>
<body>
    <jsp:doBody />
</body>
</html>