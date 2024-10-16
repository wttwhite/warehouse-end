package com.test.warehouseend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.warehouseend.Dto.Food.FoodQueryDto;
import com.test.warehouseend.common.BasePageResponse;
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
    public BaseResponse<BasePageResponse> getEntitiesByPage(FoodQueryDto foodQueryDto) {
        Page<Food> page = new Page<>(foodQueryDto.getCurrentPage(), foodQueryDto.getPageSize());
        QueryWrapper<Food> wrapper = new QueryWrapper<>();
        // 添加搜索条件
        wrapper.like(foodQueryDto.getName() != null, "name", foodQueryDto.getName());
        if (foodQueryDto.getType() != null) {
            wrapper.eq("type", foodQueryDto.getType());
        }
        // 根据时间字段进行排序，时间为空的记录放在前面
        wrapper.orderByAsc("CASE WHEN sellByDate IS NULL THEN 0 ELSE 1 END")
               .orderByDesc("sellByDate");
        // 执行分页查询
        Page<Food> foodPage = foodMapper.selectPage(page, wrapper);
        // 获取结果
        List<Food> foodList = foodPage.getRecords();
        long total = foodPage.getTotal();
        return ResultUtils.success(ResultUtils.pageSuccess(foodList, total));
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
