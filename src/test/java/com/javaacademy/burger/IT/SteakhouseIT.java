package com.javaacademy.burger.IT;

import com.javaacademy.burger.*;
import com.javaacademy.burger.dish.Dish;
import com.javaacademy.burger.dish.DishType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("владелец бизнеса")
public class SteakhouseIT {

    @Test
    @DisplayName("работа всего ресторана")
    public void successWorkAllSteakhouse() {
        Waitress waitress = new Waitress();
        Kitchen kitchen = new Kitchen();
        PayTerminal payTerminal = new PayTerminal();
        Steakhouse steakhouse = new Steakhouse(waitress, kitchen, payTerminal);

        Paycheck paycheck = steakhouse.makeOrder(DishType.BURGER, Currency.RUB);
        Dish dish = steakhouse.takeOrder(paycheck);

        BigDecimal expected = BigDecimal.valueOf(300);
        assertEquals(expected, paycheck.getTotalAmount());
        assertEquals(DishType.BURGER, paycheck.getDishType());
        assertEquals(Currency.RUB, paycheck.getCurrency());

        assertEquals(DishType.BURGER, dish.getDishType());
        assertEquals(expected, dish.getDishType().getPrice());
    }
}
