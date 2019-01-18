<#include "../common/header.ftl">

<div class="content-wrapper">
    <section class="content-header">
        <div class="page-pos">当前位置：<span style="color: #ee7b33;">分类管理 > 产品分类</span></div>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box zr-box">
                    <div class="box-header">
                        <div class="row" style="padding-bottom: 20px;">
                            <div class="col-xs-8"><a id="addCategory" data-toggle="modal" data-target="#addPop" class="btn ydcbtn bg-olive"><i class="fa fa-plus"></i> 添加分类</a><#--<span style="margin-left: 40px; color: #999;font-size: 12px;">栏目暂不可删除，请认真规划后再进行添加</span>--></div>
                        </div>
                    </div>
                    <div class="box-body">
                        <div class="categoryTree">
                            <ul style="padding-left: 0;width: 640px;">
                                <li>
                                    <span><i class="fa fa-folder-open" style="margin-right: 6px;"></i> 全部分类</span>
                                    <ul id="categoryArea">

                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <#--添加类别-->
    <div class="modal fade" style="z-index: 1041" id="addPop" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog" style="width:700px">
            <div class="modal-content">
                <div class="modal-header"><h4 class="modal-title col-xs-8" style="font-size: 14px;">创建分类</h4><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button></div>
                <div class="modal-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label text-right zr-w150" for="name">选择分类归属</label>
                            <div class="col-sm-5">
                                <select class="form-control" id="selectCat"></select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label text-right zr-w150" for="displayOrder">分类名</label>
                            <div class="col-sm-5">
                                <input class="form-control" type="text" id="catName" placeholder="请输入给分类的名称">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn ydcbtn bg-olive" id="saveBtn"><i class="fa fa-save"></i> 保存</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <#--编辑分类-->
    <div class="modal fade" style="z-index: 1041" id="editPop" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog" style="width:700px">
            <div class="modal-content">
                <div class="modal-header"><h4 class="modal-title col-xs-8" style="font-size: 14px;">编辑分类</h4><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button></div>
                <div class="modal-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label text-right zr-w150" for="displayOrder">分类名</label>
                            <div class="col-sm-5">
                                <input class="form-control" type="text" id="editName" value="" placeholder="请输入给分类的名称">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn ydcbtn bg-olive" id="editSaveBtn"><i class="fa fa-save"></i> 保存</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
<#include "../common/footer.ftl">
<script type="text/javascript">
    $(function(){
        //导航
        navcontroller("category","产品类别");

        /*添加分类*/
        $("#saveBtn").bind("click",function(){
            if($("#catName").val()==""){
                $.ydcModal("fa fa-warning","提示信息","分类名称不能为空！","我知道了","");
                return false;
            };
            $.ydcAjax("POST","/mApi/category/create",JSON.stringify({
                "name":$("#catName").val(),
                "parentId":$("#selectCat option:selected").val()
            }),"json","application/json",function(){
                $.smallTips("添加成功！",true,1000);
                setTimeout(function(){
                    window.location.reload();
                },1000);
            },function(error){
                if(error.status==400){
                    var errorMsg = JSON.parse(error.responseText);
                    $.smallTips(errorMsg.message,true,2000);
                }else{
                    $.smallTips("发生一些错误，稍后再试！",true,2000);
                }
                return false;
            });
        });
        /*编辑分类*/
        $("#editSaveBtn").bind("click",function(){
            if($("#editName").val()==""){
                $.smallTips("分类名称不能为空！",true,1000);
                return false;
            };
            $.ydcAjax("PUT","/mApi/category/update",JSON.stringify({
                "id":$('#editPop').attr('data-id'),
                "name":$("#editName").val(),
            }),"json","application/json",function(){
                $.smallTips("修改成功！",true,1000);
                setTimeout(function(){
                    window.location.reload();
                },1000);
            },function(error){
                if(error.status==400){
                    var errorMsg = JSON.parse(error.responseText);
                    $.smallTips(errorMsg.message,true,2000);
                }else{
                    $.smallTips("发生一些错误，稍后再试！",true,2000);
                }
                return false;
            });
        });
    });

    function editBtn(id,e) {
        var name=e.getAttribute("data-name");
        $('#editPop #editName').val(name);
        $('#editPop').modal('show');
        $('#editPop').attr('data-id',id);
    }

    /*删除*/
    function deleteBtn(id){
        console.log(id);
        $.ydcAjax("DELETE","/mApi/category/delete/"+id,"","json","application/json",function(data){
            $.ydcModal("fa fa-warning","操作提示","删除成功!","自动刷新中……","");
            setTimeout(function(){
                window.location.reload();
            },1000);
        },function (error) {
            $.ydcModal("fa fa-warning","操作提示","删除失败!"+$.parseJSON(error.responseText).message,"我知道了","");
        });
    };

    function selectCat(data){
        var str='<option value="">顶级栏目</option>';
        $.each(data.list,function(idx,obj){
            str+='<option value="'+obj.id+'">'+obj.name+'</option>';
            if(obj.list.length>0){
                $.each(obj.list,function(sidx,sobj){
                    str+='<option value="'+sobj.id+'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|--'+sobj.name+'</option>';
                });
            };
        });
        return str;
    };

    $.ydcAjax("GET","/mApi/category/list","","json","application/json",function(data){
        $("#selectCat").append(selectCat(data));
        $.each(data.list,function(idx,obj){
            $("#categoryArea").append(firstLev(obj));
        });
        //收缩菜单
        $('.categoryTree li:has(ul)').addClass('parent_li');
        $('.no_parent_li').each(function(){
            if($(this).siblings('ul').length<1)
                $(this).find('.no_icon').hide()
        });
        $('.categoryTree li.parent_li > span').on('click', function (e) {
            var children = $(this).parent('li.parent_li').find(' > ul > li');
            if (children.is(":visible")) {
                children.hide('fast');
                $(this).find(' > i').addClass('fa-plus').removeClass('fa-minus');
            } else {
                children.show('fast');
                $(this).find(' > i').addClass('fa-minus').removeClass('fa-plus');
            }
            e.stopPropagation();
        });
        $('.categoryTree li.parent_li > span a').bind("click",function (e) {
            e.stopPropagation();
        });
    },"");
    function firstLev(obj){
        // 一级菜单
        var str='<li>'+
                '<span><i class="fa fa-minus" style="margin-right: 6px;"></i> '+obj.name+' <a class="btn btn-danger btn-flat deleteBtn" onclick="deleteBtn('+obj.id+')"><i class="fa fa-trash"></i></a><a class="btn btn-success btn-flat " onclick="editBtn('+obj.id+',this)" data-name="'+obj.name+'" title="编辑"><i class="fa fa-pencil"></i></a>' +
                statusFn(obj.status,obj.id);
        //二级菜单
        if(obj.list.length>0){
            str+='<ul>';
            $.each(obj.list,function(sidx,sobj){
                str+='<li>'+
                        '<span class="no_parent_li"><i class="fa fa-minus no_icon" style="margin-right: 6px;"></i> '+sobj.name+' <a class="btn btn-danger btn-flat deleteBtn" onclick="deleteBtn('+sobj.id+')"><i class="fa fa-trash"></i></a><a class="btn btn-success btn-flat editBtn" onclick="editBtn('+sobj.id+',this)" data-name="'+sobj.name+'" title="编辑"><i class="fa fa-pencil"></i></a>' +
                        statusFn(sobj.status,sobj.id)+'</span>';
                // 三级菜单
                if(sobj.list.length>0){
                    str+='<ul>';
                    $.each(sobj.list,function(tidx,tobj){
                        str+='<li>'+
                                '<span class="no_parent_li"><i class="fa fa-minus no_icon" style="margin-right: 6px;"></i> '+tobj.name+' <a class="btn btn-danger btn-flat deleteBtn" onclick="deleteBtn('+tobj.id+')"><i class="fa fa-trash"></i></a><a class="btn btn-success btn-flat editBtn" onclick="editBtn('+tobj.id+',this)" data-name="'+tobj.name+'" title="编辑"><i class="fa fa-pencil"></i></a>' +
                                statusFn(tobj.status,tobj.id)+'</span></li>';
                    });
                    str+='</ul>';
                }else{
                    str+='</li>';
                }
            });
            str+='</ul>';
        }else{
            str+='</li>';
        }
        return str;
    };
    function statusFn(status,itemid){
        var statusstr;
        if(status==1){
            statusstr = '<a class="btn btn-danger btn-flat" onclick="frozen('+itemid+',this)" title="下架">下架</a>';
        }else if(status==0){
            statusstr = '<a class="btn btn-success btn-flat" onclick="reinstate('+itemid+',this)" title="上架">上架</a>';
        };
        return statusstr;
    };
    function frozen(id,_this){
        $.ydcAjax("PUT","/mApi/category/resetStatus",JSON.stringify({"id":id,status:0}),"json","application/json",function(data){
            /*$(_this).removeClass("btn-danger").addClass("btn-success");
            $(_this).attr("onclick","reinstate("+id+",this)");
            $(_this).attr("title","上架");
            $(_this).text("上架");*/
            $.ydcModal("fa fa-warning","操作提示","下架成功!","自动刷新中……","");
            setTimeout(function(){
                window.location.reload();
            },1000);
        },function(error){
            $.ydcModal("fa fa-warning","操作提示","不可下架!"+$.parseJSON(error.responseText).message,"我知道了","");
        });
    };
    function reinstate(id,_this){
        $.ydcAjax("PUT","/mApi/category/resetStatus",JSON.stringify({"id":id,status:1}),"json","application/json",function(data){
            /*$(_this).removeClass("btn-success").addClass("btn-danger");
            $(_this).attr("onclick","frozen("+id+",this)");
            $(_this).attr("title","下架");
            $(_this).text("下架");*/
            $.ydcModal("fa fa-warning","操作提示","上架成功!","自动刷新中……","");
            setTimeout(function(){
                window.location.reload();
            },1000);
        },function(error){
            $.ydcModal("fa fa-warning","操作提示","不可上架!"+$.parseJSON(error.responseText).message+"！请先上架父类目！","我知道了","");
        });
    };

</script>