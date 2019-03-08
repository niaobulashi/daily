package com.adtec.daily.service.user;

import com.adtec.daily.bean.user.User;
import com.adtec.daily.bean.user.UserExample;
import com.adtec.daily.bean.user.UserProject;

import java.util.List;

/**
 * @version V1.0
 * @Description: 用户信息接口类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright:
 */
public interface UserService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> getAll(String roleType);

    /**
     * 检验邮箱是否可用
     *
     * @param email
     * @return  true：代表当前姓名可用   fasle：不可用
     */
    boolean userCheck(String email);

    /**
     * 用户保存
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 按照用户id查询用户
     *
     * @param id
     * @return
     */
    User getUser(String id, String roleType);

    /**
     * 按照用户姓名查询用户
     *
     * @param userName
     * @return
     */
    List<User> getUserInfoByUserName(String userName);

    /**
     * 用户登录查询
     *
     * @param user
     * @return
     */
    List<User> getLoginUser(User user);

    /**
     * 用户更新
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 通过userId获取用户
     *
     * @param userId
     */
    User getByUserId(String userId);

    /**
     * 用户删除
     *
     * @param id
     */
    void deleteUser(String id);

    /**
     * 批量删除用户
     *
     * @param ids
     */
    void deleteBatch(List<String> ids);

    /**
     * 日报列表查询
     *
     * @param example
     * @return
     */
    List<User> getUserInfoList(UserExample example);

    /**
     * 根据项目id及公司id查询项目下所有用户
     *
     * @param projectId
     * @param companyId
     * @param roleType
     * @return
     */
    List<User> getAllUserByProjectIdAndCompanyId(int projectId, int companyId, String roleType);

    /**
     * 根据用户id删除项目成员
     *
     * @param userId
     */
    void deleteByUserId(String userId,Integer userRoleId);

    /**
     * 添加项目成员
     *
     * @param userProject
     */
    void projectUserSave(UserProject userProject);

    /**
     * 查询公司角色为项目经理，新增项目信息时下拉显示项目经理
     *
     * @param roleId        角色ID
     * @param roleType      角色类型
     * @return
     */
    List<User> queryUserByRoleIdForProjectUser(int roleId, String roleType);
}
