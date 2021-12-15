package by.itacademy.javaenterprise.kotkovski;

import by.itacademy.javaenterprise.kotkovski.pojos.House;
import by.itacademy.javaenterprise.kotkovski.pojos.aspects.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        HouseService houseService = (HouseService) context.getBean("houseService");
        House house = new House("Kizevatova", 30, 69);
        houseService.performCleaningByAddress(house);
        houseService.performCleaning();
        houseService.performCleaningAround();
        try {
            houseService.performExceptionCleaning();
        } catch (Exception e) {
            log.error("Exception from performExceptionCleaning method", e);
        }
        context.close();
    }
}
