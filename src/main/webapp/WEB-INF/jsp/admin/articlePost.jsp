<%--@elvariable id="types" type="java.util.Set<java.lang.String>"--%>
<%--@elvariable id="labels" type="java.util.Set<java.lang.String>"--%>
<template:admin htmlTitle="admin">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
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
        textarea {
            margin-top: 3vh;
            height: 50vh;
        }
    </style>
    <script>
        function changeTypeText(type){
            document.getElementById("article-type").value = type;
        }
        function changeLabelText(label){
            var input = document.getElementById("article-labels");
            if(input.value.indexOf(label) != -1){
                input.value = input.value.replace(label + ",","");
            }
            else{
                input.value = input.value + label + ",";
            }
        }
    </script>


    <form method="post">
        <label>
            文章标题：<input type="text" name="article-title">
        </label>
        <label>
            文章分类：<input type="text" name="article-type" id="article-type">
            <input type="button" id="type-button" value="选择">
        </label>
        <label>
            文章标签：<input type="text" name="article-labels" id="article-labels">
            <input type="button" id="label-button" value="选择">
        </label>
        <textarea name="article-content"></textarea>
        <input type="submit" name="Submit">
    </form>


    <div id="dialog-type" title="分类">
        <c:forEach items="${types}" var="type">
            <label>${type}
                <input type="radio" name="type" value="${type}"
                       onchange="changeTypeText('${type}')">
            </label>
        </c:forEach>
    </div>
    <div id="dialog-label" title="标签">
        <c:forEach items="${labels}" var="label">
            <label>${label}
                <input type="checkbox" name="label" value="${label}"
                       onchange="changeLabelText('${label}')">
            </label>
        </c:forEach>
    </div>
    <script>
        $("#dialog-type").dialog({
            autoOpen: false,
            modal: true
        });
        $("#dialog-label").dialog({
            autoOpen: false,
            modal: true
        });

        $("#type-button").click(function(){
            $("#dialog-type").dialog("open");
        });
        $("#label-button").click(function(){
            $("#dialog-label").dialog("open");
        });
    </script>

</template:admin>
