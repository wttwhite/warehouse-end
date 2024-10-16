package com.test.warehouseend.mapper;

import com.test.warehouseend.model.domain.Food;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wangt
* @description 针对表【food】的数据库操作Mapper
* @createDate 2024-10-08 14:39:07
* @Entity generator.domain.Food
*/
public interface FoodMapper extends BaseMapper<Food> {
    // 分页查询方法
    List<Food> selectByPage(@Param("name") String name,
                            @Param("offset") int offset,
                            @Param("limit") int limit);

}
