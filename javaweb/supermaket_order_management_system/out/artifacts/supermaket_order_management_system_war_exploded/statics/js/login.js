$(function () {
    $(".signup-btn").on("click", function () {
        $.ajax({
            type: "POST",
            url: "login.do",
            dataType: "text",
            data: {
                userCode: $(".txtb").get(0).value,
                userPassword: $(".txtb").get(1).value
            },
            success: function (data) {
                if (data == "Redirect") {
                    // 如果登录成功转移到系统主页面
                    window.location.href = "statics/jsp/frame.jsp"
                }else {
                    $(".error").text(data);
                }

            }
        })
    })
})