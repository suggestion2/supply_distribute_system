<#include "../common/header.ftl">

<div class="content-wrapper">
    <section class="content-header">
        <div class="page-pos">当前位置：<span style="color: #ee7b33;">管理中心 > 产品管理 > 产品列表</span></div>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box zr-box">
                    <div class="box-header">
                        <div class="row" style="padding-bottom: 20px;">
                            <div class="col-xs-5 pull-right">
                                <div class="input-group input-group-sm">
                                    <input type="text" placeholder="输入商品名称查询" style="width: 40%" id="searchName" class="form-control">
                                    <select class="form-control" id="status" style="width: 20%">
                                        <option value="" style="color: #999;">选择状态</option>
                                        <option value="0">下架</option>
                                        <option value="1">上架</option>
                                    </select>
                                    <select class="form-control" id="selectCat" style="width: 40%"></select>
                                    <span class="input-group-btn">
                                        <button class="btn ydcbtn bg-eg" onclick="searchBtn()"><i class="fa fa-search"></i></button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box-body no-padding">
                        <table id="brandList" class="table table-hover text-center" data-table="brandList">
                            <thead>
                                <tr>
                                    <th style="text-align: left;width: 200px">产品名称</th>
                                    <th>颜色</th>
                                    <th>售价(￥)</th>
                                    <th>成本价(￥)</th>
                                    <th>利润(￥)</th>
                                    <th>淘宝价(￥)<br>（分销商毛利）</th>
                                    <th>京东价(￥)<br>（分销商毛利）</th>
                                    <th width="150">备注</th>
                                    <th width="150">操作</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    <#--<div style="padding:15px 0 0 0;" id="checkallBtn">
                    </div>-->
                        <div style="text-align: center;margin-top: 30px;"><ul id="pages"></ul></div>

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
        navcontroller("goods","产品列表");
    });

    /*分类*/
    $.ydcAjax("GET","/mApi/category/list","","json","application/json",function(data){
        $("#selectCat").append(selectCat(data));
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


    var strUrl = window.location.toString();
    if(strUrl.indexOf("status=")<0){
        strUrl+="?status=all";
    }
    var pageName = strUrl.substr(strUrl .lastIndexOf("status")+7,strUrl.length-strUrl.lastIndexOf("status="));
    var pagingData;
    var checkallDown='<a href="javascript:;" class="btn btn-warning btn-flat" onclick="checkall()">全选</a>' +
            '<a href="javascript:;" class="btn btn-warning btn-flat" onclick="checkallno()">全不选</a>' +
            '<a href="javascript:;" class="btn btn-danger btn-flat" onclick="checkalldown()">批量下架</a>';
    var checkallUp='<a href="javascript:;" class="btn btn-warning btn-flat" onclick="checkall()">全选</a>' +
            '<a href="javascript:;" class="btn btn-warning btn-flat" onclick="checkallno()">全不选</a>' +
            '<a href="javascript:;" class="btn btn-danger btn-flat" onclick="checkallup()">批量上架</a>';

    newLoad();
    function newLoad() {
        switch (true){
            case pageName=="all":
                firstAjax({"content":$("#searchName").val(),"status":""});
                pagingData={"content":$("#searchName").val(),"status":""};
                break;
        };
    }

    //第一次请求
    function firstAjax(data){
        $("#pages").html("");
        $("#pages").parent().find(".pagesTotle").remove();
        data.pageIndex=0;
        data.pageSize=10;
        $.ydcAjax("POST","/mApi/goods/list",JSON.stringify(data),"json","application/json",goodsListFn,"");
    };

    //插入的内容
    function strCon(val){
        var str='',status;
        switch (true){
            case  val.status==0:status='<a href="javascript:;" onclick="forsale('+val.id+',this)" class="btn bg-olive btn-flat" title="上架">上架</a><a style="margin-left: 4px;" href="/management/goods/detail/'+val.id+'" class="btn bg-olive btn-flat" title="详情">详情</a><a class="btn btn-danger btn-flat " style="margin-left:4px" onclick="deleteBtn('+val.id+')"><i class="fa fa-trash"></i></a>';break;
            case  val.status==1:status='<a href="javascript:;" onclick="offShelf('+val.id+',this)" class="btn btn-danger btn-flat" title="下架">下架</a><a style="margin-left: 4px;" href="/management/goods/detail/'+val.id+'" class="btn bg-olive btn-flat" title="详情">详情</a>';break;
        };

        str += '<tr>' +
                '<td style="text-align: left">'+val.name+'</td>'+
                '<td>'+val.colour+'</td>'+
                '<td>'+val.price+'</td>' +
                '<td>'+val.lowSupplyPrice+'</td>' +
                '<td style="color: #f43838">'+val.profit1+'</td>' +
                '<td>'+val.taobaoPrice+'<br><span style="color: #f43838">('+val.profit2+')</span></td>' +
                '<td>'+val.jdPrice+'<br><span style="color: #f43838">('+val.profit3+')</span></td>' +
                '<td>'+val.remarks+'</td>' +
                '<td width="115">'+status;
        str+=  '</td></tr>';
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
            totalPages: Math.ceil(data.count/10),//总页数
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
                pagingData.pageSize=10;
                var data = JSON.stringify(pagingData);
                $.ydcAjax("POST","/mApi/goods/list",data,"json","application/json",function(newjson){
                    $('[data-table] tbody').html('');
                    $.each(newjson.list,function(idx,val){
                        $('[data-table] tbody').append(strCon(val));
                    });
                },"");
            }
        };
        var ifPage = data.count / 10;
        if(ifPage>=1){
            $("#pages").bootstrapPaginator(options);
            $("#pages").before(function(){
                var str='';
                str+='<ul class="pagesTotle"><li>共 '+data.count+' 条</li></ul>';
                return str;
            });
        }
    };

    function offShelf(id,_this) {
        $.ydcAjax("PUT","/mApi/goods/resetStatus",JSON.stringify({"id":id,"status":0}),"json","application/json",function(){
            //newLoad();
            //$(_this).parents("tr").remove();
            $.smallTips("商品下架成功，下架商品请在仓库中查看！",true,1000);
            setTimeout(function(){
                window.location.reload();
            },1000);
        },function(){
            $.smallTips("出现异常，请刷新页面或稍后再试！",true,1000);
        });

    };
    function forsale(id,_this){
        $.ydcAjax("PUT","/mApi/goods/resetStatus",JSON.stringify({"id":id,"status":1}),"json","application/json",function(){
            //newLoad();
            //$(_this).parents("tr").remove();
            $.smallTips("商品上架成功，上架商品请在出售中查看！",true,1000);
            setTimeout(function(){
                window.location.reload();
            },1000);
        },function(){
            $.smallTips("出现异常，请刷新页面或稍后再试！",true,1000);
        });
    };
    function stocksinput(id,_this){
        $(_this).parent().append('<span class="input-group-btn"><button type="button" class="btn btn-info btn-flat" onclick="savestocks('+id+',this)"><i class="fa fa-save" style="font-size: 1.6rem;"></i></button></span>');
    };
    function stocksinputout(_this){
        setTimeout(function(){
            $(_this).parent().find("span").remove();
        },500);
    };
    function savestocks(id,_this){
        var stocks = $(_this).parents("tr").find("input[data-stocks]").val();
        var datastocks = $(_this).parents("tr").find("input").attr("data-stocks");
        if(!(/(^[0-9]\d*$)/.test(stocks))){
            $.smallTips("只能输入大于0的整数！",true,2000);
            $(_this).parents("tr").find("input[data-stocks]").val(datastocks);
            return false;
        }
        $.ydcAjax("PUT","/api/goods/updateStocks",JSON.stringify({"id":id,"stocks":stocks}),"json","application/json",function(){
            $(_this).parent().find("span").remove();
            $(_this).parents("tr").find("input").attr("data-stocks",stocks);
            $.smallTips("商品库存修改成功！",true,2000);
        },function(error){
            if(error.status=="400"){
                $.ydcModal("fa fa-warning","提示信息",$.parseJSON(error.responseText).message,"我知道了","");
                $(_this).parents("tr").find("input[data-stocks]").val(datastocks);
                return false;
            }else{
                $.ydcModal("fa fa-warning","提示信息","出现异常，请刷新页面或稍后再试！","我知道了","");
                $(_this).parents("tr").find("input[data-stocks]").val(datastocks);
                return false;
            }
        });
    };
    function searchBtn(){
        if(pageName=="all"){
            var level=$('#selectCat').find('option:selected').attr('data-level');

            if(level!=undefined){
                switch (level) {
                    case '1':
                        var categoryId1=$('#selectCat').val();
                        var pagingData="";
                        firstAjax({"content":$("#searchName").val(),"status":$('#status').val(),categoryId1:categoryId1});
                        pagingData={"content":$("#searchName").val(),"status":$('#status').val(),categoryId1:categoryId1};
                        break;
                    case '2':
                        var categoryId2=$('#selectCat').val();
                        var pagingData="";
                        firstAjax({"content":$("#searchName").val(),"status":$('#status').val(),categoryId2:categoryId2});
                        pagingData={"content":$("#searchName").val(),"status":$('#status').val(),categoryId2:categoryId2};
                        break;
                    case '3':
                        var categoryId3=$('#selectCat').val();
                        var pagingData="";
                        firstAjax({"content":$("#searchName").val(),"status":$('#status').val(),categoryId3:categoryId3});
                        pagingData={"content":$("#searchName").val(),"status":$('#status').val(),categoryId3:categoryId3};
                        break;
                }
            }


        }
    };
    /*刪除*/
    function deleteBtn(id) {
        $.ydcAjax("DELETE","/mApi/goods/delete/"+id,"","json","application/json",function(data){
            $.ydcModal("fa fa-warning","操作提示","删除成功!","自动刷新中……","");
            setTimeout(function(){
                window.location.reload();
            },1000);
        },function (error) {
            $.ydcModal("fa fa-warning","操作提示","删除失败!"+$.parseJSON(error.responseText).message,"我知道了","");
        });
    }
</script>