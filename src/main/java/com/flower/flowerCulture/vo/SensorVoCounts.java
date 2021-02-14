package com.flower.flowerCulture.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created by Administrator on 2021/2/14.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SensorVoCounts {
    private Double temperature;//温度
    private Double humidity;//湿度
    private String counts;//个数

}


