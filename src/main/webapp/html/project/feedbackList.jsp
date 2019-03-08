<%--
  Created by IntelliJ IDEA.
  User: Zara
  Date: 2018/8/15
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>反馈信息</title>
    <jsp:include page="/html/default/pub.jsp"/>
    <script type="text/javascript" src="/js/common/currentWeek.js" charset="utf-8"></script>
</head>
<body>
<div class="layui-card">
    <form class="layui-form layui-card-header">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">反馈日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="fbDate" class="layui-input" id="fbDate" placeholder=" - "/>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">处理状态</label>
                <div class="layui-input-inline">
                    <select name="resultFlag" id="resultFlag">
                        <option value="">请选择处理类型</option>
                        <option value="0">未处理</option>
                        <option value="1">已处理</option>
                        <option value="2">已忽略</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">反馈类型</label>
                <div class="layui-input-inline">
                    <select name="fbType" id="fbType">
                        <option value="">请选择反馈类型</option>
                        <option value="100001">新需求</option>
                        <option value="100002">功能意见</option>
                        <option value="100003">界面意见</option>
                        <option value="100004">操作意见</option>
                        <option value="100005">其他意见</option>
                    </select>
                </div>
            </div>
            <div style="float:right">
                <button class="layui-btn" lay-submit lay-filter="formDemo">检索</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<div class="layui-card-body">
    <table class="layui-hidden" id="listTable" lay-filter="listTable"></table>
</div>
<script type="text/html" id="barDemo">
    {{# if(d.resultFlag =="0" || d.resultFlag ==""){ }}
    <a class="layui-btn layui-btn-mini layui-btn-xs fixed" lay-event="fixed">处理</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs del" lay-event="del">忽略</a>
    {{# } else if (d.resultFlag =="1") { }}
    <span style="font-size:12px; color:blue;">已处理</span>
    {{# } else if (d.resultFlag =="2") { }}
    <span style="font-size:12px; color:orangered;">已忽略</span>
    {{# } }}
</script>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //常规用法
        laydate.render({
            elem: '#fbDate'
            , range: true
        });
    });

    layui.use('table', function () {
        var $ = layui.$;
        var fbDate = '';
        var resultFlag = '';
        var fbType = '';
        var table = layui.table;

        table.render({
            elem: '#listTable'
            , url: '/feedBack/getFeedbackList'
            , where: {fbDate: fbDate, fbType: fbType, resultFlag: resultFlag}
            , page: true //开启分页
            , cols: [[
                {fixed: 'left', title: '操作', width: 120, align: 'center', toolbar: '#barDemo'}
                , {field: 'fbType', width: 150, title: '反馈类型'}
                , {field: 'fbInfo', title: '反馈内容'}
                , {field: 'fbEmail', width: 170, title: '反馈邮箱'}
                , {
                    field: 'createDate', width: 110, title: '反馈日期', sort: true, templet: function (d) {
                        return !!d.createDate ? getDateStr3(new Date(d.createDate)) : '';
                    }
                }
                , {field: 'fbUser', width: 80, title: '反馈人'}
            ]]
            , response: {
                statusName: 'code'
                , statusCode: '100'
                , msgName: 'msg'
                , countName: 'total'
                , dataName: 'data'
            }
        });

        table.on('tool(listTable)', function (obj) {
            var data = obj.data;
            if (data.resultFlag || data.resultFlag === '0') {
                var layEvent = obj.event;
                if ('del' === layEvent) {
                    layer.confirm('真的要忽略此行吗？', function (index) {
                        $.get('/feedBack/ignoreFeedback', {"fdId": data.fdId}, function () {
                            obj.update({
                                resultFlag: '2'
                            });
                            layer.close(index);
                            layer.msg('已忽略此行！');
                            $(obj.tr[1]).html('<td data-field="0" align="center" data-off="true"><div class="layui-table-cell laytable-cell-1-0">&nbsp;&nbsp;<span style="font-size:12px; color:orangered;">已忽略</span>&nbsp;&nbsp;</div></td>');
                        });
                    });
                } else if ('fixed' === layEvent) {
                    layer.confirm('确定已经处理完成了吗？', function (index) {
                        $.get('/feedBack/fixedIssueFeedback', {"fdId": data.fdId}, function () {
                            obj.update({
                                resultFlag: '1'
                            });
                            layer.close(index);
                            layer.msg('已处理此行！');
                            $(obj.tr[1]).html('<td data-field="0" align="center" data-off="true"><div class="layui-table-cell laytable-cell-1-0">&nbsp;&nbsp;<span style="font-size:12px; color:blue;">已处理</span>&nbsp;&nbsp;</div></td>');
                        });
                    });
                }
            }
        });
    });

    layui.use('table', function () {
        var table = layui.table;
        var form = layui.form;
        //监听提交事件，重新加载treeGrid
        form.on('submit(formDemo)', function (data) {
            table.render({
                elem: '#listTable'
                , url: '/feedBack/getFeedbackList'
                , where: {fbDate: data.field.fbDate, fbType: data.field.fbType, resultFlag: data.field.resultFlag}
                , page: true
                , cols: [[
                    {fixed: 'left', title: '操作', width: 120, align: 'center', toolbar: '#barDemo'}
                    , {field: 'fbType', width: 150, title: '反馈类型'}
                    , {field: 'fbInfo', title: '反馈内容'}
                    , {field: 'fbEmail', width: 170, title: '反馈邮箱'}
                    , {
                        field: 'createDate', width: 110, title: '反馈日期', sort: true, templet: function (d) {
                            return !!d.createDate ? getDateStr3(new Date(d.createDate)) : '';
                        }
                    }
                    , {field: 'fbUser', width: 80, title: '反馈人'}

                ]]
                , response: {
                    statusName: 'code'
                    , statusCode: '100'
                    , msgName: 'msg'
                    , countName: 'total'
                    , dataName: 'data'
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
