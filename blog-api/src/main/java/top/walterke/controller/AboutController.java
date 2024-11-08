package top.walterke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.walterke.annotation.VisitLogger;
import top.walterke.enums.VisitBehavior;
import top.walterke.model.vo.Result;
import top.walterke.service.AboutService;

/**
 * @Description: 关于我页面
 *  
 * @Date: 2020-08-31
 */
@RestController
@RequestMapping("/api")
public class AboutController {
	@Autowired
	AboutService aboutService;

	/**
	 * 获取关于我页面信息
	 *
	 * @return
	 */
	@VisitLogger(VisitBehavior.ABOUT)
	@GetMapping("/about")
	public Result about() {
		return Result.ok("获取成功", aboutService.getAboutInfo());
	}
}
