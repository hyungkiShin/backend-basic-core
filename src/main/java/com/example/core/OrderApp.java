package com.example.core;

import com.example.core.member.Grade;
import com.example.core.member.Member;
import com.example.core.member.MemberService;
import com.example.core.order.Order;
import com.example.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        final AppConfig appConfig = new AppConfig();
//        (v1)
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

//        (v2)
//        final MemberService memberService = appConfig.memberService();
//        final OrderService orderService = appConfig.orderService();

//        (v3) [Spring]
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        final MemberService memberService = appContext.getBean("memberService", MemberService.class);
        final OrderService orderService = appContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}