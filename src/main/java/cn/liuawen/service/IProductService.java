package cn.liuawen.service;

import com.github.pagehelper.PageInfo;
import cn.liuawen.vo.ProductDetailVo;
import cn.liuawen.vo.ResponseVo;

/**
 * Created by 廖师兄
 */
public interface IProductService {

	ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

	ResponseVo<ProductDetailVo> detail(Integer productId);
}
