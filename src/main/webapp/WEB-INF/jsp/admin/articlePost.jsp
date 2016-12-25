<%--@elvariable id="article" type="model.Article"--%>
<template:admin htmlTitle="admin">
    <style>
        #body-content {
            display: flex;
            display: -webkit-flex;
            flex-direction: column;
            align-items: flex-start;
            margin-left: 100px;
            margin-top: 30px;
            margin-bottom: 100px;
            font-size: 18px;
        }
        .article-information {
            width: 500px;
            height: 30px;
            font-size: 18px;
        }
        #article-input {
            width: 1000px;
            height: 500px;
            font-size: 18px;
        }
        #full-size {
            margin-left: 975px;
            cursor: pointer;
        }
        .input-submit {
            margin-top: 30px;
            margin-left: 380px;
        }
    </style>
    <script>
        function post(){
            alert("提交成功！")
        }
        function fullSize() {
            var content = document.getElementById("article-input").value;
            var idUrl = window.location.href.match("id=[0-9]+");
            window.location = window.location.origin + "/admin/article-post?editing&" + idUrl +
                "&article-content=" + content;
        }
    </script>
    <div id="body-content">
        <form method="post">

        </form>
        <form method="post">
            <label>
                文章标题: <input class="article-information" name="article-title"
                             type="text" value="${article.title}">
            </label><br><br>
            <label>
                文章类型: <input class="article-information" name="article-type"
                             type="text" value="${article.type}">
            </label><br><br>
            <label>
                文章标签: <input class="article-information" name="article-labels"
                             type="text" value="${article.labels}">
            </label><br><br>
            <img id="full-size" src="<c:url value="/resources/img/fullsize.png" />"
                onclick="fullSize()">
            <textarea name="article-content" id="article-input">${article.content}</textarea>
            <input class="input-submit" name="Submit" type="submit" onclick="post()">
        </form>
    </div>
</template:admin>