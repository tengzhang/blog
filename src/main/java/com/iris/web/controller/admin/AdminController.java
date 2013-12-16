package com.iris.web.controller.admin;

import com.iris.common.entity.Admin;
import com.iris.common.utils.CommonUtil;
import com.iris.common.utils.WebConstants;
import com.iris.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * AdminController
 *
 * @author: zhangteng
 * @time: 13-12-6 上午9:54
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController extends AbstractController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "admin/index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin() {
        return "admin/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Admin admin,
                        Model model,
                        HttpServletRequest request) {
        try {
            admin.setPassword(CommonUtil.md5(admin.getPassword()));
            admin = adminService.checkAdminLogin(admin);
            if(admin != null) {
                request.getSession().setAttribute(WebConstants.SESSIONUID, admin.getId());
                model.addAttribute("adminId", admin.getId());
                return "admin/index";
            } else {
                model.addAttribute("msg", "用户名或密码错误");
                return "admin/login";
            }
        } catch (Exception e) {
            model.addAttribute("errMsg", e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        try {
            request.getSession().setAttribute(WebConstants.SESSIONUID, null);
            return "redirect:/admin/login";
        } catch (Exception e) {
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listAdmin(Model model) {
        try {
            List<Admin> adminList = adminService.queryAllAdmin();
            model.addAttribute("adminList", adminList);
            return "admin/list";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert(HttpServletRequest request, Model model) {
        try {
            Integer uid = (Integer)request.getSession().getAttribute(WebConstants.SESSIONUID);
            Admin admin = adminService.queryAdminById(uid);
            if(admin.getName().equals("iris")) {
                return "admin/insert";
            } else {
                model.addAttribute("errorMsg", "你没有添加权限！");
                return WebConstants.sysErrorCode;
            }
        } catch(Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Admin admin) {
        try {
            admin.setPassword(CommonUtil.md5(admin.getPassword()));
            adminService.insertAdmin(admin);
            return "redirect:/admin/list";
        } catch (Exception e) {
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable Integer id,
                           HttpServletRequest request, Model model) {
        try {
            Integer uid = (Integer)request.getSession().getAttribute(WebConstants.SESSIONUID);
            Admin admin = adminService.queryAdminById(uid);
            if(admin.getId()==id || admin.getName().equals("iris")) {
                model.addAttribute("id", id);
                return "admin/update";
            } else {
                model.addAttribute("errorMsg", "你没有添加权限！");
                return WebConstants.sysErrorCode;
            }
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Integer id,
                         String oldPwd,
                         String newPwd,
                         Model model) {
        try {
            if(adminService.checkPwd(id, oldPwd)) {
                adminService.modifyPwd(id, newPwd);
                return "redirect:/admin/list";
            } else {
                model.addAttribute("id",id);
                model.addAttribute("errorMsg", "旧密码错误！");
                return "admin/update";
            }
        } catch (Exception e) {
            model.addAttribute(e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }
}
