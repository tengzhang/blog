package com.iris.web.spring;

import com.iris.service.AdminService;
import com.iris.service.ArchiveService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AbstractController
 *
 * @author: zhangteng
 * @time: 13-12-6 上午11:23
 */
public class AbstractController {

    protected Integer pageSize = 10;

    @Autowired
    protected AdminService adminService;

    @Autowired
    protected ArchiveService archiveService;

    public JSONObject sendJSONObject(JSONObject json) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", 1);
        jsonObject.put("data", json);
        return jsonObject;
    }

    public JSONObject sendErrJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", 0);
        return jsonObject;
    }
}
