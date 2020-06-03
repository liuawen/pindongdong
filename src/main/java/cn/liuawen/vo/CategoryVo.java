package cn.liuawen.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-03-05
 */
@Data
public class CategoryVo {

	private Integer id;

	private Integer parentId;

	private String name;

	private Integer sortOrder;

//	private List<CategoryVo> subCategories;

	private List<CategoryVo> subCategories;
}

