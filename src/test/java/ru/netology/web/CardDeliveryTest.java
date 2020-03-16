package ru.netology.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class CardDeliveryTest {
    @Test
    void shouldTestAllFieldsCorrectly() {
        open("http://localhost:9999");
        Integer Day = 3;
        String date = LocalDate.now().plusDays(Day).format(DateTimeFormatter.ofPattern("dd.MM.uuuu"));
        $("[data-test-id=city] input").setValue("Пермь");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $("[data-test-id=date] input").setValue(date);
        $("[data-test-id=name] input").setValue("Олег Самсонов");
        $("[data-test-id=phone] input").setValue("+79020000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();

        $(withText("Успешно!")).waitUntil(visible, 15000);
    }
}
