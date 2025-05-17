package com.javaacademy.burger.Unit;

import com.javaacademy.burger.Kitchen;
import com.javaacademy.burger.dish.DishType;
import com.javaacademy.burger.exception.KitchenHasNoGasException;
import com.javaacademy.burger.exception.UnsupportedDishTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("проверка работы кухни")
public class KitchenTest {

    @Test
    @DisplayName("успешно приготовила бургер")
    public void successCookBurger() {
        Kitchen kitchen = new Kitchen();
        kitchen.cook(DishType.BURGER);
        assertTrue(kitchen.getCompletedDishes().containsKey(DishType.BURGER));
    }

    @Test
    @DisplayName("на кухне выключили газ")
    public void failureCookBurger() {
        Kitchen kitchen = new Kitchen();
        kitchen.setHasGas(false);
        assertThrows(KitchenHasNoGasException.class, () -> kitchen.cook(DishType.BURGER));
    }

    @Test
    @DisplayName("приготовление фуагра")
    public void failureCookFuagra() {
        Kitchen kitchen = new Kitchen();
        assertThrows(UnsupportedDishTypeException.class, () -> kitchen.cook(DishType.FUAGRA));
    }
}
