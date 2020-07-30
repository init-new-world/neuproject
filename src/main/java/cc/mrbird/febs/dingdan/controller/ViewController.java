package cc.mrbird.febs.dingdan.controller;

import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.dingdan.entity.Dingdan;
import cc.mrbird.febs.dingdan.service.IDingdan;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotBlank;

/**
 * @author MrBird
 */
@Controller("dingdanView")
@RequestMapping(FebsConstant.VIEW_PREFIX)
@RequiredArgsConstructor
public class ViewController {

    private final IDingdan dingdanService;

    @GetMapping("dingdan")
    @RequiresPermissions("dingdan:view")
    public String online() {
        return FebsUtil.view("dingdan/dingdan");
    }

    @GetMapping("dingdan/add")
    @RequiresPermissions("dingdan:add")
    public String dingdanAdd() {
        return FebsUtil.view("dingdan/dingdanAdd");
    }

    @GetMapping("dingdan/update/{dingdanId}")
    @RequiresPermissions("dingdan:update")
    public String dingdanUpdate(@NotBlank(message = "{required}") @PathVariable Long dingdanId, Model model) {
        Dingdan dingdan = dingdanService.findDingdans(dingdanId);
        model.addAttribute("dingdan", dingdan);
        return FebsUtil.view("dingdan/dingdanUpdate");
    }


}
