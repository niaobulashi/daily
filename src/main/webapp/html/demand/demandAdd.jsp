<%--
  Created by IntelliJ IDEA.
  User: Lnast
  Date: 2018/8/8
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>需求管理</title>
    <jsp:include page="/html/default/pub.jsp"></jsp:include>
</head>
<body style="background-color: white">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>新增需求</legend>
</fieldset>

<blockquote class="layui-elem-quote layui-text">
    鉴于小伙伴的普遍反馈，先温馨提醒两个忠告：1. 需求初步测试</a> 2. 使用过程中有问题及时反馈</a>
</blockquote>

<div style="width: 800px; position: relative; left:20%; margin-top: 20px">
    <form id="save" class="layui-form layui-form-pane" lay-filter="demandForm">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">所属项目</label>
                <div class="layui-input-inline">
                    <select name="projectId" id="projectId">
                        <option value=""></option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">所属模块</label>
                <div class="layui-input-inline">
                    <select name="demandModule">
                        <option value=""></option>
                        <option value="0">写作</option>
                        <option value="1" selected="">阅读</option>
                        <option value="2">游戏</option>
                        <option value="3">音乐</option>
                        <option value="4">旅行</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">需求编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="demandId" lay-verify="title" autocomplete="off" placeholder="请输入需求编号"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">版本号</label>
                <div class="layui-input-inline">
                    <input type="text" name="versionNum" lay-verify="required|title" autocomplete="off"
                           placeholder="请输入版本号"
                           class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">需求名称</label>
            <div class="layui-input-block">
                <input type="text" name="demandName" lay-verify="title" autocomplete="off" placeholder="请输入需求名称"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">需求内容</label>
            <div class="layui-input-block">
                <textarea class="layui-textarea layui-hide" name="demandDes" lay-verify="content"
                          id="LAY_demo_editor"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">提出部门</label>
                <div class="layui-input-inline">
                    <input type="text" name="demandDepartmant" aceholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">提出人</label>
                <div class="layui-input-inline">
                    <input type="text" name="demandMaker" aceholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">需求日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="demandDate" id="demandDate" lay-verify="required|date"
                           placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">需求审核人</label>
                <div class="layui-input-inline">
                    <input type="text" name="demandAuditor" aceholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">计划完成日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="plannedFinishDate" id="plannedFinishDate" lay-verify="date"
                           placeholder="yyyy-MM-dd"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">实际完成日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="actualFinishDate" id="actualFinishDate"
                           placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">计划上线日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="plannedOnlineDate" id="plannedOnlineDate" lay-verify="date"
                           placeholder="yyyy-MM-dd"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">实际上线日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="actualOnlineDate" id="actualOnlineDate"
                           placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">工作量</label>
                <div class="layui-input-inline">
                    <input type="text" name="workload" lay-verify="number" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">负责人</label>
                <div class="layui-input-block">
                    <select name="demandRespoId" id="demandRespoId">
                        <option value="">请选择</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">优先级</label>
                <div class="layui-input-block">
                    <select name="priority" id="priority">
                        <option value="0">0-低</option>
                        <option value="1">1-中</option>
                        <option value="2">2-高</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">需求状态</label>
                <div class="layui-input-block">
                    <select name="demandStat" id="demandStat">
                        <option value="0">0-待处理</option>
                        <option value="1">1-分析中</option>
                        <option value="2">2-开发中</option>
                        <option value="3">3-已完成</option>
                        <option value="4">4-已上线</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">工作量确认</label>
                <div class="layui-input-block">
                    <select name="workloadConfirm" id="workloadConfirm">
                        <option value="0">0-未确认</option>
                        <option value="1">1-已确认</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">结算情况</label>
                <div class="layui-input-block">
                    <select name="settlementSituation" id="settlementSituation">
                        <option value="0">0-未结算</option>
                        <option value="1">1-已结算</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <input type="hidden" name="id" class="layui-input">
            <input type="hidden" name="remark1" class="layui-input">
            <input type="hidden" name="remark2" class="layui-input">
            <input type="hidden" name="remark3" class="layui-input">
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-warm" lay-submit lay-filter="demandAdd" id="demandAdd">提交</button>
                <button type="reset" class="layui-btn">重置</button>
                <button class="layui-btn" id="back">返回</button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['flow', 'form', 'layedit', 'laydate', 'jquery'], function () {
        var form = layui.form
            , flow = layui.flow
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , $ = layui.jquery;

        $('#back').click(function () {
            window.location.href = '/html/demand/demandList.jsp';
            return false;
        });
        //日期
        laydate.render({
            elem: '#demandDate'
        });
        laydate.render({
            elem: '#leadDate'
        });
        laydate.render({
            elem: '#plannedFinishDate'
        });
        laydate.render({
            elem: '#actualFinishDate'
        });
        laydate.render({
            elem: '#plannedOnlineDate'
        });
        laydate.render({
            elem: '#actualOnlineDate'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '内容至少得5个字符啊';
                }
            }
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });


        //监听提交
        form.on('submit(demandAdd)', function (data) {
            $.post({
                url: '/demandTrack/addDemandTrack',
                type: 'POST',
                data: JSON.stringify(data.field),
                dataType: 'json',
                contentType: 'application/json',
                success: function (res) {
                    layer.confirm(res.msg, {
                        btn: ['确定', '取消']
                    }, function () {
                        window.location.href = '/html/demand/demandList.jsp';
                    }, function () {

                    });
                }
            });
            return false;
        });


        // 加载受理人信息
        flow.load({
            elem: '#demandRespoId' //指定列表容器
            , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
                var lis = [];
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                $.ajax({
                    url: '/user/getProjectUserList',
                    type: "POST",
                    success: function (res) {
                        //假设你的列表返回在data集合中
                        layui.each(res.data, function (index, item) {
                            lis.push('<option value=' + item.userId + '>' + item.userName + '</option>');
                        });
                        //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                        //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                        next(lis.join(''), page < res.pages);
                        form.render();
                    }
                });
            }
        });


        // 加载所属项目
        flow.load({
            elem: '#projectId' //指定列表容器
            , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
                var lis = [];
                //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                $.ajax({
                    url: "/project/getProjectNameList",
                    data: {"userId": '${user.userId}'},
                    type: "POST",
                    success: function (res) {
                        //假设你的列表返回在data集合中
                        layui.each(res.extend.pros, function (index, item) {
                            lis.push('<option value=' + item.id + '>' + item.projectName + '</option>');
                        });
                        //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                        //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                        next(lis.join(''), page < res.pages);
                        form.render();
                    }
                });
            }
        });

        var id = getUrlParam('id');
        var demandId = getUrlParam('demandId');
        if (id != '' && id != undefined){
            setTimeout(function () {
                $.ajax({
                    url: "/demandTrack/queryDemandTrack",
                    data: JSON.stringify({"id": id , "demandId": demandId}),
                    type: "POST",
                    contentType: 'Application/JSON',
                    success: function (res) {
                        var data = res.extend.data;
                        form.val('demandForm',{
                            "id" : data.id,
                            "projectId" : data.projectId,
                            "versionNum": data.versionNum,
                            "demandModule" : data.demandModule,
                            "demandId" : data.demandId,
                            "demandName": data.demandName,
                            "demandDes" : data.demandDes,
                            "demandProgress": data.demandProgress,
                            "demandRespoId": data.demandRespoId,
                            "demandDepartmant": data.demandDepartmant,
                            "demandMaker" : data.demandMaker,
                            "demandAuditor" : data.demandAuditor,
                            "demandDate" : data.demandDate,
                            "leadDate" : data.leadDate,
                            "plannedFinishDate": data.plannedFinishDate,
                            "actualFinishDate": data.actualFinishDate,
                            "plannedOnlineDate": data.plannedOnlineDate,
                            "actualOnlineDate": data.actualOnlineDate,
                            "priority": data.priority,
                            "workload" : data.workload,
                            "demandStat": data.demandStat,
                            "workloadConfirm": data.workloadConfirm,
                            "settlementSituation": data.settlementSituation,
                            "remark1": data.remark1,
                            "remark2": data.remark2,
                            "remark3": data.remark3
                        });
                        editIndex = layedit.build('LAY_demo_editor');
                    }
                });
            },300);
            form.render();
        }
    });


</script>
</body>
</html>
