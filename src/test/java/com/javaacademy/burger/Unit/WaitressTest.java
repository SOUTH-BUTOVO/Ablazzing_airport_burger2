package com.javaacademy.burger.Unit;

import com.javaacademy.burger.Kitchen;
import com.javaacademy.burger.Waitress;
import com.javaacademy.burger.dish.DishType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("проверка работы официанта")
public class WaitressTest {

    @Test
    @DisplayName("запрошен бургер")
    public void successOrderBurger() {
        Kitchen mock = Mockito.mock(Kitchen.class);
        Waitress waitress = new Waitress();
        assertTrue(waitress.giveOrderToKitchen(DishType.BURGER, mock));
    }

    @Test
    @DisplayName("запрошена фуагра")
    public void failureOrderFuagra() {
        Kitchen mock = Mockito.mock(Kitchen.class);
        Waitress waitress = new Waitress();
        assertFalse(waitress.giveOrderToKitchen(DishType.FUAGRA, mock));
    }
}
