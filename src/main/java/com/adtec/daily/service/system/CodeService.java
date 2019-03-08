package com.adtec.daily.service.system;

import com.adtec.daily.bean.system.Code;
import com.adtec.daily.bean.system.CodeExample;

import java.util.List;

/**
 * @version V1.0
 * @Description: code接口类
 * @author: 胡浪
 * @date: 2018/8/28
 * @Copyright:
 */
public interface CodeService {

    /**
     * 新增
     */
    void saveCode(Code code) throws Exception;

    /**
     * 删除
     */
    void deleteCode(Code code) throws Exception;

    /**
     * 更新
     */
    void updateCode(Code code, CodeExample example) throws Exception;

    /**
     * 查询列表
     */
    List<Code> queryCodeList(CodeExample example) throws Exception;

}
