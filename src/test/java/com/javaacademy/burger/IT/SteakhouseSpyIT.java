package com.javaacademy.burger.IT;

import com.javaacademy.burger.*;
import com.javaacademy.burger.dish.DishType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("проверка из налоговой")
public class SteakhouseSpyIT {

    @Test
    @DisplayName("покупка ребра за рубли")
    public void successBuyBurgerRub() {
        Waitress waitressMock = mock(Waitress.class);
        when(waitressMock.giveOrderToKitchen(any(), any()))
                .thenReturn(true);
        Kitchen kitchenMock = mock(Kitchen.class);

        PayTerminal payTerminalSpy = spy(PayTerminal.class);
        when(payTerminalSpy.pay(DishType.RIBS, Currency.RUB)).thenReturn(
                new Paycheck(valueOf(700), Currency.RUB, DishType.RIBS));

        Steakhouse steakhouse = new Steakhouse(waitressMock, kitchenMock, payTerminalSpy);
        Paycheck paycheck = steakhouse.makeOrder(DishType.RIBS, Currency.RUB);

        BigDecimal expected1 = valueOf(700);
        assertEquals(expected1, paycheck.getTotalAmount());

        Currency expected2 = Currency.RUB;
        assertEquals(expected2, paycheck.getCurrency());

        DishType expected3 = DishType.RIBS;
        assertEquals(expected3, paycheck.getDishType());
    }

    @Test
    @DisplayName("покупка картошки за доллары")
    public void successBuyFriesOnDollars() {
        Waitress waitressMock = mock(Waitress.class);
        when(waitressMock.giveOrderToKitchen(any(), any()))
                .thenReturn(true);
        Kitchen kitchenMock = mock(Kitchen.class);

        PayTerminal payTerminalSpy = mock(PayTerminal.class);
        when(payTerminalSpy.pay(DishType.FRIED_POTATO, Currency.USD)).thenReturn(
                new Paycheck(valueOf(1), Currency.USD, DishType.FRIED_POTATO));

        Steakhouse steakhouse = new Steakhouse(waitressMock, kitchenMock, payTerminalSpy);
        Paycheck paycheck = steakhouse.makeOrder(DishType.FRIED_POTATO, Currency.USD);

        BigDecimal expected1 = valueOf(1);
        assertEquals(expected1, paycheck.getTotalAmount());

        Currency expected2 = Currency.USD;
        assertEquals(expected2, paycheck.getCurrency());

        DishType expected3 = DishType.FRIED_POTATO;
        assertEquals(expected3, paycheck.getDishType());
    }

    @Test
    @DisplayName("покупка бургера за мозамбикские доллары")
    public void successBuyBurgerOnMozambicanDollars() {
        Waitress waitressMock = mock(Waitress.class);
        when(waitressMock.giveOrderToKitchen(any(), any()))
                .thenReturn(true);
        Kitchen kitchenMock = mock(Kitchen.class);

        PayTerminal payTerminalSpy = mock(PayTerminal.class);
        when(payTerminalSpy.pay(DishType.BURGER, Currency.MOZAMBICAN_DOLLARS)).thenReturn(
                new Paycheck(valueOf(1), Currency.MOZAMBICAN_DOLLARS, DishType.BURGER));

        Steakhouse steakhouse = new Steakhouse(waitressMock, kitchenMock, payTerminalSpy);
        Paycheck paycheck = steakhouse.makeOrder(DishType.BURGER, Currency.MOZAMBICAN_DOLLARS);

        BigDecimal expected1 = valueOf(1);
        assertEquals(expected1, paycheck.getTotalAmount());

        Currency expected2 = Currency.MOZAMBICAN_DOLLARS;
        assertEquals(expected2, paycheck.getCurrency());

        DishType expected3 = DishType.BURGER;
        assertEquals(expected3, paycheck.getDishType());
    }
}
