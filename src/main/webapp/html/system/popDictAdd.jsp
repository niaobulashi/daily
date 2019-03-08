<%--
  Created by IntelliJ IDEA.
  User: ladyh
  Date: 2018/8/31
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增字典</title>
    <jsp:include page="/html/default/pub.jsp" />
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
    <legend>新增字典</legend>
</fieldset>
<div id="dictAddModel">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">分类编码</label>
                <div class="layui-input-inline">
                    <input type="tel" name="kindCode" lay-verify="required|kindCode" maxlength="20" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">分类名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="kindName" lay-verify="required|kindName" maxlength="20" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">CODE编码</label>
                <div class="layui-input-inline">
                    <input type="tel" name="code" lay-verify="required|code" maxlength="20" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">CODE名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" lay-verify="required|name" maxlength="20" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">父级分类编码</label>
                <div class="layui-input-inline">
                    <input type="tel" name="parentCode" lay-verify="parentCode" maxlength="20" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">排序</label>
                <div class="layui-input-inline">
                    <input type="tel" name="displaySort" lay-verify="required|displaySort" maxlength="20" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item" align="center">
            <div class="layui-inline">
                <button class="layui-btn layui-btn-warm" type="button" lay-filter="codeAdd" lay-submit>
                    <i class="layui-icon">&#xe654;</i>&nbsp;新增
                </button>
                <button class="layui-btn layui-btn-danger" type="button" onclick="codeClose()">
                    <i class="layui-icon">&#xe640;</i>&nbsp;关闭
                </button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //点击提交
        form.on('submit(codeAdd)', function(){
            $.ajax({
                url: "/system/addCode",
                type: "POST",
                data: $("#dictAddModel form").serialize(),
                success: function (result) {
                    if (result.code == "100") {

                        //layer.alert("数字字典新增成功");
                        layer.confirm('数字字典新增成功', {icon: 3, title: '确认信息'}, function (index) {
                            codeClose();
                        });
                    } else {
                        layer.alert(result.msg);
                    }
                }
            });
        });

    });

    //关闭当前页面
    function codeClose() {
        //当你在iframe页面关闭自身时
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    }
</script>

</body>
</html>
