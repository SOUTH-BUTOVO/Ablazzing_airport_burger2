package com.javaacademy.burger.IT;

import com.javaacademy.burger.Currency;
import com.javaacademy.burger.PayTerminal;
import com.javaacademy.burger.dish.DishType;
import com.javaacademy.burger.exception.NotAcceptedCurrencyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("работа терминала оплаты")
public class PayTerminalIT {

    @Test
    @DisplayName("оплата бургера в рублях")
    public void successPayInRub() {
        PayTerminal payTerminalSpy = Mockito.spy(PayTerminal.class);

        BigDecimal expected1 = BigDecimal.valueOf(300);
        assertEquals(expected1, payTerminalSpy.pay(DishType.BURGER, Currency.RUB).getTotalAmount());

        Currency expected2 = Currency.RUB;
        assertEquals(expected2, payTerminalSpy.pay(DishType.BURGER, Currency.RUB).getCurrency());

        DishType expected3 = DishType.BURGER;
        assertEquals(expected3, payTerminalSpy.pay(DishType.BURGER, Currency.RUB).getDishType());
    }

    @Test
    @DisplayName("оплата бургера в мозамбикских долларах")
    public void failurePayMozambicanDollars() {
        PayTerminal spy = Mockito.spy(PayTerminal.class);
        assertThrows(NotAcceptedCurrencyException.class, () ->
                spy.pay(DishType.BURGER, Currency.MOZAMBICAN_DOLLARS));
    }
}
