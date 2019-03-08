package com.adtec.daily.dao.project;

import com.adtec.daily.bean.project.DepartmentCompany;
import com.adtec.daily.bean.project.DepartmentCompanyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentCompanyMapper {
    int countByExample(DepartmentCompanyExample example);

    int deleteByExample(DepartmentCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DepartmentCompany record);

    int insertSelective(DepartmentCompany record);

    List<DepartmentCompany> selectByExample(DepartmentCompanyExample example);

    DepartmentCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DepartmentCompany record, @Param("example") DepartmentCompanyExample example);

    int updateByExample(@Param("record") DepartmentCompany record, @Param("example") DepartmentCompanyExample example);

    int updateByPrimaryKeySelective(DepartmentCompany record);

    int updateByPrimaryKey(DepartmentCompany record);
}