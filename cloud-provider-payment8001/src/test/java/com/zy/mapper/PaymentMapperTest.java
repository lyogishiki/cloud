package com.zy.mapper;

import com.zy.entity.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: zhengyi
 * @Date: 2021/8/31 15:30
 */
@SpringBootTest
public class PaymentMapperTest {

    @Autowired
    private PaymentMapper paymentMapper;

    @Test
    public void test01() {
        Payment payment = new Payment();
        payment.setSerial("1");
        this.paymentMapper.save(payment);
        System.out.println(payment.getId());
    }

    @Test
    public void test02() {
        Payment payment = paymentMapper.getPaymentById(1L);
        System.out.println(payment);
    }

}
