<%--
  Created by IntelliJ IDEA.
  User: 18319
  Date: 2020/6/8
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/head.jsp"%>
    <div class="right">
        <img class="wClock" src="${pageContext.request.contextPath}/statics/images/clock.jpg"/>
        <div class="wFont">
            <h2>${sessionScope.userSession.userName}</h2>
            <p>欢迎来到超市订单管理系统</p>
        </div>
    </div>
</section>

<%@ include file="common/foot.jsp"%>
