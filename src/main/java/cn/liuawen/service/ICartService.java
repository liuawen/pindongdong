package cn.liuawen.service;

import cn.liuawen.form.CartAddForm;
import cn.liuawen.form.CartUpdateForm;
import cn.liuawen.pojo.Cart;
import cn.liuawen.vo.CartVo;
import cn.liuawen.vo.ResponseVo;

import java.util.List;

/**
 * Created by 廖师兄
 */
public interface ICartService {

	ResponseVo<CartVo> add(Integer uid, CartAddForm form);

	ResponseVo<CartVo> list(Integer uid);

	ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm form);

	ResponseVo<CartVo> delete(Integer uid, Integer productId);

	ResponseVo<CartVo> selectAll(Integer uid);

	ResponseVo<CartVo> unSelectAll(Integer uid);

	ResponseVo<Integer> sum(Integer uid);

	List<Cart> listForCart(Integer uid);
}
