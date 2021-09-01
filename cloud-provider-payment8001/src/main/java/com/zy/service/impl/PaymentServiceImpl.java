package com.zy.service.impl;

import com.zy.entity.Payment;
import com.zy.mapper.PaymentMapper;
import com.zy.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhengyi
 * @Date: 2021/9/1 13:40
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int save(Payment payment) {
        return this.paymentMapper.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return this.paymentMapper.getPaymentById(id);
    }
}
