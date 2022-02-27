package com.example.learnup;

import com.example.learnup.service.PremierService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnupApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(LearnupApplication.class, args);
        ctx.getBean(PremierService.class).addPremier("1", "Test 1", "0-15", 10);
        ctx.getBean(PremierService.class).addPremier("2", "Test 2", "0-30", 20);
        ctx.getBean(PremierService.class).addPremier("3", "Test 3", "0-30", 30);
        ctx.getBean(PremierService.class).getAllPremiers(null);
        System.out.println("------------------------------------------------");
        ctx.getBean(PremierService.class).buyTickets("1", 3);
        ctx.getBean(PremierService.class).getAllPremiers(null);
        System.out.println("------------------------------------------------");
        ctx.getBean(PremierService.class).deletePremier("1");
        ctx.getBean(PremierService.class).getAllPremiers(null);
        System.out.println("------------------------------------------------");
        ctx.getBean(PremierService.class).buyTickets("2", 4);
        ctx.getBean(PremierService.class).returnTickets("2", 2);
        ctx.getBean(PremierService.class).getAllPremiers(null);
        System.out.println("------------------------------------------------");
        ctx.getBean(PremierService.class).updatePremierInformation("3", "Test 3 Update", "25-30");
        ctx.getBean(PremierService.class).deletePremier("2");
        ctx.getBean(PremierService.class).getAllPremiers(null);
    }

}
