<%--@elvariable id="articles" type="java.util.List<model.Article>"--%>
<template:admin htmlTitle="list">
    <style>
        table {
            width: 100%;
            border-collapse:collapse;
        }
        table th ,table td{
            border:1px solid #cecece;
            padding: 3px 0 3px 3px;
        }
        table th {
            background-color: #434343;
            color: White;
        }
    </style>
    <table>
        <tr>
            <th>id</th>
            <th>文章标题</th>
            <th>文章分类</th>
            <th>文章标签</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td align="center">${article.id}</td>
                <td align="center">${article.title}</td>
                <td align="center">${article.type}</td>
                <td align="center">
                    <c:forEach items="${article.labels}" var="label" varStatus="status">
                        <c:choose>
                            <c:when test="${status.last}">
                                ${label}
                            </c:when>
                            <c:otherwise>
                                ${label},
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </td>
                <td align="center">
                    <a href="<c:url value="/admin/article/post?id=${article.id}"/>">编辑</a>,
                    <a href="<c:url value="/admin/article/list?delete_id=${article.id}"/>">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</template:admin>