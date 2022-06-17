package com.zhangxu.ssmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangxu.ssmp.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
