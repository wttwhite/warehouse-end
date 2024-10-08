package com.test.warehouseend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.warehouseend.model.domain.Food;
import com.test.warehouseend.service.FoodService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Resource
    private FoodService foodService;



    @GetMapping("/page")
    public List<Food> getFood() {
        QueryWrapper<Food> queryWrapper = new QueryWrapper<>();
        List<Food> list = foodService.list(queryWrapper);
        return new ArrayList<>(list);
    }

}
