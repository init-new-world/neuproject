package cc.mrbird.febs.cheliang.mapper;

import cc.mrbird.febs.cheliang.entity.Cheliang;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheliangMapper extends BaseMapper<Cheliang> {

    /**
     * 通过车架号来找车
     *
     * @param FStructNum 用户名
     * @return 车辆
     */
    Cheliang findByNum(String FStructNum);

    /**
     * 查找用户详细信息
     *
     * @param page 分页对象
     * @param che 用户对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<Cheliang> findCheliangDetailPage(Page<T> page, @Param("cheliang") Cheliang che);

    long countCheliangDetail(@Param("cheliang") Cheliang che);

    /**
     * 查找车辆详细信息
     *
     * @param che 用户对象，用于传递查询条件
     * @return List<Cheliang>
     */
    List<Cheliang> findCheliangDetail(@Param("cheliang") Cheliang che);

}