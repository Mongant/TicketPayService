package com.mongant.ticketpay.controller;

import com.mongant.ticketpay.entity.Route;
import com.mongant.ticketpay.handler.PaymentHandler;
import com.mongant.ticketpay.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class PaymentController {

    private final String PAYMENT_STATUS = "PROCESSING";

    @Autowired
    PaymentRepository paymentRepository;
    PaymentHandler handler;
    Route route;

    @PostMapping("/pay")
    public String pay(@RequestParam(value = "rout") String rout, @RequestParam(value = "date") String date) {
        handler = new PaymentHandler();
        String ref = handler.getIndex();
        Date dtSql = handler.getSqlDate(date);
        route = new Route(ref, rout, dtSql, PAYMENT_STATUS);
        paymentRepository.getRoute(route);
        return ref;
    }

    @GetMapping("/process")
    public List<Route> process() {
        return paymentRepository.getProcessingRef();
    }
}