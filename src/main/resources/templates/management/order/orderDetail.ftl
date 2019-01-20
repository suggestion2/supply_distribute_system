<#include "../common/header.ftl">
<div class="content-wrapper">
    <section class="content-header">
        <div class="page-pos">当前位置：<span style="color: #ee7b33;"> 订单管理 > 订单详情</span></div>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box zr-box">
                    <div class="box-body" style="padding-top: 30px;">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-xs-2 control-label text-right" style="width: 90px;">订单信息</label>
                                        <div class="col-xs-10" style="">
                                            <table class="table table-bordered text-center">
                                                <tr>
                                                    <td style="background: #f4f4f4;">订单编号</td>
                                                    <td>${order.order.number}</td>
                                                    <td style="background: #f4f4f4;">分销商</td>
                                                    <td>${order.order.distributorName}</td>
                                                    <td style="background: #f4f4f4;">分销商手机号</td>
                                                    <td>${order.order.distributorPhone}</td>
                                                </tr>
                                                <tr>
                                                    <td style="background: #f4f4f4;">下单时间</td>
                                                    <td>${order.order.createTime?string("yyyy-MM-dd hh:mm:ss")}</td>
                                                    <td style="background: #f4f4f4;">订单状态</td>
                                                    <td><#if order.order.status==0>已取消<#elseif order.order.status==1>已创建<#elseif order.order.status==2>下单成功<#elseif order.order.status==3>提交供应商<#elseif order.order.status==4>已结算<#elseif order.order.status==5>已收货<#elseif order.order.status==6>已收货<#elseif order.order.status==7>售后</#if></td>

                                                <#if order.order.status==0>
                                                    <td style="background: #f4f4f4;">取消原因</td>
                                                    <td><#if order.order.cancelReason??>${order.order.cancelReason}</#if></td>
                                                </#if>
                                                </tr>

                                            </table>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-xs-2 control-label text-right" style="width: 90px;">订单明细</label>
                                        <div class="col-xs-10">
                                            <table class="table table-bordered text-center">
                                                <tr style="background: #f4f4f4;">
                                                   <td>商品名称</td><td>售价</td><td>供应商</td><td>供应价</td><td>数量</td><td>小计</td>
                                                </tr>
                                                <#list order.list as val>
                                                <tr>
                                                    <td style="word-break:break-all;word-wrap: break-word;">${val.goodsName}</td><td>${val.price?string("0.00")}</td><td>${val.supplierName}</td><td>${val.supplyPrice?string("0.00")}</td><td>${val.count}</td><td>${val.amount?string("0.00")}</td>
                                                </tr>
                                                </#list>
                                                <tr>
                                                    <td colspan="5" style="text-align: right;font-weight: bold;">合计：</td><td id="totlePrice" style="font-weight: bold;color:red;" colspan="1">￥ ${order.order.amount?string("0.00")}</td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label text-right" style="width: 90px;">收件信息</label>
                                    <div class="col-xs-10">
                                        <table class="table table-bordered text-center">
                                            <tr style="background: #f4f4f4;">
                                                <td>收件人</td><td>联系电话</td><td>收件地址</td>
                                            </tr>
                                            <tr>
                                                <td>${order.order.customerName}</td><td>${order.order.customerPhone}</td><td>${order.order.customerAddress}</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                               <div class="form-group">
                                    <label class="col-xs-2 control-label text-right" style="width: 90px;">物流信息</label>
                                    <div class="col-xs-10">
                                        <table class="table table-bordered text-center">
                                            <tr style="background: #f4f4f4;">
                                                <td>快递公司</td><td>订单号</td>
                                            </tr>
                                            <tr>
                                                <td>${order.order.dispatchCompany!'无'}</td><td>${order.order.dispatchNumber!'无'}</td></td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-2 control-label text-right" style="width: 90px;">备注信息</label>
                                    <div class="col-xs-10">
                                        <p style="padding-top: 7px;"><#if order.order.remarks??>${order.order.remarks}<#else>无</#if></p>
                                    </div>
                                </div>
                                <div class="row" style="margin-top: 50px;">
                                    <div class="col-xs-2 zr-w150"></div>
                                    <div class="col-xs-4">
                                        <#if order.order.status==1>
                                            <a class="btn bg-danger ydcbtn" style="margin-left: 6px;" data-toggle="modal" data-target="#refuseBox">
                                                取消订单
                                            </a>
                                            <a class="btn bg-olive ydcbtn" onclick="changeStatus(${order.order.id},2)" style="margin-left: 6px;">
                                                下单
                                            </a>
                                            <a class="btn btn-danger ydcbtn " style="margin-left: 6px;" data-toggle="modal" data-target="#deletePop">
                                                <i class="fa fa-trash"></i> &nbsp;删除订单
                                            </a>
                                            <#elseif order.order.status==2>
                                                <a class="btn bg-olive ydcbtn" onclick="changeStatus(${order.order.id},3)" style="margin-left: 6px;">
                                                    提交供应商
                                                </a>
                                            <#elseif order.order.status==3>
                                                <a class="btn bg-olive ydcbtn" onclick="changeStatus(${order.order.id},4)" style="margin-left: 6px;">
                                                    结算
                                                </a>
                                            <#elseif order.order.status==4>
                                                <a class="btn bg-olive ydcbtn" onclick="changeStatus(${order.order.id},5)" style="margin-left: 6px;">
                                                    已发货
                                                </a>
                                            <#elseif order.order.status==5>
                                                <a class="btn bg-olive ydcbtn" onclick="changeStatus(${order.order.id},6)" style="margin-left: 6px;">
                                                    已收货
                                                </a>
                                            <#elseif order.order.status==6>
                                                <a class="btn bg-olive ydcbtn" onclick="changeStatus(${order.order.id},7)" style="margin-left: 6px;">
                                                    售后
                                                </a>
                                        </#if>

                                        <a class="btn ydcbtn bg-lightgray backlist" href="/management/order/list?status=${order.order.status}" style="margin-left: 6px;">
                                            <i class="fa fa-reply"></i> &nbsp;返回列表
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<#--是否删除-->
<div class="modal fade" style="z-index: 1041;" id="deletePop" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" style="width:300px">
        <div class="modal-content">
            <div class="modal-header"><h4 class="modal-title col-xs-8" style="font-size: 14px;">删除订单</h4><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button></div>
            <div class="modal-body">
                <p>是否删除订单</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn ydcbtn bg-olive" onclick="deleteBtn(${order.order.id})"><i class="fa fa-save"></i> 确认</button>
                <button type="button" class="btn ydcbtn btn-danger" data-dismiss="modal" aria-hidden="true"><i class="fa fa-save"></i> 取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<#--取消订单-->
<div class="modal fade" id="refuseBox" tabindex="-1" role="dialog">
    <div class="modal-dialog" style="width: 400px;margin-top: 120px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">取消订单</h4>
            </div>
            <div class="modal-body" style="padding: 30px;text-align: left;">
                <p style="padding-bottom: 10px;border-bottom: 1px dashed #eee;">订单取消后不可恢复。若确认取消，请填写取消原因。</p>
                <div>
                    <label>取消原因:</label>
                    <textarea id="refuseContent" class="form-control"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn bg-olive btn-flat" data-dismiss="modal" style="height:34px;padding:2px 32px;border-radius: 3px;">先不取消</button><button type="button" onclick="refuseModBtn('${order.order.id}')" class="btn bg-red btn-flat" style="height:34px;padding:2px 32px;border-radius: 3px; margin-left: 15px;">确认取消</button>
            </div>
        </div>
    </div>
</div>

<#include "../common/footer.ftl">
<script type="text/javascript">
    //导航
    var orderStatus=${order.order.status};

    switch(true){
        case orderStatus==0:
            navcontroller("order","已取消");
            break;
        case orderStatus==1:
            navcontroller("order","已创建");
            break;
        case orderStatus==2:
            navcontroller("order","下单成功");
            break;
        case orderStatus==3:
            navcontroller("order","提交供应商");
            break;
        case orderStatus==4:
            navcontroller("order","已结算");
            break;
        case orderStatus==5:
            navcontroller("order","已发货");
            break;
        case orderStatus==6:
            navcontroller("order","已收货");
            break;
        case orderStatus==7:
            navcontroller("order","售后");
            break;
    };

    /*删除订单*/
    function deleteBtn(id) {
        $.ydcAjax("DELETE","/mApi/order/delete/"+id,"","json","application/json",function(data){
            $.ydcModal("fa fa-warning","操作提示","删除成功!","自动刷新中……","");
            setTimeout(function(){
                window.location.href='/management/order/list?status=all';
            },1000);
        },function (error) {
            $.ydcModal("fa fa-warning","操作提示","删除失败!"+$.parseJSON(error.responseText).message,"我知道了","");
        });
    }
    /*取消订单*/
    function refuseModBtn(id) {
        $.ydcAjax("PUT", "/mApi/order/resetStatus", JSON.stringify({"id":id,"cancelReason":$("#refuseContent").val(),"status":0}), "json", "application/json", function () {
            $("#refuseBox").modal("hide");
            $.smallTips("取消成功", true, 1000);
            setTimeout(function () {
                window.location.reload();
            }, 1000);
        }, function (error) {
            $("#refuseBox").modal("hide");
            if (error.status == "400") {
                $.smallTips($.parseJSON(error.responseText).message,true,1000);
                return false;
            } else {
                $.smallTips("发生一些错误，请稍后再试！",true,1000);
                return false;
            }
        });
    }
    /*改变状态*/
    function changeStatus(id,status) {
        $.ydcAjax("PUT", "/mApi/order/resetStatus", JSON.stringify({"id":id,"status":status}), "json", "application/json", function () {
            var tip='';
            if(status==2){
                tip='下单成功'
            }else if(status==3){
                tip='已提交供应商'
            }else if(status==4){
                tip='结算成功'
            }else if(status==5){
                tip='发货成功'
            }else if(status==6){
                tip='收货成功'
            }else if(status==7){
                tip='申请售后成功'
            }
            $.smallTips(tip, true, 1000);
            setTimeout(function () {
                window.location.reload();
            }, 1000);
        }, function (error) {
            if (error.status == "400") {
                $.smallTips($.parseJSON(error.responseText).message,true,1000);
                return false;
            } else {
                $.smallTips("发生一些错误，请稍后再试！",true,1000);
                return false;
            }
        });
    }
</script>