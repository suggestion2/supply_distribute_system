package com.su.supplydistributesystem.controller.api.management;

import com.su.supplydistributesystem.context.SessionContext;
import com.su.supplydistributesystem.domain.User;
import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.su.supplydistributesystem.request.LoginForm;
import com.su.supplydistributesystem.request.ResetPasswordForm;
import com.su.supplydistributesystem.response.OrderItemCategoryStatisticsView;
import com.su.supplydistributesystem.response.OrderStatisticsView;
import com.su.supplydistributesystem.response.UserView;
import com.su.supplydistributesystem.service.UserService;
import com.su.supplydistributesystem.service.statistic.OrderItemDailyCount;
import com.su.supplydistributesystem.service.statistic.OrderStatisticResult;
import com.su.supplydistributesystem.service.statistic.StatisticsService;
import com.sug.core.platform.crypto.MD5;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController("statisticsManagementApiController")
@RequestMapping(value = "/mApi/statistics")
@UserLoginRequired
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public OrderStatisticsView all() {
        OrderStatisticResult result = statisticsService.countOrder(null,null,null);
        OrderStatisticsView view = new OrderStatisticsView();
        BeanUtils.copyProperties(result,view);
        return view;
    }

    @RequestMapping(value = "/category/sum", method = RequestMethod.GET)
    public OrderItemCategoryStatisticsView sum(@RequestParam Integer id) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<OrderItemDailyCount> list = statisticsService.countOrderCount(null,id,null,null,simpleDateFormat.format(new Date()));
        int dailyCount = list.get(0).getCount();
        int weeklyCount = 0;
        for(int i =0; i < 7;i ++){
            weeklyCount += list.get(i).getCount();
        }
        int monthlyCount = list.stream().mapToInt(OrderItemDailyCount::getCount).sum();
        return new OrderItemCategoryStatisticsView(dailyCount,weeklyCount,monthlyCount,null);
    }

    @RequestMapping(value = "/category/weekly", method = RequestMethod.GET)
    public OrderItemCategoryStatisticsView weekly(@RequestParam Integer id) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<OrderItemDailyCount> list = statisticsService.countSalesCount(null,id,null,null,simpleDateFormat.format(new Date()));
        int weeklyCount = list.stream().mapToInt(OrderItemDailyCount::getCount).sum();
        return new OrderItemCategoryStatisticsView(null,weeklyCount,null,list);
    }
}