<%--@elvariable id="articles" type="java.util.List<model.Article>"--%>
<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes"
        trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ attribute name="article" type="model.Article" required="true" %>
<%@ attribute name="articleContent" type="java.lang.String" required="true" %>
<%@ include file="/WEB-INF/jsp/base.jsp" %>
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
        margin-left: 1vw;
        margin-bottom: 1vh;
        color: #171717;
        font-size: 0.8rem;
    }
    #article-content {
        margin-top: 5vh;
    }
</style>
<script>
    function detail(id){
        window.location = window.location.origin + "/article/" + id;
    }
</script>
<article>
    <h2 style="cursor: pointer" onclick="detail('${article.id}')">${article.title}</h2>
    <div class="article-information">
        <aside id="article-type">分类于：${article.type}</aside>
        <aside id="article-time">时间：${article.createdAt}</aside>
    </div>
    <div id="article-content">${articleContent}</div>
    <jsp:doBody />
</article>
