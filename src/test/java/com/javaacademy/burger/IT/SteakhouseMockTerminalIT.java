package com.javaacademy.burger.IT;

import com.javaacademy.burger.*;
import com.javaacademy.burger.dish.Dish;
import com.javaacademy.burger.dish.DishType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("проверка из санэпидемстанции")
public class SteakhouseMockTerminalIT {

    @Test
    @DisplayName("работа ресторана, терминал Spy")
    public void successWorkMockPayTerminalSteakhouse() {
        Waitress waitress = new Waitress();
        Kitchen kitchen = new Kitchen();
        PayTerminal payTerminal = mock(PayTerminal.class);
        when(payTerminal.pay(DishType.RIBS, Currency.RUB)).thenReturn(
                new Paycheck(valueOf(700), Currency.RUB, DishType.RIBS));
        Steakhouse steakhouse = new Steakhouse(waitress, kitchen, payTerminal);

        Paycheck paycheck = steakhouse.makeOrder(DishType.RIBS, Currency.RUB);
        Dish dish = steakhouse.takeOrder(paycheck);

        assertEquals(valueOf(700), paycheck.getTotalAmount());
        assertEquals(DishType.RIBS, paycheck.getDishType());
        assertEquals(Currency.RUB, paycheck.getCurrency());

        assertEquals(DishType.RIBS, dish.getDishType());
    }
}
