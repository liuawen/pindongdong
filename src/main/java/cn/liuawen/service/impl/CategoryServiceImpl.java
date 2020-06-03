package cn.liuawen.service.impl;

import cn.liuawen.dao.CategoryMapper;
import cn.liuawen.pojo.Category;
import cn.liuawen.service.ICategoryService;
import cn.liuawen.vo.CategoryVo;
import cn.liuawen.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static cn.liuawen.consts.MallConst.ROOT_PARENT_ID;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-03-03
 * 怎么查询呢？
 * 类目表  应该不是很多  1000条  5000条？ 一次查询出来 拿到数据进行操作
 *
 * 先查出一级目录 -》查其子目录 直到查到的是null
 * 查出目录-》 查父目录, 一直查到
 *
 * 类目表  优先级  数字大 优先级高
 *
 * 这么多循环 遍历  在内存里执行
 * 浏览器可以看到  NetWork  All  耗时的时间的大小  10ms 没有做缓存
 * 做什么耗时呢  http > 磁盘 > 内存
 * mysql(内网+磁盘)
 *
 * 远远大于
 * 耗时
 * 循环 Http网络请求
 * SQL 磁盘+内网 也非常耗时
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 耗时：http(请求微信api) > 磁盘 > 内存
     * mysql(内网+磁盘)
     *
     * @return
     */
    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {
//		List<CategoryVo> categoryVoList = new ArrayList<>();

        List<Category> categories = categoryMapper.selectAll();

        //ROOT_PARENT_ID   0
        //查出parent_id=0
//		for (Category category : categories) {
//			if (category.getParentId().equals(ROOT_PARENT_ID)) {
//				//一级目录
//				CategoryVo categoryVo = new CategoryVo();
//				//拷贝   第一个参数 原
//				BeanUtils.copyProperties(category, categoryVo);
//				categoryVoList.add(categoryVo);
//			}
//		}
		//e category
        //lambda + stream  e ->    .
		//collect  直接返回
        List<CategoryVo> categoryVoList = categories.stream()
                .filter(e -> e.getParentId().equals(ROOT_PARENT_ID))
                .map(this::category2CategoryVo)
                .sorted(Comparator.comparing(CategoryVo::getSortOrder).reversed())
                .collect(Collectors.toList());

         findSubCategory(categoryVoList, categories);

        return ResponseVo.success(categoryVoList);
    }

    @Override
    public void findSubCategoryId(Integer id, Set<Integer> resultSet) {
        List<Category> categories = categoryMapper.selectAll();
        findSubCategoryId(id, resultSet, categories);
    }

    private void findSubCategoryId(Integer id, Set<Integer> resultSet, List<Category> categories) {
        for (Category category : categories) {
            if (category.getParentId().equals(id)) {
                resultSet.add(category.getId());
                findSubCategoryId(category.getId(), resultSet, categories);
            }
        }
    }


    private void findSubCategory(List<CategoryVo> categoryVoList, List<Category> categories) {
       	//categoryVoList 一级目录
        for (CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subCategoryVoList = new ArrayList<>();

            for (Category category : categories) {
                //如果查到内容，设置subCategory, 继续往下查
                if (categoryVo.getId().equals(category.getParentId())) {
                    CategoryVo subCategoryVo = category2CategoryVo(category);
                    subCategoryVoList.add(subCategoryVo);
                }
				//排序 List    小到大默认的  我要反转 reversed
                subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());

                //目录category   subCategoryVoList 子目录存储
				//就存储进去 setSubCategories
                categoryVo.setSubCategories(subCategoryVoList);
				//如果subCategoryVoList为null的话 就存储空  挪一个 下一波继续
                findSubCategory(subCategoryVoList, categories);
            }
        }
    }
	// category 转换 categoryVo
    private CategoryVo category2CategoryVo(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }
}
