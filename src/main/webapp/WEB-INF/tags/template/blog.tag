<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes"
        trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ attribute name="htmlTitle" type="java.lang.String" required="true" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<template:base htmlTitle="${htmlTitle}">
    <link rel="stylesheet" href="<c:url value="/resources/stylesheet/blog.css" />">
    <nav class="nav-sidebar">
        <h1>Kn's Blog</h1><hr>
        <nav class="nav-button-group">
            <button>首页</button>
            <button>项目</button>
            <button>关于</button>
        </nav><hr>

        <h3>文章分类</h3>
        <nav class="nav-button-group">
            <button>首页</button>
            <button>项目</button>
            <button>关于</button>
        </nav><hr>

        <h3>标签墙</h3>
        <nav class="nav-button-group">
            <button>首页</button>
            <button>项目</button>
            <button>关于</button>
        </nav><hr>
        <form class="form-search" method="get">
            <input type="search" name="search-content" placeholder="请输入要搜索文章的标题...">
            <input type="submit" name="submit" value="搜索">
        </form>
    </nav>
    <hr id="sidebar-line">
    <main>
        <jsp:doBody />
    </main>

</template:base>