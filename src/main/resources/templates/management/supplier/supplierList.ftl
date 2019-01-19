<#include "../common/header.ftl">

<div class="content-wrapper">
    <section class="content-header">
        <div class="page-pos">当前位置：<span style="color: #ee7b33;">供应商商管理 > 供应商列表</span></div>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box zr-box">
                    <div class="box-header">
                        <div class="row" style="padding-bottom: 20px;">
                            <div class="col-xs-4">
                                <a id="addDistributor" data-toggle="modal" data-target="#addPop" class="btn ydcbtn bg-olive"><i class="fa fa-plus"></i> 添加供应商</a>
                            </div>
                            <div class="col-xs-8">
                                <div class="input-group input-group-sm col-xs-5 pull-right">
                                    <input type="text" placeholder="输入供应商名称" id="searchContent" class="form-control" style="border-top-left-radius: 0;border-bottom-left-radius:0;">
                                    <span class="input-group-btn">
                                        <button class="btn ydcbtn bg-eg" onclick="searchBtn()"><i class="fa fa-search"></i></button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box-body table-responsive no-padding">
                        <table id="customerList" class="table table-hover text-center" data-table="customerList">
                            <thead>
                            <tr>
                                <th>供应商名称</th>
                                <th>联系人</th>
                                <th>联系电话</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                        <div style="text-align: center;margin-top: 30px;"><ul id="pages"></ul></div>

                    </div>
                </div>
            </div>
        </div>
    </section>
    <#--添加供应商-->
    <div class="modal fade" style="z-index: 1041" id="addPop" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog" style="width:700px">
            <div class="modal-content">
                <div class="modal-header"><h4 class="modal-title col-xs-8" style="font-size: 14px;">创建分销商</h4><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button></div>
                <div class="modal-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label text-right zr-w150" for="name">名称</label>
                            <div class="col-sm-7">
                                <input class="form-control" type="text" id="addName" placeholder="请输入分销商名称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label text-right zr-w150" for="displayOrder">联系人</label>
                            <div class="col-sm-7">
                                <input class="form-control" type="text" id="addContact" placeholder="请输入联系人">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label text-right zr-w150" for="displayOrder">联系人电话</label>
                            <div class="col-sm-7">
                                <input class="form-control" type="text" id="addPhone" placeholder="请输入联系人电话">
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
    <#--编辑供应商-->
    <div class="modal fade" style="z-index: 1041" id="editPop" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog" style="width:700px">
            <div class="modal-content">
                <div class="modal-header"><h4 class="modal-title col-xs-8" style="font-size: 14px;">编辑分销商</h4><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button></div>
                <div class="modal-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label text-right zr-w150" for="name">名称</label>
                            <div class="col-sm-7">
                                <input class="form-control" type="text" id="editName" placeholder="请输入分销商名称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label text-right zr-w150" for="displayOrder">联系人</label>
                            <div class="col-sm-7">
                                <input class="form-control" type="text" id="editContact" placeholder="请输入联系人">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label text-right zr-w150" for="displayOrder">联系人电话</label>
                            <div class="col-sm-7">
                                <input class="form-control" type="text" id="editPhone" placeholder="请输入联系人电话">
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
        navcontroller("supplier","供应商列表");

    });

    $("#saveBtn").bind("click",function(){
        if($("#addName").val()==""){
            $.ydcModal("fa fa-warning","提示信息","分类名称不能为空！","我知道了","");
            return false;
        }else if($("#addContact").val()==""){
            $.ydcModal("fa fa-warning","提示信息","联系人不能为空！","我知道了","");
            return false;
        }else if($("#addPhone").val()==""){
            $.ydcModal("fa fa-warning","提示信息","电话不能为空！","我知道了","");
            return false;
        }else if($("#addAccount").val()==""){
            $.ydcModal("fa fa-warning","提示信息","账号不能为空！","我知道了","");
            return false;
        };
        $.ydcAjax("POST","/mApi/supplier/create",JSON.stringify({
            "name":$("#addName").val(),
            "contact":$("#addContact").val(),
            "phone":$("#addPhone").val(),
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

    newLoad();
    function newLoad() {
        firstAjax({"content": $("#searchContent").val()});
        pagingData = {"content": $("#searchContent").val()};
    }

    function firstAjax(data) {
        $("#pages").html("");
        $("#pages").parent().find(".pagesTotle").remove();
        data.pageIndex = 0;
        data.pageSize = 10;
        $.ydcAjax("POST", "/mApi/supplier/list", JSON.stringify(data), "json", "application/json", customerListFn, "");
    };
    function strCon(data){
        var str='';
        $.each(data.list,function (idx,val) {
            var opt='<td><a href="javascript:;" onclick="editBtn('+JSON.stringify(val).replace(/\"/g,"'")+')" style="margin-left: 4px" class="btn bg-olive btn-flat" title="编辑"><i class="fa fa-pencil"></i></a><a href="javascript:;" onclick="deleteBtn('+val.id+')" style="margin-left: 4px" class="btn btn-danger btn-flat" title="删除">删除</a></td>'
            str+='<tr>' +
                    '<td>'+val.name+'</td>' +
                    '<td>'+val.contact+'</td>' +
                    '<td>'+val.phone+'</td>' +
                    opt+
                    '</tr>'
        });
        return str;
    };
    /*填充数据*/
    function customerListFn(data) {
        //第一次插入
        $('[data-table] tbody').html('');
        $('[data-table] tbody').append(strCon(data));

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
                $.ydcAjax("POST","/mApi/supplier/list",data,"json","application/json",function(newjson){
                    $('[data-table] tbody').html('');
                    $('[data-table] tbody').append(strCon(newjson));
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
    /*搜索*/
    function searchBtn() {
        firstAjax({"content": $("#searchContent").val()});
        pagingData = {"content": $("#searchContent").val()};
    };

    function editBtn(obj) {
        $('#editName').val(obj.name);
        $('#editContact').val(obj.contact);
        $('#editPhone').val(obj.phone);
        $('#editSaveBtn').attr('data-id',obj.id);
        $('#editPop').modal('show');
    }
    $("#editSaveBtn").bind("click",function(){
        if($("#editName").val()==""){
            $.ydcModal("fa fa-warning","提示信息","分类名称不能为空！","我知道了","");
            return false;
        }else if($("#editContact").val()==""){
            $.ydcModal("fa fa-warning","提示信息","联系人不能为空！","我知道了","");
            return false;
        }else if($("#editPhone").val()==""){
            $.ydcModal("fa fa-warning","提示信息","电话不能为空！","我知道了","");
            return false;
        };
        $.ydcAjax("PUT","/mApi/supplier/update",JSON.stringify({
            "id":$(this).attr('data-id'),
            "name":$("#editName").val(),
            "contact":$("#editContact").val(),
            "phone":$("#editPhone").val(),
            "account":$("#editAccount").val(),
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
    
    /*删除*/
    function deleteBtn(id){
        $.ydcAjax("DELETE","/mApi/supplier/delete/"+id,"","json","application/json",function(data){
            $.ydcModal("fa fa-warning","操作提示","删除成功!","自动刷新中……","");
            setTimeout(function(){
                window.location.reload();
            },1000);
        },function (error) {
            $.ydcModal("fa fa-warning","操作提示","删除失败!"+$.parseJSON(error.responseText).message,"我知道了","");
        });
    };

</script>