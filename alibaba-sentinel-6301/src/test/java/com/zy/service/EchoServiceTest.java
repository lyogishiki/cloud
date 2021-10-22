package com.zy.service;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.zy.SentinelApplication;
import com.zy.service.EchoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhengyi
 * @Date: 2021/10/22 16:25
 */
@SpringBootTest(classes = SentinelApplication.class)
@RunWith(SpringRunner.class)
public class EchoServiceTest {

    @Autowired
    private EchoService echoService;

    @Test
    public void test01() {
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule = new FlowRule();
        rule.setResource("testResource");
// set limit qps to 10
        rule.setCount(5);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);

        for (int i = 0; i < 1000; i++) {
            System.out.println(echoService.testResource());
        }
    }

}
