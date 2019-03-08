<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户列表</title>
    <jsp:include page="/html/default/pub.jsp"/>
    <link href="/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/bootstrap/js/bootstrap.min.js"></script>
    <link href="/js/jquery/tree/jquery.treeview.css" rel="stylesheet">
    <script src="/js/jquery/tree/jquery.treeview.js"></script>
</head>
<body>
<div class="layui-card">
    <div class="layui-card-header">
        <!-- 角色修改的模态框 -->
        <div class="modal fade" id="roleUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title">用户修改</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">角色类型</label>
                                <div class="col-sm-10">
                                    <select id="roleTypeSelectUpdate" class="form-control" name="roleType">
                                        <option value="00">项目角色</option>
                                        <option value="01">部门角色</option>
                                    </select>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">角色名称</label>
                                <div class="col-sm-10">
                                    <input type="text" name="roleName" class="form-control" id="roleName_update_input">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">角色描述</label>
                                <div class="col-sm-10">
                                    <input type="text" name="description" class="form-control"
                                           id="description_update_input">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="role_update_btn">更新</button>
                    </div>
                </div>
            </div>
        </div>


        <!-- 角色添加的模态框 -->
        <div class="modal fade" id="roleAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">角色添加</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">角色类型</label>
                                <div class="col-sm-10">
                                    <select id="roleTypeSelectAdd" class="form-control" name="roleType">
                                        <option value="00">项目角色</option>
                                        <option value="01">部门角色</option>
                                    </select>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">角色名称</label>
                                <div class="col-sm-10">
                                    <input type="text" name="roleName" class="form-control" id="roleName_add_input">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">角色描述</label>
                                <div class="col-sm-10">
                                    <input type="text" name="description" class="form-control"
                                           id="description_add_input">
                                    <span class="help-block"></span>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="role_save_btn">保存</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 权限列表的模态框 -->
        <div class="modal fade" id="privilegeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title">设置权限</h4>
                    </div>
                    <div class="modal-body">
                        <div class="tree">
                            <ui class="navigation">

                            </ui>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="privilege_save_btn">保存</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 按钮 -->
        <button class="layui-btn" id="role_add_modal_btn" privilege-id="6">新增</button>


    </div>
    <div class="layui-card-body">
        <table id="roles_table" class="layui-table" lay-filter="rolesManaEvent"></table>
    </div>
</div>


<script type="text/html" id="toolbar">
    {{# if(privilegeList.indexOf(7) != -1){}}
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    {{# } }}
    {{# if(privilegeList.indexOf(8) != -1){}}
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    {{# } }}
    {{# if(privilegeList.indexOf(9) != -1){}}
    <a class="layui-btn  layui-btn-xs layui-btn-normal" lay-event="privilege">设置权限</a>
    {{# } }}
</script>

<script type="text/javascript">

    var totalRecord, currentPage;
    //获取当前用户的权限列表
    var privilegeList = ${user.privilegeList};
    //根据权限列表判断是否显示
    if (privilegeList.indexOf(6) == -1) {
        $("#role_add_modal_btn").hide();
    }

    layui.use('table', function () {
        var table = layui.table,
            layer = layui.layer,//弹层
            laypage = layui.laypage;


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

        function search(page, limit) {
            table.render({
                elem: '#roles_table'
                , url: '/role/getRoles' //数据接口
                , page: {
                    layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
                    , curr: page //设定初始在第 1 页
                    , limit: limit
                    , groups: 5 //只显示 5 个连续页码
                }
                , cols: [[ //表头
                    {field: 'roleName', title: '角色名称', width: 169}
                    , {field: 'description', title: '角色描述', width: 175}
                    , {
                        field: 'roleType', title: '角色类型', width: 150, templet: function (d) {
                            return d.roleType == 01 ? "部门角色" : "项目角色"
                        }
                    }
                    , {
                        field: 'createTime', title: '创建日期', align: 'center', width: 200, templet: function (d) {
                            return d.createTime == null ? "" : new Date(d.createTime).Format("yyyy-MM-dd")
                        }
                    }
                    , {
                        field: 'updateTime', title: '修改日期', align: 'center', width: 200, templet: function (d) {
                            return d.updateTime == null ? "" : new Date(d.updateTime).Format("yyyy-MM-dd")
                        }
                    }
                    , {field: 'dosomething', title: '操作', align: 'center', toolbar: '#toolbar'}
                ]]
                , response: {
                    statusName: 'code'
                    , statusCode: '100'
                    , msgName: 'msg'
                    , countName: 'total'
                    , dataName: 'data'
                }
            });

            table.on('tool(rolesManaEvent)', function (obj) {
                var data = obj.data;
                if (obj.event === 'del') {
                    // layer.confirm('真的删除行么', function (index) {
                    //     obj.del();
                    //     layer.close(index);
                    // });
                    deleteRole(data.roleName, data.roleId);
                } else if (obj.event === 'edit') {
                    editRole(data.roleId);
                } else if (obj.event === 'privilege') {
                    editPrivilege(data.roleId);
                }
            });
        }

    });

    //清空表单样式及内容
    function reset_form(ele) {
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }

    //点击新增按钮弹出模态框。
    $("#role_add_modal_btn").click(function () {
        //清除表单数据（表单完整重置（表单的数据，表单的样式））
        reset_form("#roleAddModal form");
        //弹出模态框
        $("#roleAddModal").modal({
            backdrop: "static"
        });
    });

    //校验表单数据
    function validate_add_form() {
        //1、拿到要校验的数据，使用正则表达式
        var roleName = $("#roleName_add_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,10})/;
        if (!regName.test(roleName)) {
            // alert("角色名称可以是2-10位中文或者6-16位英文和数字的组合");
            show_validate_msg("#roleName_add_input", "error", "角色名可以是2-10位中文或者6-16位英文和数字的组合");
            return false;
        } else {
            show_validate_msg("#roleName_add_input", "success", "");
        }
        return true;
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

    //校验角色名是否可用
    $("#roleName_add_input").change(function () {
        //发送ajax请求校验角色名是否可用
        var roleName = this.value;
        $.ajax({
            url: "/role/roleCheck",
            data: "roleName=" + roleName,
            type: "POST",
            success: function (result) {
                if (result.code == "100") {
                    show_validate_msg("#roleName_add_input", "success", "角色名可用");
                    $("#role_save_btn").attr("ajax-va", "success");
                } else {
                    show_validate_msg("#roleName_add_input", "error", result.extend.va_msg);
                    $("#role_save_btn").attr("ajax-va", "error");
                }
            }
        });
    });

    //校验修改角色名是否可用
    $("#roleName_update_input").change(function () {
        //发送ajax请求校验角色名是否可用
        var roleName = this.value;
        var hideName = $("#hideName").html();
        $.ajax({
            url: "/role/roleCheck",
            data: "roleName=" + roleName,
            type: "POST",
            async: false,
            success: function (result) {
                if (result.code == "100") {
                    show_validate_msg("#roleName_update_input", "success", "角色名可用");
                    $("#role_update_btn").attr("ajax-va", "success");
                } else {
                    if (hideName == roleName) {
                        show_validate_msg("#roleName_update_input", "success", "角色名可用");
                        $("#role_update_btn").attr("ajax-va", "success");
                    } else {
                        show_validate_msg("#roleName_update_input", "error", result.extend.va_msg);
                        $("#role_update_btn").attr("ajax-va", "error");
                    }
                }
            }
        });
    });

    //点击保存，保存角色。
    $("#role_save_btn").click(function () {
        // 1、先对要提交给服务器的数据进行校验
        if (!validate_add_form()) {
            return false;
        }
        //1、判断之前的ajax用户名校验是否成功。如果成功。
        if ($(this).attr("ajax-va") == "error") {
            show_validate_msg("#roleName_add_input", "error", "角色名不可用");
            $("#role_save_btn").attr("ajax-va", "error");
            return false;
        }

        //2、发送ajax请求保存员工
        $.ajax({
            url: "/role/save",
            type: "POST",
            data: $("#roleAddModal form").serialize(),
            success: function (result) {
                //alert(result.msg);
                if (result.code == "100") {
                    //用户保存成功；
                    //1、关闭模态框
                    $("#roleAddModal").modal('hide');

                    //2、来到最后一页，显示刚才保存的数据
                    //发送ajax请求显示最后一页数据即可
                    to_page(totalRecord);
                } else {
                    //显示失败信息
                    //console.log(result);
                    //有哪个字段的错误信息就显示哪个字段的；
                    if (undefined != result.extend.errorFields.empName) {
                        //显示角色名字的错误信息
                        show_validate_msg("#roleName_add_input", "error", result.extend.errorFields.roleName);
                    }
                }
            }
        });
    });


    function editRole(roleId) {
        //清空表单样式
        $('#roleUpdateModal form').find("*").removeClass("has-error has-success");
        $('#roleUpdateModal form').find(".help-block").text("");
        //1、查出用户信息，显示用户信息
        getRole(roleId);

        //2、把角色的id传递给模态框的更新按钮
        $("#role_update_btn").attr("edit-id", roleId);
        $("#roleUpdateModal").modal({
            backdrop: "static"
        });
    };

    function getRole(id) {
        $.ajax({
            url: "/role/getRoleById/" + id,
            type: "GET",
            success: function (result) {
                //console.log(result);
                var roleData = result.extend.role;
                $("#roleName_update_input").val(roleData.roleName);
                $("#description_update_input").val([roleData.description]);
                $("#roleTypeSelectUpdate").val(roleData.roleType);
                $("#hideName").remove();
                $("#roleTypeSelectUpdate").after($("<span></span>").attr("id", "hideName").html(roleData.roleName));
                $("#hideName").hide();
            }
        });
    }

    //点击更新，更新角色信息
    $("#role_update_btn").click(function () {
        //1、拿到要校验的数据，使用正则表达式
        var roleName = $("#roleName_update_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,10})/;
        if (!regName.test(roleName)) {
            // alert("角色名称可以是2-10位中文或者6-16位英文和数字的组合");
            show_validate_msg("#roleName_add_input", "error", "角色名可以是2-10位中文或者6-16位英文和数字的组合");
            return false;
        } else {
            show_validate_msg("#roleName_add_input", "success", "");
        }

        //1、判断之前的ajax用户名校验是否成功。如果成功。
        if ($(this).attr("ajax-va") == "error") {
            return false;
        }

        //2、发送ajax请求保存更新的角色数据
        $.ajax({
            url: "/role/update/" + $(this).attr("edit-id"),
            type: "PUT",
            data: $("#roleUpdateModal form").serialize(),
            success: function (result) {
                //1、关闭对话框
                $("#roleUpdateModal").modal("hide");
                layer.msg("更新成功!");
                //2、回到本页面
                to_page(currentPage);
            }
        });
    });

    //单个删除
    function deleteRole(roleName, roleId) {
        //1、弹出是否确认删除对话框
        // var roleName = $(this).parents("tr").find("td:eq(0)").text();
        // var roleId = $(this).attr("del-id");
        layer.confirm("确认删除【" + roleName + "】吗？", {icon: 3, title: '确认信息'}, function (index) {
            //确认，发送ajax请求删除即可
            $.ajax({
                url: "/role/delete/" + roleId,
                type: "DELETE",
                success: function (result) {
                    layer.msg(result.msg);
                    //回到本页
                    to_page(currentPage);
                }
            });
        })
    };

    //设置权限按钮绑定点击事件
    function editPrivilege(roleId) {
        //清空内容
        $(".tree .navigation").empty();
        //1、查出权限信息，显示权限信息
        getPrivilege(roleId);

        //2、把角色的id传递给模态框的保存按钮
        $("#privilege_save_btn").attr("role-id", roleId);
        $("#privilegeModal").modal({
            backdrop: "static"
        });
    };

    //查出所有的部门信息并显示在下拉列表中
    function getPrivilege(roleId) {
        $.ajax({
            url: "/privilege/getPrivileges",
            type: "GET",
            success: function (result) {
                var privileges = result.extend.resultList;
                init_node(privileges, roleId);
            }
        });
    }

    //查询角色的权限信息
    function getPrivilegeByRoleId(roleId) {
        $.ajax({
            url: "/rolePrivilege/getPrivileges",
            type: "GET",
            data: {roleId: roleId},
            success: function (data) {
                var privileges = data.extend.resultList;
                for (var i = 0; i < privileges.length; i++) {
                    $(".tree .navigation input[data-auth='" + privileges[i].privilegeId + "']").prop("checked", "true");
                }
            }
        })
    }

    //一级节点
    function init_node(privileges, roleId) {
        if (privileges != null) {
            for (var i = 0; i < privileges.length; i++) {
                if (privileges[i].parentId == null) {
                    var _html = '<li treeId="' + privileges[i].privilegeId + '" treeName="' + privileges[i].name + '" >&nbsp;&nbsp;<input  type="checkbox" data-auth="' + privileges[i].privilegeId + '" /><a href="javascript:void(0);" > ' + privileges[i].name + '</a></li>';
                    ;
                    $(".tree .navigation").append(_html);
                    init_subNode(privileges[i].privilegeId, privileges);
                }
            }
            //查询角色的权限信息，置为选中状态
            getPrivilegeByRoleId(roleId);
            init_tree();
        }
    }

    //子级节点
    function init_subNode(_id, privileges) {
        var _flag = true;
        var _parentObj = $('li[treeId="' + _id + '"]');
        for (var i = 0; i < privileges.length; i++) {
            if (privileges[i].parentId == _id) {
                if (_flag == true) {
                    $(_parentObj).append("<ul></ul>");
                    _flag = false;
                }
                var _html = '<li treeId="' + privileges[i].privilegeId + '" treeName="' + privileges[i].name + '" >&nbsp;&nbsp;<input  type="checkbox" data-auth="' + privileges[i].privilegeId + '" /><a href="javascript:void(0);" > ' + privileges[i].name + '</a></li>';
                ;
                $("ul:eq(0)", _parentObj).append(_html);
                init_subNode(privileges[i].privilegeId, privileges);
            }
        }
    }

    //树形初始化
    function init_tree() {
        $(".tree .navigation").treeview({
            persist: "location",
            collapsed: true,
            unique: true
        });
        initTreeChecked();
    }

    function initTreeChecked() {
        $(".tree .navigation input[type='checkbox']").click(function () {
            var pChk = this.checked;
            //当选中或取消一个权限时，也同时选中或取消所有的下级权限
            $(this).siblings("ul").find("input").each(function (index, ele) {
                ele.checked = pChk
            });

            //当选中一个权限时，也要选中所有的直接上级权限
            if (this.checked == true) {
                $(this).parents("li").children("input").each(function (index, ele) {
                    ele.checked = true;
                })
            }
        });
    }

    //点击保存，保存权限设置
    $("#privilege_save_btn").click(function () {
        var privileges = [];
        $(".tree .navigation input[type='checkbox']:checked").each(function (index, ele) {
            privileges.push($(ele).attr("data-auth"));
        });
        console.info(privileges);
        //2、发送ajax请求保存权限数据
        $.ajax({
            url: "/rolePrivilege/savePrivilege",
            type: "POST",
            data: {roleId: $("#privilege_save_btn").attr("role-id"), privilegeList: privileges, aa: 'eeee'},
            traditional: true,
            success: function (result) {
                layer.msg(result.msg);
                // 1、关闭对话框
                $("#privilegeModal").modal("hide");
            }
        });
    });

</script>
</body>
</html>