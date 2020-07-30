DROP TABLE IF EXISTS `t_cheliang`;
CREATE TABLE `t_cheliang`  (
                               `f_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '汽车ID',
                               `f_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车辆型号',
                               `f_struct_number` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车架号',
                               `f_color` varchar(20) NULL DEFAULT NULL COMMENT '颜色',
                               `f_volume` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排量',
                               `f_weight` int(10) NOT NULL COMMENT '自重',
                               `f_date` datetime(0) NOT NULL COMMENT '生产日期',
                               `f_turbo` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否涡轮增压',
                               `f_drive` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '驱动类型',
                               `f_min_price` int(10) NOT NULL COMMENT '最低价格',
                               `f_part` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '汽车配件',
                               `f_insure` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否购买保险',
                               `f_other` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '其他配件',
                               `f_care_counts` int(10) NOT NULL COMMENT '保养次数',
                               PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '车辆表' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `t_order_list`;
CREATE TABLE `t_order_list`  (
                                `f_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
                                `f_created_time` datetime(0) NOT NULL COMMENT '订单日期',
                                `f_salesman_id` bigint(20) NOT NULL COMMENT '销售员ID',
                                `f_client_id` bigint(20) NOT NULL COMMENT '客户ID',
                                `f_sale_price` bigint(20) NOT NULL COMMENT '价格',
                                `f_status` int(10) NOT NULL COMMENT '状态',
                                `f_car_id` bigint(20) NOT NULL COMMENT '汽车ID',
                               PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;