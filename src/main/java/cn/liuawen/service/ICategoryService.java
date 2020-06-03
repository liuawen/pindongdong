package cn.liuawen.service;

import cn.liuawen.vo.CategoryVo;
import cn.liuawen.vo.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-03-05
 */
public interface ICategoryService {

//	ResponseVo<List<CategoryVo>> selectAll();
	ResponseVo<List<CategoryVo>> selectAll();

	void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
