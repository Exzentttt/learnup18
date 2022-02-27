package com.example.learnup.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PremierAspect {

    @After("execution(* com.example.learnup.service.PremierService.buyTickets(..)) && args(email,..)")
    public void buyTicketsEmail(JoinPoint joinPoint, String email) {
        log.info("Send email buy tickets: {}", email);
    }

    @After("execution(* com.example.learnup.service.PremierService.addPremier(..))")
    public void addPremierEmail(JoinPoint joinPoint) {
        for (String email: new String[]{"test@example.com", "test1@example.com"}) {
            log.info("Send email add premier: {}", email);
        }
    }

    @After("execution(* com.example.learnup.service.PremierService.deletePremier(..))")
    public void deletePremierEmail(JoinPoint joinPoint) {
        for (String email: new String[]{"test@example.com", "test2@example.com"}) {
            log.info("Send email delete premier: {}", email);
        }
    }

}