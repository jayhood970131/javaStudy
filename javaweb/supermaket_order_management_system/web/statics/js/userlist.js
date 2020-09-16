var $userObj;
$(function () {
    $(".viewUser").on('click',function () {
        let $obj = $(this);
        window.location.href = "/smoms/userView.do?userId=" + $obj.attr("data-userId");
    });
    $(".modifyUser").on('click',function () {
        let $obj = $(this);
        window.location.href = "/smoms/userInfo.do?userId=" + $obj.attr("data-userId");
    });
    $(".deleteUser").on('click',function () {
        $userObj = $(this);
        setContent("Are you sure to delete user[" + $userObj.attr("data-userName") + "]?");
        openRemoveWindow();
    });
    $("#yes").on('click',function () {
        deleteUser($userObj);
    });
    $("#no").on('click',function () {
        closeRemoveWindow();
    })
})

// 改变弹出提示框的内容
function setContent(str) {
    let $p = $(".remove-main").find("p");
    $p.html(str);
}

// 弹出提示框
function openRemoveWindow() {
    $(".mask").css("display","block");
    $("#removeUse").fadeIn();
}

// 关闭提示窗
function closeRemoveWindow() {
    $(".mask").css("display","none");
    $("#removeUse").fadeOut();
}

function deleteUser($userObj) {
    $.ajax({
        url: "userDel.do",
        type: "GET",
        dataType: "json",
        data: {
            userId: $userObj.attr("data-userId")
        },
        success: function (data) {
            if (data.delResult == "true"){
                closeRemoveWindow();
                $userObj.parents("tr").detach();
            }else if (data.delResult == "false"){
                setContent("sorry,fail deleting [" + $userObj.attr("data-userName") + "]");
            }else if (data.delResult == "notExist"){
                setContent("sorry,user [" + $userObj.attr("data-userName") + "] not exist");
            }
        },
        error: function (data) {
            setContent("fail deleting!");
        }
    })
}