<#include "../common/header.ftl">
<div class="content-wrapper">
    <section class="content-header">
        <div class="page-pos">当前位置：<span style="color: #ee7b33;">账号管理 > 修改密码</span></div>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box zr-box">
                    <div class="box-body" style="padding-top: 30px;">
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label text-right zr-w150">用户名</label>
                                <div class="col-sm-5">
                                    <p style="margin: 0;margin-top: 7px;">${user.name}</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label text-right zr-w150" for="originPassword">原密码</label>
                                <div class="col-sm-5">
                                    <input type="password" class="form-control" id="originPassword" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label text-right zr-w150" for="newPassword">新密码</label>
                                <div class="col-sm-5">
                                    <input type="password" class="form-control" id="newPassword" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label text-right zr-w150" for="renewPassword">重复新密码</label>
                                <div class="col-sm-5">
                                    <input type="password" class="form-control" id="renewPassword" value="">
                                </div>
                            </div>
                            <div class="row" style="margin-top: 50px;">
                                <div class="col-xs-2 zr-w150"></div>
                                <div class="col-xs-4"><button class="btn ydcbtn bg-olive" id="setPasswordBtn"><i class="fa fa-save"></i> &nbsp;保存</button></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<#include "../common/footer.ftl">
<script type="text/javascript">
    navcontroller("account","修改密码");
    $("#setPasswordBtn").bind("click",function(){
        var originPassword = $("#originPassword").val(),
                newPassword = $("#newPassword").val(),
                renewPassword = $("#renewPassword").val();
        if(originPassword==""){
            $.smallTips("原密码不能为空！",true,2000);
            return false;
        }else if(newPassword==""){
            $.smallTips("新密码不能为空！",true,2000);
            return false;
        }else if(newPassword.length<6){
            $.smallTips("密码长度必须为6-16位！",true,2000);
            return false;
        }else if(renewPassword==""){
            $.smallTips("重复密码不能为空！",true,2000);
            return false;
        }

        if(newPassword==renewPassword){
            $.ydcAjax("PUT","/mApi/password",JSON.stringify({
                "originPassword": originPassword,
                "newPassword": newPassword
            }),"json","application/json",function(data){
                $.smallTips("修改成功！自动跳转...",true,2000);
                setTimeout(function(){
                    window.location.href='/management/index';
                },500);
            },function(error){
                if(error.status==400){
                    var errorMsg = JSON.parse(error.responseText);
                    $.smallTips(errorMsg.message,true,2000);
                }else{
                    $.smallTips("发生一些错误，请重新输入！",true,2000);
                }
                return false;
            });
        }else{
            $.smallTips("两次输入的新密码不同，请重新输入!",true,2000);
            $("#originPassword").val("");
            $("#newPassword").val("");
            $("#renewPassword").val("");
        }
    });

</script>
