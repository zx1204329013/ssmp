package com.zhangxu.ssmp.mapperTest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangxu.ssmp.mapper.BookMapper;
import com.zhangxu.ssmp.pojo.Book;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class testBookMapper {

    @Autowired
    BookMapper bookMapper;

    @Test
    public void selectAllBooksTest(){
        String name = "spring 5";
        LambdaQueryWrapper<Book> blqw = new LambdaQueryWrapper<>();
        blqw.like(StringUtils.isNotBlank(name), Book::getName , name);
        List<Book> books = bookMapper.selectList(blqw);
        System.out.println(books);
    }

    @Test
    public void selectByIdTest(){
        Book book = bookMapper.selectById(2);
        System.out.println(book);
    }

    @Test
    public void insertBookTest(){
        Book book = new Book();
        book.setName("测试数据");
        book.setType("测试数据");
        book.setDescription("测试数据");
        bookMapper.insert(book);
    }

    @Test
    public void updateBookTest(){
        Book book = new Book();
        book.setId(1);
        book.setName("测试数据");
        book.setType("测试数据");
        book.setDescription("测试数据");
        bookMapper.updateById(book);
    }

    @Test
    public void deleteBookTest(){
        bookMapper.deleteById(13);
    }

    @Test
    public void PageTest(){
        IPage<Book> bookPage = new Page<>(2, 5);
        bookMapper.selectPage(bookPage , null);
    }

}
