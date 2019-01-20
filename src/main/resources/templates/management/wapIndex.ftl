<#include "common/header_base.ftl">
<style>
    html,body{
        min-width: auto;
    }
    .wapIndex{
        padding-top: 44px;
    }
    .wapNav{
        position: fixed;
        top: 0;
        left: 0;
        right: 0;
        width: 100%;
        z-index: 9;
        height: 44px;
        background: #3a3f4a;
        color: #acb1bb;
    }
    .wapNav .navItem{
        font-size: 14px;
        color: #fff;
        line-height: 44px;
        padding: 0 8px;
    }
</style>
<body style="position: relative;background:#fff;min-height: auto;height: auto">
<div class="wapIndex">
    <div class="wapNav clearfix">
        <a class="navItem pull-left" href="/management/goods/wap/list">每日行情</a>
        <a class="navItem pull-right" href="/management/wap/index">数据统计</a>
    </div>

    <div class="box box-primary" style="margin: 4px 8px;width: auto">
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
                <ul class="clearfix" style="font-size:13px;line-height: 30px;">
                    <li><label>该品类昨日订单数：</label><span id="day1"></span>单</li>
                    <li><label>该品类过去7天订单数：</label><span id="day7"></span>单</li>
                    <li><label>该品类当月订单数：</label><span id="day30"></span>单</li>
                </ul>
            </div>
        </div>
    </div>
    <#--图表-->
    <div class="box box-primary" style="margin: 4px 8px;width: auto;padding-bottom: 24px;margin-top: 16px">
        <div class="box-header">
            <i class="ion ion-clipboard"></i>
            <h3 class="box-title">订单数量统计</h3>
            <select class="pull-right form-control" id="categoryTwo" style="width: 120px;height: 26px;font-size: 12px;padding: 0 6px">
            <#list category as item>
                <option value="${item.id}">${item.name}</option>
            </#list>
            </select>
        </div>
        <div id="main" style="width: 100%;height:300px;"></div>
    </div>
</div>
<script src="/resources/management/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/management/js/public.js"></script>
<script src="/resources/management/plugins/echarts/dist/echarts.js" type="text/javascript"></script>
<script>
   /**/

    var categoryOne=$('#categoryOne').val();
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


    var categoryTwo=$('#categoryOne').val();

    plain(categoryTwo);

    function plain(id) {
        $.ydcAjax("GET", "/mApi/statistics/category/weekly?id="+id, "", "json", "application/json", generateFn, "");
    }

    $('#categoryTwo').change(function () {
        var id=$(this).val();
        plain(id);
    })
    // 使用

    function generateFn(data){
        console.log(data);
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
                        grid:{
                            x:25,
                            y:45,
                            x2:5,
                            y2:20,
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
                            barWidth:30
                        }]
                    };

                    // 为echarts对象加载数据
                    myChart.setOption(option);
                }
        );
    }
</script>
</body>
</html>
