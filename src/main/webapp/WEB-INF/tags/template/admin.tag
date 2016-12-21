<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes"
        trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ attribute name="htmlTitle" type="java.lang.String" required="true" %>
<%@ attribute name="extraHeadContent" fragment="true" required="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<template:main htmlTitle="${htmlTitle}">
    <jsp:attribute name="headContent">
        <link rel="stylesheet" type="text/css"
              href="<c:url value="/resources/stylesheet/admin/admin.css" /> ">
        <script>
            function onArticleClick() {
                var subItems = document.getElementsByClassName("article-subItem");
                for(var i = 0;i < subItems.length;++i){
                    if(subItems[i].style.display == "block"){
                        subItems[i].style.display = "none";
                    }
                    else{
                        subItems[i].style.display = "block";
                    }
                }
            }
            function admin() {
                window.location = window.location.origin + "/admin";
            }
            function home() {
                window.location = window.location.origin + "/home";
            }
            function postArticle() {
                window.location = window.location.origin + "/admin/post-article";
            }
            function logout() {
                window.location = window.location.origin + "/login?logout";
            }
        </script>
        <jsp:invoke fragment="extraHeadContent" />
    </jsp:attribute>
    <jsp:body>
        <header>
            <button id="admin-system">后台管理系统</button>
            <div class="blog-nav">
                <button onclick="home()">首页</button>
                <button onclick="logout()">登出</button>
            </div>
        </header>
        <div class="body-content">
            <nav>
                <ul>
                    <li onclick="admin()">后台首页</li><hr>
                    <li id="admin-article" onclick="onArticleClick()">文章</li><hr>
                    <div class="article-subItem">
                        <li id="post-article" onclick="postArticle()">发布文章</li><hr>
                        <li>文章管理</li><hr>
                        <li>草稿夹</li><hr>
                    </div>
                    <li>评论管理</li>
                </ul>
            </nav>
            <main>
                <jsp:doBody />
            </main>
        </div>
    </jsp:body>
</template:main>