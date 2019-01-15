package com.su.supplydistributesystem.controller.api.management;

import com.sug.core.platform.exception.ResourceNotFoundException;
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
@RequestMapping(value = "/supplier")
public class SupplierController {

    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public SupplierListView list(@Valid @RequestBody SupplierListForm form){
        return new SupplierListView(supplierService.selectList(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public Supplier detail(@PathVariable Integer id){
        return supplierService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public SuccessView create(@Valid @RequestBody SupplierCreateForm form){
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(form,supplier);
        supplierService.create(supplier);
        return new SuccessView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public SuccessView update(@Valid @RequestBody SupplierUpdateForm form){
        Supplier supplier = supplierService.getById(form.getId());
        if(Objects.isNull(supplier)){
            throw new ResourceNotFoundException("supplier not exists");
        }
        BeanUtils.copyProperties(form,supplier);
        supplierService.update(supplier);
        return new SuccessView();
    }
}
