// 给每个input添加focus事件，当为空时显示tips，不为空时判断是否满足密码规则
$(".pwd input").on('focus', function() {
    $(this).next().text("仅支持6-15位大小写字母，数字，下划线，英文句号，美元符号");
    var str = $(this).val();

    if (validate(str)) {

        $(this).next().css("color","#05c46b");
    }else {

        $(this).next().css("color","#ff3f34");
    }

})
// 判断密码是否满足规则
function validate(str) {
    return /^[a-z0-9_$.]{6,15}$/i.test(str);
}
// input输入框实时变动时判断密码是否满足规则
$(".pwd input").on('input', function () {
        const str = $(this).val();
        if (str.length != 0){
            if (validate(str)){
                $(this).next().css("color","#05c46b");
            }
            else {
                $(this).next().css("color","#ff3f34");
            }
        }
})
function PasswordValidate(){
    var flag = true;
    // 1.检查input是否有空值,再判断是否满足密码规则
    $(".pwd input").each(function () {
        const str = $(this).val();

        if (str.length != 0){
            if (!validate(str)){
                $(this).next().text("仅支持6-15位大小写字母，数字，下划线，英文句号，美元符号");
                $(this).next().css("color","#ff3f34");
                flag = false;
            }
        }else {
            $(this).next().text("不能为空");
            $(this).next().css("color","#ff3f34");
            flag =false;
        }
    })

    return flag;
}
// 先判断input是否为空，再是否满足密码规则，然后判断新密码二连击是否吻合，最后旧密码
$(".btn-save").on('click', function () {
    if (PasswordValidate()) {
        // 判断新密码和再次确认密码是否一致
        var newPassword = $("#new-pwd").val();
        var confirmPassword = $("#confirm-pwd").val();
        if (newPassword.length !=0 && confirmPassword.length !=0 && newPassword === confirmPassword){
            $.ajax({
                url: "../../pwdModify.do",
                method: "post",
                dataType: "json",
                data: {
                    oldPassword: $("#old-pwd").val(),
                    newPassword: $("#new-pwd").val()
                },
                success: function (data) {
                    if (data.result == "different"){
                        $(".info").text("密码错误");
                        $(".info").css("color","#ff3f34");
                    }else if (data.result == "same"){
                        $(".info").text("新旧密码不能一样");
                        $(".info").css("color","#ff3f34");
                    } else if (data.result == "success"){
                        $(".info").text("密码修改成功");
                        $(".info").css("color","#05c46b");
                    } else {
                        $(".info").text("密码修改失败,请重试");
                        $(".info").css("color","#ff3f34");
                    }
                },
                error: function (error) {
                    console.log(error);
                }
            })
        } else {    // 不一致
            $(".info").text("新密码和确认密码不一致");
            $(".info").css("color","#ff3f34");
        }
    }

})







