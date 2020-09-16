<%--
  Created by IntelliJ IDEA.
  User: 18319
  Date: 2020/6/10
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/head.jsp"%>
<div class="right main-window">
    <div class="current-location">
        <span></span>您现在所在的位置是:<span style="color: #25CCF7">密码修改页面</span>
    </div>
    <div class="pwd">
        <div class="info"></div>
        <div>
            <label for="old-pwd">旧密码:</label>
            <input type="password" id="old-pwd" name="oldPassword" />
            <em></em>
        </div>
        <div>
            <label for="new-pwd">新密码:</label>
            <input type="password" id="new-pwd" name="newPassword" />
            <em></em>
        </div>
        <div>
            <label for="confirm-pwd">确认密码:</label>
            <input type="password" id="confirm-pwd" name="confirmPassword" />
            <em></em>
        </div>
        <button class="btn-save">保存</button>
    </div>
</div>
</section>
<%@ include file="common/foot.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/pwdmodify.js"></script>
