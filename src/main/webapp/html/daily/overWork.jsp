<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>加班列表</title>
    <jsp:include page="/html/default/pub.jsp"/>
    <link href="/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="/js/common/common.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/common/currentWeek.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/jquery/jquery-3.3.1.min.js" charset="utf-8"></script>
    <script src="/js/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="layui-card">

    <!-- 加班审核的模态框 -->
    <div class="modal fade" id="proUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">加班审核</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-4">
                                <input type="text" name="userName" class="form-control" id="userName" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">加班日期</label>
                            <div class="col-sm-4">
                                <input type="text" name="workDate" class="form-control" id="workDate" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">加班时长</label>
                            <div class="col-sm-4">
                                <input type="text" name="overWork" class="form-control" id="overWork">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">审批状态</label>
                            <div class="col-sm-5">
                                <select name="approvalStatus" id="approvalStatus_update" class="form-control">
                                    <option value="">请选择</option>
                                    <option value="0">待审核</option>
                                    <option value="1">审核通过</option>
                                    <option value="2">审核拒绝</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">审批意见</label>
                            <div class="col-sm-10">
                                <input type="text" name="approvalOpinion" class="form-control" id="approvalOpinion">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="pro_update_btn">确定</button>
                </div>
            </div>
        </div>
    </div>

    <!-- 批量加班审核的模态框 -->
    <div class="modal fade" id="batchAuditModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabe2">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">批量加班审核</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">审批状态</label>
                            <div class="col-sm-5">
                                <select name="approvalStatus" id="approvalStatus_batchUpdate" class="form-control">
                                    <option value="">请选择</option>
                                    <option value="0">待审核</option>
                                    <option value="1">审核通过</option>
                                    <option value="2">审核拒绝</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">审批意见</label>
                            <div class="col-sm-10">
                                <input type="text" name="approvalOpinion" class="form-control"
                                       id="approvalOpinion_batchUpdate">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="batchAudit_btn">确定</button>
                </div>
            </div>
        </div>
    </div>

    <!-- 搭建显示页面 -->
    <div class="layui-card-header">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">加班日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="workDateStr" class="layui-input" id="workDateStr" autocomplete="off">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">审核状态</label>
                <div class="layui-input-inline">
                    <select name="approvalStatus" id="approvalStatus_select" class="form-control"
                            style="width: 130px;height: 38px">
                        <option value="">请选择</option>
                        <option value="0">待审核</option>
                        <option value="1">审核通过</option>
                        <option value="2">审核拒绝</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline" id="select_user">
                <label class="layui-form-label">项目成员</label>
                <div class="layui-input-inline">
                    <select class="form-control" name="userId" id="userId_select"></select>
                </div>
            </div>
            <div style="float:right">
                <div class="layui-inline">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" id="select_modal_btn"><i
                            class="layui-icon layui-icon-search layuiadmin-button-btn"></i>搜索
                    </button>
                </div>
                <div class="layui-inline" id="batch_audit_btn">
                    <button class="layui-btn" id="batch" data-type="getCheckData"><i
                            class="layui-icon layui-icon-survey layuiadmin-button-btn"></i>批量审核
                    </button>
                </div>
            </div>
        </div>
    </div>
    <!-- 显示表格数据 -->
    <div class="layui-card-body">
        <table class="layui-table" id="pros_table" lay-filter="overWorkEvent"></table>
    </div>

</div>
<script type="text/html" id="toolbar">
    <a class="layui-btn layui-btn-xs" lay-event="audit"><i
            class="layui-icon layui-icon-survey layuiadmin-button-btn"></i>审核</a>
</script>
<script type="text/javascript">
    layer = layui.layer //弹层
    //获取当前用户的权限列表
    var privilegeList = ${user.privilegeList};
    //根据权限列表判断是否显示查询条件及批量审批按钮
    if (privilegeList.indexOf(50) == -1) {
        $("#select_user").hide();
        $("#batch_audit_btn").hide();

    } else {
        $(function () {
            //查询项目成员列表
            getProjectUserList("#userId_select");
        });
    }
    var userId = "${user.userId}";
    //执行一个laydate实例
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        var workDateStr = getWeekStartAndEnd(0);
        $("#workDateStr").val(workDateStr);

        //日期时间范围
        laydate.render({
            elem: '#workDateStr'
            , range: true
            , theme: 'grid'
        });
    });


    to_page();

    //查询加班信息
    function search(page, limit) {
        //执行一个table实例
        layui.use('table', function () {
            var table = layui.table;
            if (privilegeList.indexOf(50) == -1) {
                table.render({
                    elem: '#pros_table'
                    ,
                    url: '/overWork/getOverWorkList'
                    ,
                    where: {
                        userId: $("#userId_select").val(),
                        approvalStatus: $("#approvalStatus_select").val(),
                        workDateStr: $("#workDateStr").val()
                    }
                    ,
                    page: {
                        layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
                        , curr: page //设定初始在第 1 页
                        , limit: limit
                        , groups: 10 //只显示 5 个连续页码
                    }
                    ,
                    cols: [[
                        {field: 'userName', width: 80, title: '姓名', align: 'center'}
                        , {
                            field: 'workDate',
                            width: 150,
                            title: '加班日期',
                            align: 'center',
                            sort: true,
                            templet: function (d) {
                                return d.workDate == null ? "" : new Date(d.workDate).Format("yyyy-MM-dd")
                            }
                        }
                        , {field: 'overWork', width: 150, title: '加班时长（小时）', align: 'center'}
                        , {field: 'approvalStatusShow', width: 150, title: '审核状态', align: 'center'}
                        , {field: 'approvalOpinion', title: '审核意见', align: 'center'}
                    ]]
                    ,
                    response: {
                        statusName: 'code'
                        , statusCode: '100'
                        , msgName: 'msg'
                        , countName: 'total'
                        , dataName: 'data'
                    }
                });
            } else {
                table.render({
                    elem: '#pros_table'
                    ,
                    url: '/overWork/getOverWorkList'
                    ,
                    where: {
                        userId: $("#userId_select").val(),
                        approvalStatus: $("#approvalStatus_select").val(),
                        workDateStr: $("#workDateStr").val()
                    }
                    ,
                    page: {
                        layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
                        , curr: page //设定初始在第 1 页
                        , limit: limit
                        , groups: 10 //只显示 5 个连续页码
                    }
                    ,
                    cols: [[
                        {type: 'checkbox'}
                        , {field: 'userName', width: 80, title: '姓名', align: 'center'}
                        , {
                            field: 'workDate',
                            width: 150,
                            title: '加班日期',
                            align: 'center',
                            sort: true,
                            templet: function (d) {
                                return d.workDate == null ? "" : new Date(d.workDate).Format("yyyy-MM-dd")
                            }
                        }
                        , {field: 'overWork', width: 150, title: '加班时长（小时）', align: 'center'}
                        , {field: 'approvalStatusShow', width: 150, title: '审核状态', align: 'center'}
                        , {field: 'approvalOpinion', title: '审核意见', align: 'center'}
                        , {field: 'operate', title: '操作', align: 'center', width: 100, toolbar: '#toolbar'}
                    ]]
                    ,
                    response: {
                        statusName: 'code'
                        , statusCode: '100'
                        , msgName: 'msg'
                        , countName: 'total'
                        , dataName: 'data'
                    }
                });
            }

            //监听表格复选框选择
            table.on('checkbox(pros_table)', function (obj) {
                console.log(obj)
            });

            var active = {
                getCheckData: function () { //获取选中数据
                    var checkStatus = table.checkStatus('pros_table')
                        , data = checkStatus.data, idArray = new Array();
                    if (data.length <= 0) {
                        layer.alert('请至少选择一条数据');
                        return;
                    }
                    for (var i = 0; i < data.length; i++) {
                        idArray.push(data[i].id);
                    }

                    //1、把批量加班审核的id传递给模态框的更新按钮
                    $("#batchAudit_btn").attr("edit-id", idArray);
                    $("#batchAuditModal").modal({
                        backdrop: "static"
                    });

                }
                , getCheckLength: function () { //获取选中数目
                    var checkStatus = table.checkStatus('pros_table')
                        , data = checkStatus.data;
                    layer.alert('选中了：' + data.length + ' 个');
                }
                , isAll: function () { //验证是否全选
                    var checkStatus = table.checkStatus('pros_table');
                    layer.alert(checkStatus.isAll ? '全选' : '未全选')
                }
            };


            $('#batch').on('click', function () {
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });

            table.on('tool(overWorkEvent)', function (obj) {
                var data = obj.data;
                if (obj.event === 'audit') {
                    //2、查出加班信息，显示加班信息
                    getOverWork(data.id);
                    //3、把加班的id传递给模态框的更新按钮
                    $("#pro_update_btn").attr("edit-id", data.id);
                    $("#proUpdateModal").modal({
                        backdrop: "static"
                    });
                }
            });
        });
    }

    function to_page() {
        layui.use(['laypage'], function () {
            var laypage = layui.laypage;
            //调用分页
            laypage.render({
                curr: 1 //设定初始在第 1 页
                , limit: 10//每页显示条数
                , groups: 10 //只显示 5 个连续页码
                , layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
                , jump: function (obj) {
                    var page = obj.curr;
                    var limit = obj.limit;
                    search(page, limit);
                }
            });
        });
    }

    //查询项目成员下拉列表
    function getProjectUserList(ele) {
        //清空之前下拉列表的值
        $(ele).empty();
        $(ele).html('<option value="">请选择</option>');
        $.ajax({
            url: "/user/getProjectUserList",
            type: "POST",
            success: function (result) {
                $.each(result.data, function () {
                    $('#userId_select').append('<option value=' + this.userId + '>' + this.userName + '</option>');
                });
            }
        });
    }

    //获取加班信息
    function getOverWork(id) {
        $.ajax({
            url: "/overWork/getOverWorkById/" + id,
            type: "GET",
            success: function (result) {
                var proData = result.extend.id;
                $("#userName").val(proData.userName);
                $("#workDate").val(proData.workDate == null ? "" : new Date(proData.workDate).Format("yyyy-MM-dd"));
                $("#overWork").val(proData.overWork);
                $("#approvalStatus_update").val(proData.approvalStatus);
                $("#approvalOpinion").val(proData.approvalOpinion);
            }
        });
    }

    //点击确定，审核加班信息
    $("#pro_update_btn").click(function () {
        var id = $(this).attr("edit-id");
        var params = $("#proUpdateModal form").serialize() + "&id=" + id;
        $.ajax({
            url: "/overWork/updateOverWorkInfo",
            type: "POST",
            data: params,
            success: function (result) {
                //1、关闭对话框
                $("#proUpdateModal").modal("hide");
                //2、回到本页面
                to_page();
            }
        });
    });

    //点击确定，批量审核加班信息
    $("#batchAudit_btn").click(function () {
        var ids = $(this).attr("edit-id");
        var params = {
            idArray: ids,
            approvalStatus: $('#approvalStatus_batchUpdate').val(),
            approvalOpinion: $('#approvalOpinion_batchUpdate').val()
        };
        $.ajax({
            url: "/overWork/batchAuditOverWork",
            type: "POST",
            dataType: 'json',
            traditional: true,
            data: params,
            success: function (result) {
                //1、关闭对话框
                $("#batchAuditModal").modal("hide");
                //2、弹窗提示
                layer.alert('批量审核成功');
                //3、重新搜索
                to_page();
            }
        });

    });

    //点击查询按钮查询加班信息。
    $("#select_modal_btn").click(function () {
        to_page();
    });

</script>
</body>
</html>