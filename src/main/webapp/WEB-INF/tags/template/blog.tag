<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes"
        trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ attribute name="htmlTitle" type="java.lang.String" required="true" %>
<%@ attribute name="types" type="java.util.Set<java.lang.String>"%>
<%@ attribute name="labels" type="java.util.Set<java.lang.String>"%>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<template:base htmlTitle="${htmlTitle}">
    <script>
        $(document).ready(function(){
            $(".home-link").click(function(){
                window.location = window.location.origin;
            });
        });
    </script>
    <link rel="stylesheet" href="<c:url value="/resources/stylesheet/blog.css" />">
    <nav class="nav-sidebar">
        <h1 class="home-link" style="cursor: pointer">Kn's Blog</h1><hr>
        <nav class="nav-button-group">
            <button class="home-link">首页</button>
            <button>项目</button>
            <button>关于</button>
        </nav><hr>
        <h3>文章分类</h3>
        <nav class="nav-button-group">
            <c:forEach items="${types}" var="type">
                <button>type</button>
            </c:forEach>
        </nav><hr>

        <h3>标签墙</h3>
        <nav class="nav-button-group">
            <c:forEach items="${labels}" var="label">
                <button>${label}</button>
            </c:forEach>
        </nav><hr>
        <form class="form-search" method="post">
            <input type="search" name="search-content" placeholder="请输入要搜索文章的标题...">
            <input type="submit" name="submit" value="搜索">
        </form>
    </nav>
    <hr id="sidebar-line">
    <main>
        <jsp:doBody />
    </main>

</template:base>