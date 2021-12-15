package by.itacademy.javaenterprise.kotkovski.pojos.aspects;

import by.itacademy.javaenterprise.kotkovski.pojos.House;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component("houseAspect")
public class HouseAspect {

    @Pointcut("execution(* by.itacademy.javaenterprise.kotkovski.pojos.aspects.HouseService.performCleaning())")
    public void performance() {
    }

    @Pointcut("execution(* by.itacademy.javaenterprise.kotkovski.pojos.aspects.HouseService.performCleaningByAddress(Object)) && args(house))")
    public void performanceName(House house) {
    }

    @Before("performance()")
    public void before() {
        log.info("Clean the house.");
    }

    @AfterReturning("performance()")
    public void after() {
        log.info("The house was cleaned.");
    }

    public void afterProblems() {
        log.info("Execution after cleaning problems.");
    }

    public void around(ProceedingJoinPoint joinPoint) {
        try {
            log.info("Start");
            log.info("Begin Time: " + System.currentTimeMillis());
            String result = (String) joinPoint.proceed();
            log.info("Finish Time: " + System.currentTimeMillis());
            log.info("Status: " + result);
        } catch (Throwable throwable) {
            log.error("Exception from aroud method", throwable);
        }
    }

    @Before("performanceName(house)")
    public void interceptedAddressForCleaning(House house) {
        log.info("Intercepted address: "
                + house.getStreet() + ", "
                + house.getNumber());
    }
}
