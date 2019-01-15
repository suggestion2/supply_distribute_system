package com.su.supplydistributesystem.controller.api.management;

import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.rest.view.SuccessView;
import com.su.supplydistributesystem.domain.Distributor;
import com.su.supplydistributesystem.service.DistributorService;
import com.su.supplydistributesystem.request.DistributorCreateForm;
import com.su.supplydistributesystem.request.DistributorUpdateForm;
import com.su.supplydistributesystem.request.DistributorListForm;
import com.su.supplydistributesystem.response.DistributorListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Objects;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController("distributorController")
@RequestMapping(value = "/mApi/distributor")
public class DistributorController {

    private static final Logger logger = LoggerFactory.getLogger(DistributorController.class);

    @Autowired
    private DistributorService distributorService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public DistributorListView list(@Valid @RequestBody DistributorListForm form){
        return new DistributorListView(distributorService.selectList(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public Distributor detail(@PathVariable Integer id){
        return distributorService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public SuccessView create(@Valid @RequestBody DistributorCreateForm form){
        Distributor distributor = new Distributor();
        BeanUtils.copyProperties(form,distributor);
        distributorService.create(distributor);
        return new SuccessView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public SuccessView update(@Valid @RequestBody DistributorUpdateForm form){
        Distributor distributor = distributorService.getById(form.getId());
        if(Objects.isNull(distributor)){
            throw new ResourceNotFoundException("distributor not exists");
        }
        BeanUtils.copyProperties(form,distributor);
        distributorService.update(distributor);
        return new SuccessView();
    }
}
