package cc.mrbird.febs.dingdan.service;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.dingdan.entity.Dingdan;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;

/**
 * @author MrBird
 */
public interface IDingdan extends IService<Dingdan> {

    /**
     * 获取车辆分页数据
     *
     * @param request request
     * @param che     车辆
     * @return 车辆分页数据
     */
    IPage<Dingdan> findDingdans(QueryRequest request, Dingdan che);

    public Dingdan findDingdans(Long FId);

    public void createDingdan(Dingdan user, Long FId, Date FDate, Long FSalesmanId, Long FClientId, Integer FPrice, Integer FStatus, Long FCarId);

}
