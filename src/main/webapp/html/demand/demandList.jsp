<%--
  Created by IntelliJ IDEA.
  User: Lnast
  Date: 2018/8/8
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>需求管理</title>
    <jsp:include page="/html/default/pub.jsp" />
</head>
<body>
<div class="layui-card">
    <div class="layui-form layui-card-header">
        <form>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">需求编号</label>
                    <div class="layui-input-block">
                        <input type="text" id="demandId" name="demandId" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">需求状态</label>
                    <div class="layui-input-block">
                        <select name="demandStat" id="demandStat">
                            <option value=""></option>
                            <option value="0">待处理</option>
                            <option value="1">分析中</option>
                            <option value="2">开发中</option>
                            <option value="3">已完成</option>
                            <option value="4">已上线</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline" style="margin-left: 45px">
                    <button class="layui-btn" lay-submit lay-filter="demandSearch">
                        <i class="layui-icon layui-icon-search"></i>&nbsp;搜索
                    </button>
                    <button type="reset" class="layui-btn">
                        <i class="layui-icon layui-icon-refresh"></i>&nbsp;重置
                    </button>
                    <button type="button" class="layui-btn layui-btn-warm" id="demandAdd">
                        <i class="layui-icon">&#xe654;</i>&nbsp;新增
                    </button>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">需求名称</label>
                    <div class="layui-input-block">
                        <input type="text" id="demandName" name="demandName" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">受理人</label>
                    <div class="layui-input-block">
                        <select name="demandRespoId" id="demandRespoId" >
                            <option value="">请选择</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">版本号</label>
                    <div class="layui-input-block">
                        <input type="text" id="versionNum" name="versionNum" placeholder="请输入" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="layui-card-body">
        <table id="demandTable" class="layui-table" lay-filter="demandEvent"></table>
    </div>
</div>
<script type="text/html" id="toolbar">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/html" id="progressTpl">
    <div class="layui-progress layuiadmin-order-progress" lay-filter="progress-" + {{ d.id }} + "">
    <div class="layui-progress-bar layui-bg-blue" lay-percent={{ d.demandProgress }} lay-showpercent="true"
         style="width: {{ d.demandProgress }}"></div>
    </div>
</script>


<script type="text/html" id="status">
    {{#  if(d.demandStat == '0'){ }}
    <button class="layui-btn layui-btn-danger layui-btn-xs">待处理</button>
    {{#  } else if(d.demandStat == '1'){ }}
    <button class="layui-btn layui-btn-warm layui-btn-xs">分析中</button>
    {{#  } else if(d.demandStat == '2'){ }}
    <button class="layui-btn layui-btn-normal layui-btn-xs">开发中</button>
    {{#  } else if(d.demandStat == '3'){ }}
    <button class="layui-btn layui-btn-primary layui-btn-xs">已完成</button>
    {{#  } else if(d.demandStat == '4'){ }}
    <button class="layui-btn layui-btn-primary layui-btn-xs">已上线</button>
    {{#  } }}
</script>

<script type="text/html" id="priority">
    {{#  if(d.priority == '0'){ }}
    <button class="layui-btn layui-btn-primary layui-btn-xs">低</button>
    {{#  } else if(d.priority == '1'){ }}
    <button class="layui-btn layui-btn-warm layui-btn-xs">中</button>
    {{#  } else if(d.priority == '2'){ }}
    <button class="layui-btn layui-btn-danger layui-btn-xs">高</button>
    {{#  } }}
</script>

<script>
    layui.use(['jquery', 'table', 'form', 'flow', 'laydate'], function () {
        var $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer
            ,flow = layui.flow
            ,layedit = layui.layedit
            ,table = layui.table
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        getTableData('');

        //监听头工具栏事件
        table.on('toolbar(demandEvent)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id)
                , data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.msg('添加');
                    break;
                case 'update':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else if (data.length > 1) {
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.alert('编辑 [id]：' + checkStatus.data[0].id);
                    }
                    break;
                case 'delete':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
            }
            ;
        });

        table.on('tool(demandEvent)',function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                window.location.href = '/html/demand/demandInfo.jsp'+'?id=' + data.id + '&demandId=' + data.demandId;
            }else if(obj.event === 'del'){
                layer.confirm('真的删除么', function(index){
                    $.ajax({
                        url: "/demandTrack/delDemandTrack",
                        data: JSON.stringify(data),
                        type: "POST",
                        dataType: 'json',
                        contentType : 'application/json',
                        success: function (result) {
                            layer.msg(result.msg);
                        }
                    });
                    obj.del();
                });
            } else if(obj.event === 'edit'){
                window.location.href = '/html/demand/demandAdd.jsp'+'?id=' + data.id + '&demandId=' + data.demandId;
            }
        });

        // 加载受理人信息
        flow.load({
            elem: '#demandRespoId' //指定列表容器
            ,done: function(page, next){ //到达临界点（默认滚动触发），触发下一页
                var lis = [];
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                $.ajax({
                    url:'/user/getProjectUserList',
                    type: "POST",
                    success:function(res){
                        //假设你的列表返回在data集合中
                        layui.each(res.data, function(index, item){
                            lis.push('<option value=' + item.userId + '>'+ item.userName +'</option>');
                        });
                        //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                        //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                        next(lis.join(''), page < res.pages);
                        form.render();
                    }});
            }
        });


        //监听搜索
        form.on('submit(demandSearch)', function(data){
            getTableData(data.field);
            return false;
        });

        $('#demandAdd').click(function () {
            window.location.href = '/html/demand/demandAdd.jsp';
            return false;
        });


        function getTableData(data) {
            //第一个实例
            table.render({
                id: 'id'
                , elem: '#demandTable'
                ,url: '/demandTrack/getDemandTrackList' //数据接口
                ,method: 'POST'
                ,where:{
                    demandId : data.demandId
                    ,demandName : data.demandName
                    ,demandStat : data.demandStat
                    ,demandRespoId : data.demandRespoId
                    , versionNum: data.versionNum
                    ,userId:'${user.userId}'
                }
                ,page: true //开启分页
                , toolbar: '#toolbarHead' //开启工具栏
                ,cols: [[ //表头
                    {field: 'demandId', title: '需求编号', width: 150}
                    , {field: 'projectName', title: '归属项目', width: 200}
                    , {field: 'demandName', title: '需求名称', width: 350}
                    , {field: 'versionNum', title: '版本号', align: 'center', width: 80}
                    , {field: 'demandProgress', title: '进度', align: 'center', width: 150, templet: '#progressTpl'}
                    , {field: 'demandStat', title: '状态', align: 'center', width: 80, templet: '#status'}
                    , {field: 'plannedFinishDate', title: '计划完成日期', align: 'center', width: 120}
                    , {field: 'plannedOnlineDate', title: '计划上线日期', align: 'center', width: 120}
                    , {field: 'demandDepartmant', title: '提出部门', align: 'center', width: 100}
                    , {field: 'demandMaker', title: '提交人', align: 'center', width: 80}
                    , {field: 'userName', title: '受理人', align: 'center', width: 90, sort: true}
                    , {field: 'priority', title: '优先级', align: 'center', width: 80, templet: '#priority'}
                    , {field: '', title: '操作', align: 'center', width: 170, toolbar: '#toolbar', fixed: 'right'}
                ]]
                ,response: {
                    statusName: 'code'
                    ,statusCode: '100'
                    ,msgName: 'msg'
                    ,countName: 'total'
                    ,dataName: 'data'
                }
            });
        }
    });


</script>

</body>
</html>
