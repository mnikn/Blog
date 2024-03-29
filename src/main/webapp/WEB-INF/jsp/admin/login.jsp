<%--@elvariable id="loginFailed" type="java.lang.Boolean"--%>
<template:base htmlTitle="login">
    <link rel="stylesheet"
          href="<c:url value="/resources/stylesheet/login.css" /> ">
    <header>后台博客管理系统登录</header>
    <form method="post" action="<c:url value="/login" />">
        <input name="username" type="text" placeholder="请输入用户名" title="用户名">
        <input name="password" type="password" placeholder="请输入密码" title="密码">
        <c:if test="${loginFailed}">
            <p class="error-hint">登录错误，请输入正确的用户名和密码！</p>
        </c:if>
        <input id="submit" name="submit" type="submit">
    </form>
</template:base>