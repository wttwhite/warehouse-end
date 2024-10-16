package com.test.warehouseend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.warehouseend.Dto.Food.FoodQueryDto;
import com.test.warehouseend.common.BasePageResponse;
import com.test.warehouseend.common.BaseResponse;
import com.test.warehouseend.model.domain.Food;
import com.test.warehouseend.service.FoodService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Resource
    private FoodService foodService;

    @PostMapping("/add")
    public boolean UserRegister(@RequestBody Food food) {
        return foodService.addFood(food);
    }

    @PostMapping("/page")
    public BaseResponse<BasePageResponse> getFood(@RequestBody FoodQueryDto foodQueryDto) {
        return foodService.getEntitiesByPage(foodQueryDto);
    }

}
