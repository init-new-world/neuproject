package cc.mrbird.febs.cheliang.controller;

import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.generator.entity.GeneratorConfig;
import cc.mrbird.febs.generator.service.IGeneratorConfigService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MrBird
 */
@Controller("cheliangViews")
@RequestMapping(FebsConstant.VIEW_PREFIX)
@RequiredArgsConstructor
public class ViewController {

    private final IGeneratorConfigService generatorConfigService;

    /* 车辆管理 */
    @GetMapping("cheliang")
    public String systemVehicle() {
        return FebsUtil.view("cheliang/cheliang");
    }

    /* 新增车辆 */
    @GetMapping("cheliang/create")
    public String systemVehicleCreate() {
        return FebsUtil.view("cheliang/cheliangAdd");
    }

}
