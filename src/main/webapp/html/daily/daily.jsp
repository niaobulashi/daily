<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>日报列表</title>
    <jsp:include page="/html/default/pub.jsp" />
    <link href="/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 日报添加的模态框 -->
<div class="modal fade" id="proAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content" style="z-index: 19896; width: 700px; height: 500px; top: -24px; left: -107px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">日报添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="layui-form-label" style="width: 100px">日报日期</label>
                        <div class="col-sm-3">
                            <input type="text"
                                   name="dailyDateStr"
                                   id="dailyDateStr"
                                   readonly
                                   class="form-control"
                                   placeholder="请选择日期"
                                   lay-verify="date" autocomplete="off" class="layui-input"
                                   style="background-color: #bebebe;">
                        </div>
                        <label class="layui-form-label">项目组</label>
                        <div class="col-sm-5">
                            <select class="form-control" name="projectName" id="projectName">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="layui-form-label" style="width: 100px">工作类型</label>
                        <div class="col-sm-5">
                            <select name="workType" id="workType_add_select" class="form-control">
                                <option value="">请选择工作类型</option>
                                <option value="01">需求分析</option>
                                <option value="02">设计</option>
                                <option value="03">开发</option>
                                <option value="04">测试</option>
                                <option value="05">版本发布</option>
                                <option value="06">运维支持</option>
                                <option value="07">会议</option>
                                <option value="08">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="layui-form-label" style="width: 100px">日报内容</label>
                        <div class="col-sm-7">
                            <input type="text" name="dailyContent" id="dailyContent_add_input" class="form-control" style="width: 517px">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="layui-form-label" style="width: 100px">完成百分比</label>
                        <div class="col-sm-2">
                            <input type="text" name="dailyPercent"
                                   class="form-control"
                                   id="dailyPercent_add_input"
                                   onblur="checkGreaterHunderd()"
                                   min="0" max="100" maxlength="3"
                                   onkeyup="value=value.replace(/[^0-9]/g,'')"
                                   onpaste="value=value.replace(/[^0-9]/g,'')"
                                   oncontextmenu = "value=value.replace(/[^0-9]/g,'')">
                        </div>
                        <label class="layui-form-label" style="width: 100px">计划完成</label>
                        <div class="col-sm-4">
                            <input type="text" id="doneDate" name="doneDateStr" class="form-control" lay-verify="date" placeholder="计划完成时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="layui-form-label" style="width: 100px">工作疑问</label>
                        <div class="col-sm-7">
                            <input type="text" name="problem" id="problem_add_input" class="form-control" style="width: 517px">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="layui-form-label" style="width: 100px">下周计划</label>
                        <div class="col-sm-7">
                            <input type="text" name="nextWorkPlan" id="nextWorkPlan_add_input" class="form-control" style="width: 517px">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="daily_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<!-- 搭建显示页面 -->
<div style="width: 100%;">
    <div class="demoTable">
        <form id="weeklyExport" method="get" enctype="multipart/form-data" action="/daily/weeklyExport" style="float: left">
            日报日期：
            <div class="layui-inline">
                <input type="text" name="dailyStartDateStr" class="form-control" placeholder="日报开始日期"
                       id="dailyStartDateStr">
            </div>
            <div class="layui-inline">
                <span>-</span>
            </div>
            <div class="layui-inline">
                <input type="text" name="dailyEndDateStr" class="form-control" placeholder="日报结束日期"
                       id="dailyEndDateStr">
            </div>
            <button class="btn btn-warning" id="weeklyExport_btn">导出周报</button>
        </form>
        <div class="layui-inline" style="float: left; margin-left: 30px">
            <button class="btn btn-primary" id="add_daily_btn">新增</button>
        </div>
    </div>
    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="pros_table">
                <thead>
                <tr>
                    <th>日报日期</th>
                    <th>星期</th>
                    <th>项目组</th>
                    <th>创建日期</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>

    <!-- 显示分页信息 -->
    <div class="row">
        <!--分页文字信息  -->
        <div class="col-md-6" id="page_info_area"></div>
        <!-- 分页条信息 -->
        <div class="col-md-6" id="page_nav_area">
        </div>
    </div>
</div>
<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //常规用法
        laydate.render({
            elem: '#dailyStartDateStr'
            ,theme: 'grid'
        });
        laydate.render({
            elem: '#dailyEndDateStr'
            ,theme: 'grid'
        });
        laydate.render({
            elem: '#doneDate'
            ,theme: 'grid'
        });
    });
    layer = layui.layer //弹层
    var userId = "${user.userId}";
    var totalRecord, currentPage;
    //获取当前用户的权限列表
    var privilegeList = ${user.privilegeList};
    //根据权限列表判断是否显示
    if (privilegeList.indexOf(21) == -1) {
        $("#add_daily_btn").hide();
    }
    if (privilegeList.indexOf(32) == -1) {
        $("#weeklyExport_btn").hide();
    }
    //1、页面加载完成以后，直接去发送ajax请求,要到分页数据
    $(function () {
        //去首页
        to_page(1);
    });

    function to_page(pn) {
        var index = layer.msg('拼命加载中', {
            icon: 16
            ,shade: 0.01
        });
        $.ajax({
            url: "/daily/getDailyList",
            data: {"userId": userId, "pn": pn},
            type: "POST",
            success: function (result) {
                //1、解析并显示项目数据
                build_pros_table(result);
                //2、解析并显示项目信息
                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);
                layer.close(index);
            }
        });
    }

    function build_pros_table(result) {
        //清空table表格
        $("#pros_table tbody").empty();
        var pros = result.extend.pageInfo.list;
        $.each(pros, function (index, item) {
            var dailyDate = $("<td></td>").append(item.dailyDate == null ? "" : new Date(item.dailyDate).Format("yyyy-MM-dd"));
            var week = $("<td></td>").append(item.week);
            var projectName = $("<td></td>").append(item.projectName);
            var createTime = $("<td></td>").append(item.createTime == null ? "" : new Date(item.createTime).Format("yyyy-MM-dd"));
            var detailBtn = $("<button onclick=\"goDailyDetail('" + item.dailyId + "')\"></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("详情列表");
            //为详情按钮添加一个自定义的属性，来表示当前项目dailyId
            detailBtn.attr("detail-id", item.dailyId);
            //添加属性权限ID
            detailBtn.attr("privilege-id",23);
            //根据权限列表判断是否显示
            if (privilegeList.indexOf(23) == -1) {
                detailBtn.hide();
            }
            var btnTd = $("<td></td>").append(detailBtn);
            //append方法执行完成以后还是返回原来的元素
            $("<tr class='layui-colla-item'></tr>")
                .append(dailyDate)
                .append(week)
                .append(projectName)
                .append(createTime)
                .append(createTime)
                .append(btnTd)
                .appendTo("#pros_table tbody");
        });
    }

    //解析显示分页信息
    function build_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页,总" +
            result.extend.pageInfo.pages + "页,总" +
            result.extend.pageInfo.total + "条记录");
        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }

    //解析显示分页条，点击分页要能去下一页....
    function build_page_nav(result) {
        //page_nav_area
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //为元素添加点击翻页的事件
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
        if (result.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum + 1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
        }

        //添加首页和前一页 的提示
        ul.append(firstPageLi).append(prePageLi);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nextPageLi).append(lastPageLi);

        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }

    //清空表单样式及内容
    function reset_form(ele) {
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }

    //显示校验结果的提示信息
    function show_validate_msg(ele, status, msg) {
        //清除当前元素的校验状态
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if ("success" == status) {
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        } else if ("error" == status) {
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }
    }

    //点击详情跳转到日报详情页面
    function goDailyDetail(dailyId) {
        window.location.href = "/html/daily/dailyAdd.jsp?dailyId=" + dailyId;
    }

    //点击新增按钮弹出模态框
    $("#add_daily_btn").click(function () {
        reset_form("#proAddModal form");
        //发送ajax请求，查出部门信息，显示在下拉列表中
        getProjectNameList("#proAddModal #projectName");
        $("#proAddModal").modal({
            backdrop: "static"
        });
        $("#dailyDateStr").val((new Date()).Format('yyyy-MM-dd'));
    });

    //查询所有的项目信息并显示在下拉列表中
    function getProjectNameList(ele) {
        //清空之前下拉列表的值
        $(ele).empty();
        $.ajax({
            url: "/project/getProjectNameList",
            data: {"userId": userId},
            type: "POST",
            success: function (result) {
                $.each(result.extend.pros, function () {
                    var optionEle = $("<option></option>").append(this.projectName).attr("value", this.id);
                    optionEle.appendTo(ele);
                });
            }
        });
    }

    //点击保存，添加日报列表信息
    $("#daily_save_btn").click(function () {
        //必输项校验
        var workTypeAdd = $("#workType_add_select").val()
            ,dailyContentAdd = $("#dailyContent_add_input").val()
            ,dailyPercentAdd = $("#dailyPercent_add_input").val()
            ,doneDateAdd = $("#doneDate").val();
        //alert("workType:"+workType+"。" + "dailyContent:"+dailyContent+"。" + "dailyPercent:"+dailyPercent+"。"+ "doneDate:"+doneDate);
        if (!workTypeAdd) {
            layer.alert("工作类型不能为空！");
            return false;
        } else if (!dailyContentAdd) {
            layer.alert("日报内容不能为空！");
            return false;
        } else if (!dailyPercentAdd) {
            layer.alert("完成百分比不能为空！");
            return false;
        } else if (!doneDateAdd) {
            layer.alert("计划完成时间不能为空！");
            return false;
        }
        checkGreaterHunderd();
        $.ajax({
            url: "/daily/dailyManage/saveDaily",
            type: "POST",
            data: $("#proAddModal form").serialize() + "&userId=" + userId,
            success: function (result) {
                if (result.code == "100") {
                    $("#proAddModal").modal('hide');
                    to_page(1);
                } else if (result.code == "110") {
                    layer.open({
                        titel: '确认信息',
                        content: '当天日报已存在'
                    });
                }
            }
        });
    });

    //周报导出
    $("#weeklyExport_btn").click(function () {
        if ($("#dailyStartDateStr").val() == "" || $("#dailyEndDateStr").val() == "") {
            layer.alert('请选择日报日期！');
            return false;
        }
        $('#weeklyExport').submit();
    });

    //校验输入的数据不能大于100
    function checkGreaterHunderd() {
        var precentUpdate = $("#dailyPercent_update_input").val();
        if (precentUpdate > 100) {
            layer.alert("不能大于100！");
            $("#dailyPercent_add_input").val("");
        }
        var precentAdd = $("#dailyPercent_add_input").val();
        if (precentAdd > 100) {
            layer.alert("不能大于100！");
            $("#dailyPercent_add_input").val("");
        }
    }
</script>
</body>
</html>
