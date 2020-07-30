package cc.mrbird.febs.dingdan.entity;

import cc.mrbird.febs.common.converter.TimeConverter;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author MrBird
 */
@Data
@TableName("t_order_list")
@Excel("订单信息表")
public class Dingdan implements Serializable {

    private static final long serialVersionUID = -4352868070794165001L;

    /**
     * 订单 ID
     */
    @TableId(value = "f_id", type = IdType.AUTO)
    private Long FId;

    /**
     * 订单日期
     */
    @TableField("f_created_time")
    @ExcelField(value = "订单日期", writeConverter = TimeConverter.class)
    private Date FDate;

    /**
     * 操作人 ID
     */
    @TableId(value = "f_salesman_id")
    private Long FSalesmanId;

    /**
     * 客户 ID
     */
    @TableId(value = "f_client_id")
    private Long FClientId;

    /**
     * 价格
     */
    @TableId(value = "f_sale_price")
    private Integer FPrice;

    /**
     * 状态
     */
    @TableId(value = "f_status")
    private Integer FStatus;

    /**
     * 汽车ID
     */
    @TableId(value = "f_car_id")
    private Long FCarId;

    public Long getId() {
        return FId;
    }
}
