<%--@elvariable id="articles" type="java.util.List<model.Article>"--%>
<template:blog htmlTitle="Kn's Blog">
    <style>
        article {
            display: flex;
            display: -webkit-flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 5vh;
        }
        .article-information * {
            display: flex;
            display: -webkit-flex;
            margin-left: 5vw;
            margin-bottom: 1vh;
            color: #171717;
            font-size: 0.8rem;
            cursor: pointer;
        }
    </style>
    <c:forEach items="${articles}" var="article">
        <article>
            <h2>${article.title}</h2>
            <div class="article-information">
                <aside id="article-type">分类于：${article.type}</>
                <aside id="article-time">时间：${article.createdAt}</aside>
            </div>
            <div id="article-intro">${article.intro}</div>
            <button>继续阅读</button>
        </article><hr>
    </c:forEach>
</template:blog>