package top.walterke.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.walterke.entity.User;
import top.walterke.model.vo.Result;
import top.walterke.service.UserService;

/**
 * @Description: 账号后台管理
 *  
 * @Date: 2023-01-31
 */
@RestController
@RequestMapping("/api/admin")
public class AccountAdminController {
	@Autowired
	UserService userService;

	/**
	 * 账号密码修改
	 */
	@PostMapping("/account")
	public Result account(@RequestBody User user, @RequestHeader(value = "Authorization", defaultValue = "") String jwt) {
		boolean res = userService.changeAccount(user, jwt);
		return res ? Result.ok("修改成功") : Result.error("修改失败");
	}
}
