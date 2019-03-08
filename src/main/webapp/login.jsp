<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/css/login.css">
    <title>项目管理系统登录</title>
    <link rel="icon" href="/static/image/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="/static/image/favicon.ico" type="image/x-icon"/>
    <jsp:include page="/html/default/pub.jsp" />
    <script type="text/javascript" src="/js/common/inputSuggest.js" charset="utf-8"></script>
    <script src="/js/common/jsencrypt.min.js"></script>
</head>
<body>
<section class="top1">
    <div class="top1-1">
        <div class="logo1"></div>
    </div>
</section>
<section class="top2">
    <div class="top2-1">
        <div class="top2-3"></div>
        <div class="top2-2">
            <div class="top2-4"></div>
            <div class="layui-input2">
                <input type="text" id="email" name="title" onblur="checkEmail()" lay-verify="title" autocomplete="off" required placeholder="请输入邮箱" class="layui-input">
            </div>
            <div class="top2-5"></div>
            <div class="layui-input2">
                <input type="password" id="password" name="password" lay-verify="title" autocomplete="off" required placeholder="请输入密码" class="layui-input">
            </div>
            <div class="top2-6" id='error'></div>
            <div class="login"><button id="login" class="layui-btn layui-btn-normal loginbuttonwidth">登录</button></div>
            <div class="top2-7"></div>
            <div class="top2-8"><a class="zi1">忘记密码？</a></div>
        </div>
    </div>
</section>
<section class="top3">
    <div class="top3-1">
        <div class="top3-2">项目管理系统</div>
        <a href="http://www.miitbeian.gov.cn/"><div class="top3-3">CopyRight Ⓒ 2018 </div></a>
    </div>
</section>
</body>
<script type="text/javascript">
    var reg= /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    // 输入提示邮箱后缀
    $(function() {
        var sinaSuggest = new InputSuggest({
            opacity: 1,
            input: document.getElementById('email'),
            data: ['adtec.com.cn']
        });
    });

    // 校验输入邮箱
    function checkEmail() {
        var email = $("#email").val();
        if (!email) {
            $("#error").text("邮箱不能为空");
        } else {
            if (!reg.test(email)) {
                $("#error").text("邮箱格式不正确");
            } else {
                $("#error").text("");
            }
        }
    }

    // 在密码输入框回车
    $('#password').bind('keyup', function(event) {
        if (event.keyCode == "13") {
            //回车执行查询
            login();
        }
    });

    // 点击登陆
    $(document).on("click","#login",function () {
            login();
        }
    );

    // 用户登录
    function login() {
        var reg= /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
        var email = $("#email").val();
        var password = $("#password").val();
        if (!email) {
            $("#error").text("邮箱不能为空");
            return false;
        } else {
            if (!reg.test(email)) {
                $("#error").text("邮箱格式不正确");
                return false;
            } else {
                $("#error").text("");
            }
        }
        if (!password) {
            $("#error").text("密码不能为空");
            return false;
        }

            var publicKey;
            //获取公钥
            $.ajax({
                url: "/user/getPublicKey",
                async:false,
                success: function (result) {
                    publicKey = result.extend.publicKey;
                }
            });
            var encrypt = new JSEncrypt();
            encrypt.setPublicKey(publicKey);
            var encrypted = encrypt.encrypt(password);
            if (email) {
                $.ajax({
                    url: "/user/userLogin",
                    data: {"email": email, "password": encrypted,"encrypted":encrypted},
                    type: "POST",
                    dataType:"json",
                    success: function (result) {
                        if (result.code == 100) {
                            window.location.href="/index.jsp";
                        } else {
                            $("#error").text("");
                            $("#error").text("用户名或密码错误");
                        }
                    }
                });
            }
    };
</script>
</html>
