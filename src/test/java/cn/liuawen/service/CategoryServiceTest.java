package cn.liuawen.service;


import cn.liuawen.PindongdongApplicationTests;
import cn.liuawen.enums.ResponseEnum;
import cn.liuawen.vo.CategoryVo;
import cn.liuawen.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-03-04
 */

@Slf4j
public class CategoryServiceTest extends PindongdongApplicationTests {

	@Autowired
	private ICategoryService categoryService;

	@Test
	public void selectAll() {
		ResponseVo<List<CategoryVo>> responseVo = categoryService.selectAll();
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void findSubCategoryId() {
		Set<Integer> set = new HashSet<>();
		categoryService.findSubCategoryId(100001, set);
		log.info("set={}", set);
	}
}