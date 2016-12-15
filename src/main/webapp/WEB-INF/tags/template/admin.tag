<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes"
        trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ attribute name="htmlTitle" type="java.lang.String" required="true" %>
<%@ attribute name="extraHeadContent" fragment="true" required="false" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
<template:main htmlTitle="${htmlTitle}">
    <jsp:attribute name="headContent">
        <link rel="stylesheet" type="text/css"
              href="<c:url value="/resources/stylesheet/admin.css" /> ">
        <script>
            function onArticleClick() {
                var subItems = document.getElementsByClassName("subItem");
                for(var i = 0;i < subItems.length;++i){
                    if(subItems[i].style.display == "block"){
                        subItems[i].style.display = "none";
                    }
                    else{
                        subItems[i].style.display = "block";
                    }
                }
            }
        </script>
        <jsp:invoke fragment="extraHeadContent" />
    </jsp:attribute>
    <jsp:attribute name="navContent">
        <nav>
            <ul>
                <li id="home">后台首页</li><hr>
                <li id="article" onclick="onArticleClick()">文章</li><hr>
                <div class="subItem">
                    <li>发布文章</li><hr>
                    <li>文章管理</li><hr>
                    <li>草稿夹</li><hr>
                </div>
                <li id="comment">评论管理</li>
            </ul>
        </nav>
    </jsp:attribute>
    <jsp:body>
        <div class="content">
            <jsp:doBody />
        </div>
    </jsp:body>

</template:main>