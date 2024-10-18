-- auto-generated definition
create table food
(
    id          bigint auto_increment
        primary key,
    name        varchar(255)                        null comment '食材名称',
    type        varchar(30)                         null comment '食材类型',
    inventory   int                                 null comment '库存',
    unit        varchar(30)                         null comment '单位',
    productDate date                                null comment '生产日期',
    sellByDate  date                                null comment '保质期',
    createTime  timestamp default CURRENT_TIMESTAMP not null,
    updateTime  timestamp default CURRENT_TIMESTAMP not null,
    isDelete    tinyint   default 0                 not null comment '是否删除'
)
    charset = utf8;