<%--@elvariable id="articles" type="java.util.List<model.Article>"--%>
<template:admin htmlTitle="admin">
    <style>
        table {
            width: 1000px;
            margin: 50px;
            border-collapse:collapse;
        }
        table th ,table td{
            background-color: white;
            border:1px solid #cecece;
            padding: 3px;
        }
        table th {
            background-color: #434343;
            color: White;
        }
    </style>
    <table>
        <tr>
            <th>id</th>
            <th>标题</th>
            <th>分类</th>
            <th>标签</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.id}</td>
                <td>${article.title}</td>
                <td>${article.type}</td>
                <td>${article.labels}</td>
                <td>
                    <a href="<c:url value="/admin/article-post?id=${article.id}" /> ">
                        编辑
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

</template:admin>