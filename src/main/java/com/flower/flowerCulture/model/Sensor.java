package com.flower.flowerCulture.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangTao
 * @since 2021-02-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Sensor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double temperature;//温度

    private Double humidity;//湿度

    private Double brightness;//亮度

    private Date time;
    private String counts;


}
