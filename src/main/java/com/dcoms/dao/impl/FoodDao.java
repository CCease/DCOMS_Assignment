package com.dcoms.dao.impl;

import com.dcoms.dao.IFoodDao;
import com.dcoms.domain.Food;

import java.util.List;

public class FoodDao implements IFoodDao {
    @Override
    public List<Food> findAllFood() {
        return null;
    }

    @Override
    public List<Food> findFoodByKeyword(String keyword) {
        return null;
    }

    @Override
    public Food findFoodById(Integer id) {
        return null;
    }

    @Override
    public List<Food> findFoodByPriceRange(Double upperBound, Double lowerBound) {
        return null;
    }
}
