package com.ceva.kindergarten;

import com.ceva.model.Food;
import com.ceva.service.FoodProviderService;

import java.util.List;


public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        return List.of(new Food("Milk"), new Food("Biscuits"));
    }
}
