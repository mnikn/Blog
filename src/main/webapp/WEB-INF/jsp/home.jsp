<%--@elvariable id="articles" type="java.util.List<model.Article>"--%>
<template:blog htmlTitle="Kn's Blog">
    <c:forEach items="${articles}" var="article">
        <template:article article="${article}" articleContent="${article.intro}">
            <button onclick="detail('${article.id}')">继续阅读</button>
        </template:article><hr>
    </c:forEach>
</template:blog>