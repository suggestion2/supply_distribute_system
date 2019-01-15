<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>橄榄油商城管理中心</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link href="/resources/management/img/fav.png" rel="Shortcut Icon" type="image/x-icon"/>
    <link rel="stylesheet" href="/resources/management/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/management/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/management/plugins/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="/resources/management/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/resources/management/css/skin-green.min.css">
    <link rel="stylesheet" href="/resources/management/css/style.css">
    <script src="/resources/management/js/jquery.min.js"></script>

    <!--[if lt IE 9]>
    <script src="/resources/management/js/html5shiv.min.js"></script>
    <script src="/resources/management/js/respond.min.js"></script>
    <![endif]-->
    <link href="/resources/management/plugins/checkBrowser/badbrowser.css" rel="stylesheet">
    <script type="text/javascript">
        window.onload=function getBroswer(){
            var Sys = {};
            var ua = navigator.userAgent.toLowerCase();
            var s;
            (s = ua.match(/edge\/([\d.]+)/)) ? Sys.edge = s[1] :
                    (s = ua.match(/rv:([\d.]+)\) like gecko/)) ? Sys.ie = s[1] :
                            (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
                                    (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
                                            (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
                                                    (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
                                                            (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
            var str='<div class="badbrowser badbrowser_modal"><div class="badbrowser__helper"></div><div class="badbrowser__content"><h1>您使用的浏览器不被支持或已经过时！</h1><h3 class="badbrowser-user-browser"></h3><p>您可以继续浏览器本网站，但是不保证能够正确执行所有的功能。</p><p>您可以根据下面的链接来升级您的浏览器</p><p><a class="oldbrowser__browserLink" title="Download Google Chrome" style="background-position: 0px 0px;" href="https://www.google.com/chrome/" target="_blank"></a><a class="oldbrowser__browserLink" title="Download Mozilla Firefox" style="background-position: -60px 0px;" href="https://www.mozilla.org/ru/firefox/new/" target="_blank"></a><a class="oldbrowser__browserLink" title="Download Opera" style="background-position: -120px 0px;" href="http://www.opera.com/download" target="_blank"></a><a class="oldbrowser__browserLink" title="Download Safari" style="background-position: -180px 0px;" href="https://www.apple.com/safari/" target="_blank"></a><a class="oldbrowser__browserLink" title="Download Internet Explorer" style="background-position: -240px 0px;" href="https://www.microsoft.com/ie/" target="_blank"></a></p><a href="javascript:;" onclick="closeWeb()" class="badbrowser-close">我知道了</a></div></div>';
            if(Sys.chrome){
                var version=parseInt(Sys.chrome);
                if(version<10){
                    $("body").append(str);
                };
                console.log("浏览器：chrome，版本："+Sys.chrome);
            }else if(Sys.edge){
                console.log("浏览器：edge，版本："+Sys.edge);
            }else if(Sys.ie){
                var version=parseInt(Sys.ie);
                if(version<9){
                    $("body").append(str);
                };
                console.log("浏览器：ie，版本："+Sys.ie);
            }else if(Sys.firefox){
                var version=parseInt(Sys.firefox);
                if(version<4){
                    $("body").append(str);
                };
                console.log("浏览器：firefox，版本："+Sys.firefox);
            }else if(Sys.opera){
                var version=parseInt(Sys.opera);
                if(version<12){
                    $("body").append(str);
                };
                console.log("浏览器：opera，版本："+Sys.opera);
            }else if(Sys.safari){
                var version=parseInt(Sys.safari);
                if(version<10){
                    $("body").append(str);
                };
                console.log("浏览器：safari，版本："+Sys.safari);
            }else{
                $("body").append(str);
                console.log("浏览器：未知，版本：未知");
            };
        };
        function closeWeb(){
            $(".badbrowser_modal").remove();
        };
    </script>
</head>