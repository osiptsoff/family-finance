package ru.spb.osiptsoff.finance.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.osiptsoff.finance.crud.service.TransactionService;
import ru.spb.osiptsoff.finance.lib.dto.Transaction;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends CrudController<Transaction> {

    public TransactionController(TransactionService service) {
        super(service);
    }
    
}
