<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html style="height: 100%">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <jsp:include page="/html/default/pub.jsp" />
    <script type="text/javascript" src="/js/echarts/echarts.min.js" charset='utf-8'></script>
</head>
<body style="height: 100%; margin: 0">
<div id="container" style="height: 100%"></div>
<script type="text/javascript">
    var userId = "${user.userId}";
    //柱状图
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '折柱混合';
    var monthNoArray = new Array(); //月份编号
    var workTimeSumArray = new Array(); //月份工作时长
    var overWorkSumArray = new Array();  //月份加班时长

    var Xindex = 0;

    var monthDateArray = new Array(); //日编号
    var workHourArray = new Array(); //日工作时长
    var overWorkArray = new Array(); //日加班时长

    var date = new Date;
    var yearMonth = date.getFullYear() + '-' + date.getMonth();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;

    // 首页初始化调用获取当年12月份的概要统计
    getWorkTimeAtYear();

    function getWorkTimeAtYear() {
        var params = "userId=" + userId;
        $.ajax({
            url: "/daily/getWorkTimeAtYear",
            data: params,
            type: "POST",
            success: function (result) {
                if(result.code == "100"){
                    var pros = result.extend.workTimeYearList.list;
                    $.each(pros, function (index, item) {
                        monthNoArray.push(item.monthNo);
                        workTimeSumArray.push(item.workTimeSum);
                        overWorkSumArray.push(item.overWorkSum);
                    });
                    optionYearArray(year, monthNoArray, workTimeSumArray, overWorkSumArray);
                    return;
                } else {
                    optionYearArray(year, monthNoArray, workTimeSumArray, overWorkSumArray);
                    return;
                }
            }
        });
    }
    // 生成12月份的概要统计数据表格柱状图
    function optionYearArray(year, monthNoArray, workTimeSumArray, overWorkSumArray) {
        option = {
            title: {
                text: year + '年出勤统计表'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    crossStyle: {
                        color: '#999'
                    }
                }
            },
            toolbox: {
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            legend: {
                data:['上班时长','加班时长']
            },
            xAxis: [
                {
                    type: 'category',
                    name: '月',
                    //data: ['1','2','3','4','5','6','7','8','9','10','11','12'],
                    data:monthNoArray,
                    axisPointer: {
                        type: 'shadow'
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '小时',
                    interval: 10,
                    axisLabel: {
                        formatter: '{value}',
                        fontSize:9
                    }
                }
            ],
            series: [
                {
                    name:'上班时长',
                    type:'bar',
                    //data:[10,12,9,10,11,12,10,9,9,12,13,13,10,12,12,13,9,8,9,10,11,11,12,12,12,13,12,11,10,9]
                    data:workTimeSumArray
                },
                {
                    name:'加班时长',
                    type:'bar',
                    //data:[2,3,1,1,1.80,7.5,3,2,3,1,3,4,1,1,2,2,3,1,2,3,1,3,2,2,3,3,3,1,1,1]
                    data:overWorkSumArray
                }
            ]
        };
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
            // 使用刚指定的配置项和数据显示图表。
            // 处理点击事件并且跳转到相应的百度搜索页面
            myChart.on('click', function (params) {
                //window.open('https://www.baidu.com/s?wd=' + encodeURIComponent(params.name));
                getWorkTimeAtMonth(year + "-" + encodeURIComponent(params.name), encodeURIComponent(params.name));
                //console.log("单击了"+params.name+"柱状图");
            });
        }
    }

    // 点击不同月份调用月份详情上班、加班信息
    function getWorkTimeAtMonth(monthParam, monthNo) {
        var params = "userId=" + userId + "&yearMonth=" + monthParam;
        $.ajax({
            url: "/daily/getWorkTimeAtMonth",
            data: params,
            type: "POST",
            success: function (result) {
                if(result.code == "100"){
                    var pros = result.extend.workTimeMonthList.list;
                    $.each(pros, function (index, item) {
                        monthDateArray.push(item.monthDate);
                        workHourArray.push(item.workHour);
                        overWorkArray.push(item.overWork);
                        optionMonthArray(monthNo, monthDateArray, workHourArray, overWorkArray);
                    });
                    return;
                } else {
                    optionMonthArray(monthNo, monthDateArray, workHourArray, overWorkArray);
                    return;
                }
            }
        });
    }

    // 生成12月份的概要统计数据表格柱状图
    function optionMonthArray(monthNo, monthDateArray, workHourArray, overWorkArray) {
        option = {
            title: {
                text: monthNo + '月份出勤统计表'
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross',
                    crossStyle: {
                        color: '#999'
                    }
                }
            },
            toolbox: {
                feature: {
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            legend: {
                data:['上班时长','加班时长']
            },
            xAxis: [
                {
                    type: 'category',
                    name: '日',
                    //data: ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30'],
                    data:monthDateArray,
                    axisPointer: {
                        type: 'shadow'
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '小时',
                    interval: 1,
                    axisLabel: {
                        formatter: '{value}',
                        fontSize:9
                    }
                }
            ],
            series: [
                {
                    name:'上班时长',
                    type:'bar',
                    //data:[10,12,9,10,11,12,10,9,9,12,13,13,10,12,12,13,9,8,9,10,11,11,12,12,12,13,12,11,10,9]
                    data:workHourArray
                },
                {
                    name:'加班时长',
                    type:'bar',
                    //data:[2,3,1,1,1.80,7.5,3,2,3,1,3,4,1,1,2,2,3,1,2,3,1,3,2,2,3,3,3,1,1,1]
                    data:overWorkArray
                }
            ]
        };
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    }
</script>
</body>
</html>