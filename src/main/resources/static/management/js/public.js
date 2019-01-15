$(function(){
    var htmlheight = $(window).height();
    $(".content-wrapper").css("height",htmlheight-108+"px");
    $(window).resize(function(){
        var htmlheight = $(window).height();
        $(".content-wrapper").css("height",htmlheight-108+"px");
    });

    $("[data-osspath]").each(function(){
        var path = $(this).attr('data-osspath');
        $(this).attr('src',path+'?t='+Date.parse(new Date()));
    });

    $(document).off('click.bs.dropdown.data-api');
    dropdownOpen();

    //全局ajax设置

    $.ajaxSetup({
        statusCode: {
            401:function(){
                window.location.href = "/management/login?redirectUrl=" + window.location.pathname;
            }
        },
        success: function(data){

        }
    });
});

//前端导航控制方式
function navcontroller(navName,secondNav){
    console.log(navName,secondNav)
    $(".sidebar-menu li a[href='#"+navName+"']").parent().addClass("active");
    $(".tab-pane[data-nav="+navName+"]").addClass("active");
    $(".tab-pane[data-nav="+navName+"] li[data-navname="+secondNav+"]").addClass("active");
};

//强制带两位小数
function changeTwoDecimal_f(x) {
    var f_x = parseFloat(x);
    x=x.toString();
    var a=((x.split(".")).length-1);
    if (isNaN(f_x)||a>1){
        return '0.00';
    };
    var f_x = Math.round(f_x*100)/100;
    var s_x = f_x.toString();
    var pos_decimal = s_x.indexOf('.');
    if (pos_decimal < 0){
        pos_decimal = s_x.length;
        s_x += '.';
    }
    while (s_x.length <= pos_decimal + 2){
        s_x += '0';
    }
    return s_x;
};



//鼠标划过展开子菜单
function dropdownOpen() {
    var $dropdownLi = $('li.dropdown');
    $dropdownLi.mouseover(function() {
        $(this).addClass('open');
    }).mouseout(function() {
        $(this).removeClass('open');
    });
};

//提示模态框
$.ydcModal=function(iconClass,headerVal,content,btnVal,fn){
    $("#modalBox").remove();
    var modalStr = '';
    modalStr += '<div class="modal fade" id="modalBox">'+
        '<div class="modal-dialog">'+
        '<div class="modal-content">'+
        '<div class="modal-header"><h4 class="modal-title" id="myModalLabel" style="font-size: 14px;"><i class="'+iconClass+'"></i> &nbsp;'+headerVal+'</h4></div>'+
        '<div class="modal-body" style="text-align: center;">'+content+'</div>'+
        '<div class="modal-footer"><button type="button" class="btn bg-olive btn-flat" data-dismiss="modal" style="height:34px;padding:2px 32px;border-radius: 3px;">'+btnVal+'</button></div></div></div></div>';
    $("body").prepend(modalStr);
    $('#modalBox').modal('show');
    $(".modal-footer .btn").bind("click",fn);
};

//确认模态框
$.ydcModal2=function(iconClass,headerVal,content,btnVal1,btnVal2,fn){
    $("#modalBox").remove();
    var modalStr = '';
    modalStr += '<div class="modal fade" id="modalBox">'+
        '<div class="modal-dialog">'+
        '<div class="modal-content">'+
        '<div class="modal-header"><h4 class="modal-title" id="myModalLabel" style="font-size: 14px;"><i class="'+iconClass+'"></i> &nbsp;'+headerVal+'</h4></div>'+
        '<div class="modal-body" style="text-align: center;">'+content+'</div>'+
        '<div class="modal-footer"><button type="button" class="btn bg-olive btn-flat" data-dismiss="modal" style="height:34px;padding:2px 32px;border-radius: 3px;">'+btnVal1+'</button><button type="button" id="val2btn" class="btn bg-red btn-flat" style="height:34px;padding:2px 32px;border-radius: 3px; margin-left: 15px;">'+btnVal2+'</button></div></div></div></div>';
    $("body").prepend(modalStr);
    $('#modalBox').modal('show');
    $("#val2btn").bind("click",fn);
};

//ajax
$.ydcAjax=function(post,url,data,dataType,contentType,fn1,fn2){
    $.ajax({
        type: post,
        url: url,
        data: data,
        dataType: dataType,
        contentType: contentType,
        before:function(){
            //console.log(data);
        },
        success:fn1,
        error:fn2
    });

};

//省市区三级联动，要在页面先导入json文件，将下面方法写在jsonContent中，要传入data值
$.selectAreaFn=function(data,pro,city,area){
    pro=$("#"+pro);
    city=$("#"+city);
    area=$("#"+area);
    pro.on("change",function(){
        var proid=$(this).find("option:selected").val();
        $.each(data,function(idx,obj){
            if(proid==obj.id){
                city.html("");area.html("");
                $.each(data[idx].sub,function(cidx,cobj){
                    city.append("<option value='"+cobj.id+"'>"+cobj.name+"</option>");
                });
                $.each(data[idx].sub[0].sub,function(aidx,aobj){
                    area.append("<option value='"+aobj.id+"'>"+aobj.name+"</option>");
                });
            };
        });
    });
    city.on("change",function(){
        var cityid=$(this).find("option:selected").val();
        $.each(data,function(idx,obj){
            $.each(obj.sub,function(cidx,cobj){
                if(cobj.id==cityid){
                    area.html("");
                    $.each(cobj.sub,function(aidx,aobj){
                        area.append("<option value='"+aobj.id+"'>"+aobj.name+"</option>");
                    });
                }
            });
        });
    });
};

$.smallTips=function(content,autoHide,setTime){
    $(".smalltips").remove();
    $(".smalltipsBg").remove();
    var str='<div class="smalltipsBg" style="position: fixed;top:0;left:0;bottom:0;right:0;background: transparent;z-index: 1060;"></div><div class="smalltips" style="position: fixed;top:60px;left:50%;margin-left:-130px;z-index:1061;width: 260px;line-height: 24px;padding: 20px;background:rgba(0,0,0,.7);color: #fff;text-align: center;font-size: 14px;">'+content+'</div>';
    $("body").append(str);
    if(autoHide){
        setTimeout(function(){
            $(".smalltipsBg").fadeOut();
            $(".smalltips").fadeOut();
            setTimeout(function(){
                $(".smalltipsBg").remove();
                $(".smalltips").remove();
            },1000);
        },setTime);
    }

};
//保留固定位浮点数，不补0
function formatnumber(val,num){
    var num1=parseFloat(val);
    var pow=Math.pow(10,num);
    if(!isNaN(num1)){
        num1 = Math.round(num1*pow)/pow;
    };
    return num1;
};