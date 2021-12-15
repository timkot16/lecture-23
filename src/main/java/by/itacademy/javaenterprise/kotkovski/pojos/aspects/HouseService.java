package by.itacademy.javaenterprise.kotkovski.pojos.aspects;

import by.itacademy.javaenterprise.kotkovski.pojos.House;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("houseService")
public class HouseService {

    public void performCleaning() {
        log.info("Cleaning began.");
    }

    public void performExceptionCleaning() throws Exception {
        log.info("Threw exception in cleaning time");
        throw new Exception("ExceptionCleaning");
    }

    public String performCleaningAround() {
        log.info("Perform around cleaning.");
        return "Cleaning was finished successfully";
    }

    public void performCleaningByAddress(House house) {
        log.info("Address: "
                + house.getStreet() + ", "
                + house.getNumber() + "\n"
                + "Number of apartments: " + house.getNumberOfApartments()
        );
    }
}
