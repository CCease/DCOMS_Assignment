package com.dcoms.dao;

import com.dcoms.domain.Food;

import java.util.List;

public interface IFoodDao {

    List<Food> findAllFood();

    Food findFoodById(String id);

    List<Food> findFoodByPriceRange(Double upperBound, Double lowerBound);

    List<Food> findFoodByKeyword(String keyword);
}
