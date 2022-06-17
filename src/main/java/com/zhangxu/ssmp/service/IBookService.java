package com.zhangxu.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangxu.ssmp.pojo.Book;

import java.util.List;

public interface IBookService extends IService<Book> {
    //增加图书
    public boolean insert(Book book);

    //删除图书
    public boolean delete(Integer bookId);

    //修改图书
    public boolean modify(Book book);

    //根据Id查询一条图书记录
    public Book getById(Integer bookId);

    //查询所有图书记录
    public List<Book> getAll();

    //查询分页数据
    public IPage<Book> getPage(int currentPage , int pageSize);

    //按条件查询分页数据
    public IPage<Book> getPage(int currentPage , int pageSize , Book book);

}
