package com.zy.controller;

import com.zy.entity.CommonResult;
import com.zy.entity.Payment;
import com.zy.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhengyi
 * @Date: 2021/8/31 14:20
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @RequestMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        payment.setSerial(payment.getSerial() + ":" + port);
        return new CommonResult<>(200, "", payment);
    }

    @PostMapping("create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
        return new CommonResult<>(200, "", result);
    }

}
