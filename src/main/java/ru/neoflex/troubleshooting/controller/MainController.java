package ru.neoflex.troubleshooting.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Log4j2
@Tag(name = "Главный контроллер", description = "Позволяет выполнять основные математические операции")
public class MainController {

    @Operation(
            summary = "Суммирование",
            description = "Позволяет суммировать два числа"
    )
    @GetMapping("addition")
    public ResponseEntity<String> addition(
            @RequestParam(required = false) @Parameter(description = "Первое слагаемое") String a,
            @RequestParam(required = false) @Parameter(description = "Второе слагаемое") String b) {
        log.info("Вызов функции 'addition' c параметрами {} и {}.", a, b);
        try{
            log.warn("Замена запятых на точки в параметре {}.", a);
            a = a.replace(',', '.');
            log.warn("Замена запятых на точки в параметре {}.", b);
            b = b.replace(',', '.');
            log.info("Суммирование параметров {} и {}.", a, b);
            double result = Double.parseDouble(a) + Double.parseDouble(b);
            log.info("Возвращение полученой суммы {}.", result);
            return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(result));
        } catch (NumberFormatException ex) {
            log.debug("Какое-либо из полученных значений 'a - {}' и 'b - {}' не является числом.", a, b);
            log.error("Произошла ошибка формата числа в праметрах 'a - {}' и 'b - {}'.", a, b);
            log.info("Возвращение собщения об ошибке.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Суммирование не получилось, так как " +
                    "какой-либо параметр не является числом.");
        }
    }

    @Operation(
            summary = "Вычитание",
            description = "Позволяет получить разность двух чисел"
    )
    @GetMapping("subtraction")
    public ResponseEntity<String> subtraction(
            @RequestParam(required = false) @Parameter(description = "Уменьшаемое") String a,
            @RequestParam(required = false) @Parameter(description = "Вычитаемое") String b) {
        log.info("Вызов функции 'subtraction' c параметрами {} и {}.", a, b);
        try{
            log.warn("Замена запятых на точки в параметре {}.", a);
            a = a.replace(',', '.');
            log.warn("Замена запятых на точки в параметре {}.", b);
            b = b.replace(',', '.');
            log.info("Вычитание параметров {} и {}.", a, b);
            double result = Double.parseDouble(a) - Double.parseDouble(b);
            log.info("Возвращение полученой разницы {}.", result);
            return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(result));
        } catch (NumberFormatException ex) {
            log.debug("Какое-либо из полученных значений 'a - {}' и 'b - {}' не является числом.", a, b);
            log.error("Произошла ошибка формата числа в праметрах 'a - {}' и 'b - {}'.", a, b);
            log.info("Возвращение собщения об ошибке.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Вычитание не получилось, так как " +
                    "какой-либо параметр не является числом.");
        }
    }

    @Operation(
            summary = "Умножение",
            description = "Позволяет перемножить два числа"
    )
    @GetMapping("multiplication")
    public ResponseEntity<String> multiplication(
            @RequestParam(required = false) @Parameter(description = "Первый множитель") String a,
            @RequestParam(required = false) @Parameter(description = "Второй множитель") String b) {
        log.info("Вызов функции 'multiplication' c параметрами {} и {}.", a, b);
        try{
            log.warn("Замена запятых на точки в параметре {}.", a);
            a = a.replace(',', '.');
            log.warn("Замена запятых на точки в параметре {}.", b);
            b = b.replace(',', '.');
            log.info("Умножение параметров {} и {}.", a, b);
            double result = Double.parseDouble(a) * Double.parseDouble(b);
            log.info("Возвращение полученого произведение {}.", result);
            return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(result));
        } catch (NumberFormatException ex) {
            log.debug("Какое-либо из полученных значений 'a - {}' и 'b - {}' не является числом.", a, b);
            log.error("Произошла ошибка формата числа в праметрах 'a - {}' и 'b - {}'.", a, b);
            log.info("Возвращение собщения об ошибке.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Умножение не получилось, так как " +
                    "какой-либо параметр не является числом.");
        }
    }

    @Operation(
            summary = "Деление",
            description = "Позволяет разделить два числа"
    )
    @GetMapping("division")
    public ResponseEntity<String> division(
            @RequestParam(required = false) @Parameter(description = "Делимое") String a,
            @RequestParam(required = false) @Parameter(description = "Делитель") String b) {
        log.info("Вызов функции 'division' c параметрами {} и {}.", a, b);
        try{
            log.warn("Замена запятых на точки в параметре {}.", a);
            a = a.replace(',', '.');
            log.warn("Замена запятых на точки в параметре {}.", b);
            b = b.replace(',', '.');
            log.info("Деление параметров {} и {}.", a, b);
            double result = Double.parseDouble(a) / Double.parseDouble(b);
            log.info("Возвращение полученого результата деления {}.", result);
            return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(result));
        } catch (NumberFormatException ex) {
            log.debug("Какое-либо из полученных значений 'a - {}' и 'b - {}' не является числом.", a, b);
            log.error("Произошла ошибка формата числа в праметрах 'a - {}' и 'b - {}'.", a, b);
            log.info("Возвращение собщения об ошибке.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Деление не получилось, так как " +
                    "какой-либо параметр не является числом.");
        }
    }
}
