package com.zhangxu.ssmp.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangxu.ssmp.mapper.BookMapper;
import com.zhangxu.ssmp.pojo.Book;
import com.zhangxu.ssmp.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl extends ServiceImpl<BookMapper , Book> implements IBookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean insert(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public boolean delete(Integer bookId) {
        return bookMapper.deleteById(bookId) > 0;
    }

    @Override
    public boolean modify(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public Book getById(Integer bookId) {
        return bookMapper.selectById(bookId);
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage , pageSize);
        return bookMapper.selectPage(page , null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()) , Book::getType , book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()) , Book::getName , book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()) , Book::getDescription , book.getDescription());
        IPage<Book> page = new Page<>(currentPage , pageSize);
        return bookMapper.selectPage(page , lqw);
    }
}
