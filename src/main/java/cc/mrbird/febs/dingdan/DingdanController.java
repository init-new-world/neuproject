package cc.mrbird.febs.dingdan;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.Map;

/**
 * @author MrBird
 */
@Slf4j
@Validated
@RestController
@RequestMapping("dingdan")
@RequiredArgsConstructor
public class DingdanController extends BaseController {

    private final IDingdan dingdan;

    @GetMapping
    @RequiresPermissions("dingdan:view")
    public FebsResponse jobList(QueryRequest request, Dingdan dingdan) {
        Map<String, Object> dataTable = getDataTable(this.dingdan.findDingdans(request, dingdan));
        return new FebsResponse().success().data(dataTable);
    }

    @PostMapping
    @RequiresPermissions("dingdan:add")
    @ControllerEndpoint(operation = "新增订单", exceptionMessage = "新增订单失败")
    public FebsResponse addChe(@Valid Dingdan dingdan, Long FId, Date FDate, Long FSalesmanId, Long FClientId, Integer FPrice, Integer FStatus, Long FCarId) {
        this.dingdan.createDingdan(dingdan,FId,FDate,FSalesmanId,FClientId,FPrice,FStatus,FCarId);
        return new FebsResponse().success();
    }
}
