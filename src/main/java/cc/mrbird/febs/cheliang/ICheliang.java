package cc.mrbird.febs.cheliang;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author MrBird
 */
public interface ICheliang extends IService<Cheliang> {

    /**
     * 获取车辆分页数据
     *
     * @param request request
     * @param che     车辆
     * @return 车辆分页数据
     */
    IPage<Cheliang> findCheliangs(QueryRequest request, Cheliang che);

    public Cheliang findCheliangs(String FStructNum);

    public void createCheliang(Cheliang user,String FStructNumber,Integer FCareCounts,String FColor,String FDrive,
                               String FInsure,Integer FMinPrice,String FOther, String FPart,String FTurbo,String FType,
                               Integer FWeight,String FVolume);

}
