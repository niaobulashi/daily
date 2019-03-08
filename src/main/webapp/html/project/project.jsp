<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>项目列表</title>
    <jsp:include page="/html/default/pub.jsp"/>
    <link href="/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="layui-card">
    <div class="layui-card-header">
        <!-- 项目修改的模态框 -->
        <div class="modal fade" id="proUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title">项目修改</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">项目编号</label>
                                <div class="col-sm-10">
                                    <input type="text" name="projectCode" class="form-control"
                                           id="projectCode_update_input">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">项目名称</label>
                                <div class="col-sm-10">
                                    <input type="text" name="projectName" class="form-control"
                                           id="projectName_update_input">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">项目经理</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="projectUserId_update_input" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">上班时间</label>
                                <div class="col-sm-3">
                                    <input type="text" name="workStartTimeStr" class="form-control"
                                           id="workStartTimeStr_update_input">
                                </div>
                                <label class="col-sm-4 control-label">上午下班时间</label>
                                <div class="col-sm-3">
                                    <input type="text" name="morningEndTimeStr" class="form-control"
                                           id="morningEndTimeStr_update_input">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">下午开始上班时间</label>
                                <div class="col-sm-3">
                                    <input type="text" name="afterStartTimeStr" class="form-control"
                                           id="afterStartTimeStr_update_input">
                                </div>
                                <label class="col-sm-4 control-label">下班时间</label>
                                <div class="col-sm-3">
                                    <input type="text" name="workEndTimeStr" class="form-control"
                                           id="workEndTimeStr_update_input">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">加班开始时间</label>
                                <div class="col-sm-10">
                                    <input type="text" name="overworkStartTimeStr" class="form-control"
                                           id="overWorkStartTimeStr_update_input">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="pro_update_btn">更新</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 项目添加的模态框 -->
        <div class="modal fade" id="proAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">项目添加</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">项目编号</label>
                                <div class="col-sm-10">
                                    <input type="text" name="projectCode" class="form-control"
                                           id="projectCode_add_input">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">项目名称</label>
                                <div class="col-sm-10">
                                    <input type="text" name="projectName" class="form-control"
                                           id="projectName_add_input">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">项目经理</label>
                                <div class="col-sm-10">
                                    <select class="form-control" name="projectUserId">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">上班时间</label>
                                <div class="col-sm-3">
                                    <input type="text" name="workStartTimeStr" class="form-control"
                                           id="workStartTimeStr_add_input">
                                    <span class="help-block"></span>
                                </div>
                                <label class="col-sm-4 control-label">上午下班时间</label>
                                <div class="col-sm-3">
                                    <input type="text" name="morningEndTimeStr" class="form-control"
                                           id="morningEndTimeStr_add_input">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">下午开始上班时间</label>
                                <div class="col-sm-3">
                                    <input type="text" name="afterStartTimeStr" class="form-control"
                                           id="afterStartTimeStr_add_input">
                                </div>
                                <label class="col-sm-4 control-label">下班时间</label>
                                <div class="col-sm-3">
                                    <input type="text" name="workEndTimeStr" class="form-control"
                                           id="workEndTimeStr_add_input">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">加班开始时间</label>
                                <div class="col-sm-10">
                                    <input type="text" name="overworkStartTimeStr" class="form-control"
                                           id="overWorkStartTimeStr_add_input">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="pro_save_btn">保存</button>
                    </div>
                </div>
            </div>
        </div>

        <%--导出加班补贴表--%>
        <div class="modal fade" id="overWorkAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="overWorkExport" method="get" enctype="multipart/form-data"
                          action="/overWork/overWorkExport">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myOverWorkAddModal">导出加班补贴表</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">加班日期</label>
                                <div class="col-md-2">
                                    <input type="text" name="workStartDateStr" class="form-control" style="width: 120px"
                                           placeholder="加班开始日期"
                                           id="workStartDateStr">
                                </div>
                                <div class="col-md-2" style="margin: 9px 0 50px 50px; float: left">
                                    <span>-</span>
                                </div>
                                <div class="col-md-2" style="margin-left:-70px;float: left">
                                    <input type="text" name="workEndDateStr" class="form-control" style="width: 120px"
                                           placeholder="加班结束日期"
                                           id="workEndDateStr">
                                </div>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" id="overWork_save_btn">确定</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%--导出项目周报表--%>
        <div class="modal fade" id="projectWeekModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form class="form-horizontal" id="projectWeekExport" method="get" enctype="multipart/form-data"
                          action="/daily/projectWeeklyExport">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myProjectWeekModal">导出项目周报表</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">日报日期</label>
                                <div class="col-md-2">
                                    <input type="text" name="dailyStartDateStr" class="form-control"
                                           style="width: 120px" placeholder="日报开始日期"
                                           id="dailyStartDateStr">
                                </div>
                                <div class="col-md-2" style="margin: 9px 0 50px 50px; float: left">
                                    <span>-</span>
                                </div>
                                <div class="col-md-2" style="margin-left:-70px;float: left">
                                    <input type="text" name="dailyEndDateStr" class="form-control" style="width: 120px"
                                           placeholder="日报结束日期"
                                           id="dailyEndDateStr">
                                </div>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" id="projectWeek_save_btn">确定</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- 按钮 -->
        <button class="layui-btn" id="pro_add_modal_btn" privilege-id="12">新增</button>
        <button class="layui-btn layui-btn-danger" id="overWorkExport_btn" privilege-id="30">导出加班补贴表</button>
        <button class="layui-btn layui-btn-normal" id="projectWeekExport_btn" privilege-id="31">导出项目周报表</button>
    </div>
    <!-- 显示表格数据 -->
    <div class="layui-card-body">
        <table id="projectMana" class="layui-table" lay-filter="projectManaEvent"></table>
    </div>

</div>

<script type="text/html" id="toolbar">
    {{# if(privilegeList.indexOf(13) != -1){}}
    <a class="layui-btn layui-btn-xs " lay-event="edit">编辑</a>
    {{# } }}
    {{# if(privilegeList.indexOf(14) != -1){}}
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
    {{# } }}
    {{# if(privilegeList.indexOf(27) != -1){}}
    <a class="layui-btn layui-btn-normal layui-btn-xs " lay-event="det">项目详情</a>
    {{# } }}
</script>
<script type="text/javascript">
    layer = layui.layer //弹层
    var totalRecord, currentPage;
    //获取当前用户的权限列表
    var privilegeList = ${user.privilegeList};
    //根据权限列表判断是否显示
    if (privilegeList.indexOf(12) == -1) {
        $("#pro_add_modal_btn").hide();
    }
    if (privilegeList.indexOf(30) == -1) {
        $("#overWorkExport_btn").hide();
    }
    if (privilegeList.indexOf(31) == -1) {
        $("#projectWeekExport_btn").hide();
    }

    var userId = "${user.userId}";
    //1、页面加载完成以后，直接去发送ajax请求,要到分页数据
    to_page();
    //执行一个laydate实例
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //常规用法
        laydate.render({
            elem: '#workStartTimeStr_add_input',
            type: 'time'
        });
        laydate.render({
            elem: '#workEndTimeStr_add_input',
            type: 'time'
        });
        laydate.render({
            elem: '#morningEndTimeStr_add_input',
            type: 'time'
        });
        laydate.render({
            elem: '#afterStartTimeStr_add_input',
            type: 'time'
        });
        laydate.render({
            elem: '#overWorkStartTimeStr_add_input',
            type: 'time'
        });
        laydate.render({
            elem: '#workStartTimeStr_update_input',
            type: 'time'
        });
        laydate.render({
            elem: '#morningEndTimeStr_update_input',
            type: 'time'
        });
        laydate.render({
            elem: '#afterStartTimeStr_update_input',
            type: 'time'
        });
        laydate.render({
            elem: '#workEndTimeStr_update_input',
            type: 'time'
        });
        laydate.render({
            elem: '#overWorkStartTimeStr_update_input',
            type: 'time'
        });
        laydate.render({
            elem: '#workStartDateStr'
        });
        laydate.render({
            elem: '#workEndDateStr'
        });
        laydate.render({
            elem: '#dailyStartDateStr'
        });
        laydate.render({
            elem: '#dailyEndDateStr'
        });
    });

    //分页查询处理
    function search(page, limit) {
        layui.use('table', function () {
            var table = layui.table;

            table.render({
                elem: '#projectMana'
                , url: '/project/getProjectByUser' //数据接口
                , where: {userId: userId}
                , page: true
                , cols: [[ //表头
                    {field: 'projectCode', title: '项目编号', width: 150}
                    , {field: 'projectName', title: '项目名称', width: 200}
                    , {field: 'userName', title: '项目经理', align: 'center', width: 100}
                    , {
                        field: 'workStartTime', title: '上班时间', align: 'center', width: 100, templet: function (d) {
                            return d.workStartTime == null ? "" : new Date(d.workStartTime).Format("hh:mm:ss")
                        }
                    }
                    , {
                        field: 'morningEndTime',
                        title: '上午下班时间',
                        align: 'center',
                        width: 140,
                        templet: function (d) {
                            return d.morningEndTime == null ? "" : new Date(d.morningEndTime).Format("hh:mm:ss")
                        }
                    }
                    , {
                        field: 'afterStartTime', title: '下午上班时间', align: 'center', width: 140, templet: function (d) {
                            return d.afterStartTime == null ? "" : new Date(d.afterStartTime).Format("hh:mm:ss")
                        }
                    }
                    , {
                        field: 'workEndTime', title: '下班时间', align: 'center', width: 100, templet: function (d) {
                            return d.workEndTime == null ? "" : new Date(d.workEndTime).Format("hh:mm:ss")
                        }
                    }
                    , {
                        field: 'overworkStartTime',
                        title: '加班开始时间',
                        align: 'center',
                        width: 140,
                        templet: function (d) {
                            return d.overworkStartTime == null ? "" : new Date(d.overworkStartTime).Format("hh:mm:ss")
                        }
                    }
                    , {
                        field: 'dosomething',
                        title: '操作',
                        width: 210,
                        id: 'hide',
                        align: 'center',
                        toolbar: '#toolbar',
                        fixed: 'right'
                    }
                ]]
                , response: {
                    statusName: 'code'
                    , statusCode: '100'
                    , msgName: 'msg'
                    , countName: 'total'
                    , dataName: 'data'
                }
            });

            table.on('tool(projectManaEvent)', function (obj) {
                var data = obj.data;
                if (obj.event === 'edit') {
                    editButton(data.id);
                } else if (obj.event === 'del') {
                    delButton(data.projectName, data.id, userId);
                } else if (obj.event === 'det') {
                    detButton(data.id);
                }
            });
        })
    }

    //清空表单样式及内容
    function reset_form(ele) {
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }

    //点击新增按钮弹出模态框。
    $("#pro_add_modal_btn").click(function () {
        //清除表单数据（表单完整重置（表单的数据，表单的样式））
        reset_form("#proAddModal form");
        ;
        //发送ajax请求，查出部门信息，显示在下拉列表中
        getProjectUserNameList("#proAddModal select");
        //弹出模态框
        $("#proAddModal").modal({
            backdrop: "static"
        });
    });

    //查询项目经理下拉列表
    function getProjectUserNameList(ele) {
        //清空之前下拉列表的值
        $(ele).empty();
        $.ajax({
            url: "/user/queryUserByRoleIdForProjectUser",
            type: "POST",
            success: function (result) {
                $.each(result.extend.pros, function () {
                    var optionEle = $("<option></option>").append(this.userName + "（" + this.email + "）").attr("value", this.userId);
                    optionEle.appendTo(ele);
                });
            }
        });
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

    //校验用户名是否可用
    $("#projectCode_add_input").change(function () {
        //发送ajax请求校验用户名是否可用
        var projectCode = this.value;
        $.ajax({
            url: "/project/checkProject",
            data: "projectCode=" + projectCode,
            type: "POST",
            success: function (result) {
                if (result.code == "100") {
                    show_validate_msg("#projectCode_add_input", "success", "项目编号可用");
                    $("#pro_save_btn").attr("ajax-va", "success");
                } else {
                    show_validate_msg("#projectCode_add_input", "error", result.extend.va_msg);
                    $("#pro_save_btn").attr("ajax-va", "error");
                }
            }
        });
    });

    //点击保存，保存员工。
    $("#pro_save_btn").click(function () {
        //1、模态框中填写的表单数据提交给服务器进行保存
        //1、判断之前的ajax用户名校验是否成功。如果成功。
        if ($(this).attr("ajax-va") == "error") {
            return false;
        }
        //2、发送ajax请求保存员工
        $.ajax({
            url: "/project/addProject",
            type: "POST",
            data: $("#proAddModal form").serialize(),
            success: function (result) {
                //alert(result.msg);
                if (result.code == "100") {
                    //员工保存成功；
                    //1、关闭模态框
                    $("#proAddModal").modal('hide');
                    //2、来到最后一页，显示刚才保存的数据
                    //发送ajax请求显示最后一页数据即可
                    to_page(totalRecord);
                } else if (result.code == "110") {
                    layer.open({
                        titel: '确认信息',
                        content: '项目已存在'
                    });
                }
            }
        });
    });

    //点击编辑，弹出编辑项目信息框
    function editButton(projectId) {
        //2、查出项目信息，显示项目信息
        getProject(projectId);
        //3、把项目的id传递给模态框的更新按钮
        $("#pro_update_btn").attr("edit-id", projectId);
        $("#proUpdateModal").modal({
            backdrop: "static"
        });
    };

    //获取项目信息
    function getProject(id) {
        $.ajax({
            url: "/project/getProjectById/" + id,
            type: "GET",
            success: function (result) {
                var proData = result.extend.id;
                var proId = proData.id;
                $("#projectCode_update_input").val(proData.projectCode);
                $("#projectName_update_input").val(proData.projectName);
                $("#projectUserId_update_input").val(proData.userName + "（" + proData.email + "）");
                $("#workStartTimeStr_update_input").val(proData.workStartTime == null ? "" : new Date(proData.workStartTime).Format("hh:mm:ss"));
                $("#morningEndTimeStr_update_input").val(proData.morningEndTime == null ? "" : new Date(proData.morningEndTime).Format("hh:mm:ss"));
                $("#afterStartTimeStr_update_input").val(proData.afterStartTime == null ? "" : new Date(proData.afterStartTime).Format("hh:mm:ss"));
                $("#workEndTimeStr_update_input").val(proData.workEndTime == null ? "" : new Date(proData.workEndTime).Format("hh:mm:ss"));
                $("#overWorkStartTimeStr_update_input").val(proData.overworkStartTime == null ? "" : new Date(proData.overworkStartTime).Format("hh:mm:ss"));
            }
        });
    }

    //点击更新，更新项目信息信息
    $("#pro_update_btn").click(function () {
        var projectId = $(this).attr("edit-id");
        var params = $("#proUpdateModal form").serialize() + "&id=" + projectId;
        $.ajax({
            url: "/project/updateProjectInfo",
            type: "POST",
            data: params,
            success: function (result) {
                //alert(result.msg);
                //1、关闭对话框
                $("#proUpdateModal").modal("hide");
                //2、回到本页面
                to_page(currentPage);
            }
        });
    });

    //单个删除
    function delButton(projectName, proId, userId) {
        //1、弹出是否确认删除对话框
        var params = "proId=" + proId + "&userId=" + userId;
        layer.confirm('确定删除【' + projectName + '】吗？', {icon: 3, title: '确认信息'}, function (index) {
            //确认，发送ajax请求删除即可
            $.ajax({
                url: "/project/delProjectInfo",
                data: params,
                type: "POST",
                success: function (result) {
                    layer.msg(result.msg);
                    //回到本页
                    to_page(currentPage);
                }
            });
        });
    };

    //完成全选/全不选功能
    $("#check_all").click(function () {
        $(".check_item").prop("checked", $(this).prop("checked"));
    });

    //check_item
    $(document).on("click", ".check_item", function () {
        //判断当前选择中的元素是否5个
        var flag = $(".check_item:checked").length == $(".check_item").length;
        $("#check_all").prop("checked", flag);
    });

    //加班补贴表
    $("#overWorkExport_btn").click(function () {
        reset_form("#overWorkAddModal form");
        $("#overWorkAddModal").modal({
            backdrop: "static"
        });
        $("#monthStr").val((new Date()).Format('yyyy-MM'));
    });

    //点击保存，导出加班补贴表
    $("#overWork_save_btn").click(function () {
        if ($("#workStartDateStr").val() == "" || $("#workEndDateStr").val() == "") {
            layer.alert('请选择加班日期！');
            return false;
        }
        $('#overWorkExport').submit();
        reset_form("#overWorkAddModal form");
        $("#overWorkAddModal").modal('hide');
    });

    //项目周报表
    $("#projectWeekExport_btn").click(function () {
        reset_form("#projectWeekModal form");
        $("#projectWeekModal").modal({
            backdrop: "static"
        });
    });

    //点击保存，导出加班补贴表
    $("#projectWeek_save_btn").click(function () {
        if ($("#dailyStartDateStr").val() == "" || $("#dailyEndDateStr").val() == "") {
            layer.alert('请选择周报日期！');
            return false;
        }
        $('#projectWeekExport').submit();
        reset_form("#projectWeekModal form");
        $("#projectWeekModal").modal('hide');
    });

    //点击详情，跳转到项目详情页面
    function detButton(projectId) {
        var id = projectId;
        console.info(id);
        window.location.href = "/html/project/projectDetail.jsp?projectId=" + id;
    };

    function to_page() {
        layui.use(['laypage'], function () {
            var laypage = layui.laypage;
            //调用分页
            laypage.render({
                curr: 1 //设定初始在第 1 页
                , limit: 10//每页显示条数
                , groups: 5 //只显示 5 个连续页码
                , layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
                , jump: function (obj) {
                    var page = obj.curr;
                    var limit = obj.limit;
                    search(page, limit);
                }
            });
        });
    }

</script>
</body>
</html>