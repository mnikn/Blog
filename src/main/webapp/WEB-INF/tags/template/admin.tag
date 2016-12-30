<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes"
        trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ attribute name="htmlTitle" type="java.lang.String" required="true" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<template:base htmlTitle="${htmlTitle}">
    <script>
        $(document).ready(function(){

            $("#blog-button").click(function(){
                window.location = location.origin;
            });
            $("#logout-button").click(function(){
                window.location = location.origin + "/login?logout";
            });
            $("#admin-button").click(function(){
                window.location = location.origin + "/admin";
            });
            $("#post-article-button").click(function(){
                window.location = location.origin + "/admin/article/post";
            });
            $("#manage-article-button").click(function(){
                window.location = location.origin + "/admin/article/list";
            });


            $("#article-manage").mouseenter(function(){
                $("#article-items").slideToggle("fast");
            }).mouseleave(function(){
                $("#article-items").slideToggle("fast");
            });
        });
    </script>
    <link rel="stylesheet" href="<c:url value="/resources/stylesheet/admin.css" />">
    <header>
        <button id="blog-button">首页</button>
        <button id="logout-button">登出</button>
    </header>
    <div class="content-wrapper">
        <nav class="nav-sidebar">
            <ul>
                <li id="admin-button">后台首页</li>
                <div id="article-manage">
                    <li >文章管理</li>
                    <div id="article-items" hidden="hidden">
                        <li id="post-article-button">发布文章</li>
                        <li id="manage-article-button">管理文章</li>
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