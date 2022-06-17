package com.zhangxu.ssmp.serviceTest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhangxu.ssmp.pojo.Book;
import com.zhangxu.ssmp.service.IBookService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SpringBootTest
public class testBookService {
    @Autowired
    IBookService bookService;

    @Test
    public void saveTest(){
        Book book = new Book();
        book.setName("测试数据");
        book.setType("测试数据");
        book.setDescription("测试数据");
        System.out.println(bookService.insert(book));
    }

    @Test
    public void deleteTest(){
        System.out.println(bookService.delete(14));
    }

    @Test
    public void modifyTest(){
        Book book = new Book();
        book.setId(13);
        book.setName("测试数据");
        book.setType("测试数据");
        book.setDescription("测试数据");
        System.out.println(bookService.modify(book));
    }

    @Test
    public void getByIdTest(){
        System.out.println(bookService.getById(13));
    }

    @Test
    public void getAllTest(){
        List<Book> allBooks = bookService.getAll();
        System.out.println(allBooks);
    }

    @Test
    public void getPageTest(){
        IPage<Book> page = bookService.getPage(1, 5);
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
    }

}
