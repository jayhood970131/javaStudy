<%@ page import="com.jayhood.utils.Constant" %><%--
  Created by IntelliJ IDEA.
  User: 18319
  Date: 2020/6/9
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录-超市订单管理系统</title>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="statics/css/base.css">
    <link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/login.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/login.js"></script>

</head>
<body class="body-login">
  <div class="form-login">
      <h1>Supermarket Order Management System</h1>
      <p class="error"></p>
      <input type="text" placeholder="Full Name"  name="userCode" class="txtb" />
      <input type="password" placeholder="Password"  name="userPassword" class="txtb"/>
      <input type="submit" value="Login" class="signup-btn">
  </div>
</body>
</html>
