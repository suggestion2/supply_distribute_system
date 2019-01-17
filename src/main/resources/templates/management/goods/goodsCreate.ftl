<#include "../common/header.ftl">

<div class="content-wrapper">
    <section class="content-header">
        <div class="page-pos">当前位置：<span style="color: #ee7b33;">管理中心 > 产品管理 > 产品录入</span></div>
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
                                        <p>基本信息</p>
                                    </div>
                                    <div class="col-xs-10 gright">
                                        <div class="form-horizontal">
                                            <div class="form-group" style="padding-top: 30px;">
                                                <label class="col-sm-2 control-label text-right zr-w150" for="name"><span style="color:red">*</span> 产品名称</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" id="name" value="" maxlength="50" placeholder="必填项，不能超过50字符或汉字">
                                                    <p class="tips"></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" style="margin-top: 2px;">
                                    <div class="col-xs-2 gleft"><p>价格信息</p></div>
                                    <div class="col-xs-10 gright" style="padding-top: 30px;">
                                        <div class="form-horizontal">
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label text-right zr-w150"><span style="color:red">*</span> 商品分类</label>
                                                <div class="col-sm-7">
                                                    <div class="col-sm-4" style="padding-left: 0">
                                                        <select class="form-control" id="category1"></select>
                                                    </div>
                                                    <div class="col-sm-4" style="padding-left: 0">
                                                        <select class="form-control" id="category2"></select>
                                                    </div>
                                                    <div class="col-sm-4" style="padding-left: 0">
                                                        <select class="form-control" id="category3"></select>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label text-right zr-w150"><span style="color:red">*</span> 颜色：</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" id="colour" value="" placeholder="请输入颜色">
                                                    <p class="tips"></p>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label text-right zr-w150"><span style="color:red">*</span> 价格：</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" id="price" value="" placeholder="请输入价格">
                                                    <p class="tips"></p>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label text-right zr-w150"><span style="color:red">*</span> 淘宝/天猫价：</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" id="taobaoPrice" value="" placeholder="请输入淘宝/天猫价">
                                                    <p class="tips"></p>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label text-right zr-w150"><span style="color:red">*</span> 京东价：</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" id="jdPrice" value="" placeholder="请输入京东价">
                                                    <p class="tips"></p>
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
                                        <p>供应商</p>
                                    </div>
                                    <div class="col-xs-10 gright" style="padding:30px;">
                                        <div class="form-horizontal">
                                            <div id="skuboxarea">
                                                <div class="skubox">

                                                </div>
                                                <div>
                                                    <a href="javascript:;" class="btn ydcbtn btn-primary btn-flat" onclick="addSkuItem()"><i class="fa fa-plus"></i> 添加供应商</a>
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
    $(function(){
        //导航
        navcontroller("goods","产品录入");

    });
    /*供应商*/
    var supplierList;
    $.ydcAjax("POST","/mApi/supplier/list",JSON.stringify({content:''}),"json","application/json",function (data) {
        supplierList=data.list;
    },"");

    /*加载品类*/
    var categoryObj;
    var sList;  /*二级分类*/
    $.ydcAjax("GET","/mApi/category/list","","json","application/json",function(data){
        $("#category1,#category2,#category3").html("");
        if(data.list.length>0){
            $.each(data.list,function(idx,obj){
                $("#category1").append("<option value='"+obj.id+"'>"+obj.name+"</option>");
            });
            if(data.list[0].list.length>0){
                sList=data.list[0].list;
                $.each(data.list[0].list,function(cidx,cobj){
                    $("#category2").append("<option value='" + cobj.id + "'>" + cobj.name + "</option>");
                });
                if(data.list[0].list[0].list.length>0){
                    $.each(data.list[0].list[0].list,function (tidx,tobj) {
                        $("#category3").append("<option value='" + tobj.id + "'>" + tobj.name + "</option>");
                    })
                }
            }else{
                $.smallTips("请先补全类目，否则无法创建！",true,2000);
            };
        }else{
            $.smallTips("请先创建商品类目，否则无法创建！",true,2000);
        };
        categoryObj=data;
    },"");

    /*分类联动*/
    $("#category1").on("change",function(){
        var cat1=$(this).find("option:selected").val();
        $.each(categoryObj.list,function(idx,obj){
            if(cat1==obj.id){
                if(!categoryObj.list[idx].list.length>0){
                    //$.ydcModal("fa fa-warning","提示信息","栏目不全，请先添加完整三级栏目。","我知道了","");
                    $("#category2").html("");
                    $("#category3").html("");
                    return false;
                }
                $("#category2").html("");
                $("#category3").html("");
                sList=categoryObj.list[idx].list;
                $.each(categoryObj.list[idx].list,function(cidx,cobj){
                    $("#category2").append("<option value='" + cobj.id + "'>" + cobj.name +"</option>");
                    if(categoryObj.list[idx].list[0].list.length>0){
                        $.each(categoryObj.list[idx].list[0].list,function(tidx,tobj){
                            $("#category3").append("<option value='" + tobj.id + "'>" + tobj.name +"</option>");
                        })
                    }
                });
            };
        });
        if($("#category2").html()==""){
            $.smallTips("请先补全类目，否则无法创建！",true,2000);
        }
    });

    $("#category2").on("change",function(){
        var cat2=$(this).find("option:selected").val();
        $.each(sList,function(idx,obj){
            if(cat2==obj.id){
                if(!sList[idx].list.length>0){
                    //$.ydcModal("fa fa-warning","提示信息","栏目不全，请先添加完整三级栏目。","我知道了","");
                    $("#category3").html("");
                    return false;
                }
                $("#category3").html("");
                $.each(sList[idx].list,function(cidx,cobj){
                    if(cobj.status!==0) {
                        $("#category3").append("<option value='" + cobj.id + "'>" + cobj.name +"</option>");
                    }
                });
            };
        });
        if($("#category3").html()==""){
            $.smallTips("请先补全类目，否则无法创建！",true,2000);
        }
    });

    /*添加供应商*/
    var cookid=0;
    function addSkuItem(){
        /*if($(".skuitem").length>1){
            $.smallTips("只能创建2级sku，不可再添加！",true,1000);
            return false;
        };*/
        /*供应商列表*/
        var supplierSrc='';
        for(var i in supplierList){
            supplierSrc+='<option value="'+supplierList[i].id+'">' + supplierList[i].name +'</option>';
        }

        var str='';
        str='<div class="skuitem" data-id="n'+cookid+'" data-level="'+cookid+'">'+
                '<div style="border:1px solid #e7eaec;padding:10px;margin-bottom: 10px;">'+
                '<div class="form-group" style="margin-bottom: 0">'+
                '<div class="col-sm-12">'+
                '<div class="input-group inputgroupspc">'+
                '<select name="n'+cookid+'" class="form-control supplierName">' +
                '<option value="-1">请选择供应商</option>' +supplierSrc+
                '</select>'+
                '<input type="text" name="n'+cookid+'" class="form-control supplyPrice" value="" placeholder="对应价格">'+
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
    /*删除供应商*/
    function removeSpec(pid){
        $(".skuitem[data-id="+pid+"]").remove();
        cookid--;
    }


    /*保存*/
    $('#saveBtn').on('click',function () {
        if($("#name").val()==""){
            $.smallTips("产品名称不能为空",true,1000);
            return false;
        }else if($("#category1").val()=="" || $("#category2").val()==""||$("#category3").val()==""){
            $.smallTips("商品类目必须都选择",true,1000);return false;
        }else if($("#colour").val()==""){
            $.smallTips("颜色必须填写",true,1000);return false;
        }else if($("#price").val()==""){
            $.smallTips("价格必须填写",true,1000);return false;
        }else if($("#taobaoPrice").val()==""){
            $.smallTips("淘宝价必须填写",true,1000);return false;
        }else if($("#jdPrice").val()==""){
            $.smallTips("京东价必须填写",true,1000);return false;
        }else if(cookid==0){
            $.smallTips("请添加供应商",true,1000);return false;
        }


        var goodsSupplyList=[];
        $('.skuitem').each(function () {
            if($(this).find('.supplierName').val()==-1){
                $.smallTips("请选择供应商",true,1000);return false;
            }else if($(this).find('.supplyPrice').val()==''){
                $.smallTips("请填写价格",true,1000);return false;
            }else{
                goodsSupplyList.push({supplierId:$(this).find('.supplierName').val(),supplierName:$(this).find('.supplierName').find("option:selected").text(),supplyPrice:$(this).find('.supplyPrice').val()})
            }
        });

        var data={
            name:$("#name").val(),
            categoryId1:$("#category1").val(),
            categoryId2:$("#category2").val(),
            categoryId3:$("#category3").val(),
            category1:$("#category1").find('option:selected').text(),
            category2:$("#category2").find('option:selected').text(),
            category3:$("#category3").find('option:selected').text(),
            colour:$("#colour").val(),
            price:$("#price").val(),
            taobaoPrice:$("#taobaoPrice").val(),
            jdPrice:$("#jdPrice").val(),
            remarks:$("#remarks").val(),
            goodsSupplyList:goodsSupplyList,
        }

        $.ydcAjax("POST","/mApi/goods/create",JSON.stringify(data),"json","application/json",function (data) {
            $.smallTips("添加成功！请到列表中查看",true,1000);
            setTimeout(function(){
                window.location.href="/management/goods/list";
            },1000);
        },"");
    })
</script>