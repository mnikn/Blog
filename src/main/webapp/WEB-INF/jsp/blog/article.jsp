<%--@elvariable id="article" type="model.Article"--%>
<template:blog htmlTitle="${article.title}">
    <link rel="stylesheet"
          href="<c:url value="/resources/stylesheet/blog/article.css" />">
    <div class="body-content">
        <h1 id="article-title">${article.title}</h1>
        <div id="article-information">
            发表于<fmt:formatDate value="${article.createdAt}" pattern="yyyy-MM-dd" />
            | 分类于 ${article.type}
        </div>
        <div id="article-content">${article.content}</div>
    </div>
</template:blog>