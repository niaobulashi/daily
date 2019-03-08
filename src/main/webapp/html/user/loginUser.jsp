<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>安全设置</title>
    <jsp:include page="/html/default/pub.jsp" />
    <link href="/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 员工修改的模态框 -->
<div class="modal fade" id="userUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">资料修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" name="userName" class="form-control" id="userName_update_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_update_input" value="1" checked="checked">
                                男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_update_input" value="0"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">身份证:</label>
                        <div class="col-sm-10">
                            <input type="text" name="identityNo" class="form-control" id="identityNo_update_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">手机号</label>
                        <div class="col-sm-10">
                            <input type="text" name="mobile" class="form-control" id="mobile_update_input">
                            <span class="help-block"></span>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="user_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>

<!-- 搭建显示页面 -->
<div class="container">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <!--  登录员工资料页面-->
            <div class="modal-dialog" role="document">
                <div>
                    <div>
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-5 control-label">姓名:</label>
                                <div class="col-sm-7" style="padding-top: 7px">
                                    <span name="userName" id="userName_input"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-5 control-label">性别:</label>
                                <div class="col-sm-7" style="padding-top: 7px">
                                    <span name="gender" id="gender_input"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-5 control-label">邮箱:</label>
                                <div class="col-sm-7" style="padding-top: 7px">
                                    <span name="email" id="email_input"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-5 control-label">身份证:</label>
                                <div class="col-sm-7" style="padding-top: 7px">
                                    <span name="identityNo" id="identityNo_input"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-5 control-label">部门角色:</label>
                                <div class="col-sm-7" style="padding-top: 7px">
                                    <span name="role" id="role_input"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-5 control-label">手机号:</label>
                                <div class="col-sm-7" style="padding-top: 7px">
                                    <span name="mobile" id="mobile_input"></span>
                                </div>
                            </div>

                        </form>
                        <div style="text-align: center">
                        <button class="layui-btn"   id="user_update_modal_btn" >修改资料</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!-- 按钮 -->
</div>
<script type="text/javascript">
    console.info(${user.projectName});
    console.info(${user.projectId});
    $(function () {
        getUser("${user.userId}");
    })

    function getUser(id) {
        $.ajax({
            url: "/user/selectUserById",
            data:{id:id,roleType:"01"},
            type: "POST",
            success: function (result) {
                var userData = result.extend.user;
                $("#userName_input").html(userData.userName);
                $("#email_input").text(userData.email);
                $("#gender_input").text([userData.gender == '1' ? "男" : "女"]);
                $("#mobile_input").html([userData.mobile]);
                $("#role_input").html([userData.roleName]);
                $("#identityNo_input").html([userData.identityNo]);

            }
        });
    }

    //获取用户信息，用于修改页面
    function getUserInfo(id) {
        $.ajax({
            url: "/user/selectUserById",
            data:{id:id,roleType:"01"},
            type: "POST",
            success: function (result) {
                var userData = result.extend.user;
                $("#userName_update_input").val(userData.userName);
                $("#userUpdateModal input[name=gender]").val([userData.gender]);
                $("#mobile_update_input").val([userData.mobile]);
                $("#identityNo_update_input").val([userData.identityNo]);
                //把员工的id传递给模态框的更新按钮
                $("#user_update_btn").attr("edit-id", id);
            }
        });
    }

    //点击修改按钮弹出模态框。
    $("#user_update_modal_btn").click(function () {
        //清除表单数据（表单完整重置（表单的数据，表单的样式））
        reset_form("#userUpdateModal form");
        getUserInfo("${user.userId}");
        //弹出模态框
        $("#userUpdateModal").modal({
            backdrop: "static"
        });
    });

    //清空表单样式及内容
    function reset_form(ele) {
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }

    //点击更新，更新员工信息
    $("#user_update_btn").click(function () {
        //1、拿到要校验的数据，使用正则表达式
        var userName = $("#userName_update_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if (!regName.test(userName)) {
            //alert("用户名可以是2-10位中文或者6-10位英文和数字的组合");
            show_validate_msg("#userName_update_input", "error", "用户名可以是2-10位中文或者6-10位英文和数字的组合");
            return false;
        } else {
            show_validate_msg("#userName_update_input", "success", "");
        }

        //2、发送ajax请求保存更新的员工数据
        $.ajax({
            url: "/user/update/" + $(this).attr("edit-id")+"/"+ "-1",
            type: "PUT",
            data: $("#userUpdateModal form").serialize(),
            success: function (result) {
                //1、关闭对话框
                $("#userUpdateModal").modal("hide");
                //2、刷新页面
                getUser("${user.userId}");

            }
        });
    });

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
</script>
</body>
</html>