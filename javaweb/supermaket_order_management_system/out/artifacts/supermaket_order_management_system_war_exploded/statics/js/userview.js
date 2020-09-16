var $userRoleName = null;

$(function () {
    $userRoleName = $("#userRoleName");
    $("#backBtn").on('click',function () {
        window.location.href = "/smoms/userList.do";
    })
    $.ajax({
        type: "get",
        url: "roleList.do",
        dataType: "json",
        success: function (data) {
            var $userRole = $("#userRole");
            $userRoleName.html("");
            var options = "<option value=''>please choose</option>";
            for (var i = 0; i< data.length; i++){
                if (data[i].id == $userRole.val()){
                    options += "<option selected value='" + data[i].id + "'>" + data[i].roleName +"</option>";
                }else {
                    options += "<option value='" + data[i].id + "'>" + data[i].roleName +"</option>";
                }
            }
            $userRoleName.html(options);
        }
    })
    $("#saveBtn").on('click',function () {

    })
})