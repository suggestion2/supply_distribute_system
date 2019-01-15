package com.su.supplydistributesystem.controller.api.management;

import com.su.supplydistributesystem.context.SessionContext;
import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import com.sug.core.rest.view.SuccessView;
import com.su.supplydistributesystem.domain.Supplier;
import com.su.supplydistributesystem.service.SupplierService;
import com.su.supplydistributesystem.request.SupplierCreateForm;
import com.su.supplydistributesystem.request.SupplierUpdateForm;
import com.su.supplydistributesystem.request.SupplierListForm;
import com.su.supplydistributesystem.response.SupplierListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Objects;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController
@RequestMapping(value = "/mApi/supplier")
@UserLoginRequired
public class SupplierController {

    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public SupplierListView list(@Valid @RequestBody SupplierListForm form){
        return new SupplierListView(supplierService.selectList(form.getQueryMap()),supplierService.selectCount(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public Supplier detail(@PathVariable Integer id){
        return supplierService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public ResponseView create(@Valid @RequestBody SupplierCreateForm form){
        Supplier sup = supplierService.getByName(form.getName());
        if(Objects.nonNull(sup)){
            throw new InvalidRequestException("multipleName","supplier is exists");
        }
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(form,supplier);
        supplier.setCreateBy(sessionContext.getUser().getId());
        supplier.setUpdateBy(sessionContext.getUser().getId());
        supplierService.create(supplier);
        return new ResponseView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public ResponseView update(@Valid @RequestBody SupplierUpdateForm form){
        Supplier supplier = supplierService.getById(form.getId());
        if(Objects.isNull(supplier)){
            throw new ResourceNotFoundException("supplier not exists");
        }
        //检查good_supply是否有此账号
        //检查orderItem是否有此账号
        BeanUtils.copyProperties(form,supplier);
        supplierService.update(supplier);
        return new ResponseView();
    }
    @RequestMapping(value = DELETE_BY_ID, method = RequestMethod.DELETE)
    public ResponseView deleteById(@PathVariable Integer id) {
        //检查good_supply是否有此账号
        //检查orderItem是否有此账号
        supplierService.deleteById(id);
        return new ResponseView();
    }
}
