package com.example.learnup;

import com.example.learnup.service.PremierService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class LearnupApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(LearnupApplication.class, args);
        PremierService premierService = ctx.getBean(PremierService.class);
        premierService.addPremier("1", "Test 1", "0-15", 10);
        premierService.addPremier("2", "Test 2", "0-30", 20);
        premierService.addPremier("3", "Test 3", "0-30", 30);
        premierService.getAllPremiers(null);
        System.out.println("------------------------------------------------");
        premierService.buyTickets("test@example.com","1", 3);
        premierService.getAllPremiers(null);
        System.out.println("------------------------------------------------");
        premierService.deletePremier("1");
        premierService.getAllPremiers(null);
        System.out.println("------------------------------------------------");
        premierService.buyTickets("test@example.com", "2", 4);
        premierService.getAllPremiers(null);
        System.out.println("------------------------------------------------");
        premierService.returnTickets("2", 2);
        premierService.getAllPremiers(null);
        System.out.println("------------------------------------------------");
        premierService.updatePremierInformation("3", "Test 3 Update", "25-30");
        premierService.deletePremier("2");
        premierService.getAllPremiers(null);
    }

}
