package com.zhangxu.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhangxu.ssmp.controller.utils.AxiosResult;
import com.zhangxu.ssmp.pojo.Book;
import com.zhangxu.ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookContoller {
    @Autowired
    IBookService bookService;


    /*
     * API:http://localhost/books
     * method:Post
     */
    @PostMapping
    public AxiosResult insert(@RequestBody Book book) throws IOException {
        return new AxiosResult(bookService.insert(book));
    }

    /*
     * API:http://localhost/books/{bookId}
     * method:Delete
     */
    @DeleteMapping("/{bookId}")
    public AxiosResult delete(@PathVariable Integer bookId) throws IOException {
        return new AxiosResult(bookService.delete(bookId));
    }

    /*
     * API:http://localhost/books
     * method:Put
     */
    @PutMapping
    public AxiosResult modify(@RequestBody Book book) throws IOException {
        return new AxiosResult(bookService.modify(book));
    }

    /*
     * API:http://localhost/books/{bookId}
     * method:Get
     */
    @GetMapping("/{bookId}")
    public AxiosResult getById(@PathVariable Integer bookId) throws IOException {
        return new AxiosResult(true, true, bookService.getById(bookId));
    }

    /*
     * API:http://localhost/books
     * method:Get
     */
    @GetMapping
    public AxiosResult getAll() throws IOException {
        return new AxiosResult(true, true, bookService.getAll());
    }

    /*
     * API:http://localhost/books/{currentPage}/{pageSize}
     * method:Get
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public AxiosResult getPage(@PathVariable int currentPage, @PathVariable int pageSize , Book book) throws IOException {
        //修复删除完当前页数据后不跳转显示的bug
        IPage<Book> page = bookService.getPage(currentPage, pageSize , book);
        if (currentPage > page.getPages()){
            page = bookService.getPage(1, pageSize , book);
        }
        return new AxiosResult(true, true, page);
    }

}
