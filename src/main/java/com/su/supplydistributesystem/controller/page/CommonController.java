package com.su.supplydistributesystem.controller.page;

import com.su.supplydistributesystem.context.SessionContext;
import com.su.supplydistributesystem.domain.User;
import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.su.supplydistributesystem.request.LoginForm;
import com.su.supplydistributesystem.request.ResetPasswordForm;
import com.su.supplydistributesystem.response.GoodsCategoryListItemView;
import com.su.supplydistributesystem.response.OrderItemCategoryStatisticsView;
import com.su.supplydistributesystem.response.UserView;
import com.su.supplydistributesystem.service.GoodsCategoryService;
import com.su.supplydistributesystem.service.UserService;
import com.su.supplydistributesystem.service.statistic.OrderItemDailyCount;
import com.su.supplydistributesystem.service.statistic.StatisticsService;
import com.sug.core.platform.crypto.MD5;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import org.apache.poi.hssf.record.chart.CategorySeriesAxisRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@Controller("commonManagementController")
//@RequestMapping(value = "/management")
public class CommonController {

    @Autowired
    private SessionContext sessionContext;

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @RequestMapping(value = "/management/user/resetPwd", method = RequestMethod.GET)
    @UserLoginRequired
    public String user(ModelMap modelMap) {
        modelMap.put("user",sessionContext.getUser());
        return "management/customer/resetPwd";
    }

    @RequestMapping(value = "/management/login", method = RequestMethod.GET)
    public String login(@RequestParam(required = false) String redirectUrl,ModelMap modelMap) {
        modelMap.put("redirectUrl", !StringUtils.hasText(redirectUrl) ? "/management" : redirectUrl);
        return "management/login";
    }

    @RequestMapping(value = "/wap/login", method = RequestMethod.GET)
    public String wapLogin(@RequestParam(required = false) String redirectUrl,ModelMap modelMap) {
        modelMap.put("redirectUrl", !StringUtils.hasText(redirectUrl) ? "/wap/index" : redirectUrl);
        return "management/wapLogin";
    }

    @RequestMapping(value = "/management", method = RequestMethod.GET)
    @UserLoginRequired
    public String index(ModelMap modelMap) {
        modelMap.put("user",sessionContext.getUser());
        modelMap.put("allOrderCount",statisticsService.countOrder(null,null,null));

        List<GoodsCategoryListItemView> categoryList = goodsCategoryService.getAllListView();
        if(Objects.nonNull(categoryList) && categoryList.size() > 0){
            modelMap.put("category",categoryList);
            int id = categoryList.get(0).getId();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            List<OrderItemDailyCount> list = statisticsService.countOrderCount(null,id,null,null,simpleDateFormat.format(new Date()));
            if(Objects.isNull(list)){
                modelMap.put("sumOrderCount",new OrderItemCategoryStatisticsView(0,0,0,null));
            }else {
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
                modelMap.put("sumOrderCount",new OrderItemCategoryStatisticsView(dailyCount,weeklyCount,monthlyCount,null));
            }

            List<OrderItemDailyCount> list1 = statisticsService.countSalesCount(null,id,null,null,simpleDateFormat.format(new Date()));
            if(Objects.isNull(list1) || list1.size() == 0){
                modelMap.put("sumSalesCount",new OrderItemCategoryStatisticsView(null,0,null,list1));
            }else {
                int weeklyCount1 = list1.stream().mapToInt(OrderItemDailyCount::getCount).sum();
                modelMap.put("sumSalesCount",new OrderItemCategoryStatisticsView(null,weeklyCount1,null,list1));
            }
        }else {
            modelMap.put("category",new ArrayList<>());
            modelMap.put("sumOrderCount",new OrderItemCategoryStatisticsView(0,0,0,null));
            modelMap.put("sumSalesCount",new OrderItemCategoryStatisticsView(null,0,null,new ArrayList<>()));
        }
        return "management/index";
    }

    /*手机首页*/
    @RequestMapping(value = "/wap/index", method = RequestMethod.GET)
    @UserLoginRequired
    public String wapIndex(ModelMap modelMap) {
        modelMap.put("user",sessionContext.getUser());
        modelMap.put("allOrderCount",statisticsService.countOrder(null,null,null));

        List<GoodsCategoryListItemView> categoryList = goodsCategoryService.getAllListView();
        if(Objects.nonNull(categoryList) && categoryList.size() > 0){
            modelMap.put("category",categoryList);
            int id = categoryList.get(0).getId();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            List<OrderItemDailyCount> list = statisticsService.countOrderCount(null,id,null,null,simpleDateFormat.format(new Date()));
            if(Objects.isNull(list)){
                modelMap.put("sumOrderCount",new OrderItemCategoryStatisticsView(0,0,0,null));
            }else {
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
                modelMap.put("sumOrderCount",new OrderItemCategoryStatisticsView(dailyCount,weeklyCount,monthlyCount,null));
            }

            List<OrderItemDailyCount> list1 = statisticsService.countSalesCount(null,id,null,null,simpleDateFormat.format(new Date()));
            if(Objects.isNull(list1) || list1.size() == 0){
                modelMap.put("sumSalesCount",new OrderItemCategoryStatisticsView(null,0,null,list1));
            }else {
                int weeklyCount1 = list1.stream().mapToInt(OrderItemDailyCount::getCount).sum();
                modelMap.put("sumSalesCount",new OrderItemCategoryStatisticsView(null,weeklyCount1,null,list1));
            }
        }else {
            modelMap.put("category",new ArrayList<>());
            modelMap.put("sumOrderCount",new OrderItemCategoryStatisticsView(0,0,0,null));
            modelMap.put("sumSalesCount",new OrderItemCategoryStatisticsView(null,0,null,new ArrayList<>()));
        }
        return "management/wapIndex";
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
