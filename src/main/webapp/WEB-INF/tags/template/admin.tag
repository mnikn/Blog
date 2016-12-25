<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes"
        trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ attribute name="htmlTitle" type="java.lang.String" required="true" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<script>
    function home(){
        window.location = location.origin;
    }
    function logout(){
        window.location = location.origin + "/login?logout";
    }
</script>
<template:base htmlTitle="${htmlTitle}">
    <script>
        function showArticleItems(){
            document.getElementById("article-items").style.display = "block";
        }
        function hideArticleItems(){
            document.getElementById("article-items").style.display = "none";
        }
    </script>
    <link rel="stylesheet" href="<c:url value="/resources/stylesheet/admin.css" />">
    <header>
        <button onclick="home()">首页</button>
        <button onclick="logout()">登出</button>
    </header>
    <div class="content-wrapper">
        <nav class="nav-sidebar">
            <ul>
                <li>后台首页</li>
                <div id="article-manage" onmouseenter="showArticleItems()"
                     onmouseleave="hideArticleItems()">
                    <li >文章管理</li>
                    <div id="article-items" hidden="hidden">
                        <li>发布文章</li>
                        <li>管理文章</li>
                        <li>草稿</li>
                    </div>
                </div>
                <li>评论管理</li>
                <li>用户设置</li>
            </ul>
        </nav>
        <main>
            <jsp:doBody />
        </main>
    </div>
</template:base>