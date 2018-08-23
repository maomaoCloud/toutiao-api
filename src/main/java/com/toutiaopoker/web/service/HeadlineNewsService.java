package com.toutiaopoker.web.service;


import com.toutiaopoker.web.model.HeadlineNews;

import java.util.Map;

public interface HeadlineNewsService {

    public Map<String, Object> queryNewsByPage(String typeId, int pageNum, int pageSize);

    public HeadlineNews queryNewsById(String newsId);


}