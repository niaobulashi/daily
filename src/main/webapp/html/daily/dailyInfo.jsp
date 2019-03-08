<%--
  Created by IntelliJ IDEA.
  User: HeXin
  Date: 2018/6/5
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>日报信息</title>
    <link rel="stylesheet" type="text/css" href="/js/layui/css/layui.css" />
    <script type="text/javascript" src="/js/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/common/common.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/common/currentWeek.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/jquery/jquery-3.3.1.min.js" charset="utf-8"></script>
    <link href="/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="layui-card">
    <div class="layui-card-header">
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

    <!-- 日报修改的模态框 -->
    <div class="modal fade" id="proUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabelUpdate">
        <div class="modal-dialog" role="document">
            <div class="modal-content" style="z-index: 19896; width: 700px; height: 500px; top: -24px; left: -107px;">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabelUpdate">日报修改</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="layui-form-label" style="width: 100px">日报日期</label>
                            <div class="col-sm-3">
                                <input type="text"
                                       name="dailyDateStr"
                                       id="dailyDateStrUpdate"
                                       readonly
                                       class="form-control"
                                       placeholder="请选择日期"
                                       lay-verify="date" autocomplete="off" class="layui-input"
                                       style="background-color: #bebebe;">
                            </div>
                            <label class="layui-form-label">项目组</label>
                            <div class="col-sm-5">
                                <select class="form-control" name="projectName" id="projectNameUpdate">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="layui-form-label" style="width: 100px">工作类型</label>
                            <div class="col-sm-5">
                                <select name="workType" id="workType_update_select" class="form-control">
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
                                <input type="text" name="dailyContent" id="dailyContent_update_input" class="form-control" style="width: 517px">
                                <input type="hidden" name="dailyDetailId" id="dailyDetailIdHidden">
                                <input type="hidden" name="dailyId" id="dailyIdHidden">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="layui-form-label" style="width: 100px">完成百分比</label>
                            <div class="col-sm-2">
                                <input type="text" name="dailyPercent"
                                       class="form-control"
                                       id="dailyPercent_update_input"
                                       onblur="checkGreaterHunderd()"
                                       min="0" max="100" maxlength="3"
                                       onkeyup="value=value.replace(/[^0-9]/g,'')"
                                       onpaste="value=value.replace(/[^0-9]/g,'')"
                                       oncontextmenu = "value=value.replace(/[^0-9]/g,'')">
                            </div>
                            <label class="layui-form-label" style="width: 100px">计划完成</label>
                            <div class="col-sm-4">
                                <input type="text" id="doneDate_update_input" name="doneDateStr" class="form-control" lay-verify="date" placeholder="计划完成时间">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="layui-form-label" style="width: 100px">工作疑问</label>
                            <div class="col-sm-7">
                                <input type="text" name="problem" id="problem_update_input" class="form-control" style="width: 517px">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="layui-form-label" style="width: 100px">下周计划</label>
                            <div class="col-sm-7">
                                <input type="text" name="nextWorkPlan" id="nextWorkPlan_update_input" class="form-control" style="width: 517px">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="daily_update_btn">更新</button>
                </div>
            </div>
        </div>
    </div>

    <%-- 检索区 --%>
    <form id="weeklyExport" method="get" enctype="multipart/form-data" action="/daily/weeklyExport" class="layui-form" lay-filter="mainForm">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label" style="width: 120px;">完成进度</label>
                <div class="layui-input-inline">
                    <select id="completeProgress" name="completeProgress" lay-verify="required" lay-filter="completeProgress" lay-search="">
                        <option value="00">全部</option>
                        <option value="02">未完成</option>
                        <option value="03">已完成</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label" style="width: 120px;">日报日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="preFinishDate" class="layui-input" id="preFinishDate" placeholder=" - " autocomplete="off">
                </div>
            </div>
            <div class="layui-inline" style="float:right">
                <button class="layui-btn" lay-submit lay-filter="formDemo" id="search">检索</button>
                <button type="reset" class="layui-btn">重置</button>
                <button class="layui-btn" lay-submit lay-filter="weeklyExport_btn">导出周报</button>
                <button class="layui-btn layui-btn-warm" type="button" id="add_daily_btn">
                    <i class="layui-icon">&#xe654;</i>&nbsp;新增
                </button>
            </div>
        </div>

        <div id="memberList" class="layui-form-item"></div>

    </form>
    </div>
    <div class="layui-card-body">
    <%-- 列表区 --%>
    <table class="layui-hidden" id="treeTable" lay-filter="treeTable"></table>
    </div>
</div>
</body>
<script type="text/html" id="toolbar">
    {{#  if(d.pid != '0'){ }}
    <span class="layui-btn layui-btn-xs" lay-event="update">修改</span>
    <span class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</span>
    {{#  } }}
</script>
<script>
    var userId = "${user.userId}";
    layui.use(['jquery', 'form', 'laydate', 'element', 'table', 'treeGrid'], function(){
        var $ = layui.$;
        var form = layui.form;
        var laydate = layui.laydate;
        // var table = layui.table;
        var treeGrid = layui.treeGrid;
        var preFinishDate = getWeekStartAndEnd(0);
        var completeProgress = $('#completeProgress');
        var membersId;
        var initSelectFlag = false;

        //日期时间范围
        laydate.render({
            elem: '#preFinishDate'
            ,range: true
            ,theme: 'grid'
            ,value: getWeekStartAndEnd(0)
            ,done : function(value, date, endDate){
                preFinishDate = value;
            }
        });
        laydate.render({
            elem: '#doneDate'
            ,theme: 'grid'
        });
        laydate.render({
            elem: '#doneDate_update_input'
            ,theme: 'grid'
        });

        // 初始化treeGrid
        var treeTable = treeGrid.render({
            elem: '#treeTable'
            ,url:'/dailyDetail/getDailyDetailByUserId'
            ,method:"GET"
            ,where: {userId: userId, preFinishDate: preFinishDate, completeProgress: completeProgress.val(), memberId: membersId}
            , cellMinWidth: 150
            ,treeId:'dailyDetailId'//树形id字段名称
            ,treeUpId:'pid'//树形父id字段名称
            ,treeShowName:'workTypeShow'//以树形式显示的字段
            ,cols: [[
                {field:'operate', title: '操作', align:'center', width: 120, toolbar:'#toolbar'}
                ,{field:'workTypeShow', width:'150', title: '日报类型'}
                ,{field:'dailyDateShow', width:'100', title: '日报日期'}
                ,{field:'dailyContent', width:'300', title: '日报内容'}
                ,{field:'dailyPercent', width:'100', title: '完成百分比',templet: function(d){
                        return d.dailyPercent?d.dailyPercent + '%':''
                    }}
                ,{field:'doneDateShow', width:'120', title: '计划完成时间'}
                ,{field:'execution', width:'100', title: '完成情况'}
                , {field: 'problem', title: '工作存在问题'}

            ]]
            ,response: {
                statusName: 'code'
                ,statusCode: '100'
                ,msgName: 'msg'
                ,countName: 'total'
                ,dataName: 'data'
            }
            ,page:false
            ,done: function(res, curr, count){
                if (!initSelectFlag) {
                    if (!!res.extend.showMembers && res.extend.showMembers == 'show') {
                        initSelectFlag = true;
                        var memberGroup = $("<div id='memberGroup' class='layui-inline'></div>");
                        var memberLabel = $("<label id='memberLabel' class='layui-form-label' style='width: 120px'>小组成员</label>");
                        var membersDiv = $("<div id='membersDiv' class='layui-input-inline'></div>");
                        var members = $("<select id='members' name='memberId' lay-verify='required' lay-filter='members' lay-search=''></select>");

                        memberGroup.append(memberLabel);
                        memberGroup.append(membersDiv);
                        membersDiv.append(members);

                        $.each(res.extend.userList, function (i, user) {
                            var opt = $("<option></option>");
                            opt.attr("value", user.userId);
                            opt.append(user.userName);
                            members.append(opt);
                        });

                        $('#memberList').append(memberGroup);

                        form.render('select', 'mainForm');
                        membersId = $('#members').val();

                        form.on('select(members)', function(data){
                            membersId = data.value;
                        });
                    }
                }
            }
        });

        //监听提交事件，重新加载treeGrid
        form.on('submit(formDemo)', function(data){
            preFinishDate = $('#preFinishDate').val();
            if (!preFinishDate) {
                preFinishDate = getWeekStartAndEnd(0);
            }
            membersId = $('#members').val();
            treeGrid.reload('treeTable', {
                where: {userId: userId, preFinishDate: preFinishDate, completeProgress: data.field.completeProgress, memberId: membersId}
            });
            return false;
        });

        //导出周报
        form.on('submit(weeklyExport_btn)', function(){
            preFinishDate = $('#preFinishDate').val();
            if ($('#preFinishDate').val() == "") {
                layer.alert('请选择日报日期！');
                return false;
            }
            $('#weeklyExport').submit();
        });


        //点击修改
        treeGrid.on('tool(treeTable)',function (obj) {
            var data = obj.data;
            if (obj.event === 'update') {
                //根据日报详情ID查询日报信息
                getDailyDetailInfo(data.dailyDetailId);
            } else if (obj.event === 'del') {
                //弹框提示是否删除日报信息
                delDailyDetail(data.dailyContent, data.dailyDetailId);
            }
        });
    });

    //------------------------------------------------------------------
    //点击新增
    $('#add_daily_btn').click(function () {
        reset_form("#proAddModal form");
        //发送ajax请求，查出部门信息，显示在下拉列表中
        getProjectNameList("#proAddModal #projectName");
        $("#proAddModal").modal({
            backdrop: "static"
        });
        $("#dailyDateStr").val((new Date()).Format('yyyy-MM-dd'));
    });

    //清空表单样式及内容
    function reset_form(ele) {
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }

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
        //校验完成百分比
        checkGreaterHunderd();
        var index = layer.msg('拼命加载中', {
            icon: 16
            ,shade: 0.01
        });
        $.ajax({
            url: "/daily/dailyManage/saveDaily",
            type: "POST",
            data: $("#proAddModal form").serialize() + "&userId=" + userId,
            success: function (result) {
                if (result.code == "100") {
                    $("#proAddModal").modal('hide');
                    $("#search").click();
                    layer.close(index);
                } else if (result.code == "110") {
                    layer.open({
                        titel: '确认信息',
                        content: '当天日报已存在'
                    });
                }
            }
        });
    });

    //校验输入的数据不能大于100
    function checkGreaterHunderd() {
        var precentUpdate = $("#dailyPercent_update_input").val();
        if (precentUpdate > 100) {
            layer.alert("不能大于100！");
            $("#dailyPercent_add_input").val("");
            return false;
        }
        var precentAdd = $("#dailyPercent_add_input").val();
        if (precentAdd > 100) {
            layer.alert("不能大于100！");
            $("#dailyPercent_add_input").val("");
            return false;
        }
    }

    //点击修改，获取项目信息
    function getDailyDetailInfo(id) {
        $.ajax({
            url: "/dailyDetail/searchDailyDetail/" + id,
            type: "GET",
            success: function (result) {
                //弹框显示
                $("#proUpdateModal").modal({
                    backdrop: "static"
                });
                var proData = result.extend.tDailyDetail;
                getProjectNameList("#proUpdateModal #projectNameUpdate");
                $("#dailyIdHidden").val(proData.dailyId);
                $("#dailyDetailIdHidden").val(proData.dailyDetailId);
                $("#dailyDateStrUpdate").val(proData.dailyDate == null ? "" : new Date(proData.dailyDate).Format("yyyy-MM-dd"));
                $("#workType_update_select").val(proData.workType);
                $("#dailyContent_update_input").val(proData.dailyContent);
                $("#dailyPercent_update_input").val(proData.dailyPercent);
                $("#doneDate_update_input").val(proData.doneDate == null ? "" : new Date(proData.doneDate).Format("yyyy-MM-dd"));
                $("#problem_update_input").val(proData.problem);
                $("#nextWorkPlan_update_input").val(proData.nextWorkPlan);
            }
        });
    };

    //弹框页面中点击更新，更新日报内容信息
    $("#daily_update_btn").click(function () {
        var workTypeUpdate = $("#workType_update_select").val()
            ,dailyContentUpdate = $("#dailyContent_update_input").val()
            ,dailyPercentUpdate = $("#dailyPercent_update_input").val()
            ,doneDateUpdate = $("#doneDate_update_input").val();
        if (!workTypeUpdate) {
            layer.alert("工作类型不能为空！");
            return false;
        } else if (!dailyContentUpdate) {
            layer.alert("日报内容不能为空！");
            return false;
        } else if (!dailyPercentUpdate) {
            layer.alert("完成百分比不能为空！");
            return false;
        } else if (!doneDateUpdate) {
            layer.alert("计划完成时间不能为空！");
            return false;
        }
        //最后还需要校验完成百分比不能大于100
        checkGreaterHunderd();
        var params = $("#proUpdateModal form").serialize() + "&userId=" + userId;
        $.ajax({
            url: "/dailyDetail/updateDailyDetail",
            type: "POST",
            data: params,
            success:function(result){
                if(result.code == "100"){
                    $("#proUpdateModal").modal('hide');
                    $("#search").click();
                }
            }
        });
    });

    //删除日报
    function delDailyDetail(dailyContent, dailyDetailId) {
        layer.confirm('确定删除【' + dailyContent + '】吗？', {icon: 3, title: '确认信息'}, function (index) {
            //确认，发送ajax请求删除即可
            $.ajax({
                url: "/dailyDetail/deleteDailyDetail/" + dailyDetailId,
                type: "DELETE",
                success: function (result) {
                    layer.msg(result.msg);
                    //回到本页
                    $("#search").click();
                }
            });
        });
    };

</script>
</html>
