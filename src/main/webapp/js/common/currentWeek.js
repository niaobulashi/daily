//获取当前日期yy-mm-dd
//date 为时间对象
function getDateStr3(date) {
    var year = "";
    var month = "";
    var day = "";
    var now = date;
    year = ""+now.getFullYear();
    if((now.getMonth()+1)<10){
        month = "0"+(now.getMonth()+1);
    }else{
        month = ""+(now.getMonth()+1);
    }
    if((now.getDate())<10){
        day = "0"+(now.getDate());
    }else{
        day = ""+(now.getDate());
    }
    return year+"-"+month+"-"+day;
}
/**
 * 获得相对当前周AddWeekCount个周的起止日期
 * AddWeekCount为0代表当前周   为-1代表上一个周   为1代表下一个周以此类推
 * **/
function getWeekStartAndEnd(AddWeekCount) {
    //起止日期数组
    var startStop;
    //一天的毫秒数
    var millisecond = 1000 * 60 * 60 * 24;
    //获取当前时间
    var currentDate = new Date();
    //相对于当前日期AddWeekCount个周的日期
    currentDate = new Date(currentDate.getTime() + (millisecond * 7*AddWeekCount));
    //返回date是一周中的某一天
    var week = currentDate.getDay();
    //返回date是一个月中的某一天
    var month = currentDate.getDate();
    //减去的天数
    var minusDay = week != 0 ? week - 1 : 6;
    //获得当前周的第一天
    var currentWeekFirstDay = new Date(currentDate.getTime() - (millisecond * minusDay));
    //获得当前周的最后一天
    var currentWeekLastDay = new Date(currentWeekFirstDay.getTime() + (millisecond * 6));
    //添加至数组
    // startStop.push(getDateStr3(currentWeekFirstDay));
    // startStop.push(getDateStr3(currentWeekLastDay));

    startStop = getDateStr3(currentWeekFirstDay) + ' - ' + getDateStr3(currentWeekLastDay);

    return startStop;
}
/**
 * 获得相对当月AddMonthCount个月的起止日期
 * AddMonthCount为0 代表当月 为-1代表上一个月  为1代表下一个月 以此类推
 * ***/
function getMonthStartAndEnd(AddMonthCount) {
    //起止日期数组
    var startStop = new Array();
    //获取当前时间
    var currentDate = new Date();
    var month=currentDate.getMonth()+AddMonthCount;
    if(month<0){
        var n = parseInt((-month)/12);
        month += n*12;
        currentDate.setFullYear(currentDate.getFullYear()-n);
    }
    currentDate = new Date(currentDate.setMonth(month));
    //获得当前月份0-11
    var currentMonth = currentDate.getMonth();
    //获得当前年份4位年
    var currentYear = currentDate.getFullYear();
    //获得上一个月的第一天
    var currentMonthFirstDay = new Date(currentYear, currentMonth,1);
    //获得上一月的最后一天
    var currentMonthLastDay = new Date(currentYear, currentMonth+1, 0);
    //添加至数组
    startStop.push(getDateStr3(currentMonthFirstDay));
    startStop.push(getDateStr3(currentMonthLastDay));
    //返回
    return startStop;
}