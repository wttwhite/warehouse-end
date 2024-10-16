package com.test.warehouseend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.warehouseend.common.BaseResponse;
import com.test.warehouseend.common.ResultUtils;
import com.test.warehouseend.service.FoodService;
import com.test.warehouseend.model.domain.Food;
import com.test.warehouseend.mapper.FoodMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author wangt
* @description 针对表【food】的数据库操作Service实现
* @createDate 2024-10-08 14:39:07
*/
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food>
implements FoodService {

    private final FoodMapper foodMapper;

    public FoodServiceImpl(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    @Override
    public BaseResponse<List<Food>> getEntitiesByPage(String name, int pageNo, int pageSize) {
        int offset = (pageNo - 1) * pageSize;
        return ResultUtils.success(foodMapper.selectByPage(name, offset, pageSize));
    }

    @Override
    public boolean addFood(Food food) {
        // 插入数据
        Food f = new Food();
        f.setName(food.getName());
        f.setType(food.getType());
        f.setUnit(food.getUnit());
        f.setInventory(food.getInventory());
        f.setProductDate(food.getProductDate());
        f.setSellByDate(food.getSellByDate());
        return this.save(f);
    }
}
