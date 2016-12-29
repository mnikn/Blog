<%--@elvariable id="types" type="java.util.Set<java.lang.String>"--%>
<template:admin htmlTitle="admin">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/1.11.2/simplemde.min.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdn.jsdelivr.net/simplemde/1.11.2/simplemde.min.js"></script>
    <style>
        form {
            display: flex;
            display: -webkit-flex;
            flex-direction: column;
        }
        input {
            width: 40vw;
            height: 4vh;
            margin-top: 3vh;
        }
        input[type=submit] {
            align-self: center;
        }
    </style>


    <form method="post">
        <label>
            文章标题：<input type="text" name="article-title">
        </label>
        <label>
            文章分类：<input type="text" name="article-type">
            <input type="button" id="type-button" value="选择">
        </label>
        <label>
            文章标签：<input type="text" name="article-labels">
            <input type="button" id="label-button" value="选择">
        </label>
        <div class="CodeMirror-scrollbar-filler" id="editor"></div>
        <input type="submit" name="Submit">
    </form>


    <div id="dialog-type" title="分类">
        <c:forEach items="${types}" var="type">
            <label>${type}<input type="radio" name="type" value="${type}"></label>
        </c:forEach>
    </div>
    <script>
        $("#dialog-type").dialog({
            autoOpen: false,
            modal: true
        });
        $("#type-button").click(function(){
            $("#dialog-type").dialog("open");
        })
    </script>

</template:admin>
