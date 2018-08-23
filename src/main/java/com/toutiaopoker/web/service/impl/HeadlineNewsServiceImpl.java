package com.toutiaopoker.web.service.impl;

import com.mysql.jdbc.StringUtils;
import com.toutiaopoker.web.dao.HeadlineNewsMapper;
import com.toutiaopoker.web.entity.NewsListItem;
import com.toutiaopoker.web.model.HeadlineNews;
import com.toutiaopoker.web.service.HeadlineNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Service
public class HeadlineNewsServiceImpl implements HeadlineNewsService {

    @Autowired
    private HeadlineNewsMapper headlineNewsMapper;

    @Override
    public Map<String, Object> queryNewsByPage(String typeId,
                                               int pageNum,
                                               int pageSize) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        if( StringUtils.isNullOrEmpty( typeId ) ) {
            paramMap.put( "typeId", typeId );
        }

        List<HeadlineNews> originDatalist = headlineNewsMapper.queryNewsByPage( paramMap );
        List<NewsListItem> list = new ArrayList<>();
        for( HeadlineNews hn : originDatalist )
            list.add( NewsListItem.genItemFromHeadlineNews( hn ) );

        int total;
        total = headlineNewsMapper.countNewsByCondition( paramMap );
        resultMap.put( "hasMore", ( pageNum - 1 ) * pageSize + list.size() < total );
        resultMap.put( "data", list );
        return resultMap;
    }

    @Override
    public HeadlineNews queryNewsById(String newsId) {

        return headlineNewsMapper.selectByPrimaryKey( newsId );
    }

}
