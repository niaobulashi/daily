<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>项目成员列表</title>
    <jsp:include page="/html/default/pub.jsp"/>
    <link href="/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
        .layui-table-cell {
            height: 38px;
        }

        .layui-form-select dl {
            position: fixed;
            top: initial;
            left: initial;
            min-width: 180px;
        }
    </style>
</head>
<body>
<div class="layui-card">
    <div class="layui-card-header">
        <!-- 搭建显示页面 -->
        <div class="layui-form-item">
            <div class="layui-inline">
                <button class="layui-btn" onclick="history.go(-1)">返回</button>
            </div>
            <div class="layui-inline">
                <input type="text" id="user-name" autocomplete="off" placeholder="请输入姓名" class="layui-input">
            </div>
            <div class="layui-inline">
                <button class="layui-btn layui-btn-normal" id="user_search_btn" lay-filter="user_search_btn">搜索
                </button>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <button class="layui-btn layui-btn-danger" id="user_save_btn" data-type="getCheckData">保存</button>
            </div>
        </div>
    </div>
    <!-- 显示表格数据 -->
    <div class="layui-card-body">
        <table id="projectAddUser" class="layui-table" lay-filter="projectAddUserEvent"></table>
    </div>
</div>

<script type="text/html" id="checkboxTpl">
    <!-- 这里的 checked 的状态只是演示 -->
    <select id='selectRoles' name="selectRoles" lay-filter={{d.userId}}>
        <option value="">请选择</option>
    </select>

</script>

<script type="text/javascript">
    layui.use(['jquery', 'table', 'form', 'flow', 'laydate'], function () {
        var projectId = (window.location.search).split("=")[1];
        var $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer
            , flow = layui.flow
            , layedit = layui.layedit
            , table = layui.table
            , laydate = layui.laydate;
        var map = {};

        $(getProjectRoles());

        //获取项目角色，重新定义模板
        function getProjectRoles() {
            ele = document.getElementById('checkboxTpl').innerHTML;
            $.ajax({
                url: "/role/getSpecificRoles",
                data: {roleType: "00"},
                type: "POST",
                async: false,
                success: function (result) {
                    //显示角色信息在下拉列表中
                    $.each(result.data, function () {
                        var optionEle = "<option value='" + this.roleId + "'>" + this.roleName + "</option>";
                        var before = ele.split('</select>')[0];
                        var after = ele.split('</select>')[1];
                        ele = before + optionEle;
                    });
                    ele = ele + '</select>';
                    document.getElementById('checkboxTpl').innerHTML = ele;
                }
            });
        }

        //监听select选择，将select选择存在map里
        form.on('select()', function (obj) {
            var value = obj.value;
            var id = obj.elem.attributes.getNamedItem("lay-filter").value;
            map[id] = value;
        });

        //监听保存按钮，保存项目成员
        $('#user_save_btn').on('click', function () {
            var type = $(this).data('type');
            active[type].call(this);
        });

        //保存项目成员
        var active = {
            getCheckData: function () { //获取选中数据
                var checkStatus = table.checkStatus('projectAddUser')
                    , data = checkStatus.data;
                var userNames = "";
                var save_idstr = "";
                var save_roleIds = "";
                //是否选择项目角色标记
                var flag = true;
                $.each(data, function () {
                    //this
                    userNames += this.userName + ",";
                    //组装员工id字符串
                    save_idstr += this.userId + "-";
                    //组装角色类型字符串
                    if (map[this.userId] == null || map[this.userId] == "") {
                        layer.msg("请选择" + this.userName + "所属项目角色!");
                        return flag = false;
                    } else {
                        save_roleIds += map[this.userId] + "-";
                    }
                });
                //项目角色都已选择，后台进行校验并新增
                if (flag) {
                    //去除userNames多余的,
                    userNames = userNames.substring(0, userNames.length - 1);
                    //去除save_idstr多余的-
                    save_idstr = save_idstr.substring(0, save_idstr.length - 1);
                    //去除save_roleTypes多余的-
                    save_roleIds = save_roleIds.substring(0, save_roleIds.length - 1);
                    if (userNames.length > 0) {
                        layer.confirm('确定添加吗？', {icon: 3, title: '确认信息'}, function (index) {
                            //确认，发送ajax请求删除即可
                            $.ajax({
                                url: "/project/projectUserSave",
                                type: "GET",
                                data: "ids=" + save_idstr + "&projectId=" + projectId + "&roleIds=" + save_roleIds,
                                success: function (result) {
                                    if (result.length > 0) {
                                        layer.msg(result[0].currentUserName + " 邮箱:" + result[0].currentUserEmail + "已经在" + result[0].projectName + "！");
                                    } else {
                                        //回到项目详情页
                                        window.history.back(-1);
                                    }

                                }
                            });
                        });
                    } else {
                        layer.msg("请选择用户！")
                    }
                }
            }
        };

        //根据用户名获取用户列表
        function search(userName) {
            table.render({
                elem: '#projectAddUser'
                , url: '/user/getUserInfoByUserName' //数据接口
                , where: {userName: userName}
                , page: true
                , cols: [[ //表头
                    {checkbox: true, fixed: true}
                    , {field: 'userName', title: '姓名', width: 200}
                    , {
                        field: 'gender', title: '性别', width: 150, templet: function (d) {
                            return d.gender == 0 ? "女" : "男"
                        }
                    }
                    , {field: 'email', title: '邮箱'}
                    , {field: 'mobile', title: '手机号', width: 210}
                    , {
                        field: 'projectRole',
                        title: '项目角色',
                        width: 200,
                        toolbar: '#checkboxTpl'
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
        };


        //点击搜索，查询用户列表
        $("#user_search_btn").click(function () {
            getTableData();
        });

        function getTableData() {

            userName = $('#user-name').val();
            if (userName == "") {
                userName = "*^~#)";
            }
            search(userName);
        }

        //监听用户名input的改变，查询用户列表
        $('#user-name').bind('input propertychange', function () {
            getTableData();
        });
    });


</script>
</body>
</html>