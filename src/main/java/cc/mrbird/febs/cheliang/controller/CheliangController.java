package cc.mrbird.febs.cheliang.controller;

import cc.mrbird.febs.cheliang.entity.Cheliang;
import cc.mrbird.febs.cheliang.service.ICheliang;
import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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

    @GetMapping("list")
    public FebsResponse cheList(QueryRequest request, Cheliang che) {
        Map<String, Object> dataTable = getDataTable(this.che.findCheliangs(che,request));
        return new FebsResponse().success().data(dataTable);
    }

    @PostMapping("create")
    @ControllerEndpoint(operation = "新增汽车车辆", exceptionMessage = "新增车辆失败")
    public FebsResponse addChe(@Valid Cheliang user) {
        this.che.createCheliang(user,user.getFStructNumber(),user.getFCareCounts(),user.getFColor(),user.getFDrive(), user.getFInsure(),
                user.getFMinPrice(),user.getFOther(),user.getFPart(),user.getFTurbo(),
                user.getFType(), user.getFWeight(),user.getFVolume(),user.getFDate());
        return new FebsResponse().success();
    }
}
