<template:admin htmlTitle="admin">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/1.11.2/simplemde.min.css">
    <script src="https://cdn.jsdelivr.net/simplemde/1.11.2/simplemde.min.js">
        var simplemde = new SimpleMDE({ element: document.getElementById("editor") });
    </script>
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
    <form>
        <label>
            文章标题：<input type="text" name="article-title">
        </label>
        <label>
            文章分类：<input type="text" name="article-type">
            <button>选择</button>
        </label>
        <label>
            文章标签：<input type="text" name="article-labels">
            <button>选择</button>
        </label>
        <div class="CodeMirror-scrollbar-filler" id="editor"></div>
        <input type="submit" name="Submit">
    </form>
</template:admin>
