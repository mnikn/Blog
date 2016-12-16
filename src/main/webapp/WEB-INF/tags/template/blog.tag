<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes"
        trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ attribute name="htmlTitle" type="java.lang.String" required="true" %>
<%@ attribute name="extraHeadContent" fragment="true" required="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<template:main htmlTitle="${htmlTitle}">
    <jsp:attribute name="headContent">
        <link rel="stylesheet" type="text/css"
              href="<c:url value="/resources/stylesheet/blog.css" /> ">
        <jsp:invoke fragment="extraHeadContent" />
    </jsp:attribute>
    <jsp:body>
        <header class="caption">Kn's world</header>
        <header class="description">A gamer,programmer and harmonica player</header>
        <div class="body-content">
            <nav>
                <ul>
                    <li>首页</li>
                    <li>分类</li>
                    <li>标签</li>
                    <li>统计</li>
                    <li>关于</li>
                </ul>
            </nav>
            <main>
                <jsp:doBody />
            </main>
        </div>
    </jsp:body>
</template:main>
