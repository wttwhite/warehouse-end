package com.test.warehouseend.Dto.Food;

public class FoodQueryDto {
    private int currentPage = 1;
    private int pageSize = 10;
    private String name;
    private Integer type;

    public int getCurrentPage() {
        return currentPage ;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
