package com.zy.mapper;

import com.zy.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zhengyi
 * @Date: 2021/8/31 15:14
 */
@Mapper
public interface PaymentMapper {

    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
