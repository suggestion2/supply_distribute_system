<#include 'common/header.ftl'>
<div class="content-wrapper">
    <section class="content container-fluid">
        <div class="row">
            <div class="col-xs-12">
                <div class="box zr-box">
                    <div id="main1" style="width:100%;">
                        <div class="row">
                            <div class="col-xs-4" style="width: 150px;"><img src="/resources/management/img/userhead.jpg" style="width: 100px;border:1px solid #eee;border-radius: 50%;"></div>
                            <div class="col-xs-8" style="border-left:1px solid #eee;padding-left: 30px;">
                                <p>欢迎您,<span>${user.name}</span></p>
                                <p style="margin-top: 26px;">版本：V1.0</p>
                                <p>在使用过程中遇到问题，请联系QQ技术客服：523357941</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <#--数量-->
        <div class="row">
            <div class="col-lg-3 col-xs-6">
                <div class="small-box bg-aqua">
                    <div class="inner">
                        <h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;" id="pendingGoods">0</font></font></h3>
                        <p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">总订单数</font></font></p>
                    </div>
                    <div class="icon">
                        <i class="fa fa-shopping-cart"></i>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-xs-6">
                <div class="small-box bg-green">
                    <div class="inner">
                        <h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;" id="salesgoods">0</font></font></h3>
                        <p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">总利润</font></font></p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-stats-bars"></i>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-xs-6">
                <div class="small-box bg-yellow">
                    <div class="inner">
                        <h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;" id="userCount">0</font></font></h3>
                        <p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">今日订单数</font></font></p>
                    </div>
                    <div class="icon">
                        <i class="fa fa-first-order"></i>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-xs-6">
                <div class="small-box bg-red">
                    <div class="inner">
                        <h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">0</font></font></h3>
                        <p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">今日总利润</font></font></p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-pie-graph"></i>
                    </div>
                </div>
            </div>
        </div>

        <#--销售排行榜-->
        <div class="row">
            <div class="col-xs-12">
                <div class="box box-primary">
                    <div class="box-header">
                        <i class="ion ion-clipboard"></i>
                        <h3 class="box-title">销售排行榜</h3>
                    </div>
                    <div class="box-body">
                        <table class="table table-hover text-center">
                            <thead>
                                <tr>
                                    <th>排名</th>
                                    <th>产品名称</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>xiaomihehejiade xiaodeng</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>xiaomihehejiade xiaodeng</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>xiaomihehejiade xiaodeng</td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td>xiaomihehejiade xiaodeng</td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td>xiaomihehejiade xiaodeng</td>
                                </tr>
                                <tr>
                                    <td>6</td>
                                    <td>xiaomihehejiade xiaodeng</td>
                                </tr>
                                <tr>
                                    <td>7</td>
                                    <td>xiaomihehejiade xiaodeng</td>
                                </tr>
                                <tr>
                                    <td>8</td>
                                    <td>xiaomihehejiade xiaodeng</td>
                                </tr>
                                <tr>
                                    <td>9</td>
                                    <td>xiaomihehejiade xiaodeng</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="box-footer clearfix text-center no-border">

                    </div>
                </div>
            </div>
        </div>
        <#--图表-->
        <div class="row">
            <div class="col-xs-12">
                <div class="box box-primary">
                    <div class="box-header">
                        <i class="ion ion-clipboard"></i>
                        <h3 class="box-title">订单数量统计</h3>
                    </div>
                    <div id="main" style="width: 100%;height:400px;"></div>
                </div>
            </div>
        </div>
    </section>
</div>
<#include 'common/footer.ftl'>
<script src="/resources/management/plugins/echarts/echarts.simple.min.js" type="text/javascript"></script>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
    option = {
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line'
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    window.onresize =  function () {
        this.myChart.resize();
    };
</script>
