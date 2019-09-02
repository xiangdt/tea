package com.newer.service;

import com.newer.domain.Tea;
import com.newer.mapper.TeaMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TeaSerice {

    private TeaMapper teaMapper;
    private SqlSession sqlSession;

    private void into(){
        sqlSession= SqlSessionUtil.getSqlSession();
        teaMapper=sqlSession.getMapper(TeaMapper.class);
    }

    public int addTea(Tea tea){
        into();
        int rows=teaMapper.addTea(tea);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return rows;
    }
}
