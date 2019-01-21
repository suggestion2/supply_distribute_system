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
            <div class="col-lg-4 col-xs-6">
                <div class="small-box bg-aqua">
                    <div class="inner">
                        <h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;" id="pendingGoods">${allOrderCount.count}</font></font></h3>
                        <p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">总订单数</font></font></p>
                    </div>
                    <div class="icon">
                        <i class="fa fa-shopping-cart"></i>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-xs-6">
                <div class="small-box bg-green">
                    <div class="inner">
                        <h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;" id="salesgoods">${allOrderCount.sumAmount}</font></font></h3>
                        <p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">总销售额</font></font></p>
                    </div>
                    <div class="icon">
                        <i class="ion ion-stats-bars"></i>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-xs-6">
                <div class="small-box bg-yellow">
                    <div class="inner">
                        <h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;" id="userCount">${allOrderCount.sumSalesCount}</font></font></h3>
                        <p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">订单商品数</font></font></p>
                    </div>
                    <div class="icon">
                        <i class="fa fa-first-order"></i>
                    </div>
                </div>
            </div>
        </div>
        <#--销售情况分析-->
        <div class="row">
            <div class="col-xs-12">
                <div class="box box-primary">
                    <div class="box-header clearfix">
                        <i class="ion ion-clipboard"></i>
                        <h3 class="box-title">销售情况分析</h3>
                        <select class="pull-right form-control" id="categoryOne" style="width: 120px;height: 26px;font-size: 12px;padding: 0 6px">
                            <#list category as item>
                                <option value="${item.id}">${item.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="record" style="min-height: 100px">
                        <div class="item">
                            <ul class="clearfix" style="font-size:16px;line-height: 30px;">
                                <li class="col-xs-3"><label>该品类昨日订单数：</label><span id="day1" style="font-size: 30px;font-weight: bold;"></span> 单</li>
                                <li class="col-xs-3"><label>该品类过去7天订单数：</label><span id="day7" style="font-size: 30px;font-weight: bold;"></span> 单</li>
                                <li class="col-xs-3"><label>该品类当月订单数：</label><span id="day30" style="font-size: 30px;font-weight: bold;"></span> 单</li>
                            </ul>
                        </div>
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

                        <select class="pull-right form-control" id="categoryTwo" style="width: 120px;height: 26px;font-size: 12px;padding: 0 6px">
                        <#list category as item>
                            <option value="${item.id}">${item.name}</option>
                        </#list>
                        </select>
                    </div>
                    <div id="main" style="width:96%;height:400px;"></div>
                </div>
            </div>
        </div>
    </section>
</div>
<#include 'common/footer.ftl'>
<script src="/resources/management/plugins/echarts/dist/echarts.js" type="text/javascript"></script>
<script type="text/javascript">
    navcontroller('index','数据统计');

    /*获得销售数据*/
    var categoryOne=$('#categoryOne').val() === null ? 0 : $('#categoryOne').val();
    getCateDate(categoryOne);
    function getCateDate(id) {
        $.ydcAjax("GET", "/mApi/statistics/category/sum?id="+id, "", "json", "application/json", function (data) {
            $('#day1').text(data.dailyCount);
            $('#day7').text(data.weeklyCount);
            $('#day30').text(data.monthlyCount);
        }, "");
    }
    $('#categoryOne').change(function () {
        var id=$(this).val();
        getCateDate(id);
    })




    require.config({
        paths: {
            echarts: '/resources/management/plugins/echarts/dist'
        }
    });

    var today = new Date();

    var endDate = today.getFullYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();


    var categoryTwo=$('#categoryOne').val() === null ? 0 : $('#categoryOne').val();

    plain(categoryTwo);

    function plain(id) {
        $.ydcAjax("GET", "/mApi/statistics/category/weekly?id="+id, "", "json", "application/json", generateFn, "");
    }

    $('#categoryTwo').change(function () {
        var id=$(this).val();
        plain(id);
    });
    // 使用

    function generateFn(data){
        //console.log(data);
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main'));

                var dataList = data.list === null?[]:data.list ;
                var dataArr=[];
                var dateList = [];
                for(var i in dataList){
                    dataArr.push(dataList[i].count);
                    dateList.push(dataList[i].date);
                }

                var option = {
                    title : {
                        text: '7日订单统计',
                        x:'center',
                        y:'top',
                        textAlign:'center'
                    },
                    tooltip : {
                        trigger: 'axis'
                    },

                    toolbox: {
                        show : true,
                        feature : {
                            mark : {show: true},
                            //dataView : {show: true, readOnly: false},
                            //magicType : {show: true, type: ['line', 'bar']},
                            //restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    xAxis: {
                        type: 'category',
                        data: dateList
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: dataArr,
                        type: 'bar',
                        barWidth:50
                    }]
                };

                // 为echarts对象加载数据
                myChart.setOption(option);
            }
        );
    }



</script>
