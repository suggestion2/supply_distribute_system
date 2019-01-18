<!doctype html>
<html xmlns="http://www.w3.org/1999/html">
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
        <h2>分销商(distributor)</h2>
        <div>
            <strong>[登录]</strong><br/>
            分销商:<input class="textbox" type="text" id="login-d-account" style="width: 100px;"
                       value="supplier"/>
            密码:<input class="textbox" type="text" id="login-d-password" style="width: 100px;"
                      value="123456"/>
            <input type="button" value="登录" onclick="distributeDistributorModule.login()"/><br>
        </div>
        <div>
            <strong>[修改密码]</strong><br/>
            旧密码:<input class="textbox" type="text" id="resetPwd-d-originPwd" style="width: 100px;"
                       value=""/>
            新密码:<input class="textbox" type="text" id="resetPwd-d-newPwd" style="width: 100px;"
                       value=""/>
            重复密码:<input class="textbox" type="text" id="resetPwd-d-repeatPwd" style="width: 100px;"
                       value=""/>
            <input type="button" value="修改" onclick="distributeDistributorModule.resetPwd()"/><br>
        </div>
        <div style="float: blow; width: 400px;">
            <h2>商品品类(category)</h2>
            <div>
                <strong>[列表]</strong><br/>
                <input type="button" value="列表" onclick="distributeCategoryModule.list()"/><br>
            </div>
        </div>
        <div style="float: blow; width: 400px;">
            <div>
                <h2>商品(goods)</h2>
                <strong>[列表]</strong><br/>
                content:<input class="textbox" type="text" id="goods-d-list-content" style="width: 100px;"
                               value=""/>
                categoryId1:<input class="textbox" type="text" id="goods-d-list-categoryId1" style="width: 100px;"
                                   value=""/></br>
                categoryId2:<input class="textbox" type="text" id="goods-d-list-categoryId2" style="width: 100px;"
                                   value=""/>
                categoryId3:<input class="textbox" type="text" id="goods-d-list-categoryId3" style="width: 100px;"
                                   value=""/></br>
                </select><br>
                startIndex:<input class="textbox" type="text" id="goods-d-list-startIndex" style="width: 100px;"
                                  value="0"/>
                pageSize:<input class="textbox" type="text" id="goods-d-list-pageSize" style="width: 100px;"
                                value="10"/><br>
                <input type="button" value="列表" onclick="distributeGoodsModule.list()"/><br>
            </div>
        </div>
        <div style="float: blow; width: 400px;">
            <div>
                <h2>订单(order)</h2>
                    <strong>[列表]</strong><br/>
                    content:<input class="textbox" type="text" id="order-d-list-content" style="width: 100px;"
                                   value=""/>
                    date:<input class="textbox" type="text" id="order-d-list-date" style="width: 100px;"
                                value="" placeholder="2018-12-12"/></br>
                    status:<select class="textbox" id="order-d-list-status" style="width: 100px;">
                    <option value="">all</option>
                    <option value="0">取消</option>
                    <option value="1">创建</option>
                    <option value="2">成功下单</option>
                    <option value="3">提交供应商</option>
                    <option value="4">已结算</option>
                    <option value="5">已发货</option>
                    <option value="6">已收货</option>
                    <option value="7">售后</option>
                </select><br>
                    startIndex:<input class="textbox" type="text" id="order-d-list-startIndex" style="width: 100px;"
                                      value="0"/>
                    pageSize:<input class="textbox" type="text" id="order-d-list-pageSize" style="width: 100px;"
                                    value="10"/><br>
                <input type="button" value="列表" onclick="distributeOrderModule.list()"/><br>
            </div>
        </div>
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

            <h2>统计(statistics)</h2>
            <div>
                <strong>[历史订单统计]</strong><br/>
                <input type="button" value="统计" onclick="statisticsModule.all()"/><br>
            </div>
            <div>
                <strong>[按品类统计当日/7日内/当月 订单数量]</strong><br/>
                categoryId:<input class="textbox" type="text" id="statistics-sum-categoryId" style="width: 100px;"
                                  value="0"/>
                <input type="button" value="统计" onclick="statisticsModule.sum()"/><br>
            </div>
            <div>
                <strong>[按品类统计7日内销量]</strong><br/>
                categoryId:<input class="textbox" type="text" id="statistics-weekly-categoryId" style="width: 100px;"
                                  value="0"/>
                <input type="button" value="统计" onclick="statisticsModule.weekly()"/><br>
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
                             value="supplier"/></br>
                供应商联系方式（座机加上区号或手机号码）:<input class="textbox" type="text" id="supplier-create-phone" style="width: 100px;"
                             value="05936896222"/></br>
                供应商联系人:<input class="textbox" type="text" id="supplier-create-contact" style="width: 100px;"
                             value="supplier"/></br>
                <input type="button" value="创建" onclick="supplierModule.create()"/><br>
            </div>
            <div>
                <strong>[修改]</strong><br/>
                供应商id:<input class="textbox" type="text" id="supplier-update-id" style="width: 100px;"
                             value="1"/></br>
                供应商名称:<input class="textbox" type="text" id="supplier-update-name" style="width: 100px;"
                          value="1"/></br>
                供应商联系方式（座机加上区号或手机号码）:<input class="textbox" type="text" id="supplier-update-phone" style="width: 100px;"
                          value="1"/></br>
                供应商联系人:<input class="textbox" type="text" id="supplier-update-contact" style="width: 100px;"
                          value="1"/></br>
                <input type="button" value="编辑" onclick="supplierModule.updateById()"/><br>
            </div>
            <div>
                <strong>[删除]</strong><br/>
                供应商id:<input class="textbox" type="text" id="supplier-delete-id" style="width: 100px;"
                             value="1"/>
                <input type="button" value="删除" onclick="supplierModule.deleteById()"/><br>
            </div>
        </div>
        <div style="float: left; width: 500px;">
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
                                                value=""/><br>
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
        <div style="float: left; width: 400px;">
            <h2>分销商(distibutor)</h2>
            <div>
                <strong>[创建]</strong><br/>
                分销商名称:<input class="textbox" type="text" id="distributor-create-name" style="width: 100px;"
                           value="supplier"/>
                分销商手机:<input class="textbox" type="text" id="distributor-create-phone" style="width: 100px;"
                           value="15059272122"/></br>
                分销商账号:<input class="textbox" type="text" id="distributor-create-account" style="width: 100px;"
                           value="15059222222"/>
                分销商联系人:<input class="textbox" type="text" id="distributor-create-contact" style="width: 100px;"
                           value="王"/>
                <input type="button" value="创建" onclick="distributorModule.create()"/><br>
            </div>
            <div>
                <strong>[修改]</strong><br/>
                分销商id:<input class="textbox" type="text" id="distributor-update-id" style="width: 100px;"
                             value="1"/></br>
                分销商名称:<input class="textbox" type="text" id="distributor-update-name" style="width: 100px;"
                             value="1"/></br>
                分销商联系方式:<input class="textbox" type="text" id="distributor-update-phone" style="width: 100px;"
                                            value="1"/></br>
                分销商联系人:<input class="textbox" type="text" id="distributor-update-contact" style="width: 100px;"
                              value="1"/></br>
                分销商账号:<input class="textbox" type="text" id="distributor-update-account" style="width: 100px;"
                              value="1"/></br>
                <input type="button" value="编辑" onclick="distributorModule.updateById()"/><br>
            </div>
            <div>
                <strong>[删除]</strong><br/>
                id:<input class="textbox" type="text" id="distributor-m-delete-id" style="width: 100px;"
                          value="1"/>
                <input type="button" value="删除" onclick="distributorModule.deleteById()"/><br>
            </div>
            <div>
                <strong>[重置密码]</strong><br/>
                分销商id:<input class="textbox" type="text" id="distributor-resetPassword-id" style="width: 100px;"
                           value="1"/>
                <input type="button" value="重置" onclick="distributorModule.resetPasswordById()"/><br>
            </div>
            <div>
                <strong>[查找]</strong><br/>
                分销商名称:<input class="textbox" type="text" id="distributor-list-name" style="width: 100px;"
                          value="1"/></br>
                startIndex:<input class="textbox" type="text" id="distributor-list-startIndex" style="width: 100px;"
                                  value="0"/>
                pageSize:<input class="textbox" type="text" id="distributor-list-pageSize" style="width: 100px;"
                                value="10"/> &ensp;
                <input type="button" value="获取" onclick="distributorModule.list()"/><br>
            </div>
            <div>
                <strong>[冻结/解冻]</strong><br/>
                id:<input class="textbox" type="text" id="distributor-m-status-id" style="width: 100px;"
                          value=""/>
                status:<select class="textbox" id="distributor-m-status-status" style="width: 100px;">
                <option value="0">disable</option>
                <option value="1">enable</option>
            </select><br>
                <input type="button" value="修改" onclick="distributorModule.resetStatus()"/><br>
            </div>
        </div>
        <div style="float: left; width: 500px;">
            <h2>订单(order)</h2>
            <div>
                <strong>[列表]</strong><br/>
                content:<input class="textbox" type="text" id="order-m-list-content" style="width: 100px;"
                               value=""/>
                date:<input class="textbox" type="text" id="order-m-list-date" style="width: 100px;"
                                   value="" placeholder="2018-12-12"/></br>
                status:<select class="textbox" id="order-m-list-status" style="width: 100px;">
                <option value="">all</option>
                <option value="0">取消</option>
                <option value="1">创建</option>
                <option value="2">成功下单</option>
                <option value="3">提交供应商</option>
                <option value="4">已结算</option>
                <option value="5">已发货</option>
                <option value="6">已收货</option>
                <option value="7">售后</option>
            </select><br>
                startIndex:<input class="textbox" type="text" id="order-m-list-startIndex" style="width: 100px;"
                                  value="0"/>
                pageSize:<input class="textbox" type="text" id="order-m-list-pageSize" style="width: 100px;"
                                value="10"/><br>
                <input type="button" value="列表" onclick="orderModule.list()"/><br>
            </div>
            <div>
                <strong>[详情]</strong><br/>
                id:<input class="textbox" type="text" id="order-m-detail-id" style="width: 100px;"
                          value=""/>
                <input type="button" value="详情" onclick="orderModule.detail()"/><br>
            </div>
            <div>
                <strong>[创建]</strong><br/>
                distributorId:<input class="textbox" type="text" id="order-m-create-distributorId" style="width: 100px;"
                            value=""/>
                distributorName:<input class="textbox" type="text" id="order-m-create-distributorName" style="width: 100px;"
                                   value=""/></br>
                distributorPhone:<input class="textbox" type="text" id="order-m-create-distributorPhone" style="width: 100px;"
                                 value=""/>
                customerName:<input class="textbox" type="text" id="order-m-create-customerName" style="width: 100px;"
                                   value=""/></br>
                customerAddress:<input class="textbox" type="text" id="order-m-create-customerAddress" style="width: 100px;"
                                 value=""/>
                customerPhone:<input class="textbox" type="text" id="order-m-create-customerPhone" style="width: 100px;"
                                   value=""/></br>
                dispatchCompany:<input class="textbox" type="text" id="order-m-create-dispatchCompany" style="width: 100px;"
                                 value=""/>
                dispatchNumber:<input class="textbox" type="text" id="order-m-create-dispatchNumber" style="width: 100px;"
                                   value=""/></br>
                status:<select class="textbox" id="order-m-create-status" style="width: 100px;">
                <option value="0">取消</option>
                <option value="1" selected>创建</option>
                <option value="2">成功下单</option>
                <option value="3">提交供应商</option>
                <option value="4">已结算</option>
                <option value="5">已发货</option>
                <option value="6">已收货</option>
                <option value="7">售后</option>
            </select>
                remarks:<input class="textbox" type="text" id="order-m-create-remarks" style="width: 100px;"
                               value=""/><br>

                orderItem1:<br>
                goodsId:<input class="textbox" type="text" id="order-m-create-goodsId1" style="width: 100px;"
                                  value=""/>
                categoryId1:<input class="textbox" type="text" id="order-m-create-categoryId11" style="width: 100px;"
                                   value=""/></br>
                categoryId2:<input class="textbox" type="text" id="order-m-create-categoryId21" style="width: 100px;"
                                   value=""/>
                categoryId3:<input class="textbox" type="text" id="order-m-create-categoryId31" style="width: 100px;"
                                   value=""/></br>
                goodSupplyId:<input class="textbox" type="text" id="order-m-create-goodSupplyId1" style="width: 100px;"
                                    value=""/>
                goodsName:<input class="textbox" type="text" id="order-m-create-goodsName1" style="width: 100px;"
                                   value=""/></br>
                supplierName:<input class="textbox" type="text" id="order-m-create-supplierName1" style="width: 100px;"
                                   value=""/>
                taobaoPrice:<input class="textbox" type="text" id="order-m-create-taobaoPrice1" style="width: 100px;"
                                 value=""/></br>
                jdPrice:<input class="textbox" type="text" id="order-m-create-jdPrice1" style="width: 100px;"
                                 value=""/>
                price:<input class="textbox" type="text" id="order-m-create-price1" style="width: 100px;"
                                   value=""/></br>
                supplyPrice:<input class="textbox" type="text" id="order-m-create-supplyPrice1" style="width: 100px;"
                                 value=""/>
                count:<input class="textbox" type="text" id="order-m-create-count1" style="width: 100px;"
                                   value=""/></br>
                orderItem2:<br>
                goodsId:<input class="textbox" type="text" id="order-m-create-goodsId2" style="width: 100px;"
                               value=""/>
                categoryId1:<input class="textbox" type="text" id="order-m-create-categoryId12" style="width: 100px;"
                                   value=""/></br>
                categoryId2:<input class="textbox" type="text" id="order-m-create-categoryId22" style="width: 100px;"
                                   value=""/>
                categoryId3:<input class="textbox" type="text" id="order-m-create-categoryId32" style="width: 100px;"
                                   value=""/></br>
                goodSupplyId:<input class="textbox" type="text" id="order-m-create-goodSupplyId2" style="width: 100px;"
                                    value=""/>
                goodsName:<input class="textbox" type="text" id="order-m-create-goodsName2" style="width: 100px;"
                                 value=""/></br>
                supplierName:<input class="textbox" type="text" id="order-m-create-supplierName2" style="width: 100px;"
                                    value=""/>
                taobaoPrice:<input class="textbox" type="text" id="order-m-create-taobaoPrice2" style="width: 100px;"
                                   value=""/></br>
                jdPrice:<input class="textbox" type="text" id="order-m-create-jdPrice2" style="width: 100px;"
                               value=""/>
                price:<input class="textbox" type="text" id="order-m-create-price2" style="width: 100px;"
                             value=""/></br>
                supplyPrice:<input class="textbox" type="text" id="order-m-create-supplyPrice2" style="width: 100px;"
                                   value=""/>
                count:<input class="textbox" type="text" id="order-m-create-count2" style="width: 100px;"
                             value=""/></br>
                <input type="button" value="创建" onclick="orderModule.create()"/><br>
            </div>
            <div>
                <strong>[修改]</strong><br/>
                id:<input class="textbox" type="text" id="order-m-update-id" style="width: 100px;"
                          value=""/></br>
                distributorId:<input class="textbox" type="text" id="order-m-update-distributorId" style="width: 100px;"
                                     value=""/>
                distributorName:<input class="textbox" type="text" id="order-m-update-distributorName" style="width: 100px;"
                                       value=""/></br>
                distributorPhone:<input class="textbox" type="text" id="order-m-update-distributorPhone" style="width: 100px;"
                                        value=""/>
                customerName:<input class="textbox" type="text" id="order-m-update-customerName" style="width: 100px;"
                                    value=""/></br>
                customerAddress:<input class="textbox" type="text" id="order-m-update-customerAddress" style="width: 100px;"
                                       value=""/>
                customerPhone:<input class="textbox" type="text" id="order-m-update-customerPhone" style="width: 100px;"
                                     value=""/></br>
                dispatchCompany:<input class="textbox" type="text" id="order-m-update-dispatchCompany" style="width: 100px;"
                                       value=""/>
                dispatchNumber:<input class="textbox" type="text" id="order-m-update-dispatchNumber" style="width: 100px;"
                                      value=""/></br>
                remarks:<input class="textbox" type="text" id="order-m-update-remarks" style="width: 100px;"
                               value=""/><br>

                orderItem1:
                id:<input class="textbox" type="text" id="order-m-update-id1" style="width: 100px;"
                               value=""/>
                goodsId:<input class="textbox" type="text" id="order-m-update-goodsId1" style="width: 100px;"
                               value=""/></br>
                categoryId1:<input class="textbox" type="text" id="order-m-update-categoryId11" style="width: 100px;"
                                   value=""/>
                categoryId2:<input class="textbox" type="text" id="order-m-update-categoryId21" style="width: 100px;"
                                   value=""/></br>
                categoryId3:<input class="textbox" type="text" id="order-m-update-categoryId31" style="width: 100px;"
                                   value=""/>
                goodSupplyId:<input class="textbox" type="text" id="order-m-update-goodSupplyId1" style="width: 100px;"
                                    value=""/></br>
                goodsName:<input class="textbox" type="text" id="order-m-update-goodsName1" style="width: 100px;"
                                 value=""/>
                supplierName:<input class="textbox" type="text" id="order-m-update-supplierName1" style="width: 100px;"
                                    value=""/></br>
                taobaoPrice:<input class="textbox" type="text" id="order-m-update-taobaoPrice1" style="width: 100px;"
                                   value=""/>
                jdPrice:<input class="textbox" type="text" id="order-m-update-jdPrice1" style="width: 100px;"
                               value=""/></br>
                price:<input class="textbox" type="text" id="order-m-update-price1" style="width: 100px;"
                             value=""/>
                supplyPrice:<input class="textbox" type="text" id="order-m-update-supplyPrice1" style="width: 100px;"
                                   value=""/></br>
                count:<input class="textbox" type="text" id="order-m-update-count1" style="width: 100px;"
                             value=""/></br>
                orderItem2:
                goodsId:<input class="textbox" type="text" id="order-m-update-goodsId2" style="width: 100px;"
                               value=""/>
                categoryId1:<input class="textbox" type="text" id="order-m-update-categoryId12" style="width: 100px;"
                                   value=""/></br>
                categoryId2:<input class="textbox" type="text" id="order-m-update-categoryId22" style="width: 100px;"
                                   value=""/>
                categoryId3:<input class="textbox" type="text" id="order-m-update-categoryId32" style="width: 100px;"
                                   value=""/></br>
                goodSupplyId:<input class="textbox" type="text" id="order-m-update-goodSupplyId2" style="width: 100px;"
                                    value=""/>
                goodsName:<input class="textbox" type="text" id="order-m-update-goodsName2" style="width: 100px;"
                                 value=""/></br>
                supplierName:<input class="textbox" type="text" id="order-m-update-supplierName2" style="width: 100px;"
                                    value=""/>
                taobaoPrice:<input class="textbox" type="text" id="order-m-update-taobaoPrice2" style="width: 100px;"
                                   value=""/></br>
                jdPrice:<input class="textbox" type="text" id="order-m-update-jdPrice2" style="width: 100px;"
                               value=""/>
                price:<input class="textbox" type="text" id="order-m-update-price2" style="width: 100px;"
                             value=""/></br>
                supplyPrice:<input class="textbox" type="text" id="order-m-update-supplyPrice2" style="width: 100px;"
                                   value=""/>
                count:<input class="textbox" type="text" id="order-m-update-count2" style="width: 100px;"
                             value=""/></br>
                <input type="button" value="修改" onclick="orderModule.update()"/><br>
            </div>
            <div>
                <strong>[改变状态]</strong><br/>
                id:<input class="textbox" type="text" id="order-m-status-id" style="width: 100px;"
                          value=""/>
                status:<select class="textbox" id="order-m-status-status" style="width: 100px;">
                <option value="0">取消</option>
                <option value="1" selected>创建</option>
                <option value="2">成功下单</option>
                <option value="3">提交供应商</option>
                <option value="4">已结算</option>
                <option value="5">已发货</option>
                <option value="6">已收货</option>
                <option value="7">售后</option>
            </select><br>
                cancelReason:<input class="textbox" type="text" id="order-m-status-cancelReason" style="width: 100px;"
                          value=""/>
                remarks:<input class="textbox" type="text" id="order-m-status-remarks" style="width: 100px;"
                          value=""/>
                <input type="button" value="修改" onclick="orderModule.resetStatus()"/><br>
            </div>
            <div>
                <strong>[删除]</strong><br/>
                id:<input class="textbox" type="text" id="order-m-delete-id" style="width: 100px;"
                          value=""/>
                <input type="button" value="删除" onclick="orderModule.deleteById()"/><br>
            </div>
            <div>
                <strong>[导出excel]</strong><br/>
                content:<input class="textbox" type="text" id="order-m-excel-content" style="width: 100px;"
                          value=""/>
                date:<input class="textbox" type="text" id="order-m-excel-date" style="width: 100px;"
                               value="" placeholder="2018-12-12"/><br>
                status:<select class="textbox" id="order-m-excel-status" style="width: 100px;">
                <option value="" selected>all</option>
                <option value="0">取消</option>
                <option value="1">创建</option>
                <option value="2">成功下单</option>
                <option value="3">提交供应商</option>
                <option value="4">已结算</option>
                <option value="5">已发货</option>
                <option value="6">已收货</option>
                <option value="7">售后</option>
            </select><br>
                <input type="button" value="导出" onclick="orderModule.excel()"/><br>
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
