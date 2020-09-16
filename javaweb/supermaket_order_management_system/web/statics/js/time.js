window.onload = function() {
    Date.prototype.Format = function(formatStr) {
        var d = new Date();
        var str = formatStr;
        var Week = ['日', '一', '二', '三', '四', '五', '六'];

        // 年
        str = str.replace(/yyyy|YYYY/, d.getFullYear().toString());

        str = str.replace(/yy|YY/, (d.getFullYear() % 100) > 9 ?
            (d.getFullYear() % 100).toString() :
            '0' + (d.getFullYear() % 100));

        // 月
        str = str.replace(/MM/, d.getMonth() > 8 ?
            d.getMonth() + 1 : '0' + (d.getMonth() + 1));

        str = str.replace(/M/, d.getMonth() + 1);

        // 日
        str = str.replace(/dd|DD/, d.getDate() > 9 ? d.getDate() :
            '0' + d.getDate());

        str = str.replace(/d|D/, d.getDate());

        // 时
        str = str.replace(/hh|HH/, d.getHours() > 9 ? d.getHours() :
            '0' + d.getHours());

        str = str.replace(/h|H/, d.getHours());

        // 分
        str = str.replace(/mm/, d.getMinutes() > 9 ?
            d.getMinutes() : '0' + d.getMinutes());

        str = str.replace(/m/, d.getMinutes());

        // 秒
        str = str.replace(/ss|SS/, d.getSeconds() > 9 ?
            d.getSeconds() : '0' + d.getSeconds());

        str = str.replace(/s|S/, d.getSeconds());

        // 周几
        str = str.replace(/w|W/, Week[d.getDay()]);

        return str;
    }

    function realTime() {
        document.getElementById("time").innerText = Date.prototype.Format("yyyy年MM月dd日 hh:mm:ss 星期w");
    }
    realTime();
    setInterval(realTime, 1000);
}