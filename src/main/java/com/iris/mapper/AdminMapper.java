package com.iris.mapper;

import com.iris.common.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AdminMapper
 *
 * @author: zhangteng
 * @time: 13-12-5 下午3:07
 */
@Repository
public interface AdminMapper {

    /**
     * 添加一个管理员
     *
     * @param admin
     * @return
     */
    public Integer insertAdmin(@Param("admin") Admin admin);

    /**
     * 检查用户名是否存在
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Integer checkAdminName(@Param("name") String name);

    /**
     * 根据id查询管理员
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Admin queryAdminById(@Param("id") Integer id);

    /**
     * 查询全部管理员
     *
     * @return
     * @throws Exception
     */
    public List<Admin> queryAllAdmin();


    /**
     * 更新管理员信息
     *
     * @param admin
     * @return
     * @throws Exception
     */
    public Admin updateAdmin(@Param("admin") Admin admin);

    /**
     * 管理登陆
     *
     * @param admin
     * @return
     * @throws Exception
     */
    public Admin checkAdminLogin(@Param("admin") Admin admin) throws Exception;
}
