package com.iris.web.controller.index;

import com.iris.common.entity.Archive;
import com.iris.common.exception.SSException;
import com.iris.common.utils.Pagination;
import com.iris.common.utils.WebConstants;
import com.iris.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * DefaultController
 *
 * @author: zhangteng
 * @time: 13-12-5 下午2:56
 */
@Controller
@RequestMapping(value = "")
public class DefaultController extends AbstractController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        try {
            int dataCount = archiveService.queryCountByCondition("");
            if(dataCount > 0) {
                Pagination page = new Pagination(dataCount, this.pageSize, 1);
                List<Archive> archiveList = archiveService.queryByCondition("", page);
                for(int i = 8;i >= 0; --i) {
                    model.addAttribute("archive" + (9-i), archiveList.get(i));
                }
            }
            return "index/index";
        } catch (Exception e) {
            model.addAttribute("errorMsg", "系统异常");
            return WebConstants.sysErrorCode;
        }
    }

    @RequestMapping(value = "archive", method = RequestMethod.GET)
    public String archive() {
        return "archive/list";
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about() {
        return "index/about";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String defaultPage() throws SSException{
        throw new SSException("系统异常");
    }
}
