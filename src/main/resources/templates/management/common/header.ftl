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
                <#if userLevel??>
                    <#if userLevel == 3>
                        <li><a href="#order" data-toggle="tab"><i class="fa fa-diamond"></i> <span>订单</span></a></li>
                    <#elseif userLevel == 4>
                        <li><a href="#customer" data-toggle="tab"><i class="fa fa-id-card-o"></i> <span>会员</span></a></li>
                    <#else>
                        <li><a href="#order" data-toggle="tab"><i class="fa fa-diamond"></i> <span>订单</span></a></li>
                        <li><a href="#goods" data-toggle="tab"><i class="fa fa-gift"></i> <span>商品</span></a></li>
                        <li><a href="#customer" data-toggle="tab"><i class="fa fa-id-card-o"></i> <span>会员</span></a></li>
                    <#--<li><a href="#shop" data-toggle="tab"><i class="fa fa-home"></i> <span>商户</span></a></li>
                    <li><a href="#marketing" data-toggle="tab"><i class="fa fa-tag"></i> <span>营销</span></a></li>-->
                        <li><a href="#article" data-toggle="tab"><i class="fa fa-file-word-o"></i> <span>文章</span></a></li>
                        <li><a href="#paymentDiscount" data-toggle="tab"><i class="fa fa-tag"></i> <span>促销</span></a></li>
                        <li><a href="#comment" data-toggle="tab"><i class="fa fa-file-word-o"></i> <span>评论</span></a></li>
                        <li><a href="#report" data-toggle="tab"><i class="fa fa-home"></i> <span>报表</span></a></li>
                        <li><a href="#user" data-toggle="tab"><i class="fa fa-share-alt"></i> <span>用户</span></a></li>
                        <li><a href="#setting" data-toggle="tab"><i class="fa fa-cog"></i> <span>设置</span></a></li>
                    </#if>
                </#if>
            </ul>
        </section>
    </aside>
    <aside class="two-sidebar tab-content">
    <#--首页-->
        <section data-nav="index" class="tab-pane">
            <div class="sidebarname">快捷导航</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li><a href="/management/goods/list?status=sale">在售商品</a></li>
                <li><a href="/management/order/list?status=pending">待发订单</a></li>
                <li><a href="/management/customer/list">会员列表</a></li>
            </ul>
        </section>
        <section data-nav="order" id="order" class="tab-pane">
            <div class="sidebarname">订单管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="全部订单"><a href="/management/order/list?status=all">全部订单</a></li>
                <li data-navname="待发货"><a href="/management/order/list?status=pending">待发货</a></li>
                <li data-navname="待支付"><a href="/management/order/list?status=unpaid">待支付</a></li>
                <li data-navname="待收货"><a href="/management/order/list?status=undelivered">待收货</a></li>
                <li data-navname="已完成"><a href="/management/order/list?status=done">已完成</a></li>
                <li data-navname="已取消"><a href="/management/order/list?status=cancel">已取消</a></li>
                <li data-navname="待售后"><a href="/management/order/list?status=refund">待售后</a></li>
                <li data-navname="已售后"><a href="/management/order/list?status=afterSale">已售后</a></li>
            </ul>
        </section>
        <section data-nav="customer" id="customer" class="tab-pane">
            <div class="sidebarname">会员管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="会员列表"><a href="/management/customer/list">会员列表</a></li>
            </ul>
        </section>
        <section data-nav="goods" id="goods" class="tab-pane">
            <div class="sidebarname">商品管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="添加商品"><a href="/management/goods/create">添加商品</a></li>
                <li data-navname="全部商品"><a href="/management/goods/list?status=all">全部商品</a></li>
                <li data-navname="出售中"><a href="/management/goods/list?status=sale">出售中</a></li>
                <li data-navname="仓库中"><a href="/management/goods/list?status=warehouse">仓库中</a></li>
                <li data-navname="已售罄"><a href="/management/goods/list?status=soldout">已售罄</a></li>
                <li data-navname="商品分类"><a href="/management/category/list">商品分类</a></li>
            <#--<li data-navname="配送设置"><a href="/management/goods/express">配送设置</a></li>-->
            </ul>
        </section>
        <section data-nav="marketing" id="marketing" class="tab-pane">
            <div class="sidebarname">营销活动</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="活动管理"><a href="/management/activity/list">活动管理</a></li>
            </ul>
        </section>
        <section data-nav="shop" id="shop" class="tab-pane">
            <div class="sidebarname">商户管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="待审核商户"><a href="/management/shop/application/list">待审核商户</a></li>
                <li data-navname="待审核分类"><a href="/management/category/shop/examine/list">待审核分类</a></li>
                <li data-navname="待审核商品"><a href="/management/shop/application/goods/list">待审核商品</a></li>
                <li data-navname="全部商户"><a href="/management/shop/list">全部商户</a></li>
                <li data-navname="商户行业分类"><a href="/management/shop/category">商户行业分类</a></li>
                <li data-navname="商户会员"><a href="/management/shop/user/list">商户会员</a></li>
                <li data-navname="提现"><a href="/management/shop/withdraw/list?status=all">提现</a></li>
            </ul>
        </section>
        <section data-nav="user" id="user" class="tab-pane">
            <div class="sidebarname">用户管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="创建用户"><a href="/management/user/create">创建用户</a></li>
                <li data-navname="用户列表"><a href="/management/user/list">用户列表</a></li>
            </ul>
        </section>
        <section data-nav="article" id="article" class="tab-pane">
            <div class="sidebarname">文章管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="添加文章"><a href="/management/article/create">添加文章</a></li>
                <li data-navname="文章列表"><a href="/management/article/list">文章列表</a></li>
                <li data-navname="标签管理"><a href="/management/article/label/list">标签管理</a></li>
            </ul>
        </section>
        <section data-nav="paymentDiscount" id="paymentDiscount" class="tab-pane">
            <div class="sidebarname">促销管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="促销列表"><a href="/management/paymentDiscount/list">促销列表</a></li>
                <li data-navname="添加促销"><a href="/management/paymentDiscount/create">添加促销</a></li>
            </ul>
        </section>
        <section data-nav="comment" id="comment" class="tab-pane">
            <div class="sidebarname">评论管理</div>
            <ul class="sidebar-menu" data-widget=""tree">
                <li data-navname="商品评论列表"><a href="/management/comment/list?type=goods">商品评论列表</a></li>
                <li data-navname="文章评论列表"><a href="/management/comment/list?type=article">文章评论列表</a></li>
            </ul>
        </section>
        <section data-nav="report" id="report" class="tab-pane">
            <div class="sidebarname">报表管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="流量统计"><a href="/management/report/flow">流量统计</a></li>
            </ul>
        </section>
        <section data-nav="setting" id="setting" class="tab-pane">
            <div class="sidebarname">平台管理</div>
            <ul class="sidebar-menu" data-widget="tree">
                <li data-navname="轮播图"><a href="/management/banner/list">轮播图</a></li>
            <#--<li data-navname="管理员"><a href="/management/user/list">管理员</a></li>-->

            <#--<li data-navname="用户反馈"><a href="/management/feedback/list">用户反馈</a></li>
                <li data-navname="系统消息"><a href="/management/message/list">系统消息</a></li>-->
            </ul>
        </section>
    </aside>

    <script type="text/javascript">
        if (window.location.pathname == "/management") {
            $("section[data-nav='index']").addClass("tab-pane active");
        };

        function loginOut() {
            $.ydcAjax("GET", "/mApi/logout", "", "json", "application/json", function (data) {
                if (data.response == "successfully") window.location.href = "/management/login"
            }, "");
        };
    </script>