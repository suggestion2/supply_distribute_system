<#include "../common/header.ftl">
<div class="content-wrapper">
    <section class="content-header">
        <div class="page-pos">当前位置：<span style="color: #ee7b33;"> 订单管理 > 订单录入</span></div>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box zr-box">
                    <div class="box-body" style="padding-top: 30px;">
                        <div id="goodsContent" class="tab-content">
                            <div class="tab-pane fade in active" id="page1">
                                <div class="row">
                                    <div class="col-xs-2 gleft">
                                        <p>分销商信息</p>
                                    </div>
                                    <div class="col-xs-10 gright">
                                        <div class="form-horizontal">
                                            <div class="form-group" style="padding-top: 30px;">
                                                <label class="col-sm-2 control-label text-right zr-w150" for="name"><span style="color:red">*</span> 分销商：</label>
                                                <div class="col-sm-7">
                                                    <select class="form-control" id="distributor1">
                                                        <option value="">请选择分销商名称</option>
                                                        <#list distributor as item>
                                                            <option value="${item.id}" data-phone="${item.phone}">${item.name}</option>
                                                        </#list>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" style="margin-top: 2px;">
                                    <div class="col-xs-2 gleft"><p>详细信息</p></div>
                                    <div class="col-xs-10 gright" style="padding-top: 30px;">
                                        <div class="form-horizontal">
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label text-right zr-w150"><span style="color:red">*</span> 收件人：</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" id="customerName" value="" placeholder="收件人">
                                                    <p class="tips"></p>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label text-right zr-w150"><span style="color:red">*</span> 收货电话：</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" id="customerPhone" value="" placeholder="收货电话">
                                                    <p class="tips"></p>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label text-right zr-w150"><span style="color:red">*</span> 收货地址：</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" id="customerAddress" value="" placeholder="收货地址">
                                                    <p class="tips"></p>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label text-right zr-w150"><span style="color:red">*</span> 快递公司：</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" id="dispatchCompany" value="" placeholder="快递公司">
                                                    <p class="tips"></p>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label text-right zr-w150"><span style="color:red">*</span> 快递单号：</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" id="dispatchNumber" value="" placeholder="快递单号">
                                                    <p class="tips"></p>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label text-right zr-w150"><span style="color:red">*</span>选择订单状态：</label>
                                                <div class="col-sm-7">
                                                    <select class="form-control" id="status">
                                                        <option value="">请选择订单状态</option>
                                                        <option value="1">成功下单</option>
                                                        <option value="2">提交供应商</option>
                                                        <option value="3">已结算</option>
                                                        <option value="4">售后</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label text-right zr-w150">备注：</label>
                                                <div class="col-sm-7">
                                                    <textarea class="form-control" id="remarks" value="" placeholder="请输入备注"></textarea>
                                                    <p class="tips"></p>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="row" style="margin-top: 2px;">
                                    <div class="col-xs-2 gleft">
                                        <p>商品信息</p>
                                    </div>
                                    <div class="col-xs-10 gright" style="padding:30px;">
                                        <div class="form-horizontal">
                                            <div id="skuboxarea">
                                                <div class="skubox">

                                                </div>
                                                <div>
                                                    <a href="javascript:;" class="btn ydcbtn btn-primary btn-flat" onclick="addSkuItem()"><i class="fa fa-plus"></i> 添加商品</a>
                                                </div>
                                                <table style="margin-top: 20px;" class="table table-bordered text-center" id="showSku">
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="margin-top:30px;">
                            <div class="col-xs-2 zr-w150" style="width: 120px;"></div>
                            <div class="col-xs-4"><button class="btn ydcbtn bg-olive" id="saveBtn" style="width: 130px;"><i class="fa fa-save"></i> &nbsp;保存</button><button class="btn ydcbtn bg-lightgray" onclick="window.location.href='/management/goods/list'" style="margin-left: 20px;"><i class="fa fa-reply"></i> &nbsp;返回列表</button></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>


<#include "../common/footer.ftl">
<script type="text/javascript">
    navcontroller("order","订单录入");

    /*/!*商品列表*!/
    var goodsList;
    $.ydcAjax("POST","/mApi/goods/list",JSON.stringify({status:1}),"json","application/json",function (data) {
        goodsList=data.list;
    },"");*/


    /*商品分类*/
    var categoryList=[];
    $.ydcAjax("GET","/mApi/category/list","","json","application/json",function(data){
//        $("#selectCat").append(selectCat(data));
        categoryList=data;
    },"");
    function selectCat(data){
        var str='<option value="" style="color: #999;">选择类目</option>';
        $.each(data.list,function(idx,obj){
            str+='<option data-level="'+obj.level+'" value="'+obj.id+'">'+obj.name+'</option>';
            if(obj.list.length>0){
                $.each(obj.list,function(sidx,sobj){
                    str+='<option data-level="'+sobj.level+'" value="'+sobj.id+'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--'+sobj.name+'</option>';
                    if(obj.list[sidx].list.length>0){
                        $.each(obj.list[sidx].list,function (tidx,tobj) {
                            str+='<option data-level="'+tobj.level+'" value="'+tobj.id+'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--'+tobj.name+'</option>';
                        })
                    }
                });
            };
        });
        return str;
    };


    var cookid=0;
    function addSkuItem(){
        /*if($(".skuitem").length>1){
            $.smallTips("只能创建2级sku，不可再添加！",true,1000);
            return false;
        };*/
        /*分类列表*/
        var categorySrc=selectCat(categoryList);

/*
        var goodsSrc='';
        for(var i in goodsList){
            goodsSrc+='<option value="'+goodsList[i].id+'">' + goodsList[i].name +'</option>';
        }*/

        var str='';
        str='<div class="skuitem" data-id="n'+cookid+'" data-level="'+cookid+'">'+
                '<div style="border:1px solid #e7eaec;padding:10px;margin-bottom: 10px;">'+
                '<div class="form-group" style="margin-bottom: 0">'+
                '<div class="col-sm-12">'+
                '<div class="input-group inputgroupspc">'+
                '<select name="n'+cookid+'" class="form-control goodsCate" style="width: 25%">' + categorySrc+
                '</select>'+
                '<select name="n'+cookid+'" class="form-control goodsName" style="width: 25%">' +
                '<option value="">请选择商品</option>' +
                '</select>'+
                '<select  name="n'+cookid+'" class="form-control supplyPrice" style="width: 25%">' +
                '<option value="">请选择供应商以及对应价格</option>' +
                '</select>'+
                '<input type="text" name="n'+cookid+'" class="form-control count" style="width: 25%" value="1" placeholder="数量">'+
                '<div class="input-group-btn">'+
                '<a href="javascript:;" class="btn ydcbtn btn-danger" onclick="removeSpec(\'n'+cookid+'\')"><i class="fa fa-remove"></i></a>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>'+
                '</div>';
        $(".skubox").append(str);
        cookid+=1;
    }
    /*选择类目*/
    var chooseCate={};
    $(document).on('change','.skubox .goodsCate',function () {
        var id=$(this).val();
        var level=$(this).find('option:selected').attr('data-level');
        $(this).next('.goodsName').html('<option value="">请选择商品</option>');
        $(this).parent('.inputgroupspc').find('.supplyPrice').html('<option value="">请选择供应商以及对应价格</option>');
        var that=this;
        if(id!=''){
            switch (level) {
                case '1':
                    var categoryId1=$(this).val()||'';
                    break;
                case '2':
                    var categoryId2=$(this).val()||'';
                    break;
                case '3':
                    var categoryId3=$(this).val()||'';
                    break;
            }
            var data={categoryId1:categoryId1,categoryId2:categoryId2,categoryId3:categoryId3};
            $.ydcAjax("POST","/mApi/goods/list",JSON.stringify(data),"json","application/json",function (data) {
                var goodsList=data.list;
                var goodsSrc='';
                $.each(goodsList,function (idx,val) {
                    goodsSrc+='<option value="'+val.id+'">' + val.name +'</option>';
                });
                console.log(goodsSrc);
                $(that).next('.goodsName').append(goodsSrc);
            },"");
        }else{
            $(that).next('.goodsName').html('<option value="">请选择商品</option>');
            return false;
        }



        /*var id=$(this).val();
        $(this).next('.supplyPrice').html('<option value="-1">请选择供应商以及对应价格</option>');
        if(id==''){
            return false;
        }
        var that=this;
        $.ydcAjax("GET","/mApi/goods/detail/"+id,"","json","application/json",function(data){
            chooseGoods=data;
            var supplierList=data.list;
            var str='';
            $.each(supplierList,function (idx,val) {
                str+='<option value="'+val.id+'" data-supplierName="'+val.supplierName+'" data-supplyPrice="'+val.supplyPrice+'">'+val.supplierName+' : ￥'+val.supplyPrice+'</option>'
            });
            console.log(str);
            $(that).next('.supplyPrice').append(str);
        },"");*/
    });

    /*选择商品*/
    var chooseGoods={};  /*选择的商品*/
    $(document).on('change','.skubox .goodsName',function () {
        var id=$(this).val();
        $(this).next('.supplyPrice').html('<option value="-1">请选择供应商以及对应价格</option>');
        if(id==''){
            return false;
        }
        var that=this;
        $.ydcAjax("GET","/mApi/goods/detail/"+id,"","json","application/json",function(data){
            chooseGoods=data;
            var supplierList=data.list;
            var str='';
            $.each(supplierList,function (idx,val) {
                str+='<option value="'+val.id+'" data-supplierName="'+val.supplierName+'" data-supplyPrice="'+val.supplyPrice+'">'+val.supplierName+' : ￥'+val.supplyPrice+'</option>'
            });
            console.log(str);
            $(that).next('.supplyPrice').append(str);
        },"");
    });

    $('#saveBtn').on('click',function () {
        if($("#distributor1").val()==""){
            $.smallTips("请选择分销商名称",true,1000);
            return false;
        }else if($("#customerName").val()==""){
            $.smallTips("请填写收件人",true,1000);return false;
        }else if($("#customerPhone").val()==""){
            $.smallTips("请填写收件人电话",true,1000);return false;
        }else if($("#customerAddress").val()==""){
            $.smallTips("请填写收货地址",true,1000);return false;
        }else if($("#status").val()==""){
            $.smallTips("请选择订单状态",true,1000);return false;
        }


        var goodsList=[];
        $('.skuitem').each(function () {
            if($(this).find('.goodsName').val()==''){
                $.smallTips("请选择商品名称",true,1000);return false;
            }else if($(this).find('.supplyPrice').val()==''){
                $.smallTips("请选择供应商对应价格",true,1000);return false;
            }else{
                goodsList.push({
                            "goodsId":chooseGoods.goods.id,
                            "categoryId1":chooseGoods.goods.categoryId1,
                            "categoryId2":chooseGoods.goods.categoryId2,
                            "categoryId3":chooseGoods.goods.categoryId3,
                            "goodSupplyId":$(this).find('.supplyPrice').val(),
                            "goodsName":chooseGoods.goods.name,
                            "supplierName":$(this).find('.supplyPrice').find('option:selected').attr('data-supplierName'),
                            "taobaoPrice":chooseGoods.goods.taobaoPrice,
                            "jdPrice":chooseGoods.goods.jdPrice,
                            "price":chooseGoods.goods.price,
                            "supplyPrice":$(this).find('.supplyPrice').find('option:selected').attr('data-supplyPrice'),
                            "count":$(this).find('.count').val()
                })
            }
        });
        var data={
            distributorId:$("#distributor1").val(),
            distributorName:$("#distributor1").find('option:selected').text(),
            distributorPhone:$("#distributor1").find('option:selected').attr('data-phone'),
            customerName:$("#customerName").val(),
            customerAddress:$("#customerAddress").val(),
            customerPhone:$("#customerPhone").val(),
            dispatchCompany:$("#dispatchCompany").val(),
            dispatchNumber:$("#dispatchNumber").val(),
            status:$("#status").val(),
            remarks:$("#remarks").val(),
            list:goodsList,
        }

        $.ydcAjax("POST","/mApi/order/create",JSON.stringify(data),"json","application/json",function (data) {
            $.smallTips("添加成功！请到列表中查看",true,1000);
            setTimeout(function(){
                window.location.href="/management/order/list";
            },1000);
        },function (error) {
            $.ydcModal("fa fa-warning","操作提示","添加失败!"+$.parseJSON(error.responseText).message,"我知道了","");
        });
    })

</script>