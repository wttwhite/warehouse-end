package com.test.warehouseend.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasePageResponse<T> implements Serializable {
    private long total;
    private T records;

    public BasePageResponse( T records, long total) {
        this.total = total;
        this.records = records;
    }
}
