package cn.liuawen.controller;

import cn.liuawen.service.ICategoryService;
import cn.liuawen.vo.CategoryVo;
import cn.liuawen.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类目
 * 多级分类
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-03-05
 */
@RestController
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@GetMapping("/categories")
	public ResponseVo<List<CategoryVo>> selectAll() {
		return categoryService.selectAll();
	}
}
