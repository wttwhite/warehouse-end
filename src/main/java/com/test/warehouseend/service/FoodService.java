package com.test.warehouseend.service;

import com.test.warehouseend.model.domain.Food;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wangt
* @description 针对表【food】的数据库操作Service
* @createDate 2024-10-08 14:39:07
*/
public interface FoodService extends IService<Food> {
    boolean addFood(Food food);

}
