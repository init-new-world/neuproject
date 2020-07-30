package cc.mrbird.febs.cheliang;

import cc.mrbird.febs.common.annotation.Desensitization;
import cc.mrbird.febs.common.annotation.IsMobile;
import cc.mrbird.febs.common.converter.TimeConverter;
import cc.mrbird.febs.common.entity.DesensitizationType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author MrBird
 */
@Data
@TableName("t_user")
@Excel("用户信息表")
public class Cheliang implements Serializable {

    private static final long serialVersionUID = -4352868070794165001L;

    /**
     * 可以涡轮
     */
    public static final String STATUS_TURBO_YES = "1";
    /**
     * 不能涡轮
     */
    public static final String STATUS_TURBO_NO = "0";
    /**
     * 买了保险
     */
    public static final String STATUS_INSURE_YES = "1";
    /**
     * 没买保险
     */
    public static final String STATUS_INSURE_NO = "0";
    /**
     * 汽车 ID
     */
    @TableId(value = "f_id", type = IdType.AUTO)
    private Long FId;

    /**
     * 车辆型号
     */
    @TableField("f_type")
    @Size(min = 4, max = 100, message = "{range}")
    @ExcelField(value = "车辆型号")
    private String FType;

    /**
     * 车架号
     */
    @TableField("f_struct_number")
    @Size(min = 4, max = 100, message = "{range}")
    @ExcelField(value = "车架号")
    private String FStructNumber;

    /**
     * 颜色
     */
    @TableField("f_color")
    @Size(max = 20, message = "{noMoreThan}")
    @ExcelField(value = "颜色")
    private String FColor;

    /**
     * 排量
     */
    @TableField("f_volume")
    @Size(max = 20, message = "{noMoreThan}")
    @ExcelField(value = "排量")
    private String FVolume;

    /**
     * 自重
     */
    @TableField("f_weight")
    @Size(max = 8, message = "{noMoreThan}")
    @ExcelField(value = "自重")
    private Integer FWeight;

    /**
     * 是否涡轮增压
     */
    @TableField("f_turbo")
    @NotBlank(message = "{required}")
    @ExcelField(value = "是否涡轮增压", writeConverterExp = "0=没有,1=有")
    private String FTurbo;

    /**
     * 生产日期
     */
    @TableField("f_date")
    @ExcelField(value = "创建时间", writeConverter = TimeConverter.class)
    private Date FDate;

    /**
     * 是否购买保险
     */
    @TableField("f_insure")
    @NotBlank(message = "{required}")
    @ExcelField(value = "是否购买保险", writeConverterExp = "0=没买,1=买了")
    private String FInsure;

    /**
     * 颜色
     */
    @TableField("f_drive")
    @Size(max = 20, message = "{noMoreThan}")
    @ExcelField(value = "驱动类型")
    private String FDrive;

    /**
     * 最低价格
     */
    @TableField("f_min_price")
    @Size(max = 9, message = "{noMoreThan}")
    @ExcelField(value = "最低价格")
    private Integer FMinPrice;


    /**
     * 汽车配件
     */
    @TableField("f_part")
    @Size(max = 100, message = "{noMoreThan}")
    @ExcelField(value = "汽车配件")
    private String FPart;

    /**
     * 其他配件
     */
    @TableField("f_other")
    @Size(max = 100, message = "{noMoreThan}")
    @ExcelField(value = "汽车配件")
    private String FOther;

    /**
     * 保养次数
     */
    @TableField("f_care_counts")
    @Size(max = 5, message = "{noMoreThan}")
    @ExcelField(value = "保养次数")
    private Integer FCareCounts;

    public Long getId() {
        return FId;
    }
}
