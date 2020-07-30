package cc.mrbird.febs.cheliang;

import cc.mrbird.febs.common.authentication.ShiroRealm;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.utils.Md5Util;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.system.entity.User;
import cc.mrbird.febs.system.entity.UserDataPermission;
import cc.mrbird.febs.system.entity.UserRole;
import cc.mrbird.febs.system.mapper.UserMapper;
import cc.mrbird.febs.system.service.IUserDataPermissionService;
import cc.mrbird.febs.system.service.IUserRoleService;
import cc.mrbird.febs.system.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Init_new_world
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CheliangImpl extends ServiceImpl<CheliangMapper, Cheliang> implements ICheliang {

    public Cheliang findByNum(String FStructNum) {
        return this.baseMapper.findByNum(FStructNum);
    }

    @Override
    public IPage<Cheliang> findCheliangs(QueryRequest request,Cheliang che) {
        Page<Cheliang> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countUserDetail(che));
        SortUtil.handlePageSort(request, page, "FId", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findCheliangDetailPage(page,che);
    }

    @Override
    public Cheliang findCheliangs(String FStructNum) {
        Cheliang param = new Cheliang();
        param.setFStructNumber(FStructNum);
        List<Cheliang> users = this.baseMapper.findCheliangDetail(param);
        return CollectionUtils.isNotEmpty(users) ? users.get(0) : null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createCheliang(Cheliang user,String FStructNumber,Integer FCareCounts,String FColor,String FDrive,
                               String FInsure,Integer FMinPrice,String FOther, String FPart,String FTurbo,String FType,
                               Integer FWeight,String FVolume) {
        user.setFDate(new Date());
        user.setFStructNumber(FStructNumber);
        user.setFCareCounts(FCareCounts);
        user.setFColor(FColor);
        user.setFDrive(FDrive);
        user.setFInsure(FInsure);
        user.setFMinPrice(FMinPrice);
        user.setFOther(FOther);
        user.setFPart(FPart);
        user.setFTurbo(FTurbo);
        user.setFType(FType);
        user.setFWeight(FWeight);
        user.setFVolume(FVolume);
        save(user);
    }
}
