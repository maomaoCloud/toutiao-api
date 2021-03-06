package com.toutiaopoker.web.controller;

import com.github.pagehelper.PageHelper;
import com.toutiaopoker.web.common.JsonResult;
import com.toutiaopoker.web.model.HeadlineNews;
import com.toutiaopoker.web.service.HeadlineNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("news")
@Scope("prototype")
public class HeadlineNewsController {

    @Autowired
    private HeadlineNewsService headlineNewsService;

    @RequestMapping("{typeId}/{pageNum}/{pageSize}")
    public JsonResult newsList(@PathVariable(name = "typeId") String typeId,
                               @PathVariable(name = "pageNum") Integer pageNum,
                               @PathVariable(name = "pageSize") Integer pageSize) {
        PageHelper.startPage( pageNum, pageSize );
        JsonResult jsonResult;
        Map<String, Object> resultMap;
        try {
            resultMap = headlineNewsService.queryNewsByPage( typeId, pageNum, pageSize );
            jsonResult = JsonResult.SUCCESS( "success", resultMap );
        } catch (Exception e) {
            jsonResult = JsonResult.FAILED( "头条新闻列表接口异常" );
            e.printStackTrace();
        }
        return jsonResult;
    }

    @RequestMapping("newsById/{newsId}")
    public HeadlineNews newsById(@PathVariable(name = "newsId") String newsId) {
        return headlineNewsService.queryNewsById( newsId );
    }

}
