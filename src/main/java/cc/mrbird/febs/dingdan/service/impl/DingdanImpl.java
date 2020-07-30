package cc.mrbird.febs.dingdan.service.impl;

import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.dingdan.entity.Dingdan;
import cc.mrbird.febs.dingdan.mapper.DingdanMapper;
import cc.mrbird.febs.dingdan.service.IDingdan;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Init_new_world
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DingdanImpl extends ServiceImpl<DingdanMapper, Dingdan> implements IDingdan {

    public Dingdan findByNum(String FStructNum) {
        return this.baseMapper.findByNum(FStructNum);
    }

    @Override
    public IPage<Dingdan> findDingdans(QueryRequest request, Dingdan dingdan) {
        Page<Dingdan> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countDingdanDetail(dingdan));
        SortUtil.handlePageSort(request, page, "FId", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findDingdanDetailPage(page,dingdan);
    }

    @Override
    public Dingdan findDingdans(Long FId) {
        Dingdan param = new Dingdan();
        param.setFId(FId);
        List<Dingdan> users = this.baseMapper.findDingdanDetail(param);
        return CollectionUtils.isNotEmpty(users) ? users.get(0) : null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createDingdan(Dingdan user, Long FId,Date FDate,Long FSalesmanId,Long FClientId,Integer FPrice,Integer FStatus,Long FCarId) {
        user.setFId(FId);
        user.setFDate(new Date());
        user.setFSalesmanId(FSalesmanId);
        user.setFClientId(FClientId);
        user.setFPrice(FPrice);
        user.setFStatus(FStatus);
        user.setFCarId(FCarId);
        save(user);
    }
}
