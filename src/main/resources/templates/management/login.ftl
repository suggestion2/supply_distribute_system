<#include "common/header_base.ftl">
<body class="hold-transition login-page" style="position: relative;height: 100%;background:#2f4050">
<style type="text/css">
    #particles {  width: 100%;  height: 100%;  overflow: hidden;}
    .login-box{position: absolute;left: 50%;top: 50%; margin-left: -180px; margin-top: -180px;z-index: 99;border-radius: 4px;}
</style>
<input id="redirectUrl" type="hidden" value="${redirectUrl?default('')}"/>
<div id="particles">
    <div class="login-box">
        <div class="login-box-body" style="border-radius: 4px;">
            <div class="login-logo">
                <p style="font-size: 22px;font-weight: 500;color:#2f4050;margin-bottom: 0;padding-top: 20px;">订单管理系统</p>
                <p style="font-size: 16px;font-weight: 500;font-style: italic;color:#2f4050">Management System</p>
            </div>


            <div class="form-group has-feedback">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                <input type="text" name="username" class="form-control" placeholder="帐号">
            </div>

            <div class="form-group has-feedback">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                <input type="password" name="password" class="form-control" placeholder="密码">
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <button id="submit" class="btn btn-block bg-eg btn-flat" style="height: 40px;font-size: 16px;border-radius: 3px;">登 录</button>
                </div>
            </div>



            <div class="social-auth-links text-center" style="font-size: 12px;color:#2f4050;">
                <p>- IF -</p>
                <p>如果忘记了用户名和密码，请联系管理员处理</p>
            </div>
        </div>
    </div>
</div>

<script src="/resources/management/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/resources/management/plugins/bootstrap/js/bootstrap-paginator.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/management/js/jquery.particleground.min.js"></script>
<script type="text/javascript" src="/resources/management/plugins/icheck/icheck.min.js"></script>
<script type="text/javascript" src="/resources/management/js/public.js"></script>
<script>
    $(function () {

        //动态背景
        $('#particles').particleground({
            dotColor: 'rgba(255,255,255,.2)',
            lineColor: 'rgba(255,255,255,.2)'
        });
        //登录验证
        $(document).keyup(function(event){
            if(event.keyCode ==13){
                $("#submit").trigger("click");
            }
        });
        $("#submit").bind("click",function(){
            var username = $("input[name='username']");
            var password = $("input[name='password']");
            if(username.val()==""){
                $.smallTips("用户名不能为空！",true,1000);
                return false;
            }else if(password.val()==""){
                $.smallTips("密码不能为空！",true,1000);
                return false;
            }
            $.ydcAjax('POST','/mApi/login',JSON.stringify({"name": username.val(),"password": password.val()}),'json','application/json',function(msg){
                if(msg.message=="success")
                    $.smallTips("登录成功！自动跳转中...",true,1000);
                setTimeout(function(){
                    if($("#redirectUrl").val()!=''){
                        window.location.href= $("#redirectUrl").val();
                    }else{
                        window.location.href="/management/index";
                    }
                },1000);
            },function(error){
                if(error.status==400){
                    var errorMsg = JSON.parse(error.responseText);
                    $.smallTips(errorMsg.message,true,1000);
                }else{
                    $.smallTips("帐号或密码错误，请核对后重新登录！",true,1000);
                }
                return false;
            });
        });
    });
</script>
</body>
</html>