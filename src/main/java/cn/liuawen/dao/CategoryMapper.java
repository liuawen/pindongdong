package cn.liuawen.dao;

import cn.liuawen.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    //加上的  查询所有的 selectALl() 类目  去写mappers的对应的xml了
    List<Category> selectAll();
}