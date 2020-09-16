function page_nav(frm,num) {
    frm.pageIndex.value = num;
    frm.submit();

}

function jump_to(frm,num) {
    var regexp = /^[1-9]\d*$/;
    var totalPageCount = document.getElementById("totalPageCount").value;
    if (!regexp.test(num)){
        alert("please input number > 0")
        return false;
    }else if ((num-totalPageCount) > 0){
        alert("please input number <= totalPageCount");
        return false;
    }else {
        page_nav(frm,num);
    }
}