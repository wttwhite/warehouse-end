package com.test.warehouseend;

import com.test.warehouseend.model.domain.Food;
import com.test.warehouseend.service.FoodService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WarehouseEndApplicationTests {

    @Resource
    private FoodService foodService;
    @Test
    void testAddFood() {
        Food f = new Food();
        f.setName("名称1");
        f.setType("1");
        f.setInventory(500);
        f.setUnit("g");
//        f.setProductDate("2024-10-08");
//        f.setSellByDate("2025-12-12");
        boolean result = foodService.save(f);
        System.out.println(f.getId());
        assertTrue(result);
        System.out.println("testAddUser");
    }

}
