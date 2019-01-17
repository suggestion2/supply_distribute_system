package com.su.supplydistributesystem;

import com.su.supplydistributesystem.controller.api.management.OrderController;
import com.su.supplydistributesystem.domain.Distributor;
import com.su.supplydistributesystem.domain.Goods;
import com.su.supplydistributesystem.domain.GoodsSupply;
import com.su.supplydistributesystem.request.OrderCreateForm;
import com.su.supplydistributesystem.request.OrderItemForm;
import com.su.supplydistributesystem.service.DistributorService;
import com.su.supplydistributesystem.service.GoodsDetailParams;
import com.su.supplydistributesystem.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplyDistributeSystemApplicationTests {

	@Autowired
	private OrderController orderController;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private DistributorService distributorService;

	@Test
	public void contextLoads() {
		Distributor distributor = distributorService.getById(10);
		List<GoodsDetailParams> goodsList = goodsService.getAllEnabledList();

		for(int i = 0;i < 100;i ++){
			OrderCreateForm form = new OrderCreateForm();
			form.setDistributorId(distributor.getId());
			form.setDistributorName(distributor.getName());
			form.setDistributorPhone(distributor.getPhone());
			form.setCustomerName("test");
			form.setCustomerAddress("test");
			form.setCustomerPhone("13000000000");
			form.setDispatchCompany("test");
			form.setDispatchNumber("test" + i);
			form.setStatus(1);
			List<OrderItemForm> itemFormList = new ArrayList<>();
			for(int j =0;j < (int)(Math.random() * 5) + 1; j ++){
				OrderItemForm itemForm = new OrderItemForm();
				GoodsDetailParams goodsDetailParams = goodsList.get((int)(Math.random() * goodsList.size()));
				Goods goods = goodsDetailParams.getGoods();
				GoodsSupply goodsSupply = goodsDetailParams.getList().get((int)(Math.random() * goodsDetailParams.getList().size()));

				itemForm.setGoodsId(goods.getId());
				itemForm.setCategoryId1(goods.getCategoryId1());
				itemForm.setCategoryId2(goods.getCategoryId2());
				itemForm.setCategoryId3(goods.getCategoryId3());
				itemForm.setGoodsName(goods.getName());
				itemForm.setGoodSupplyId(goodsSupply.getId());
				itemForm.setCount((int)(Math.random() * 10));
				itemForm.setJdPrice(goods.getJdPrice());
				itemForm.setTaobaoPrice(goods.getTaobaoPrice());
				itemForm.setPrice(goods.getPrice());
				itemForm.setSupplyPrice(goodsSupply.getSupplyPrice());
				itemForm.setSupplierName(goodsSupply.getSupplierName());

				itemFormList.add(itemForm);
			}
			form.setList(itemFormList);
			orderController.create(form);
		}
	}

}

