<%--@elvariable id="articles" type="java.util.List<model.Article>"--%>
<template:blog htmlTitle="Kn's world">
    <script>
        function toArticle(id){
            window.location = window.location.href + "/article/" + id;
        }
    </script>
    <link rel="stylesheet"
          href="<c:url value="/resources/stylesheet/blog/article.css" />">
    <div class="body-content">
        <c:forEach items="${articles}" var="article">
            <h1 id="article-title" onclick="toArticle('${article.id}')">${article.title}</h1>
            <div id="article-information">
                发表于<fmt:formatDate value="${article.createdAt}" pattern="yyyy-MM-dd" />
                | 分类于 ${article.type}
            </div>
            <div id="article-content">${article.content}</div>
            <button id="read-all" onclick="toArticle('${article.id}')">阅读全文</button>
        </c:forEach>
    </div>
</template:blog>