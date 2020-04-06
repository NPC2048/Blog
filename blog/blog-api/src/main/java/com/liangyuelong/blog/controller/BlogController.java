package com.liangyuelong.blog.controller;

import com.liangyuelong.blog.common.Result;
import com.liangyuelong.blog.common.form.BlogPageForm;
import com.liangyuelong.blog.service.BlogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 博客 controller
 *
 * @author yuelong.liang
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    @RequestMapping("/list")
    public Result list() {
        return Result.success(blogService.list());
    }

    @RequestMapping("/test")
    public Result ex(@Valid BlogPageForm form) {
        return Result.success(blogService.list());
    }

}
