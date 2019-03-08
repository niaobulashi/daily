<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>日报列表</title>
    <jsp:include page="/html/default/pub.jsp" />
    <link href="/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/js/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 搭建显示页面 -->
<div style="width: 1000px;">
    <!-- 日报添加的模态框 -->
    <div class="modal fade" id="proAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content" style="z-index: 19896; width: 800px; height: 490px; top: 10px; left: -107px;">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">日报添加</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label"><span style="color: #f00;">*</span>工作类型</label>
                            <div class="col-sm-5">
                                <select name="workType" id="workType_add_select" class="form-control">
                                    <option value="">请选择工作类型</option>
                                    <option value="01">需求分析</option>
                                    <option value="02">设计</option>
                                    <option value="03">开发</option>
                                    <option value="04">测试</option>
                                    <option value="05">版本发布</option>
                                    <option value="06">运维支持</option>
                                    <option value="07">会议</option>
                                    <option value="08">其他</option>
                                </select>
                            </div>
                            <%--<button type="button" class="btn btn-primary" id="daily_unfinished_btn">未完成任务</button>--%>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label"><span style="color: #f00;">*</span>日报内容</label>
                            <div class="col-sm-10">
                                <input type="text" name="dailyContent" class="form-control" id="dailyContent_add_input">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class= "col-sm-2 control-label"><span style="color: #f00;">*</span>完成百分比</label>
                            <div class="col-sm-2">
                                <input type="text" name="dailyPercent" class="form-control" onblur="checkGreaterHunderd()" id="dailyPercent_add_input" min="0" max="100" maxlength="3" onkeyup="value=value.replace(/[^0-9]/g,'')" onpaste="value=value.replace(/[^0-9]/g,'')" oncontextmenu = "value=value.replace(/[^0-9]/g,'')">
                                <span class="help-block"></span>
                            </div>
                            <div class="col-sm-2"><span style="color: #f00;" id="greaterHunderd_add" class="help-block"></span></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label"><span style="color: #f00;">*</span>计划完成时间</label>
                            <div class="col-sm-2">
                                <input type="text" name="doneDateStr" class="form-control" placeholder="yyyy-MM-dd" id="doneDate">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">工作存在问题</label>
                            <div class="col-sm-10">
                                <input type="text" name="problem" class="form-control" id="problem_add_input">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">下周工作计划</label>
                            <div class="col-sm-10">
                                <input type="text" name="nextWorkPlan" class="form-control" id="nextWorkPlan_add_input">
                                <span class="help-block"></span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="pro_save_btn">保存</button>
                </div>
            </div>
        </div>
    </div>

    <!-- 日报修改的模态框 -->
    <div class="modal fade" id="proUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content" style="z-index: 19896; width: 800px; height: 490px; top: 10px; left: -107px;">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">日报修改</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label"><span style="color: #f00;">*</span>工作类型</label>
                            <div class="col-sm-5">
                                <select name="workType" id="workType_update_select" class="form-control">
                                    <option value="">请选择工作类型</option>
                                    <option value="01">需求分析</option>
                                    <option value="02">设计</option>
                                    <option value="03">开发</option>
                                    <option value="04">测试</option>
                                    <option value="05">版本发布</option>
                                    <option value="06">运维支持</option>
                                    <option value="07">会议</option>
                                    <option value="08">其他</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label"><span style="color: #f00;">*</span>日报内容</label>
                            <div class="col-sm-10">
                                <input type="text"  name="dailyContent" class="form-control" id="dailyContent_update_input">
                                <input type="hidden" name="dailyDetailId" id="dailyDetailIdHidden">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label"><span style="color: #f00;">*</span>完成百分比</label>
                            <div class="col-sm-2">
                                <input type="text" name="dailyPercent" onblur="checkGreaterHunderd()" class="form-control" id="dailyPercent_update_input" min="0" max="100" maxlength="3" onkeyup="value=value.replace(/[^0-9]/g,'')" onpaste="value=value.replace(/[^0-9]/g,'')" oncontextmenu = "value=value.replace(/[^0-9]/g,'')">
                                <span class="help-block"></span>
                            </div>
                            <div class="col-sm-2"><span style="color: #f00;" id="greaterHunderd_update" class="help-block"></span></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label"><span style="color: #f00;">*</span>计划完成时间</label>
                            <div class="col-sm-2">
                                <input type="text" name="doneDateStr" class="form-control" placeholder="yyyy-MM-dd" id="doneDate_update_input">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">工作存在问题</label>
                            <div class="col-sm-10">
                                <input type="text" name="problem" class="form-control" id="problem_update_input">
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">下周工作计划</label>
                            <div class="col-sm-10">
                                <input type="text" name="nextWorkPlan" class="form-control" id="nextWorkPlan_update_input">
                                <span class="help-block"></span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="daily_update_btn">更新</button>
                </div>
            </div>
        </div>
    </div>

    <!-- 按钮 -->
    <div class="row">
        <div class="col-md-12">
            <button class="btn btn-primary" onclick="history.go(-1)">返回</button>
            <button class="btn btn-primary" id="pro_add_modal_btn">新增</button>
        </div>
    </div>

    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="pros_table">
                <thead>
                <tr>
                    <th>工作类型</th>
                    <th>日报内容</th>
                    <th>完成百分比</th>
                    <th>计划完成时间</th>
                    <th>创建日期</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>

    <!-- 显示分页信息 -->
    <div class="row">
        <!--分页文字信息  -->
        <div class="col-md-6" id="page_info_area"></div>
        <!-- 分页条信息 -->
        <div class="col-md-6" id="page_nav_area">
        </div>
    </div>

</div>
<script type="text/javascript">
    var dailyId = (window.location.search).split("=")[1];
    layer = layui.layer //弹层
    var userId = "${user.userId}";
    //日期标签
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        //常规用法
        laydate.render({
            elem: '#doneDate'
        });
        laydate.render({
            elem: '#doneDate_update_input'
        });
    });

    var totalRecord, currentPage;
    //获取当前用户的权限列表
    var privilegeList = ${user.privilegeList};
    //根据权限列表判断是否显示
    if (privilegeList.indexOf(33) == -1) {
        $("#pro_add_modal_btn").hide();
    }
    //1、页面加载完成以后，直接去发送ajax请求,要到分页数据
    $(function () {
        //去首页
        to_page(1);
    });

    function to_page(pn) {
        params = "dailyId=" + dailyId + "&pn=" + pn;
        var index = layer.msg('拼命加载中', {
            icon: 16
            ,shade: 0.01
        });
        $.ajax({
            url: "/dailyDetail/getDailyDetailList",
            data: params,
            type: "POST",
            success: function (result) {
                //1、解析并显示项目数据
                build_pros_table(result);
                //2、解析并显示项目信息
                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);
                layer.close(index);
            }
        });
    }

    function build_pros_table(result) {
        //清空table表格
        $("#pros_table tbody").empty();
        var pros = result.extend.pageInfo.list;

        $.each(pros, function (index, item) {
            var workTypeStr = "";
            if (item.workType == "01") {
                workTypeStr = "需求分析";
            } else if (item.workType == "02") {
                workTypeStr = "设计";
            } else if (item.workType == "03") {
                workTypeStr = "开发";
            } else if (item.workType == "04") {
                workTypeStr = "测试";
            } else if (item.workType == "05") {
                workTypeStr = "版本发布";
            } else if (item.workType == "06") {
                workTypeStr = "运维支持";
            } else if (item.workType == "07") {
                workTypeStr = "会议";
            } else if (item.workType == "08") {
                workTypeStr = "其他";
            }
            var workType = $("<td></td>").append(workTypeStr);
            var dailyContent = $("<td></td>").append(item.dailyContent);
            var dailyPercent = $("<td></td>").append(item.dailyPercent);
            var doneDate = $("<td></td>").append(item.doneDate == null ? "" : new Date(item.doneDate).Format("yyyy-MM-dd"));
            var createTime = $("<td></td>").append(item.createTime == null ? "" : new Date(item.createTime).Format("yyyy-MM-dd"));

            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
            //为编辑按钮添加一个自定义的属性，来表示当前项目dailyId
            editBtn.attr("edit-id", item.dailyDetailId);
            //添加属性权限ID
            editBtn.attr("privilege-id",34);
            //根据权限列表判断是否显示
            if (privilegeList.indexOf(34) == -1) {
                editBtn.hide();
            }
            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            //为删除按钮添加一个自定义的属性来表示当前删除的项目dailyId
            delBtn.attr("del-id", item.dailyDetailId);
            //添加属性权限ID
            delBtn.attr("privilege-id",35);
            //根据权限列表判断是否显示
            if (privilegeList.indexOf(35) == -1) {
                delBtn.hide();
            }
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            //append方法执行完成以后还是返回原来的元素
            $("<tr class='layui-colla-item'></tr>")
                .append(workType)
                .append(dailyContent)
                .append(dailyPercent)
                .append(doneDate)
                .append(createTime)
                .append(btnTd)
                .appendTo("#pros_table tbody");
        });
    }

    //解析显示分页信息
    function build_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页,总" +
            result.extend.pageInfo.pages + "页,总" +
            result.extend.pageInfo.total + "条记录");
        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }

    //解析显示分页条，点击分页要能去下一页....
    function build_page_nav(result) {
        //page_nav_area
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //为元素添加点击翻页的事件
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
        if (result.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum + 1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
        }

        //添加首页和前一页 的提示
        ul.append(firstPageLi).append(prePageLi);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nextPageLi).append(lastPageLi);

        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }

    //清空表单样式及内容
    function reset_form(ele) {
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }

    //点击新增按钮弹出模态框。
    $("#pro_add_modal_btn").click(function(){
        //清除表单数据（表单完整重置（表单的数据，表单的样式））
        reset_form("#proAddModal form");
        //弹出模态框
        $("#proAddModal").modal({
            backdrop:"static"
        });
        $("#doneDate").val((new Date()).Format('yyyy-MM-dd'));
    });

    //点击编辑
    $(document).on("click", ".edit_btn", function () {
        //1、查出日报信息，显示日报信息
        getDailyDetailInfo($(this).attr("edit-id"));
        //2、把日报的id传递给模态框的更新按钮
        $("#pro_update_btn").attr("edit-id", $(this).attr("edit-id"));
        $("#proUpdateModal").modal({
            backdrop: "static"
        });
    });

    //点击未完成按钮弹出模态框。
    /*$("#daily_unfinished_btn").click(function(){
        //查询未完成日报信息列表
        //弹出模态框
        $("#proUnfinishedModal").modal({
            backdrop:"static"
        });
        $("#doneDate").val((new Date()).Format('yyyy-MM-dd'));
    });*/

    //获取项目信息
    function getDailyDetailInfo(id) {
        $.ajax({
            url: "/dailyDetail/getDailyDetailInfo/" + id,
            type: "GET",
            success: function (result) {
                var proData = result.extend.tDailyDetail;
                var proId = proData.dailyDetailId;
                $("#dailyDetailIdHidden").val(proId);
                $("#workType_update_select").val(proData.workType);
                $("#dailyContent_update_input").val(proData.dailyContent);
                $("#dailyPercent_update_input").val(proData.dailyPercent);
                $("#doneDate_update_input").val(proData.doneDate == null ? "" : new Date(proData.doneDate).Format("yyyy-MM-dd"));
                $("#problem_update_input").val(proData.problem);
                $("#nextWorkPlan_update_input").val(proData.nextWorkPlan);
            }
        });
    };

    //点击更新，更新日报内容信息
    $("#daily_update_btn").click(function () {
        var workTypeUpdate = $("#workType_update_select").val()
            ,dailyContentUpdate = $("#dailyContent_update_input").val()
            ,dailyPercentUpdate = $("#dailyPercent_update_input").val()
            ,doneDateUpdate = $("#doneDate_update_input").val();
        if (!workTypeUpdate) {
            layer.alert("工作类型不能为空！");
            return false;
        } else if (!dailyContentUpdate) {
            layer.alert("日报内容不能为空！");
            return false;
        } else if (!dailyPercentUpdate) {
            layer.alert("完成百分比不能为空！");
            return false;
        } else if (!doneDateUpdate) {
            layer.alert("计划完成时间不能为空！");
            return false;
        }
        //最后还需要校验完成百分比不能大于100
        checkGreaterHunderd();
        var params = $("#proUpdateModal form").serialize() + "&userId=" + userId + "&dailyId=" + dailyId;
        $.ajax({
            url: "/dailyDetail/updateDailyDetail",
            type: "POST",
            data: params,
            success:function(result){
                if(result.code == "100"){
                    $("#proUpdateModal").modal('hide');
                    to_page(1);
                }
            }
        });
    });

    //点击添加保存
    $("#pro_save_btn").click(function () {
        //必输项校验
        var workTypeAdd = $("#workType_add_select").val()
            ,dailyContentAdd = $("#dailyContent_add_input").val()
            ,dailyPercentAdd = $("#dailyPercent_add_input").val()
            ,doneDateAdd = $("#doneDate").val();
        //alert("workType:"+workType+"。" + "dailyContent:"+dailyContent+"。" + "dailyPercent:"+dailyPercent+"。"+ "doneDate:"+doneDate);
        if (!workTypeAdd) {
            layer.alert("工作类型不能为空！");
            return false;
        } else if (!dailyContentAdd) {
            layer.alert("日报内容不能为空！");
            return false;
        } else if (!dailyPercentAdd) {
            layer.alert("完成百分比不能为空！");
            return false;
        } else if (!doneDateAdd) {
            layer.alert("计划完成时间不能为空！");
            return false;
        }
        //校验输入项是否正确
        checkGreaterHunderd();
        var params = $("#proAddModal form").serialize() + "&dailyId=" + dailyId;
        $.ajax({
            url:"/dailyDetail/saveDailyDetail",
            type:"POST",
            data:params,
            success:function(result){
                if(result.code == "100"){
                    $("#proAddModal").modal('hide');
                    to_page(1);
                }
            }
        });
    });

    //单个删除
    $(document).on("click", ".delete_btn", function () {
        //1、弹出是否确认删除对话框
        var dailyContent = $(this).parents("tr").find("td:eq(1)").text();
        var dailyDetailId = $(this).attr("del-id");
        layer.confirm('确定删除【' + dailyContent + '】吗？', {icon: 3, title: '确认信息'}, function (index) {
            //确认，发送ajax请求删除即可
            $.ajax({
                url: "/dailyDetail/deleteDailyDetail/" + dailyDetailId,
                type: "DELETE",
                success: function (result) {
                    layer.msg(result.msg);
                    //回到本页
                    to_page(currentPage);
                }
            });
        });
    });

    //校验输入的数据不能大于100
    function checkGreaterHunderd() {
        var precentUpdate = $("#dailyPercent_update_input").val();
        if (precentUpdate > 100) {
            $("#greaterHunderd_update").text("不能大于100");
        } else {
            $("#greaterHunderd_update").text("");
        }
        var precentAdd = $("#dailyPercent_add_input").val();
        if (precentAdd > 100) {
            $("#greaterHunderd_add").text("不能大于100");
        } else {
            $("#greaterHunderd_add").text("");
        }
    }
</script>
</body>
</html>