package ru.spb.osiptsoff.finance.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.osiptsoff.finance.crud.service.TargetService;
import ru.spb.osiptsoff.finance.lib.dto.Target;

@RestController
@RequestMapping("/target")
public class TargetController extends CrudController<Target> {

    public TargetController(TargetService service) {
        super(service);
    }
    
}
