package com.iris.service.impl;

import com.iris.common.entity.Admin;
import com.iris.common.enums.StatusEnum;
import com.iris.common.log.Log;
import com.iris.common.log.LogClerk;
import com.iris.common.utils.CommonUtil;
import com.iris.mapper.AdminMapper;
import com.iris.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * AdminServiceImpl
 *
 * @author: zhangteng
 * @time: 13-12-5 下午3:19
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class},propagation = Propagation.REQUIRED)
    public Admin insertAdmin(Admin admin) throws Exception{
        try {
            if(checkAdminName(admin.getName())) {
                admin.setStatus(StatusEnum.Show.getId());
                admin.setCreateTime(new Date());
                Integer id = adminMapper.insertAdmin(admin);
                admin.setId(id);
                return admin;
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
        return null;
    }

    @Override
    public boolean checkAdminName(String name) throws Exception {
        try {
            if(adminMapper.checkAdminName(name) > 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean checkPwd(Integer id, String pwd) throws Exception {
        try {
            Admin admin = queryAdminById(id);
            if(admin.getPassword().equals(CommonUtil.md5(pwd))) {
                return true;
            }
            return false;
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Admin queryAdminById(Integer id) throws Exception {
        try {
            return adminMapper.queryAdminById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Admin> queryAllAdmin() throws Exception {
        try {
            List<Admin> adminList = adminMapper.queryAllAdmin();
            System.out.println(adminList);
            return adminList;
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateAdmin(Admin admin) throws Exception {
        try {
            adminMapper.updateAdmin(admin);
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class},propagation = Propagation.REQUIRED)
    public void deleteAdminById(Integer id) throws Exception {
        try {
            Admin admin = queryAdminById(id);
            admin.setStatus(StatusEnum.Hide.getId());
            updateAdmin(admin);
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Admin checkAdminLogin(Admin admin) throws Exception {
        try {
            admin = adminMapper.checkAdminLogin(admin);
            return admin;
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class},propagation = Propagation.REQUIRED)
    public void modifyPwd(Integer id, String newPwd) throws Exception {
        try {
            Admin admin = queryAdminById(id);
            admin.setPassword(CommonUtil.md5(newPwd));
            updateAdmin(admin);
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }
}
