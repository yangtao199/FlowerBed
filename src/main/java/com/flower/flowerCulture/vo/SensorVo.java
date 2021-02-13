package com.flower.flowerCulture.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by Administrator on 2021/2/13.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SensorVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Double maxTemperature;//最大温度
    private Double maxHumidity;//最大湿度
    private Double minTemperature;//最小温度
    private Double minHumidity;//最小湿度
    private Double artificialIllumination;//人工光照
    private Double illumination;//光照

}
