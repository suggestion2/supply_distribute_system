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
import org.codehaus.janino.IClass;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.su.supplydistributesystem.constants.CommonConstants.*;
import static com.su.supplydistributesystem.constants.StatisticsConstants.*;

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
        if(Objects.isNull(list)){
            return new OrderItemCategoryStatisticsView(0,0,0,null);
        }
        Calendar calendarDaily = getCalendar();
        calendarDaily.add(Calendar.DATE,-1);
        Calendar calendarWeekly = getCalendar();
        calendarDaily.add(Calendar.DATE,-7);
        Calendar calendarMonthly = getCalendar();
        calendarDaily.set(Calendar.DAY_OF_MONTH,1);
        int dailyCount = 0;
        int weeklyCount = 0;
        int monthlyCount = 0;
        for(int i =0; i < list.size();i ++){
            OrderItemDailyCount count = list.get(i);
            if(simpleDateFormat.format(calendarDaily.getTime()).equalsIgnoreCase(simpleDateFormat.format(count.getDate()))){
                dailyCount = count.getCount();
            }
            if(calendarWeekly.getTimeInMillis() < count.getDate().getTime()){
                weeklyCount += count.getCount();
            }
            if(calendarMonthly.getTimeInMillis() < count.getDate().getTime()){
                monthlyCount += count.getCount();
            }
        }
        return new OrderItemCategoryStatisticsView(dailyCount,weeklyCount,monthlyCount,null);
    }

    @RequestMapping(value = "/category/weekly", method = RequestMethod.GET)
    public OrderItemCategoryStatisticsView weekly(@RequestParam Integer id) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<OrderItemDailyCount> list = statisticsService.countSalesCount(null,id,null,null,simpleDateFormat.format(new Date()));
        if(Objects.isNull(list) || list.size() == 0){
            return new OrderItemCategoryStatisticsView(null,0,null,new ArrayList<>());
        }
        int weeklyCount = list.stream().mapToInt(OrderItemDailyCount::getCount).sum();
        return new OrderItemCategoryStatisticsView(null,weeklyCount,null,list);
    }

    private Calendar getCalendar(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);

        return calendar;
    }
}
