<#include "common/header_base.ftl">
<style>
    html,body{
        min-width: auto;
        background: #fafafa;
    }
    ul,li{
        list-style: none;
        margin: 0;
        padding: 0;
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
    .sidebar{
        position: fixed;
        left: 0;
        top: 44px;
        right: 0;
        width: 100%;
        background: #fff;
        padding-bottom: 0;
    }
    .sidebar .class-box{
        display: -webkit-box;
        overflow-x: auto;
        -webkit-overflow-scrolling: touch;
        white-space: nowrap;
        display: -ms-flexbox;
        display: flex;
        list-style: none;
        padding: 0;
        margin: 0;
    }
    .sidebar .class-box li{
        list-style: none;
    }
    .sidebar .class-box li a{
        text-align: center;
        text-indent: 0;
        margin: 0 8px;
        font-size: 12px;
        height: 40px;
        position: relative;
        line-height: 40px;
        display: inline-block;
        color: #666;
    }
    .sidebar .class-box li{
        -webkit-box-flex: 1;
        -ms-flex: 1;
        flex: 1;
        border-bottom: none;
    }
    .sidebar .class-box li.current a{
        color: #f74a4a;
        border-bottom: 2px solid #f74a4a;
    }
    .maincont{
        padding-top: 10px;
    }
    .maincont .filter-box{
        background: #fff;
        padding-bottom: 8px;
        font-size: 12px;
    }
    .cate{
        padding-top: 16px;
    }
    .cate .cate-item{
        line-height: 20px;
    }
    .cate .cate-item label{
        color: #999;
        float: left;
        width: 80px;
        text-align: center;
        margin-bottom: 8px;
    }
    .cate .cate-item ul{
        float: left;
    }
    .cate .cate-item ul li{
        float: left;
        margin: 0px 16px 8px 0;
        cursor: pointer;
        padding:0 4px;
        color: #666;
    }
    .cate .cate-item ul li.current{
        color: #f74a4a;
    }
    .cate .cate-item ul li:first-child{
        margin-left: 0;
    }

    .cate .cate-item.type1 li{
        border: 1px solid #999;
    }
    .cate .cate-item.type1 li.current{
        border: 1px solid #999;
    }


    /* flex布局 */
    .flex-wrp{
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
    }
    .flex-wrp .flex-item{
        -webkit-box-flex: 1;
        -webkit-flex: 1;
        -ms-flex: 1;
        flex: 1;
    }

    .listwrap .goodsList{
        padding: 8px 8px;
    }
    .listwrap .goodsList .goods-item{
        margin-bottom: 8px;
        background: #fff;
        border: 1px solid #ffc3c3;
        border-radius: 4px;
        overflow: hidden;
    }
    .listwrap .goodsList .goods-item .goods-h{
        padding: 12px 8px;
    }
    .listwrap .goodsList .goods-item .goods-h .info .name{
        font-size: 13px;
        margin-bottom: 4px;
    }
    .listwrap .goodsList .goods-item .goods-h .info .remark{
        color: #999;
        font-size: 12px;
        margin-bottom: 4px;
    }
    .listwrap .goodsList .goods-item .goods-h .info .color{
        color: #999;
        font-size: 12px;
        margin-bottom: 4px;
    }
    .listwrap .goodsList .goods-item .goods-h .info .priceLow{
        color: #999;
        font-size: 12px;
        margin-bottom: 4px;
    }

    .listwrap .goodsList .goods-item .goods-h .price{
        width: 80px;
        font-size: 14px;
        color: #f74a4a;
        text-align: right;
        padding-top: 24px;
    }
    .listwrap .goodsList .goods-item .goods-h .price h5{
        font-size: 18px;
        color: #f74a4a;
        font-weight: bold;
    }
    .listwrap .goodsList .goods-item .goods-f{
        text-align: center;
    }
    .listwrap .goodsList .goods-item .goods-f>div{
        padding: 4px 0;
        color: #fff;
    }
    .listwrap .goodsList .goods-item .goods-f>div label{
        font-size: 13px;
        font-weight: bold;
        margin-bottom: 0;
    }
    .listwrap .goodsList .goods-item .goods-f>div p{
        font-size: 12px;
        margin-bottom: 0;
    }
    .listwrap .goodsList .goods-item .goods-f>div:first-child{
        background: #ffb197;
    }
    .listwrap .goodsList .goods-item .goods-f>div:last-child{
        background: #ff7979;
    }
</style>
<body style="position: relative;min-height: auto;height: auto">
<div class="wapIndex" style="padding-top: 84px">
    <div class="wapNav clearfix">
        <div class="navItem pull-left">每日行情</div>
        <div class="navItem pull-right">数据统计</div>
    </div>
    <div class="sidebar">
        <ul class="class-box">
            <li class="current" onclick="chooseCateOne('all')" data-id="all"><a>全部分类</a></li>
        </ul>
    </div>
    <div class="maincont">
        <div class="filter-box clear">
            <div class="cate">
                <div class="cate-item type1 flex-wrp">
                    <label>二级类</label>
                    <ul class="clear flex-item">
                        <li onclick="chooseCateTwo('all')" class="current" data-id="all">全部</li>
                    </ul>
                </div>
                <div class="cate-item type2 flex-wrp">
                    <label>三级类</label>
                    <ul class="clear flex-item">
                        <li onclick="chooseCateThree('all')" class="current" data-id="all">全部</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="listwrap mt10 clearfix">
            <div class="goodsList">

            </div>
            <div style="text-align: center;margin-top: 30px;"><ul id="pages"></ul></div>
        </div>
    </div>
</div>
<script src="/resources/management/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/management/js/public.js"></script>
<script src="/resources/management/plugins/bootstrap/js/bootstrap-paginator.min.js" type="text/javascript"></script>
<script>
    /*分类*/
    var cateList=[];
    var cateOneId=null,cateTwoId=null,cateThreeId=null;
    var cateTwoList=[],cateThreeList=[];
    $.ydcAjax("GET","/mApi/category/list","","json","application/json",function(data){
        cateList=data.list;
        var str='';
        $.each(cateList,function (idx,val) {
            str+='<li onclick="chooseCateOne('+val.id+')" data-id="'+val.id+'"><a>'+val.name+'</a></li>'
        })
        $('.class-box').append(str);
    },"");

    /*选择一级品类*/
    function chooseCateOne(id) {
        $('.cate .type1 ul').html('<li onclick="chooseCateTwo(\'all\')" class="current" data-id="all">全部</li>');
        $('.cate .type2 ul').html('<li onclick="chooseCateThree(\'all\')" class="current" data-id="all">全部</li>');
        $('.class-box li').each(function () {
           if($(this).attr('data-id')==id){
               $(this).addClass('current').siblings().removeClass('current');
           }
        });
        if(id=='all'){
            cateOneId=null;
            cateTwoId=null;
            cateThreeId=null;
            cateTwoList=[];
            cateThreeList=[];
            $('.cate .type1 ul').html('<li onclick="chooseCateTwo(\'all\')" class="current" data-id="all">全部</li>');
            $('.cate .type2 ul').html('<li onclick="chooseCateThree(\'all\')" class="current" data-id="all">全部</li>');

            id='';
        }else{
            cateOneId=id;
            $.each(cateList,function (idx,val) {
                if(val.id==id){
                    cateTwoList=cateList[idx].list;
                    var str='';
                    $.each(cateTwoList,function (idx,val) {
                        str+='<li onclick="chooseCateTwo('+val.id+')" data-id="'+val.id+'">'+val.name+'</li>'
                    });
                    $('.cate .type1 ul').append(str);
                }
            });
        }
        var pagingData="";
        firstAjax({categoryId1:id,categoryId2:'',categoryId3:''});
        pagingData={categoryId1:id,categoryId2:'',categoryId3:''};
    }
    /*选择二级品类*/
    function chooseCateTwo(id) {
        $('.cate .type2 ul').html('<li onclick="chooseCateThree(\'all\')" class="current" data-id="all">全部</li>');
        $('.cate .type1 ul li').each(function () {
            if($(this).attr('data-id')==id){
                $(this).addClass('current').siblings().removeClass('current');
            }
        });
        if(id=='all'){
            cateTwoId=null;
            cateThreeId=null;
            cateThreeList=[];
            $('.cate .type2 ul').html('<li onclick="chooseCateThree(\'all\')" class="current" data-id="all">全部</li>');
            id='';
        }else{
            cateTwoId=id;
            $.each(cateTwoList,function (idx,val) {
                if(val.id==id){
                    cateThreeList=cateTwoList[idx].list;
                    var str='';
                    $.each(cateThreeList,function (idx,val) {
                        str+='<li onclick="chooseCateThree('+val.id+')" data-id="'+val.id+'">'+val.name+'</li>'
                    });
                    $('.cate .type2 ul').append(str);
                }
            });
        }
        var pagingData="";
        firstAjax({categoryId1:cateOneId,categoryId2:id,categoryId3:''});
        pagingData={categoryId1:cateOneId,categoryId2:id,categoryId3:''};
    }
    /*选择三级品类*/
    function chooseCateThree(id) {
        $('.cate .type2 ul li').each(function () {
            if($(this).attr('data-id')==id){
                $(this).addClass('current').siblings().removeClass('current');
            }
        });
        if(id=='all'){
            cateThreeId=null;
            id='';
        }else{
            cateThreeId=id;
        }
        var pagingData="";
        firstAjax({categoryId1:cateOneId,categoryId2:cateTwoId,categoryId3:id});
        pagingData={categoryId1:cateOneId,categoryId2:cateTwoId,categoryId3:id};
    }

    var pagingData;
    newLoad();
    function newLoad() {
        firstAjax({"content":"","categoryId1":"","categoryId2":"","categoryId3":"","pageIndex":"0","pageSize":"10"});
        pagingData={"content":"","categoryId1":"","categoryId2":"","categoryId3":"","pageIndex":"0","pageSize":"10"};
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
        var str='';

        str+='<div class="goods-item">' +
                '    <div class="goods-h flex-wrp">' +
                '        <div class="info flex-item">' +
                '            <h5 class="name">'+val.name+'</h5>' +
                '            <p class="remark">备注：'+val.remarks+'</p>' +
                '            <p class="color">颜色：'+val.colour+'</p>' +
                '            <p class="priceLow">成本价：<span style="font-weight: bold;color: #333;font-size: 14px">￥'+(val.lowSupplyPrice).toFixed(2)+'</span>（<span style="color: #f43838;font-size: 13px">￥'+(val.profit1).toFixed(2)+'</span>）</p>'+
                '        </div>' +
                '        <div class="price">' +
                '            <span style="color: #333">售价<span><h5 style="margin: 0">￥'+(val.price).toFixed(2)+'</h5>' +
                '        </div>' +
                '    </div>' +
                '    <div class="goods-f flex-wrp">' +
                '        <div class="flex-item">' +
                '            <label>淘宝/天猫</label>' +
                '            <p>￥'+(val.taobaoPrice).toFixed(2)+'(赚￥'+(val.profit2).toFixed(2)+')</p>' +
                '        </div>' +
                '        <div class="flex-item">' +
                '            <label>京东</label>' +
                '            <p>￥'+(val.jdPrice).toFixed(2)+'(赚￥'+(val.profit3).toFixed(2)+')</p>' +
                '        </div>' +
                '    </div>' +
                '</div>'
        return str;
    };

    //数据请求成功，调用方法
    function goodsListFn(data){
        //第一次插入
        $('.goodsList').html('');
        $.each(data.list,function(idx,val){
            $('.goodsList').append(strCon(val));
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
                    $('.goodsList').html('');
                    $.each(newjson.list,function(idx,val){
                        $('.goodsList').append(strCon(val));
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
</script>
</body>
</html>
