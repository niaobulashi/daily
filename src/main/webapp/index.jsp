<%--
  Created by IntelliJ IDEA.
  User: 11111
  Date: 2018/3/26
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>项目管理系统</title>
    <link rel="icon" href="/static/image/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="/static/image/favicon.ico" type="image/x-icon"/>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="/js/jquery/jquery-3.3.1.min.js" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="/js/layui/css/layui.css" />
    <style type="text/css">
        a:link {text-decoration: none;}  a:visited {text-decoration: none;}  a:hover {text-decoration: none;}  a:active {text-decoration: none;}
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">项目管理系统</div>
        <ul class="layui-nav layui-layout-left">
            <%--<li class="layui-nav-item"><a href="">控制台</a></li>--%>
            <%--<li class="layui-nav-item"><a href="">商品管理</a></li>--%>
            <%--<li class="layui-nav-item"><a href="">用户</a></li>--%>
            <%--<li class="layui-nav-item"><a href="javascript:;">其它系统</a>--%>
                <%--<dl class="layui-nav-child">--%>
                    <%--<dd>--%>
                        <%--<a href="">邮件管理</a>--%>
                    <%--</dd>--%>
                    <%--<dd>--%>
                        <%--<a href="">消息管理</a>--%>
                    <%--</dd>--%>
                    <%--<dd>--%>
                        <%--<a href="">授权管理</a>--%>
                    <%--</dd>--%>
                <%--</dl></li>--%>
        </ul>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right" lay-filter="menu">
            <li id='' class="layui-nav-item">
                <a href="javascript:;">
                    <img src="/static/image/tx.jpg" class="layui-nav-img">
                    ${user.userName}
                </a>
                <dl class="layui-nav-child">
                    <dd style="line-height: 36px"><a href="javascript:;" id="S00106" name="html/user/loginUser.jsp"
                                                     levId="S00106">基本资料</a></dd>
                    <dd style="line-height: 36px"><a href="javascript:;" id="S00107" name="/html/user/changePassword.jsp"
                                                     levId="S00107">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" ><a href="" id="exit" name="exit" levId="">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航-菜单缩放按钮 -->
            <div title="菜单缩放" class="kit-side-fold">
                <li class="layui-icon layui-icon-shrink-right" id="flexible" aria-hidden="true"></li>
            </div>
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree " lay-filter="menu">
                <c:if test="${not empty menus}">
                    <c:forEach items="${menus}" var="topMenu">
                        <li class="layui-nav-item hidden menu">
                            <a href="javascript:;" id="${topMenu.key.privilegeId}" name="${topMenu.key.url}"
                               levId="${topMenu.key.parentId}"
                               class="layui-icon ${topMenu.key.menuImage}">
                                <span class="oneMenu">${topMenu.key.name}</span></a>
                            <c:if test="${not empty topMenu.value}">
                                <dl class="layui-nav-child">
                                    <c:forEach items="${topMenu.value}" var="childMenu">
                                        <dd class=""><a href="javascript:void(0);" id="${childMenu.privilegeId}"
                                                        name="${childMenu.url}"
                                                        levId="${childMenu.parentId}">${childMenu.name}</a></dd>
                                    </c:forEach>
                                </dl>
                            </c:if>
                        </li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>
    </div>

    <div class="layui-body" style="bottom: 0px;">
        <!-- 内容主体区域 -->
        <div class="layui-tab" lay-allowClose="true" lay-filter="tab-switch">
            <ul class="layui-tab-title"></ul>
            <div class="layui-tab-content"></div>
        </div>

    </div>

    <!--<div class="layui-footer">-->
    <!--&lt;!&ndash; 底部固定区域 &ndash;&gt;-->
    <!--© layui.com - 底部固定区域-->
    <!--</div>-->

</div>

<script src="/js/layui/layui.all.js"></script>
<script type="text/javascript">
    $('.menu').click(function() {
        $(this).siblings().removeClass('layui-nav-itemed');
    });

    layui.use(['element', 'jquery'], function () {
        var element = layui.element,
            $ = layui.jquery;

         /*
        也可以通过class属性达到隐藏元素的目的
        class="layui-hide"

         */

        addTab('首页', 'html/about/home.jsp', '65');
        element.tabChange('tab-switch', "65"); //切换到新增的tab上

        //监听菜单点击
        element.on('nav(menu)', function (elem) {
            var levId = elem[0].attributes[3].nodeValue;
            console.info(levId);
            if (levId == null || levId == "") {
                if (elem[0].name == null || elem[0].name == "" || elem[0].name == "exit") {
                    return;
                } else {
                    addTab(elem[0].innerText, elem[0].attributes[2].nodeValue, elem[0].id);
                }
            } else {
                addTab(elem[0].innerText, elem[0].attributes[2].nodeValue, elem[0].id);
                layui.each($(".layui-nav-child"), function () {
                    $(this).find("dd").removeClass("layui-this");
                });
                var ele = '#' + elem[0].id;
                $(ele).parent().addClass( "layui-this");
            }
        });
        //监听tab选项卡切换
        element.on('tab(tab-switch)', function (data) {
            if (data.elem.context.attributes != undefined) {
                var id = data.elem.context.attributes[0].nodeValue;
                layui.each($(".layui-nav-child"), function () {
                    $(this).find("dd").removeClass("layui-this");
                });layui.each($(".layui-nav-item"),function(){
                    $(this).removeClass("layui-this");
                })
                var ele = '#' + id;
                $(ele).parent().addClass( "layui-this");
            }
        });
        //注销返回登录界面
        $(document).on("click", "#exit", function () {
            $.ajax({
                url: "/user/userExit",
                type: "POST",
                dataType: "json",
                success: function (result) {
                    if (result.code == "100") {
                        window.location.href = "/login.jsp";
                    } else {
                        window.location.href = "/login.jsp";
                    }
                }
            });
        })

        /**
         * 新增tab选项卡，如果已经存在则打开已经存在的，不存在则新增
         * @param tabTitle 选项卡标题名称
         * @param tabUrl 选项卡链接的页面URL
         * @param tabId 选项卡id
         */
        function addTab(tabTitle, tabUrl, tabId) {
            if ($(".layui-tab-title li[lay-id=" + tabId + "]").length > 0) {
                element.tabChange('tab-switch', tabId);
            } else {
                element.tabAdd('tab-switch', {
                    title: tabTitle,
                    content: '<iframe id="mainiframe" src=' + tabUrl + ' frameborder="0" scrolling="auto" ' +
                        'style="overflow: hidden;overflow-x: hidden;overflow-y: hidden;height: 100%;width: 100%;position: absolute"></iframe>', // 选项卡内容，支持传入html,
                    id: tabId //选项卡标题的lay-id属性值
                });
                element.tabChange('tab-switch', tabId); //切换到新增的tab上
            }
        }


    });


    /**
     * ifrme自适应页面高度，需要设定min-height
     * @param iframe
     */
    function setIframeHeight(iframe) {
        if (iframe) {
            var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
            if (iframeWin.document.body) {
                iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
            }
        }
    };

    function changeFrameHeight() {
        var ifm = document.getElementById("mainiframe");
        ifm && (ifm.height = document.documentElement.clientHeight - 56);
    }

    window.onresize = function () {
        changeFrameHeight();
    }
    $(function () {
        changeFrameHeight();
    });

    function open() {
        layer.open({
            title: ['温馨提示'],
            content: '<div style="color:#767676">修改密码成功，您需重新登陆!</div>',
            btn: ['确定'],
            shadeClose: false,
            shade: [0.8, '#393D49'],
            //回调函数
            yes: function (index, layero) {
                parent.location.href = "/login.jsp";//立即确定按钮
            },
            cancel: function (index, layero) { //按右上角“X”按钮
                parent.location.href = "/login.jsp";
            }
        })
    }

    /* 菜单缩放 */
    var isShow = true; //定义一个标志位
    $('.kit-side-fold').click(function () {
        //选择出所有的span，并判断是不是hidden
        $('.hidden span').each(function () {
            if ($(this).is(':hidden')) {
                $(this).fadeIn(350);
            } else {
                $(this).fadeOut(350);
            }
        });
        //判断ishow的状态
        if (isShow) {
            $('.layui-body').animate({left: 60}, 350);
            $('.layui-side.layui-bg-black').animate({width: 60}, 350); //设置宽度(左侧导航整个DIV)
            $('.layui-nav.layui-nav-tree.layui-inline').animate({width: 60}, 350); //菜单DIV
            $('.kit-side-fold').animate({width: 60}, 350);
            $('#flexible').animate({width: 60}, 350);
            $('.layui-nav-tree .layui-nav-item').animate({width: 60}, 350);
            $('.layui-nav-item').removeClass('layui-nav-itemed'); //点击关闭左侧导航菜单时，关闭所有一级菜单
            $('.layui-nav-child').removeClass('layui-nav-itemed'); //点击关闭左侧导航菜单时，关闭二级菜单
            $('#flexible').removeClass('layui-icon-shrink-right');
            $('#flexible').addClass('layui-icon-spread-left');
            //修改标志位
            isShow = false;
        } else {
            $('.layui-body').animate({left: 200}, 350)
            $('.layui-nav-tree .layui-nav-item').animate({width: 200}, 350);
            $('.layui-side.layui-bg-black').animate({width: 200}, 350);
            $('.layui-nav.layui-nav-tree.layui-inline').animate({width: 200}, 350);
            $('.kit-side-fold').animate({width: 200}, 350);
            $('#flexible').animate({width: 200}, 350);
            $('#flexible').removeClass('layui-icon-spread-left');
            $('#flexible').addClass('layui-icon-shrink-right');
            isShow = true;
        }
    });
</script>

</body>
</html>
