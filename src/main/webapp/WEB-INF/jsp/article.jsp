<%--@elvariable id="article" type="model.Article"--%>
<template:blog htmlTitle="Kn's Blog">
    <template:article article="${article}" articleContent="${article.htmlContent}">
    </template:article>
</template:blog>