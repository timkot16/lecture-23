package by.itacademy.javaenterprise.kotkovski.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {
    private String street;
    private int number;
    private int numberOfApartments;
}
