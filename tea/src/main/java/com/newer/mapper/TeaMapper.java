package com.newer.mapper;

import com.newer.domain.Tea;
import org.apache.ibatis.annotations.Insert;

public interface TeaMapper {
    @Insert("insert into tea(detail,num,price ) values (#{detail},#{num},#{price})")
    int addTea(Tea tea);
}
