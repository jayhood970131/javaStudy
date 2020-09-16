<%--
  Created by IntelliJ IDEA.
  User: 18319
  Date: 2020/6/11
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录信息过期</title>
    <meta charset="UTF-8">
</head>
<body>
<h1 style="color: #eb3b5a;">登录信息过期.....<span id="time"></span>秒后返回登录特面</h1>
<a href="login.jsp">点击返回登录页面</a>
<script type="text/javascript">

    function timeout() {
        window.location.href = "${pageContext.request.contextPath}/login.jsp";
    }

    function time() {
        --time1;
        document.getElementById("time").innerText = time1;
    }
    var time1 = 5;
    document.getElementById("time").innerText = time1;
    setInterval(time, 1000);
    setTimeout(timeout, 5000);
</script>
</body>
</html>
