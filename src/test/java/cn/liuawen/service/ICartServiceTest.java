package cn.liuawen.service;

import cn.liuawen.PindongdongApplicationTests;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.liuawen.enums.ResponseEnum;
import cn.liuawen.form.CartAddForm;
import cn.liuawen.form.CartUpdateForm;
import cn.liuawen.vo.CartVo;
import cn.liuawen.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-03
 */
@Slf4j
public class ICartServiceTest extends PindongdongApplicationTests {

	@Autowired
	private ICartService cartService;

	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	private Integer uid = 1;

	private Integer productId = 26;

	@Before
	public void add() {
		log.info("【新增购物车...】");
		CartAddForm form = new CartAddForm();
		form.setProductId(productId);
		form.setSelected(true);
		ResponseVo<CartVo> responseVo = cartService.add(uid, form);
		log.info("list={}", gson.toJson(responseVo));
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void list() {
		ResponseVo<CartVo> responseVo = cartService.list(uid);
		log.info("list={}", gson.toJson(responseVo));
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void update() {
		CartUpdateForm form = new CartUpdateForm();
		form.setQuantity(5);
		form.setSelected(false);
		ResponseVo<CartVo> responseVo = cartService.update(uid, productId, form);
		log.info("result={}", gson.toJson(responseVo));
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@After
	public void delete() {
		log.info("【删除购物车...】");
		ResponseVo<CartVo> responseVo = cartService.delete(uid, productId);
		log.info("result={}", gson.toJson(responseVo));
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void selectAll() {
		ResponseVo<CartVo> responseVo = cartService.selectAll(uid);
		log.info("result={}", gson.toJson(responseVo));
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void unSelectAll() {
		ResponseVo<CartVo> responseVo = cartService.unSelectAll(uid);
		log.info("result={}", gson.toJson(responseVo));
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}

	@Test
	public void sum() {
		ResponseVo<Integer> responseVo = cartService.sum(uid);
		log.info("result={}", gson.toJson(responseVo));
		Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
	}
}