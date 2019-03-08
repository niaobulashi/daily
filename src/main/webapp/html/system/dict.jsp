<%--
  Created by IntelliJ IDEA.
  User: hulang
  Date: 2018/8/28
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>字典管理</title>
    <jsp:include page="/html/default/pub.jsp" />
</head>
<body>
<div class="layui-card">
    <div class="layui-form layui-card-header">
        <form>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">分类名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="kindName" id="kindName" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">CODE名称</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" id="name" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline" style="float:right">
                    <%--<button class="layui-btn" lay-submit lay-filter="codeTest">
                        <i class="layui-icon layui-icon-search"></i>&nbsp;测试
                    </button>--%>
                    <button class="layui-btn" lay-submit lay-filter="codeSearch">
                        <i class="layui-icon layui-icon-search"></i>&nbsp;搜索
                    </button>
                    <button class="layui-btn layui-btn-normal" type="reset">
                        <i class="layui-icon layui-icon-refresh"></i>&nbsp;重置
                    </button>
                    <button class="layui-btn layui-btn-warm" type="button" id="codeAdd">
                        <i class="layui-icon">&#xe654;</i>&nbsp;新增
                    </button>
                    <button class="layui-btn layui-btn-danger" type="button" id="codeDel" data-type="getCheckData">
                        <i class="layui-icon">&#xe640;</i>&nbsp;删除
                    </button>
                </div>
            </div>
        </form>
    </div>
    <div class="layui-card-body">
        <table id="codeTable" class="layui-table" lay-filter="codeEvent"></table>
    </div>
</div>
<script type="text/html" id="toolbar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use(['jquery','table','form'], function() {
        var $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,table = layui.table
            ,laydate = layui.laydate;


        getTableData('');

        function getTableData(data) {
            //第一个实例
            table.render({
                id: 'id'
                ,elem: '#codeTable'
                ,url: '/system/getCodeList' //数据接口
                ,method: 'POST'
                ,where:{
                    kindName : data.kindName
                    ,name : data.name
                }
                ,page: true //开启分页
                ,cols: [[ //表头
                    {field: 'kindCode', title: '分类编码', width:226, fixed: 'left'}
                    ,{field:'kindName', title: '分类名称', width:164, align:'left'}
                    ,{field: 'code', title: 'CODE编码', width:161, align:'left'}
                    ,{field:'name', title: 'CODE名称', width:241, align:'left'}
                    ,{field:'parentCode', title: '父级分类编码', align:'left', width: 203}
                    ,{field: 'displaySort', title: '排序', align: 'left',  width: 80}
                    ,{field: 'projectName', title: '所属项目', align: 'left',  width: 80}
                    , {field: '', title: '操作', align: 'center', width: 200, toolbar: '#toolbar'}
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

        //监听搜索
        form.on('submit(codeSearch)', function(data){
            getTableData(data.field);
            return false;
        });

        //测试
        form.on('submit(codeTest)', function(data){
            $.ajax({
                url: "/system/addCalendar",
                type: "POST",
                success: function (result) {
                    if (result.code == "100") {

                    } else {
                        layer.alert(result.msg);
                    }
                }
            });
        });

        //操作区
        table.on('tool(codeEvent)',function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                window.location.href = '/html/demand/demandInfo.jsp'+'?id=' + data.id + '&demandId=' + data.demandId;
            }else if(obj.event === 'del'){
                layer.confirm('真的删除么', function(index){
                    $.ajax({
                        url: "/system/delCode",
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
    });

    //点击新增
    $('#codeAdd').click(function () {
        //iframe层-父子操作
        layer.open({
            type: 2,
            area: ['700px', '350px'],
            fixed: false, //不固定
            maxmin: true,
            content: '/html/system/popDictAdd.jsp'
        });
    });

    //点击删除
    /*$('#codeDel').click(function () {

    });*/



</script>
</body>
</html>
