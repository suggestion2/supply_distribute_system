<#include 'header_base.ftl'>
<body class="hold-transition skin-green sidebar-mini">
<div class="wrapper">
    <header class="main-header">
        <!-- Logo -->
        <a href="/management" class="logo">
            <span class="logo-mini">订单管理系统</span>
            <span class="logo-lg">管理中心</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <a href="/management" class="sidebar-toggle">
                <span style="padding-left: 10px;">控制台</span>
            </a>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown tasks-menu">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
                            <span id="managerName">${user.name}</span><i class="fa fa-angle-down"
                                                                         style="margin-left: 6px;"></i>
                        </a>
                        <ul class="dropdown-menu zrdropdown-menu">
                            <li><a href="/management/user/password/reset">修改密码</a></li>
                        </ul>
                    </li>

                    <!-- 退出登录 -->
                    <li class="dropdown user user-menu">
                        <a href="javascript:;" onclick="loginOut()"><i class="fa fa-sign-out"></i>退出</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side -->

    <aside class="main-sidebar">
        <section class="sidebar" style="padding-top: 20px;">
            <ul class="sidebar-menu" data-widget="tree">
                <li><a href="#goods" data-toggle="tab"><i class="fa fa-diamond"></i> <span>产品管理</span></a></li>
                <li><a href="#category" data-toggle="tab"><i class="fa fa-diamond"></i> <span>分类管理</span></a></li>
                <li><a href="#distributor" data-toggle="tab"><i class="fa fa-diamond"></i> <span>分销商管理</span></a></li>
                <li><a href="#order" data-toggle="tab"><i class="fa fa-diamond"></i> <span>订单管理</span></a></li>
                <li><a href="#account" data-toggle="tab"><i class="fa fa-diamond"></i> <span>账号管理</span></a></li>
            </ul>
        </section>
    </aside>
    <aside class="two-sidebar tab-content">
        <#--首页-->
        <section data-nav="index" class="tab-pane">
            <div class="sidebarname">快捷导航</div>
            <ul class="sidebar-menu" data-widget="tree">

            </ul>
        </section>
        <section data-nav="goods" id="goods" class="tab-pane">
            <div class="sidebarname">产品管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="产品录入"><a href="/management/goods/create">产品录入</a></li>
                <li data-navname="产品列表"><a href="/management/goods/list?status=all">产品列表</a></li>
            </ul>
        </section>

        <section data-nav="category" id="category" class="tab-pane">
            <div class="sidebarname">分类管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="产品类别"><a href="/management/category/list">产品类别</a></li>
            </ul>
        </section>
        <section data-nav="distributor" id="distributor" class="tab-pane">
            <div class="sidebarname">分销商管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="分销商列表"><a href="/">分销商列表</a></li>
            </ul>
        </section>
        <section data-nav="provider" id="provider" class="tab-pane">
            <div class="sidebarname">供应商管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="供应商列表"><a href="/">供应商列表</a></li>
            </ul>
        </section>
        <section data-nav="order" id="order" class="tab-pane">
            <div class="sidebarname">订单管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="全部订单"><a href="/management/order/list?status=all">全部订单</a></li>
            </ul>
        </section>
        <section data-nav="account" id="account" class="tab-pane">
            <div class="sidebarname">账号管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="修改密码"><a href="/management/order/list?status=all">修改密码</a></li>
            </ul>
        </section>
    </aside>

    <script type="text/javascript">
        if (window.location.pathname == "/management/index") {
            $("section[data-nav='index']").addClass("tab-pane active");
        };

        function loginOut() {
            $.ydcAjax("GET", "/mApi/logout", "", "json", "application/json", function (data) {
                if (data.message == "success") window.location.href = "/management/login"
            }, "");
        };
    </script>