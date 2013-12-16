package com.iris.service;

import com.iris.common.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * AdminService
 *
 * @author: zhangteng
 * @time: 13-12-5 下午3:18
 */
public interface AdminService {

    /**
     * 添加一个管理员
     *
     * @param admin
     * @return
     */
    public Admin insertAdmin(Admin admin) throws Exception;

    /**
     * 检查用户名是否存在
     *
     * @param name
     * @return
     * @throws Exception
     */
    public boolean checkAdminName(String name) throws Exception;

    /**
     * 根据用户名判断密码是否正确
     *
     * @param id
     * @param pwd
     * @return
     * @throws Exception
     */
    public boolean checkPwd(Integer id, String pwd) throws Exception;

    /**
     * 根据id查询管理员
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Admin queryAdminById(Integer id) throws Exception;

    /**
     * 查询全部管理员
     *
     * @return
     * @throws Exception
     */
    public List<Admin> queryAllAdmin() throws Exception;

    /**
     * 更新管理员信息
     *
     * @param admin
     * @return
     * @throws Exception
     */
    public void updateAdmin(Admin admin) throws Exception;

    /**
     * 根据id删除管理员
     *
     * @param id
     * @throws Exception
     */
    public void deleteAdminById(Integer id) throws Exception;

    /**
     * 管理登陆
     *
     * @param admin
     * @return
     * @throws Exception
     */
    public Admin checkAdminLogin(Admin admin) throws Exception;

    /**
     * 修改密码
     *
     * @param id
     * @param nwePwd
     * @throws Exception
     */
    public void modifyPwd(Integer id, String newPwd) throws Exception;
}
