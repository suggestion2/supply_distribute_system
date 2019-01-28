$(function () {

    window.jsonParser = new JsonParser("");

    /*$("#secretKey").val($("option:selected", $("#selClient")).attr("secretKey"));

    $("#selClient").change(function(){
        var optionSelected = $("option:selected", this);
        $("#secretKey").val($(optionSelected).attr("secretKey"));

        $("#p_clientId").val( $("#selClient").val());
        $("#p_secretKey").val( $("#secretKey").val());
    });

    $("#p_clientId").val( $("#selClient").val());
    $("#p_secretKey").val( $("#secretKey").val());*/

});

function openTab(tab) {
    if (tab === 1) {
        $("#tabs-2").hide();
        $("#tabs-1").show();
    } else if (tab === 2) {
        $("#tabs-1").hide();
        $("#tabs-2").show();
    }
}

function uuid() {
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "-";

    var uuid = s.join("");
    return uuid;
}

function showResult(settings) {
    $.fn.mask();

    $("#requestedUrl").val($("#requestedUrl").attr("domain") + settings.url);
    $("#requestedMethod").text(settings.type);
    $("#p_data").text(settings.data == null ? "" : settings.data);

    var timestamp = Math.round(new Date().getTime());
    /*var requestId = uuid();
    var visitorId = $("#visitorId").val();*/

    /*var signature = [];
    signature.push("uri=" + settings.url);
    signature.push("&method=" + settings.type.toUpperCase());
    if (settings.data != null && settings.data.length > 0)
        signature.push("&body=" + settings.data);
    signature.push("&timestamp=" + timestamp);
    signature.push("&requestId=" + requestId);
    if(visitorId != null && visitorId.length > 0)
        signature.push("&visitorId=" + visitorId);
    console.log(signature.join(''));
    var signatureStr =  CryptoJS.HmacSHA1(signature.join(''),$("#secretKey").val()).toString(CryptoJS.enc.Base64);
    console.log(signatureStr);*/

    $.ajax({
        type: settings.type,
        url: settings.url,
        dataType: settings.dataType,
        data: settings.data,
        contentType: settings.contentType === null ? settings.contentType : "application/json",
        processData: settings.processData === null ? settings.processData : true,
        async: settings.async === null ? settings.async : true,
        headers: {
            "Timestamp": timestamp
            /*,"Client-Id": $("#selClient").val(),
            "Visitor-Id" : $("#visitorId").val(),
            "Request-Id" : requestId,
            "Client-Signature": signatureStr*/
        },
        success: function (data) {

            window.jsonParser.jsonContent = JSON.stringify(data);
            window.jsonParser.init();

            if (settings.success)
                settings.success(data);

            $.fn.mask.close();
        },
        error: function (data) {
            window.jsonParser.jsonContent = JSON.stringify(data);
            window.jsonParser.init();
            $.fn.mask.close();
        }
    });
}

var commonModule = {
    login: function () {
        var settings = {
            type: "POST",
            url: "/mApi/login",
            dataType: "json",
            data: JSON.stringify({
                "name": $("#login-m-name").val(),
                "password": $("#login-m-password").val()
            })
        };
        showResult(settings);
    },
    resetPwd: function () {
        var settings = {
            type: "PUT",
            url: "/mApi/password",
            dataType: "json",
            data: JSON.stringify({
                "originPassword": $("#resetPwd-m-originPwd").val(),
                "newPassword": $("#resetPwd-m-newPwd").val()
            })
        };
        showResult(settings);
    },
    currentUser: function () {
        var settings = {
            type: "GET",
            url: "/mApi/current",
            dataType: "json"
        };
        showResult(settings);
    },
    logout: function () {
        var settings = {
            type: "GET",
            url: "/mApi/logout",
            dataType: "json"
        };
        showResult(settings);
    }
};

var categoryModule = {
    list: function () {
        var settings = {
            type: "GET",
            url: "/mApi/category/list",
            dataType: "json"
        };
        showResult(settings);
    },
    create: function () {
        var settings = {
            type: "POST",
            url: "/mApi/category/create",
            dataType: "json",
            data: JSON.stringify({
                "name": $("#category-m-create-name").val(),
                "parentId": $("#category-m-create-parentId").val()
            })
        };
        showResult(settings);
    },
    update: function () {
        var settings = {
            type: "PUT",
            url: "/mApi/category/update",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#category-m-update-id").val(),
                "name": $("#category-m-update-name").val()
            })
        };
        showResult(settings);
    },
    resetStatus: function () {
        var settings = {
            type: "PUT",
            url: "/mApi/category/resetStatus",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#category-m-status-id").val(),
                "status": $("#category-m-status-status").val()
            })
        };
        showResult(settings);
    },
    deleteById: function () {
        var settings = {
            type: "DELETE",
            url: "/mApi/category/delete/" + $("#category-m-delete-id").val(),
            dataType: "json"
        };
        showResult(settings);
    }
};

var supplierModule = {
    create: function () {
        var settings = {
            type: "POST",
            url: "/mApi/supplier/create",
            dataType: "json",
            data: JSON.stringify({
                "name": $("#supplier-create-name").val(),
                "contact": $("#supplier-create-contact").val(),
                "phone": $("#supplier-create-phone").val()
            })
        };
        showResult(settings);
    },
    deleteById: function () {
        var settings = {
            type: "DELETE",
            url: "/mApi/supplier/delete/" + $("#supplier-delete-id").val(),
            dataType: "json"
        };
        showResult(settings);
    },
    updateById: function () {
        var settings = {
            type: "PUT",
            url: "/mApi/supplier/update",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#supplier-update-id").val(),
                "name": $("#supplier-update-name").val(),
                "phone": $("#supplier-update-phone").val(),
                "contact": $("#supplier-update-contact").val()
            })
        };
        showResult(settings);
    },
    list: function () {
        var settings = {
            type: "POST",
            url: "/mApi/supplier/list",
            dataType: "json",
            data: JSON.stringify({
                "content": $("#supplier-list-name").val(),
                "pageIndex": $("#supplier-list-startIndex").val(),
                "pageSize": $("#supplier-list-pageSize").val()
            })
        };
        showResult(settings);
    }
};
var distributorModule = {
    create: function () {
        var settings = {
            type: "POST",
            url: "/mApi/distributor/create",
            dataType: "json",
            data: JSON.stringify({
                "name": $("#distributor-create-name").val(),
                "phone": $("#distributor-create-phone").val(),
                "contact": $("#distributor-create-contact").val(),
                "account": $("#distributor-create-account").val()
            })
        };
        showResult(settings);
    },
    updateById: function () {
        var settings = {
            type: "PUT",
            url: "/mApi/distributor/update",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#distributor-update-id").val(),
                "name": $("#distributor-update-name").val(),
                "phone": $("#distributor-update-phone").val(),
                "contact": $("#distributor-update-contact").val(),
                "account": $("#distributor-update-account").val()
            })
        };
        showResult(settings);
    },
    deleteById: function () {
        var settings = {
            type: "DELETE",
            url: "/mApi/distributor/delete/" + $("#distributor-m-delete-id").val(),
            dataType: "json"
        };
        showResult(settings);
    },
    resetPasswordById: function () {
        var settings = {
            type: "PUT",
            url: "/mApi/distributor/password",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#distributor-resetPassword-id").val()
            })
        };
        showResult(settings);
    },
    list: function () {
        var settings = {
            type: "POST",
            url: "/mApi/distributor/list",
            dataType: "json",
            data: JSON.stringify({
                "content": $("#distributor-list-name").val(),
                "pageIndex": $("#distributor-list-startIndex").val(),
                "pageSize": $("#distributor-list-pageSize").val()
            })
        };
        showResult(settings);
    },
    resetStatus: function () {
        var settings = {
            type: "PUT",
            url: "/mApi/distributor/resetStatus",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#distributor-m-status-id").val(),
                "status": $("#distributor-m-status-status").val()
            })
        };
        showResult(settings);
    }
};


var goodsModule = {
    list: function () {
        var settings = {
            type: "POST",
            url: "/mApi/goods/list",
            dataType: "json",
            data: JSON.stringify({
                "content": $("#goods-m-list-content").val(),
                "categoryId1": $("#goods-m-list-categoryId1").val(),
                "categoryId2": $("#goods-m-list-categoryId2").val(),
                "categoryId3": $("#goods-m-list-categoryId3").val(),
                "status": $("#goods-m-list-status").val(),
                "pageIndex": $("#goods-m-list-startIndex").val(),
                "pageSize": $("#goods-m-list-pageSize").val()
            })
        };
        showResult(settings);
    },
    detail: function () {
        var settings = {
            type: "GET",
            url: "/mApi/goods/detail/" + $("#goods-m-detail-id").val(),
            dataType: "json"
        };
        showResult(settings);
    },
    create: function () {
        var settings = {
            type: "POST",
            url: "/mApi/goods/create",
            dataType: "json",
            data: JSON.stringify({
                "name": $("#goods-m-create-name").val(),
                "categoryId1": $("#goods-m-create-categoryId1").val(),
                "category1": $("#goods-m-create-category1").val(),
                "categoryId2": $("#goods-m-create-categoryId2").val(),
                "category2": $("#goods-m-create-category2").val(),
                "categoryId3": $("#goods-m-create-categoryId3").val(),
                "category3": $("#goods-m-create-category3").val(),
                "taobaoPrice": $("#goods-m-create-taobaoPrice").val(),
                "jdPrice": $("#goods-m-create-jdPrice").val(),
                "price": $("#goods-m-create-price").val(),
                "remarks": $("#goods-m-create-remarks").val(),
                "colour": $("#goods-m-create-colour").val(),
                "goodsSupplyList": [
                    {
                        "supplierId": $("#goods-m-create-supplierId1").val(),
                        "supplierName": $("#goods-m-create-supplierName1").val(),
                        "supplyPrice": $("#goods-m-create-supplyPrice1").val()
                    },
                    {
                        "supplierId": $("#goods-m-create-supplierId2").val(),
                        "supplierName": $("#goods-m-create-supplierName2").val(),
                        "supplyPrice": $("#goods-m-create-supplyPrice2").val()
                    }
                ]
            })
        };
        showResult(settings);
    },
    update: function () {
        var settings = {
            type: "PUT",
            url: "/mApi/goods/update",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#goods-m-update-id").val(),
                "name": $("#goods-m-update-name").val(),
                "categoryId1": $("#goods-m-update-categoryId1").val(),
                "category1": $("#goods-m-update-category1").val(),
                "categoryId2": $("#goods-m-update-categoryId2").val(),
                "category2": $("#goods-m-update-category2").val(),
                "categoryId3": $("#goods-m-update-categoryId3").val(),
                "category3": $("#goods-m-update-category3").val(),
                "taobaoPrice": $("#goods-m-update-taobaoPrice").val(),
                "jdPrice": $("#goods-m-update-jdPrice").val(),
                "price": $("#goods-m-update-price").val(),
                "remarks": $("#goods-m-update-remarks").val(),
                "colour": $("#goods-m-update-colour").val(),
                "goodsSupplyList": [
                    {
                        "id": $("#goods-m-update-gsId1").val(),
                        "supplierId": $("#goods-m-update-supplierId1").val(),
                        "supplierName": $("#goods-m-update-supplierName1").val(),
                        "supplyPrice": $("#goods-m-update-supplyPrice1").val()
                    },
                    {
                        "supplierId": $("#goods-m-update-supplierId2").val(),
                        "supplierName": $("#goods-m-update-supplierName2").val(),
                        "supplyPrice": $("#goods-m-update-supplyPrice2").val()
                    }
                ]
            })
        };
        showResult(settings);
    },
    resetStatus: function () {
        var settings = {
            type: "PUT",
            url: "/mApi/goods/resetStatus",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#goods-m-status-id").val(),
                "status": $("#goods-m-status-status").val()
            })
        };
        showResult(settings);
    },
    batchStatus: function () {
        var settings = {
            type: "PUT",
            url: "/mApi/goods/batchStatus",
            dataType: "json",
            data: JSON.stringify({
                "list": $("#goods-m-batchStatus-id").val().split(","),
                "status": $("#goods-m-batchStatus-status").val()
            })
        };
        showResult(settings);
    },
    deleteById: function () {
        var settings = {
            type: "DELETE",
            url: "/mApi/goods/delete/" + $("#goods-m-delete-id").val(),
            dataType: "json"
        };
        showResult(settings);
    },
    excel: function () {
        window.open('/management/excel/goods');
    }
};

var orderModule = {
    list: function () {
        var settings = {
            type: "POST",
            url: "/mApi/order/list",
            dataType: "json",
            data: JSON.stringify({
                "content": $("#order-m-list-content").val(),
                "date": $("#order-m-list-date").val(),
                "status": $("#order-m-list-status").val(),
                "pageIndex": $("#order-m-list-startIndex").val(),
                "pageSize": $("#order-m-list-pageSize").val()
            })
        };
        showResult(settings);
    },
    detail: function () {
        var settings = {
            type: "GET",
            url: "/mApi/order/detail/" + $("#order-m-detail-id").val(),
            dataType: "json"
        };
        showResult(settings);
    },
    create: function () {
        var settings = {
            type: "POST",
            url: "/mApi/order/create",
            dataType: "json",
            data: JSON.stringify({
                "distributorId": $("#order-m-create-distributorId").val(),
                "distributorName": $("#order-m-create-distributorName").val(),
                "distributorPhone": $("#order-m-create-distributorPhone").val(),
                "customerName": $("#order-m-create-customerName").val(),
                "customerAddress": $("#order-m-create-customerAddress").val(),
                "customerPhone": $("#order-m-create-customerPhone").val(),
                "dispatchCompany": $("#order-m-create-dispatchCompany").val(),
                "dispatchNumber": $("#order-m-create-dispatchNumber").val(),
                "status": $("#order-m-create-status").val(),
                "remarks": $("#order-m-create-remarks").val(),
                "list": [
                    {
                        "goodsId": $("#order-m-create-goodsId1").val(),
                        "categoryId1": $("#order-m-create-categoryId11").val(),
                        "categoryId2": $("#order-m-create-categoryId21").val(),
                        "categoryId3": $("#order-m-create-categoryId31").val(),
                        "goodSupplyId": $("#order-m-create-goodSupplyId1").val(),
                        "goodsName": $("#order-m-create-goodsName1").val(),
                        "supplierName": $("#order-m-create-supplierName1").val(),
                        "taobaoPrice": $("#order-m-create-taobaoPrice1").val(),
                        "jdPrice": $("#order-m-create-jdPrice1").val(),
                        "price": $("#order-m-create-price1").val(),
                        "supplyPrice": $("#order-m-create-supplyPrice1").val(),
                        "count": $("#order-m-create-count1").val()
                    },
                    {
                        "goodsId": $("#order-m-create-goodsId2").val(),
                        "categoryId1": $("#order-m-create-categoryId12").val(),
                        "categoryId2": $("#order-m-create-categoryId22").val(),
                        "categoryId3": $("#order-m-create-categoryId32").val(),
                        "goodSupplyId": $("#order-m-create-goodSupplyId2").val(),
                        "goodsName": $("#order-m-create-goodsName2").val(),
                        "supplierName": $("#order-m-create-supplierName2").val(),
                        "taobaoPrice": $("#order-m-create-taobaoPrice2").val(),
                        "jdPrice": $("#order-m-create-jdPrice2").val(),
                        "price": $("#order-m-create-price2").val(),
                        "supplyPrice": $("#order-m-create-supplyPrice2").val(),
                        "count": $("#order-m-create-count2").val()
                    }
                ]
            })
        };
        showResult(settings);
    },
    update: function () {
        var settings = {
            type: "PUT",
            url: "/mApi/order/update",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#order-m-update-id").val(),
                "distributorId": $("#order-m-update-distributorId").val(),
                "distributorName": $("#order-m-update-distributorName").val(),
                "distributorPhone": $("#order-m-update-distributorPhone").val(),
                "customerName": $("#order-m-update-customerName").val(),
                "customerAddress": $("#order-m-update-customerAddress").val(),
                "customerPhone": $("#order-m-update-customerPhone").val(),
                "dispatchCompany": $("#order-m-update-dispatchCompany").val(),
                "dispatchNumber": $("#order-m-update-dispatchNumber").val(),
                "remarks": $("#order-m-update-remarks").val(),
                "list": [
                    {
                        "id": $("#order-m-update-id1").val(),
                        "goodsId": $("#order-m-update-goodsId1").val(),
                        "categoryId1": $("#order-m-update-categoryId11").val(),
                        "categoryId2": $("#order-m-update-categoryId21").val(),
                        "categoryId3": $("#order-m-update-categoryId31").val(),
                        "goodSupplyId": $("#order-m-update-goodSupplyId1").val(),
                        "goodsName": $("#order-m-update-goodsName1").val(),
                        "supplierName": $("#order-m-update-supplierName1").val(),
                        "taobaoPrice": $("#order-m-update-taobaoPrice1").val(),
                        "jdPrice": $("#order-m-update-jdPrice1").val(),
                        "price": $("#order-m-update-price1").val(),
                        "supplyPrice": $("#order-m-update-supplyPrice1").val(),
                        "count": $("#order-m-update-count1").val()
                    },
                    {
                        "goodsId": $("#order-m-update-goodsId2").val(),
                        "categoryId1": $("#order-m-update-categoryId12").val(),
                        "categoryId2": $("#order-m-update-categoryId22").val(),
                        "categoryId3": $("#order-m-update-categoryId32").val(),
                        "goodSupplyId": $("#order-m-update-goodSupplyId2").val(),
                        "goodsName": $("#order-m-update-goodsName2").val(),
                        "supplierName": $("#order-m-update-supplierName2").val(),
                        "taobaoPrice": $("#order-m-update-taobaoPrice2").val(),
                        "jdPrice": $("#order-m-update-jdPrice2").val(),
                        "price": $("#order-m-update-price2").val(),
                        "supplyPrice": $("#order-m-update-supplyPrice2").val(),
                        "count": $("#order-m-update-count2").val()
                    }
                ]
            })
        };
        showResult(settings);
    },
    resetStatus: function () {
        var settings = {
            type: "PUT",
            url: "/mApi/order/resetStatus",
            dataType: "json",
            data: JSON.stringify({
                "id": $("#order-m-status-id").val(),
                "status": $("#order-m-status-status").val()
                // "cancelReason": $("#order-m-status-cancelReason").val(),
                // "remarks": $("#order-m-status-remarks").val()
            })
        };
        showResult(settings);
    },
    deleteById: function () {
        var settings = {
            type: "DELETE",
            url: "/mApi/order/delete/" + $("#order-m-delete-id").val(),
            dataType: "json"
        };
        showResult(settings);
    },
    excel: function () {
        window.open('/management/excel/order?content='
            + $("#order-m-excel-content").val()
            + '&date='
            + $("#order-m-excel-date").val()
            + '&status='
            + $("#order-m-excel-status").val());
    }
};

var distributeDistributorModule = {
    login: function () {
        var settings = {
            type: "POST",
            url: "/dApi/distributor/login",
            dataType: "json",
            data: JSON.stringify({
                "account": $("#login-d-account").val(),
                "password": $("#login-d-password").val()
            })
        };
        showResult(settings);
    },
    resetPwd: function () {
        var settings = {
            type: "PUT",
            url: "/dApi/distributor/password",
            dataType: "json",
            data: JSON.stringify({
                "originPassword": $("#resetPwd-d-originPwd").val(),
                "newPassword": $("#resetPwd-d-newPwd").val(),
                "repeatPassword": $("#resetPwd-d-repeatPwd").val()
            })
        };
        showResult(settings);
    },
    logout: function () {
        var settings = {
            type: "GET",
            url: "/dApi/distributor/logout",
            dataType: "json"
        };
        showResult(settings);
    }
};
var distributeCategoryModule = {
    list: function () {
        var settings = {
            type: "GET",
            url: "/dApi/category/list",
            dataType: "json"
        };
        showResult(settings);
    }
};
var distributeGoodsModule = {
    list: function () {
        var settings = {
            type: "POST",
            url: "/dApi/goods/list",
            dataType: "json",
            data: JSON.stringify({
                "content": $("#goods-d-list-content").val(),
                "categoryId1": $("#goods-d-list-categoryId1").val(),
                "categoryId2": $("#goods-d-list-categoryId2").val(),
                "categoryId3": $("#goods-d-list-categoryId3").val(),
                "pageIndex": $("#goods-d-list-startIndex").val(),
                "pageSize": $("#goods-d-list-pageSize").val()
            })
        };
        showResult(settings);
    },
    detail: function () {
        var settings = {
            type: "GET",
            url: "/mApi/goods/detail/" + $("#goods-m-detail-id").val(),
            dataType: "json"
        };
        showResult(settings);
    }
};

var statisticsModule = {
    all: function () {
        var settings = {
            type: "GET",
            url: "/mApi/statistics/all",
            dataType: "json"
        };
        showResult(settings);
    },
    sum: function () {
        var settings = {
            type: "GET",
            url: "/mApi/statistics/category/sum?id=" + $("#statistics-sum-categoryId").val(),
            dataType: "json"
        };
        showResult(settings);
    },
    weekly: function () {
        var settings = {
            type: "GET",
            url: "/mApi/statistics/category/weekly?id=" + $("#statistics-weekly-categoryId").val(),
            dataType: "json"
        };
        showResult(settings);
    }
};
var distributeOrderModule = {
    list: function () {
        var settings = {
            type: "POST",
            url: "/dApi/order/list",
            dataType: "json",
            data: JSON.stringify({
                "content": $("#order-d-list-content").val(),
                "date": $("#order-d-list-date").val(),
                "status": $("#order-d-list-status").val(),
                "pageIndex": $("#order-d-list-startIndex").val(),
                "pageSize": $("#order-d-list-pageSize").val()
            })
        };
        showResult(settings);
    }
};