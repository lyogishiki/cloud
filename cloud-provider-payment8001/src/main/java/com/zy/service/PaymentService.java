package com.zy.service;

import com.zy.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zhengyi
 * @Date: 2021/9/1 13:39
 */
public interface PaymentService {
    int save(Payment payment);

    Payment getPaymentById(Long id);
}
