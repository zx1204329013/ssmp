package com.zhangxu.ssmp.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Book {
    @TableId
    private Integer Id;
    private String Type;
    private String Name;
    private String Description;
}
