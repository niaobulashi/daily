<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改密码</title>
    <jsp:include page="/html/default/pub.jsp" />
    <link href="/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 搭建显示页面 -->
<div class="container">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <!--  密码修改页面-->
            <div class="modal-dialog" role="document">
                <div>
                    <div>
                        <form class="form-horizontal">
                            <div class="form-group" style="padding-top: 20px">
                                <label class="col-sm-2 control-label">原密码:</label>
                                <div class="col-sm-8" >
                                    <input type="text" name="userName" class="form-control" id="old_password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">新密码:</label>
                                <div class="col-sm-8" >
                                    <input type="text" name="userName" class="form-control" id="new_password" onkeydown="return noBlank(event)">
                                </div>
                                <span id="new_password_prompt">6-16位英文字母和数字的字符串</span>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">确认新密码:</label>
                                <div class="col-sm-8" >
                                    <input type="text" name="userName" class="form-control" id="confirm_password">
                                    <span id="confirm_password_prompt"></span>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div style="padding-top: 15px;text-align: center">
                        <button class="layui-btn" id="confirm_update" >确认修改</button>
                        <%--<button type="button" class="btn btn-primary" id="confirm_update">确认修改</button>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 按钮 -->
</div>
<script type="text/javascript">

    function noBlank(e) {
        var keynum;
        var keychar;
        var numcheck;

        if(window.event) // IE
        {
            keynum = e.keyCode
        }
        else if(e.which) // Netscape/Firefox/Opera
        {
            keynum = e.which
        }
        keychar = String.fromCharCode(keynum);
        numcheck = /\s+/g;
        return !numcheck.test(keychar);
    }

    $("#confirm_update").click(function () {
        if (!validate_update_form()) {
            return false;
        }
        var userId = "${user.userId}";
        var confirmPassword = $("#confirm_password").val();
        var oldPassword = $("#old_password").val();
        //发送ajax请求修改密码
        $.ajax({
            url: "/user/updatePasswprd",
            type: "POST",
            data: {"userId":userId,"password":confirmPassword,"oldPassword":oldPassword},
            success: function (result) {
                if (result.code == "100") {
                    parent.open();
                }else if(result.code == 200){
                    layer.msg("原密码输入错误!");
                }
            }
        });
    })

    //校验表单数据
    function validate_update_form() {
        //1、拿到要校验的数据，使用正则表达式
        var oldPassword = $("#old_password").val();
        var newPassword = $("#new_password").val();
        var confirmPassword = $("#confirm_password").val();
        var regName = /^[A-Za-z]+[0-9]+[A-Za-z0-9]*|[0-9]+[A-Za-z]+[A-Za-z0-9]*$/g;
        if (oldPassword.length < 1) {
            layer.msg("原密码不能为空!");
            return false;
        }
        if (!regName.test(newPassword)) {
            layer.msg("密码必须由6-16位英文字母和数字的字符串组成!");
            return false;
        }
        if (newPassword != confirmPassword) {
            layer.msg("两次密码输入不一致!");
            return false;
        }
        return true;
    }

</script>
</body>
</html>