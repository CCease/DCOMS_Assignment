package main.java.com.dcoms.dao;

import main.java.com.dcoms.domain.Food;

import java.util.List;

public interface IFoodDao {

    List<Food> findAllFood();

    Food findFoodById(Integer id);

    List<Food> findFoodByPriceRange(Double upperBound, Double lowerBound);

    List<Food> findFoodByKeyword(String keyword);
}
