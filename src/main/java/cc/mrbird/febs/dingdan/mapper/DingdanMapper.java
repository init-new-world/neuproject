package cc.mrbird.febs.dingdan.mapper;

import cc.mrbird.febs.dingdan.entity.Dingdan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DingdanMapper extends BaseMapper<Dingdan> {

    /**
     * 通过车架号来找车
     *
     * @param FStructNum 用户名
     * @return 车辆
     */
    Dingdan findByNum(String FStructNum);

    /**
     * 查找用户详细信息
     *
     * @param page 分页对象
     * @param che 用户对象，用于传递查询条件
     * @return Ipage
     */
    <T> IPage<Dingdan> findDingdanDetailPage(Page<T> page, @Param("dingdan") Dingdan che);

    long countDingdanDetail(@Param("dingdan") Dingdan che);

    /**
     * 查找车辆详细信息
     *
     * @param che 用户对象，用于传递查询条件
     * @return List<Dingdan>
     */
    List<Dingdan> findDingdanDetail(@Param("dingdan") Dingdan che);

}