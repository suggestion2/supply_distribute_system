<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>sdSystem</title>
    <link href="/resources/images/favicon.ico" rel="icon" type="image/x-icon"/>
    <link rel="stylesheet" href="/resources/css/jquery-ui.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link rel="stylesheet" href="/resources/css/tab.css">
    <link rel="stylesheet" href="/resources/js/mask/mask.css">
    <link rel="stylesheet" href="/resources/js/JsonParser/JsonParser.css">
</head>
<body>
<div id="tabs" class="ui-widget-content">
    <div class="tab">
        <button class="tablinks" onclick="openTab(1)">dApi</button>
        <button class="tablinks" onclick="openTab(2)">mApi</button>
    </div>
    <div id="tabs-1" style="width: 2000px;display: none">

    </div>
    <div id="tabs-2" style="width: 2000px;display: block">
        <div style="float: left; width: 400px;">
            <h2>管理员(user)</h2>
            <div>
                <strong>[登录]</strong><br/>
                管理员:<input class="textbox" type="text" id="login-m-name" style="width: 100px;"
                           value="admin"/>
                密码:<input class="textbox" type="text" id="login-m-password" style="width: 100px;"
                          value="123456"/>
                <input type="button" value="登录" onclick="commonModule.login()"/><br>
            </div>
            <div>
                <strong>[修改密码]</strong><br/>
                旧密码:<input class="textbox" type="text" id="resetPwd-m-originPwd" style="width: 100px;"
                           value=""/>
                新密码:<input class="textbox" type="text" id="resetPwd-m-newPwd" style="width: 100px;"
                           value=""/>
                <input type="button" value="修改" onclick="commonModule.resetPwd()"/><br>
            </div>
            <div>
                <strong>[当前管理员]</strong><br/>
                <input type="button" value="获取" onclick="commonModule.currentUser()"/><br>
            </div>
            <div>
                <strong>[登出]</strong><br/>
                <input type="button" value="登出" onclick="commonModule.logout()"/><br>
            </div>

            <h2>供应商(supplier)</h2>
            <div>
                <strong>[查找]</strong><br/>
                供应商名称:<input class="textbox" type="text" id="supplier-list-name" style="width: 100px;"
                             value="1"/></br>
                startIndex:<input class="textbox" type="text" id="supplier-list-startIndex" style="width: 100px;"
                                  value="0"/>
                pageSize:<input class="textbox" type="text" id="supplier-list-pageSize" style="width: 100px;"
                                value="10"/> &ensp;
                <input type="button" value="获取" onclick="supplierModule.list()"/><br>
            </div>
            <div>
                <strong>[创建]</strong><br/>
                供应商名称:<input class="textbox" type="text" id="supplier-create-name" style="width: 100px;"
                             value="supplier"/>
                <input type="button" value="创建" onclick="supplierModule.create()"/><br>
            </div>
            <div>
                <strong>[修改]</strong><br/>
                供应商id:<input class="textbox" type="text" id="supplier-update-id" style="width: 100px;"
                             value="1"/>
                名称:<input class="textbox" type="text" id="supplier-update-name" style="width: 100px;"
                          value="1"/>
                <input type="button" value="编辑" onclick="supplierModule.updateById()"/><br>
            </div>
            <div>
                <strong>[删除]</strong><br/>
                供应商id:<input class="textbox" type="text" id="supplier-delete-id" style="width: 100px;"
                             value="1"/>
                <input type="button" value="删除" onclick="supplierModule.deleteById()"/><br>
            </div>
        </div>
        <div style="float: left; width: 400px;">
            <h2>商品品类(category)</h2>
            <div>
                <strong>[列表]</strong><br/>
                <input type="button" value="列表" onclick="categoryModule.list()"/><br>
            </div>
            <div>
                <strong>[创建]</strong><br/>
                name:<input class="textbox" type="text" id="category-m-create-name" style="width: 100px;"
                            value=""/>
                parentId(0 if no parent):<input class="textbox" type="text" id="category-m-create-parentId"
                                                style="width: 100px;"
                                                value=""/>
                <input type="button" value="创建" onclick="categoryModule.create()"/><br>
            </div>
            <div>
                <strong>[修改]</strong><br/>
                id:<input class="textbox" type="text" id="category-m-update-id" style="width: 100px;"
                          value=""/>
                name:<input class="textbox" type="text" id="category-m-update-name" style="width: 100px;"
                            value=""/>
                <input type="button" value="修改" onclick="categoryModule.update()"/><br>
            </div>
            <div>
                <strong>[上架/下架]</strong><br/>
                id:<input class="textbox" type="text" id="category-m-status-id" style="width: 100px;"
                          value=""/>
                status:<select class="textbox" id="category-m-status-status" style="width: 100px;">
                <option value="0">disable</option>
                <option value="1">enable</option>
            </select><br>
                <input type="button" value="修改" onclick="categoryModule.resetStatus()"/><br>
            </div>
            <div>
                <strong>[删除]</strong><br/>
                id:<input class="textbox" type="text" id="category-m-delete-id" style="width: 100px;"
                          value=""/>
                <input type="button" value="删除" onclick="categoryModule.deleteById()"/><br>
            </div>
            <h2>商品(goods)</h2>
            <div>
                <strong>[列表]</strong><br/>
                content:<input class="textbox" type="text" id="goods-m-list-content" style="width: 100px;"
                             value=""/>
                categoryId1:<input class="textbox" type="text" id="goods-m-list-categoryId1" style="width: 100px;"
                             value=""/></br>
                categoryId2:<input class="textbox" type="text" id="goods-m-list-categoryId2" style="width: 100px;"
                                   value=""/>
                categoryId3:<input class="textbox" type="text" id="goods-m-list-categoryId3" style="width: 100px;"
                                   value=""/></br>
                status:<select class="textbox" id="goods-m-list-status" style="width: 100px;">
                <option value="">all</option>
                <option value="0">disable</option>
                <option value="1">enable</option>
            </select><br>
                startIndex:<input class="textbox" type="text" id="goods-m-list-startIndex" style="width: 100px;"
                                  value="0"/>
                pageSize:<input class="textbox" type="text" id="goods-m-list-pageSize" style="width: 100px;"
                                value="10"/><br>
                <input type="button" value="列表" onclick="goodsModule.list()"/><br>
            </div>
            <div>
                <strong>[详情]</strong><br/>
                id:<input class="textbox" type="text" id="goods-m-detail-id" style="width: 100px;"
                             value=""/>
                <input type="button" value="详情" onclick="goodsModule.detail()"/><br>
            </div>
            <div>
                <strong>[创建]</strong><br/>
                name:<input class="textbox" type="text" id="goods-m-create-name" style="width: 100px;"
                            value=""/></br>
                categoryId1:<input class="textbox" type="text" id="goods-m-create-categoryId1" style="width: 100px;"
                                   value=""/>
                category1:<input class="textbox" type="text" id="goods-m-create-category1" style="width: 100px;"
                                   value=""/></br>
                categoryId2:<input class="textbox" type="text" id="goods-m-create-categoryId2" style="width: 100px;"
                                   value=""/>
                category2:<input class="textbox" type="text" id="goods-m-create-category2" style="width: 100px;"
                                   value=""/></br>
                categoryId3:<input class="textbox" type="text" id="goods-m-create-categoryId3" style="width: 100px;"
                                   value=""/>
                category3:<input class="textbox" type="text" id="goods-m-create-category3" style="width: 100px;"
                                   value=""/></br>
                taobaoPrice:<input class="textbox" type="text" id="goods-m-create-taobaoPrice" style="width: 100px;"
                                 value=""/>
                jdPrice:<input class="textbox" type="text" id="goods-m-create-jdPrice" style="width: 100px;"
                                   value=""/><br>
                price:<input class="textbox" type="text" id="goods-m-create-price" style="width: 100px;"
                                   value=""/><br>
                colour:<input class="textbox" type="text" id="goods-m-create-colour" style="width: 100px;"
                               value=""/>
                remarks:<input class="textbox" type="text" id="goods-m-create-remarks" style="width: 100px;"
                             value=""/><br>
                
                supply1:
                supplierId:<input class="textbox" type="text" id="goods-m-create-supplierId1" style="width: 100px;"
                                   value=""/></br>
                supplierName:<input class="textbox" type="text" id="goods-m-create-supplierName1" style="width: 100px;"
                                 value=""/>
                supplyPrice:<input class="textbox" type="text" id="goods-m-create-supplyPrice1" style="width: 100px;"
                                   value=""/></br>
                supply2:
                supplierId:<input class="textbox" type="text" id="goods-m-create-supplierId2" style="width: 100px;"
                                  value=""/></br>
                supplierName:<input class="textbox" type="text" id="goods-m-create-supplierName2" style="width: 100px;"
                                    value=""/>
                supplyPrice:<input class="textbox" type="text" id="goods-m-create-supplyPrice2" style="width: 100px;"
                                   value=""/></br>
                <input type="button" value="创建" onclick="goodsModule.create()"/><br>
            </div>
            <div>
                <strong>[修改]</strong><br/>
                id:<input class="textbox" type="text" id="goods-m-update-id" style="width: 100px;"
                          value=""/>
                name:<input class="textbox" type="text" id="goods-m-update-name" style="width: 100px;"
                            value=""/></br>
                categoryId1:<input class="textbox" type="text" id="goods-m-update-categoryId1" style="width: 100px;"
                                   value=""/>
                category1:<input class="textbox" type="text" id="goods-m-update-category1" style="width: 100px;"
                                 value=""/></br>
                categoryId2:<input class="textbox" type="text" id="goods-m-update-categoryId2" style="width: 100px;"
                                   value=""/>
                category2:<input class="textbox" type="text" id="goods-m-update-category2" style="width: 100px;"
                                 value=""/></br>
                categoryId3:<input class="textbox" type="text" id="goods-m-update-categoryId3" style="width: 100px;"
                                   value=""/>
                category3:<input class="textbox" type="text" id="goods-m-update-category3" style="width: 100px;"
                                 value=""/></br>
                taobaoPrice:<input class="textbox" type="text" id="goods-m-update-taobaoPrice" style="width: 100px;"
                                   value=""/>
                jdPrice:<input class="textbox" type="text" id="goods-m-update-jdPrice" style="width: 100px;"
                               value=""/><br>
                price:<input class="textbox" type="text" id="goods-m-update-price" style="width: 100px;"
                             value=""/><br>
                colour:<input class="textbox" type="text" id="goods-m-update-colour" style="width: 100px;"
                              value=""/>
                remarks:<input class="textbox" type="text" id="goods-m-update-remarks" style="width: 100px;"
                               value=""/><br>

                supply1:
                id:<input class="textbox" type="text" id="goods-m-update-gsId1" style="width: 100px;"
                                  value=""/>
                supplierId:<input class="textbox" type="text" id="goods-m-update-supplierId1" style="width: 100px;"
                                  value=""/></br>
                supplierName:<input class="textbox" type="text" id="goods-m-update-supplierName1" style="width: 100px;"
                                    value=""/>
                supplyPrice:<input class="textbox" type="text" id="goods-m-update-supplyPrice1" style="width: 100px;"
                                   value=""/></br>
                supply2:
                supplierId:<input class="textbox" type="text" id="goods-m-update-supplierId2" style="width: 100px;"
                                  value=""/></br>
                supplierName:<input class="textbox" type="text" id="goods-m-update-supplierName2" style="width: 100px;"
                                    value=""/>
                supplyPrice:<input class="textbox" type="text" id="goods-m-update-supplyPrice2" style="width: 100px;"
                                   value=""/></br>
                <input type="button" value="修改" onclick="goodsModule.update()"/><br>
            </div>
            <div>
                <strong>[上架/下架]</strong><br/>
                id:<input class="textbox" type="text" id="goods-m-status-id" style="width: 100px;"
                             value="1"/>
                status:<select class="textbox" id="goods-m-status-status" style="width: 100px;">
                <option value="0">disable</option>
                <option value="1">enable</option>
            </select><br>
                <input type="button" value="修改" onclick="goodsModule.resetStatus()"/><br>
            </div>
            <div>
                <strong>[删除]</strong><br/>
                id:<input class="textbox" type="text" id="goods-m-delete-id" style="width: 100px;"
                             value="1"/>
                <input type="button" value="删除" onclick="goodsModule.deleteById()"/><br>
            </div>
            <div>
                <strong>[导出excel]</strong><br/>
                <input type="button" value="导出" onclick="goodsModule.excel()"/><br>
            </div>
        </div>
    </div>

    <div style="clear: both;"></div>
</div>

<div style="margin-top: 7px; height:27px;" class="ui-tabs ui-widget ui-widget-content ui-corner-all">
    <b>Requested URL: </b>
    <input type="text" id="requestedUrl" style="width:60%;"
           domain="${request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()?c}"/>
</div>

<div id="d_param" class="ui-tabs ui-corner-all">
    <div style="float:left;width:300px; margin:0 10px 10px 0;height: 450px;"
         class="ui-tabs ui-widget ui-widget-content ui-corner-all">
        <strong style="margin-left: 5px;">Requested Method:</strong>

        <lable id="requestedMethod"></lable>
        <br/><br/>
        <strong style="margin-left: 5px;">HTTP Header:</strong>
        <table id="tb_h_param">
        <#--<tr>
            <td>ClientId:</td>
            <td><input type="text" id="p_clientId"/></td>
        </tr>
        <tr>
            <td>SecretKey:</td>
            <td><input type="text" id="p_secretKey"/></td>
        </tr>-->
            <tr>
                <td colspan="2"><textarea id="p_data" rows="20" cols="35"></textarea></td>
            </tr>
        </table>
    </div>

    <div style="margin-left:315px; z-index:9999; position:relative;">

        <div id="resultShow"></div>
    </div>
</div>


</body>

<script src="/resources/js/jquery-1.10.2.js"></script>
<script src="/resources/js/jquery-ui.js"></script>
<script src="/resources/js/JsonParser/JsonParser.js"></script>
<script src="/resources/js/crypto/hmac-sha1.js"></script>
<script src="/resources/js/crypto/enc-base64-min.js"></script>
<script src="/resources/js/tool.js"></script>
<script src="/resources/js/mask/mask.js"></script>

</html>
