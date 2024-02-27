package com.prp.business.model.dao;

import com.prp.business.model.vo.BusinessVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BusinessDao {
    void insert(BusinessVo business) throws DataAccessException;
}
