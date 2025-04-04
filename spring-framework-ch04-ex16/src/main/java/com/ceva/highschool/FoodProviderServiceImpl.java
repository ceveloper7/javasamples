package com.ceva.highschool;

import com.ceva.model.Food;
import com.ceva.service.FoodProviderService;

import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        return List.of(new Food("Coke"), new Food("Hamburger"), new Food("Fries"));
    }
}
