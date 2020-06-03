package cn.liuawen.service.impl;

import cn.liuawen.PindongdongApplicationTests;
import cn.liuawen.enums.ResponseEnum;
import cn.liuawen.enums.RoleEnum;
import cn.liuawen.pojo.User;
import cn.liuawen.service.IUserService;
import cn.liuawen.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 廖师兄
 */
@Transactional
public class UserServiceImplTest extends PindongdongApplicationTests {

	public static final String USERNAME = "jack";

	public static final String PASSWORD = "123456";

	@Autowired
	private IUserService userService;

	@Before
	public void register() {
		User user = new User(USERNAME, PASSWORD, "jack@qq.com", RoleEnum.CUSTOMER.getCode());
		userService.register(user);
	}

	@Test
	public void login() {
		ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}
}