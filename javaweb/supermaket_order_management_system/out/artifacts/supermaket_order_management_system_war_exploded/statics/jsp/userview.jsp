<%--
  Created by IntelliJ IDEA.
  User: 18319
  Date: 2020/6/17
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/head.jsp"%>

<div class="left main-window">
    <div class="current-location">
        <span></span>您现在所在的位置是:<span style="color: #25CCF7">用户信息查看页面</span>
    </div>
    <div class="user-view">
        <p><strong>用户编号:</strong><span>${user.userCode}</span></p>
        <p><strong>用户名称:</strong><span>${user.userName}</span></p>
        <p><strong>用户性别:</strong>
            <span>
                <c:if test="${user.gender == 1}">男</c:if>
                <c:if test="${user.gender == 2}">女</c:if>
            </span></p>
        <p><strong>出生日期:</strong><span>${user.birthday}</span></p>
        <p><strong>用户电话:</strong><span>${user.phone}</span></p>
        <p><strong>用户地址:</strong><span>${user.address}</span></p>
        <p><strong>用户角色:</strong><span>${user.userRoleName}</span></p>
        <p><strong>个人证件照:</strong><span>暂无</span></p>
        <p><strong>工作证照片:</strong><span>暂无</span></p>
        <a href="${pageContext.request.contextPath}/userList.do">返回</a>
    </div>
</div>



<%--head的文件的section--%>
</section>

<%@ include file="common/foot.jsp"%>
