<template:base htmlTitle="error">
    <style>
        body {
            padding: -4px;
            margin: -4px;
            display: flex;
            display: -webkit-flex;
            flex-direction: column;
            align-items: center;
        }
        header {
            height: 10vh;
            width: 100vw;
            background-color: #414c55;
        }
    </style>
    <header></header>
    <img src="<c:url value="/resources/img/404.png"/>" />
    <h1>你进了不该进的地方了</h1>
    <span>现在出去还来得及.....</span>
    <a href="http://localhost:8080/" >首页</a>

</template:base>
