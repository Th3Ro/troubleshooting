package ru.neoflex.troubleshooting;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.neoflex.troubleshooting.controller.MainController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainControllerTest {
    private final MainController mainController = new MainController();

    @Test
    public void testAdditionCode200() {
        String a = "40";
        String b = "2";
        ResponseEntity<String> expected = ResponseEntity.status(HttpStatus.OK)
                .body(String.valueOf(42D));
        ResponseEntity<String> result = mainController.addition(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testAdditionCode400() {
        String a = "40";
        String b = "not 2";
        ResponseEntity<String> expected = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Суммирование не получилось, так как " +
                        "какой-либо параметр не является числом.");
        ResponseEntity<String> result = mainController.addition(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testSubtractionCode200() {
        String a = "40";
        String b = "2";
        ResponseEntity<String> expected = ResponseEntity.status(HttpStatus.OK)
                .body(String.valueOf(38D));
        ResponseEntity<String> result = mainController.subtraction(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testSubtractionCode400() {
        String a = "40";
        String b = "not 2";
        ResponseEntity<String> expected = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Вычитание не получилось, так как " +
                        "какой-либо параметр не является числом.");
        ResponseEntity<String> result = mainController.subtraction(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testMultiplicationCode200() {
        String a = "40";
        String b = "2";
        ResponseEntity<String> expected = ResponseEntity.status(HttpStatus.OK)
                .body(String.valueOf(80D));
        ResponseEntity<String> result = mainController.multiplication(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testMultiplicationCode400() {
        String a = "40";
        String b = "not 2";
        ResponseEntity<String> expected = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Умножение не получилось, так как " +
                        "какой-либо параметр не является числом.");
        ResponseEntity<String> result = mainController.multiplication(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testDivisionCode200() {
        String a = "40";
        String b = "2";
        ResponseEntity<String> expected = ResponseEntity.status(HttpStatus.OK)
                .body(String.valueOf(20D));
        ResponseEntity<String> result = mainController.division(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testDivisionCode400() {
        String a = "40";
        String b = "not 2";
        ResponseEntity<String> expected = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Деление не получилось, так как " +
                        "какой-либо параметр не является числом.");
        ResponseEntity<String> result = mainController.division(a, b);
        assertEquals(expected, result);
    }
}
