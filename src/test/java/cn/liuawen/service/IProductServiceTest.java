package cn.liuawen.service;

import cn.liuawen.PindongdongApplicationTests;
import com.github.pagehelper.PageInfo;
import cn.liuawen.enums.ResponseEnum;
import cn.liuawen.vo.ProductDetailVo;
import cn.liuawen.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-03
 */
public class IProductServiceTest extends PindongdongApplicationTests {

	@Autowired
	private IProductService productService;

	@Test
	public void list() {
		ResponseVo<PageInfo> responseVo = productService.list(null, 2, 3);
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void detail() {
		ResponseVo<ProductDetailVo> responseVo = productService.detail(26);
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}
}