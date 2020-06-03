package cn.liuawen.controller;

import cn.liuawen.service.ICategoryService;
import cn.liuawen.vo.CategoryVo;
import cn.liuawen.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 廖师兄
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
