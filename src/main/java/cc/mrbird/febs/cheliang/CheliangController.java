package cc.mrbird.febs.cheliang;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.job.entity.Job;
import cc.mrbird.febs.job.service.IJobService;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.quartz.CronExpression;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * @author MrBird
 */
@Slf4j
@Validated
@RestController
@RequestMapping("cheliang")
@RequiredArgsConstructor
public class CheliangController extends BaseController {

    private final ICheliang che;

    @GetMapping
    @RequiresPermissions("cheliang:view")
    public FebsResponse jobList(QueryRequest request, Cheliang che) {
        Map<String, Object> dataTable = getDataTable(this.che.findCheliangs(request, che));
        return new FebsResponse().success().data(dataTable);
    }

    @PostMapping
    @RequiresPermissions("cheliang:add")
    @ControllerEndpoint(operation = "新增汽车车辆", exceptionMessage = "新增车辆失败")
    public FebsResponse addChe(@Valid Cheliang che) {
        this.che.createCheliang(che,FStructNumber);
        return new FebsResponse().success();
    }
}
