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
        .input-submit {
            margin-top: 30px;
            margin-left: 380px;
        }
    </style>
    <script>
        function post(){
            alert("提交成功！")
        }
    </script>
    <div id="body-content">
        <form method="post">
            <label>
                文章标题: <input class="article-information" name="article-title" type="text">
            </label><br><br>
            <label>
                文章类型: <input class="article-information" name="article-type" type="text">
            </label><br><br>
            <label>
                文章标签: <input class="article-information" name="article-labels" type="text">
            </label><br><br>
            <textarea name="article-content" id="article-input"></textarea>
            <input class="input-submit" name="Submit" type="submit" onclick="post()">
        </form>
    </div>
</template:admin>