package com.iris.web.controller.admin;

import com.iris.common.entity.Archive;
import com.iris.common.utils.Pagination;
import com.iris.common.utils.WebConstants;
import com.iris.web.spring.AbstractController;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ArchiveController
 *
 * @author: zhangteng
 * @time: 13-12-6 下午3:17
 */
@Controller
@RequestMapping("archive")
public class ArchiveController extends AbstractController {

    /*     ----- 后台用到的方法 -----         */
    @RequestMapping(value = "tableList", method = RequestMethod.GET)
    public String toTableList(@RequestParam(required = false) String search,
                              @RequestParam(required = false) Integer pageNo,
                              @RequestParam(required = false) Integer pageSize,
                              Model model) {
        try {
            if(pageNo == null) {
                pageNo = 1;
            }
            if(search == null) {
                search = "";
            }
            if(pageSize != null) {
                this.pageSize = pageSize;
            }
            int dataCount = archiveService.queryCountByCondition(search);
            Pagination page = new Pagination(dataCount, this.pageSize, pageNo);
            List<Archive> archiveList = archiveService.queryByCondition(search, page);
            model.addAttribute("archiveList", archiveList);
            model.addAttribute("page", page);
            model.addAttribute("search", search);
            return "archive/archiveTableList";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public String toInsert() {
        return "archive/insert";
    }
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Archive archive,
                         HttpServletRequest request) {
        try {
            Integer adminId = (Integer)request.getSession().getAttribute(WebConstants.SESSIONUID);
            archive.setAdminId(adminId);
            archiveService.insertArchive(archive);
            return "redirect:/archive/tableList";
        } catch (Exception e) {
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable Integer id,
                           Model model) {
        try {
            Archive archive = archiveService.queryArchiveById(id);
            model.addAttribute("archive", archive);
            return "archive/update";
        } catch (Exception e) {
            return WebConstants.sysErrorCode;
        }
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Archive archive) {
        try {
            archiveService.updateArchive(archive);
            return "archive/archiveTableList";
        } catch (Exception e) {
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id) {
        try {
            archiveService.deleteArchiveById(id);
            return "redirect:/archive/tableList";
        } catch (Exception e) {
            return WebConstants.sysErrorCode;
        }
    }
    /*     ----- 前台用到的方法 -----         */

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toArchiveList(@RequestParam(required = false) String search,
                                @RequestParam(required = false) Integer pageNo,
                                @RequestParam(required = false) Integer pageSize,
                                Model model) {
        try {
            if(pageNo == null) {
                pageNo = 1;
            }
            if(search == null) {
                search = "";
            }
            if(pageSize != null) {
                this.pageSize = pageSize;
            }
            int dataCount = archiveService.queryCountByCondition(search);
            Pagination page = new Pagination(dataCount, this.pageSize, pageNo);
            List<Archive> archiveList = archiveService.queryByCondition(search, page);
            model.addAttribute("archiveList", archiveList);
            model.addAttribute("page", page);
            model.addAttribute("search", search);
            return "index/archives";
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getArchive(@PathVariable Integer id,
                             Model model) {
        try {
            Archive archive = archiveService.queryArchiveById(id);
            model.addAttribute("archive", archive);
            return "archive/archive";
        } catch (Exception e) {
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "ajax", method = RequestMethod.GET)
    public @ResponseBody JSONObject getArchiveList(@RequestParam(required = false) String search,
                                 @RequestParam Integer pageNo) {
        try {
            int dataCount = archiveService.queryCountByCondition(search);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("dataCount", dataCount);
            if(dataCount > 0) {
                Pagination page = new Pagination(dataCount, 10, pageNo);
                List<Archive> archiveList = archiveService.queryByCondition(null, page);
                JSONArray jsonArray = JSONArray.fromObject(archiveList);
                System.out.println(jsonArray);
                jsonObject.put("list", jsonArray);
            }
            System.out.println(jsonObject);
            return sendJSONObject(jsonObject);
        } catch (Exception e) {
            return sendErrJSONObject();
        }
    }
}
