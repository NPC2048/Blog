package com.liangyuelong.blog.common.form;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liangyuelong.blog.entity.Blog;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 博客分页查询表单
 *
 * @author yuelong.liang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BlogPageForm extends Page<Blog> {

    @NotNull(message = "id 不能为空")
    private Long id;

}
