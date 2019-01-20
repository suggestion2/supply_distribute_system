<#include '../common/header.ftl'>
<div class="content-wrapper">
    <section class="content-header">
        <div class="page-pos">当前位置：<span style="color: #ee7b33;">  订单管理 > 订单列表 > <font id="pageName"></font></span></div>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box zr-box">
                    <div class="box-header">
                        <div class="row" style="padding-bottom: 20px;">
                            <div class="col-xs-4">
                                <a class="btn ydcbtn bg-olive" href="javascript:;" onclick="outputOrder()"><i class="fa fa-file-excel-o"></i> 导出当前结果excel</a>
                            </div>
                            <div class="col-xs-5 pull-right">
                                <div class="input-group input-group-sm">
                                    <input type="text" placeholder="输入商品名称查询" style="width: 60%" id="searchName" class="form-control">
                                    <input id="datepicker" type="text" class="form-control">
                                    <span class="input-group-btn">
                                        <button class="btn ydcbtn bg-eg" onclick="searchBtn()"><i class="fa fa-search"></i></button>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <#--<div class="row" style="padding-bottom: 20px;">
                            <div class="col-xs-4 pull-right">
                                <div class="input-group input-group-sm">
                                    <input type="text" placeholder="输入订单编号" id="searchName" class="form-control">
                                    <span class="input-group-btn">
                                        <button class="btn ydcbtn bg-eg" onclick="searchBtn()"><i class="fa fa-search"></i></button>
                                    </span>
                                </div>
                            </div>
                        </div>-->
                    </div>
                    <div class="box-body  no-padding">
                        <table id="orderList" class="table table-hover text-center" data-table="orderList">
                            <thead>
                            <tr>
                                <th>订单编号</th>
                                <th>产品名称</th>
                                <th>分销商</th>
                                <th>订单状态</th>
                                <th width="150">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                        <div style="text-align: center;margin-top: 30px;"><ul id="pages"></ul></div>
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
                <button type="button" class="btn ydcbtn bg-olive" id="deleteBtn" onclick="deleteBtn()"><i class="fa fa-save"></i> 确认</button>
                <button type="button" class="btn ydcbtn btn-danger" data-dismiss="modal" aria-hidden="true"><i class="fa fa-save"></i> 取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<#include '../common/footer.ftl'>


<script type="text/javascript">

    navcontroller("order","全部订单");
    var strUrl = window.location.toString();
    if(strUrl.indexOf("status=")<0){
        strUrl+="?status=all";
    }

    var pageName = strUrl.substr(strUrl .lastIndexOf("status")+7,strUrl.length-strUrl.lastIndexOf("status="));

    var pagingData;
    newLoad();
    var refundStatus;
    function newLoad(){
        switch (true){
            case pageName=="all":
                $("#pageName").html("全部订单");
                navcontroller("order","全部订单");
                firstAjax({"content":$("#searchName").val()});
                pagingData={"content":$("#searchName").val()};
                break;
            case pageName=="0":
                $("#pageName").html("已取消");
                navcontroller("order","已取消");
                firstAjax({"content":$("#searchName").val(),"status":0});
                pagingData={"content":$("#searchName").val(),"status":0};
                break;
            case pageName=="1":
                $("#refundListTab").hide();
                $("#underlinePay").show();
                $("#pageName").html("已创建");
                navcontroller("order","已创建");
                firstAjax({"content":$("#searchName").val(),"status":1});
                pagingData={"content":$("#searchName").val(),"status":1};
                break;
            case pageName=="2":
                $("#pageName").html("下单成功");
                navcontroller("order","下单成功");
                firstAjax({"content":$("#searchName").val(),"status":2});
                pagingData={"content":$("#searchName").val(),"status":2};
                break;
            case pageName=="3":
                $("#pageName").html("提交供应商");
                navcontroller("order","提交供应商");
                firstAjax({"content":$("#searchName").val(),"status":3});
                pagingData={"content":$("#searchName").val(),"status":3};
                break;
            case pageName=="4":
                $("#pageName").html("已结算");
                navcontroller("order","已结算");
                firstAjax({"content":$("#searchName").val(),"status":4});
                pagingData={"content":$("#searchName").val(),"status":4};
                break;
            case pageName=="5":
                $("#pageName").html("已发货");
                navcontroller("order","已发货");
                firstAjax({"content":$("#searchName").val(),"status":5});
                pagingData={"content":$("#searchName").val(),"status":5};
                break;
            case pageName=="6":
                $("#pageName").html("已收货");
                navcontroller("order","已收货");
                firstAjax({"content":$("#searchName").val(),"status":6});
                pagingData={"content":$("#searchName").val(),"status":6};
                break;
            case pageName=="7":
                $("#pageName").html("售后");
                navcontroller("order","售后");
                firstAjax({"content":$("#searchName").val(),"status":7});
                pagingData={"content":$("#searchName").val(),"status":7};
                break;
        };
    };

    //第一次请求
    function firstAjax(data){
        $("#pages").html("");
        $("#pages").parent().find(".pagesTotle").remove();
        data.pageIndex=0;
        data.pageSize=15;
        $.ydcAjax("POST","/mApi/order/list",JSON.stringify(data),"json","application/json",goodsListFn,"");
    };

    //插入的内容
    function strCon(val){
        var str='',status;
        switch (true){
            case  val.status==0:status='已取消';break;
            case  val.status==1:status='已创建';break;
            case  val.status==2:status='下单成功';break;
            case  val.status==3:status='提交供应商';break;
            case  val.status==4:status='已结算';break;
            case  val.status==5:status='已发货';break;
            case  val.status==6:status='已收货';break;
            case  val.status==7:status='售后';break;
        };
        if(val.status==1){
            var delStr='<a style="margin-left: 4px" title="删除" class="btn btn-danger btn-flat" onclick="deletePop('+val.id+')">删除</a>' ;
        }else{
            var delStr='';
        }
        str += '<tr>' +
                '<td>'+val.number+'</td>'+
                '<td>'+val.goodsNames+'</td>'+
                '<td>'+val.distributorName+'</td>'+
                '<td>'+status+'</td>' +
                '<td>' +
                '<a href="/management/order/detail/'+val.id+'" class="btn bg-olive btn-flat" title="详情">详情</a>' +
                delStr+
                '</td>' +
                '</tr>';

        return str;
    };

    //数据请求成功，调用方法
    function goodsListFn(data){
        //第一次插入
        $('[data-table] tbody').html('');
        $.each(data.list,function(idx,val){
            $('[data-table] tbody').append(strCon(val));
        });

        //分页
        var options = {
            bootstrapMajorVersion:3,
            currentPage: 1,//当前页
            totalPages: Math.ceil(data.count/15),//总页数
            numberOfPages: 5,//显示的页数
            shouldShowPage:function(type, page, current){
                switch(type){default:return true;}
            },
            tooltipTitles: function (type, page, current) {
                switch (type) {case "first":return "首页";case "prev":return "上一页";case "next":return "下一页";case "last":return "尾页";case "page":return "第"+page+"页";}
            },
            itemTexts: function(type, page, current) { //修改显示文字
                switch (type) {case "first":return "首页";case "prev":return "上一页";case "next":return "下一页";case "last":return "末页";case "page":return page;}
            },
            onPageClicked: function (event, originalEvent, type, page) { //异步换页
                pagingData.pageIndex=page-1;
                pagingData.pageSize=15;
                var data = JSON.stringify(pagingData);
                $.ydcAjax("POST","/mApi/order/list",data,"json","application/json",function(newjson){
                    $('[data-table] tbody').html('');
                    $.each(newjson.list,function(idx,val){
                        $('[data-table] tbody').append(strCon(val));
                    });
                },"");
            }
        };
        var ifPage = data.count / 15;
        if(ifPage>=1){
            $("#pages").bootstrapPaginator(options);
            $("#pages").before(function(){
                var str='';
                str+='<ul class="pagesTotle"><li>共 '+data.count+' 条</li></ul>';
                return str;
            });
        }
    };

    function searchBtn(){
        switch(true){
            case pageName=="all":
                firstAjax({"content":$("#searchName").val()});
                pagingData={"content":$("#searchName").val()};
                break;

            case pageName=="0":
                firstAjax({"content":$("#searchName").val(),"status":0});
                pagingData={"content":$("#searchName").val(),"status":0};
                break;
            case pageName=="1":
                firstAjax({"content":$("#searchName").val(),"status":1});
                pagingData={"content":$("#searchName").val(),"status":1};
                break;
            case pageName=="2":
                firstAjax({"content":$("#searchName").val(),"status":2});
                pagingData={"content":$("#searchName").val(),"status":2};
                break;
            case pageName=="3":
                firstAjax({"content":$("#searchName").val(),"status":3});
                pagingData={"content":$("#searchName").val(),"status":3};
                break;
            case pageName=="4":
                firstAjax({"content":$("#searchName").val(),"status":4});
                pagingData={"content":$("#searchName").val(),"status":4};
                break;
            case pageName=="5":
                firstAjax({"content":$("#searchName").val(),"status":5});
                pagingData={"content":$("#searchName").val(),"status":5};
                break;
            case pageName=="6":
                firstAjax({"content":$("#searchName").val(),"status":6});
                pagingData={"content":$("#searchName").val(),"status":6};
                break;
            case pageName=="7":
                firstAjax({"content":$("#searchName").val(),"status":7});
                pagingData={"content":$("#searchName").val(),"status":7};
                break;
        };
    };
    function deletePop(id) {
        $('#deletePop').modal('show');
        $('#deleteBtn').attr('data-id',id)
    }
    $('#deleteBtn').on('click',function(){
        var id=$(this).attr('data-id');
        $.ydcAjax("DELETE","/mApi/order/delete/"+id,"","json","application/json",function(data){
            $.ydcModal("fa fa-warning","操作提示","删除成功!","自动刷新中……","");
            setTimeout(function(){
                window.location.reload();
            },1000);
        },function (error) {
            $.ydcModal("fa fa-warning","操作提示","删除失败!"+$.parseJSON(error.responseText).message,"我知道了","");
        });
    })

    function outputOrder(){

    };
</script>
