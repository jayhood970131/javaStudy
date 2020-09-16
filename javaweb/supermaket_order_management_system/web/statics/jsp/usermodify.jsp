<%--
  Created by IntelliJ IDEA.
  User: 18319
  Date: 2020/6/17
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/head.jsp"%>

<div class="left main-window">
    <div class="current-location">
        <span></span>您现在所在的位置是:<span style="color: #25CCF7">用户信息修改页面</span>
    </div>
    <div class="user-modify">
        <div class="modify-info">
            <input type="hidden" id="id" value="${user.id}">
            <div>
                <label for="userName">用户编码:</label>
                <input type="text" value="${user.userCode}" readonly/>
            </div>
            <div>
                <label for="userName">用户姓名:</label>
                <input id="userName" type="text" value="${user.userName}"/>
            </div>
            <div>
                <label for="gender">用户性别:</label>
                <select id="gender" name="gender">
                    <c:choose>
                        <c:when test="${user.gender == 1}">
                            <option value="1" selected>男</option>
                            <option value="2">女</option>
                        </c:when>
                        <c:otherwise>
                            <option value="1">男</option>
                            <option value="2" selected>女</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
            <div>
                <label for="birthday">出生日期:</label>
                <input type="text" class="Wdate" id="birthday" name="birthday" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" />"
                readonly onclick="WdatePicker();"/>
            </div>
            <div>
                <label for="phone">用户手机:</label>
                <input type="text" id="phone" name="phone" value="${user.phone}"/>
            </div>
            <div>
                <label for="address">用户地址:</label>
                <input type="text" name="address" id="address" value="${user.address}">
            </div>
            <div>
                <input type="hidden" id="userRole" value="${user.userRole}"></input>
                <label>用户角色:</label>
                <select name="userRole" id="userRoleName"></select>
            </div>
            <div>
                <button id="saveBtn">保存</button>
                <button id="backBtn">返回</button>
            </div>
        </div>
    </div>
</div>



<%--head的文件的section--%>
</section>

<%@ include file="common/foot.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/userview.js"></script>
