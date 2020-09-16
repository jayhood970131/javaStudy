<%--
  Created by IntelliJ IDEA.
  User: 18319
  Date: 2020/6/10
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="common/head.jsp"%>
<div class="left main-window">
    <div class="current-location">
        <span></span>您现在所在的位置是:<span style="color: #25CCF7">用户管理页面</span>
    </div>
    <div class="search">
        <form method="post" action="${pageContext.request.contextPath}/userList.do">
            <label>用户名:</label>
            <input name="queryUserName" class="input-text" type="text" value="${userName}"/>
            <label>用户角色:</label>
            <select name="queryUserRole">
                <c:if test="${roleList != null}">
                    <option value="">---请选择---</option>
                    <c:forEach var="role" items="${roleList}">
                        <option value="${role.id}" <c:if test="${role.id == userRole}">selected</c:if>>${role.roleName}</option>
                    </c:forEach>
                </c:if>
            </select>
            <input type="hidden" name="pageIndex"/>
            <input type="submit" class="btn-search" value="查 询"/>
            <a href="">添加用户</a>
        </form>
    </div>
    <%--  用户  --%>
    <table class="userTable" cellpadding="0" cellspacing="0">
        <thead>
            <tr class="firstTr">
                <th width="10%">用户编码</th>
                <th width="20%">用户名称</th>
                <th width="10%">性别</th>
                <th width="10%">年龄</th>
                <th width="10%">电话</th>
                <th width="10%">用户角色</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>
                        <span>${user.userCode}</span>
                    </td>
                    <td>
                        <span>${user.userName}</span>
                    </td>
                    <td>
                        <span>
                            <c:if test="${user.gender == 1}">男</c:if>
                            <c:if test="${user.gender == 2}">女</c:if>
                        </span>
                    </td>
                    <td>
                        <span>${user.age}</span>
                    </td>
                    <td>
                        <span>${user.phone}</span>
                    </td>
                    <td>
                        <span>${user.userRoleName}</span>
                    </td>
                    <td>
                        <span><a class="viewUser" href="javascript:;" data-userId="${user.id}" data-userName="${user.userName}"><img src="${pageContext.request.contextPath}/statics/images/read.png" alt="查看"/></a></span>
                        <span><a class="modifyUser" href="javascript:;" data-userId="${user.id}" data-userName="${user.userName}"><img src="${pageContext.request.contextPath}/statics/images/xiugai.png" alt="修改"/></a></span>
                        <span><a class="deleteUser" href="javascript:;" data-userId="${user.id}" data-userName="${user.userName}"><img src="${pageContext.request.contextPath}/statics/images/schu.png" alt="删除"></a></span>
                    </td>
                </tr>
            </c:forEach>
        </thead>
    </table>
    <input type="hidden" value="${totalPageCount}" id="totalPageCount"/>
    <c:import url="rollpage.jsp">
        <c:param name="totalCount" value="${totalCount}"></c:param>
        <c:param name="currentPageNo" value="${currentPageNo}"></c:param>
        <c:param name="totalPageCount" value="${totalPageCount}"></c:param>
    </c:import>
</div>
</section>

<%--点击删除按钮后弹出的页面--%>
<div class="mask"></div>
<div class="remove" id="removeUse">
    <div class="remove-child">
        <h2>提示</h2>
        <div class="remove-main">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@ include file="common/foot.jsp"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/userlist.js"></script>