<%--@elvariable id="articleContent" type="java.lang.String"--%>
<template:main htmlTitle="edit">
    <style>
        * {
            font-size: 20px;
        }
        #body-content {
            display: flex;
            display: -webkit-flex;
            height: 100vh;
        }
        #article-content,#article-show {
            padding: 20px;
            flex: 1;
        }
        #article-content {
            border: none;
            resize: none;
            border-right:1px solid #1e1d22;
        }
        #full-size {
            height: 32px;
            cursor: pointer;
            margin-left: 650px;
            background: image("/resources/img/fullsize.png");
        }
    </style>
    <div id="body-content">
        <textarea id="article-content" name="article-content" form="form-content">${articleContent}</textarea>
        <div id="article-show">
            <form id="form-content" method="post"
                  action="<c:url value="/admin/article-post?edited" />">
                <input type="submit" name="Submit" id="full-size">
                <%--<img id="full-size" src="/resources/img/fullsize.png" onclick="back()" />--%>
            </form>
        </div>
    </div>
</template:main>