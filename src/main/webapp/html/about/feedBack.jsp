<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>意见反馈</title>
    <jsp:include page="/html/default/pub.jsp"/>
</head>
<body>
<form class="layui-form">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">反馈类型</label>
            <div class="layui-input-inline">
                <select name="fbType" id="fbType" lay-search="">
                    <option value="">请选择反馈类型</option>
                    <option value="100001">新需求</option>
                    <option value="100002">功能意见</option>
                    <option value="100003">界面意见</option>
                    <option value="100004">操作意见</option>
                    <option value="100005">其他意见</option>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">反馈内容</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容（限500字）" name="fbInfo" id="fbInfo" class="layui-textarea" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\.]/g,'')" onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\.]/g,'')" oncontextmenu = "value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\.]/g,'')" maxlength="500"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">联系邮箱</label>
            <div class="layui-input-inline">
                <input placeholder="邮箱选填" type="text" name="fbEmail" id="fbEmail" hotocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" class="layui-btn" id="putFeedBack">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary" id="resetButton">重置</button>
        </div>
    </div>
</form>

<script src="/js/layui/layui.all.js" charset="utf-8"></script>
<script>
    layer = layui.layer //弹层
    var userId = "${user.userId}";
    var reg= /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    //邮箱校验正则表达式
    $("#putFeedBack").click(function () {
        var fbType = $("#fbType").val();
        var fbInfo = $("#fbInfo").val();
        var fbEmail = $("#fbEmail").val();
        //点击立即提交
        if (!fbType){
            layer.alert("反馈类型不能为空！");
            return false;
        } else if (!fbInfo) {
            layer.alert("反馈内容不能为空！");
            return false;
        } else if (fbEmail != "") {
            if (!reg.test(fbEmail)) {
                layer.alert("邮箱格式不正确！");
                return false;
            }
        }
        /*layer.alert(JSON.stringify(data.field), {
            title: '最终的提交信息'
        });*/
        var params = "fbType=" + fbType + "&fbInfo=" + fbInfo + "&fbEmail=" + fbEmail + "&fbUser=" + userId;
        $.ajax({
            url: "/feedBack/putFeedBack",
            type: "POST",
            data: params,
            success:function(result){
                if(result.code == "100"){
                    layer.msg('感谢您的反馈，我们将会及时处理！', {
                        icon: 6,
                        btn: ['确定']
                    });
                    $("#resetButton").click();
                } else if (result.code == "100001") {
                    layer.msg(result.msg, {
                        icon: 5,
                        btn: ['确定']
                    });
                }
            }
        });
    });

    //获取SessionId
    /*function getSessionId(){
        var c_name = 'JSESSIONID';
        if(document.cookie.length>0){
            c_start=document.cookie.indexOf(c_name + "=")
            if(c_start!=-1){
                c_start=c_start + c_name.length+1
                c_end=document.cookie.indexOf(";",c_start)
                if(c_end==-1) c_end=document.cookie.length
                return unescape(document.cookie.substring(c_start,c_end));
            }
        }
    }*/
</script>
</body>
</html>