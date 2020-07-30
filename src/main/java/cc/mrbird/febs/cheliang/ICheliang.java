package cc.mrbird.febs.cheliang;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.job.entity.Job;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author MrBird
 */
public interface ICheliang extends IService<Job> {

    /**
     * 获取定时任务
     *
     * @param jobId 任务id
     * @return 定时任务
     */
    Job findCheliang(Long jobId);

    /**
     * 获取定时任务分页数据
     *
     * @param request request
     * @param job     job
     * @return 定时任务分页数据
     */
    IPage<Job> findCheliangs(QueryRequest request, Job job);

    /**
     * 创建定时任务
     *
     * @param job job
     */
    void createCheliang(Job job);

}
