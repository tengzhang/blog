package com.iris.service.impl;

import com.iris.common.entity.Archive;
import com.iris.common.enums.StatusEnum;
import com.iris.common.log.LogClerk;
import com.iris.common.utils.Pagination;
import com.iris.mapper.ArchiveMapper;
import com.iris.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ArchiveServiceImpl
 *
 * @author: zhangteng
 * @time: 13-12-6 下午2:55
 */
@Service("archiveService")
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    private ArchiveMapper archiveMapper;

    @Override
    public List<Archive> queryAllArchive() throws Exception {
        try {
            return archiveMapper.queryAllArchive();
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Archive queryArchiveById(Integer id) throws Exception {
        try {
            return archiveMapper.queryArchiveById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Archive insertArchive(Archive archive) throws Exception {
        try {
            archive.setStatus(StatusEnum.Show.getId());
            archive.setViewCount(0);
            archive.setCreateTime(new Date());
            Integer id = archiveMapper.insertArchive(archive);
            archive.setId(id);
            return archive;
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateArchive(Archive archive) throws Exception {
        try {
            archiveMapper.updateArchive(archive);
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class},propagation = Propagation.REQUIRED)
    public void deleteArchiveById(Integer id) throws Exception {
        try {
            Archive archive = queryArchiveById(id);
            archive.setStatus(StatusEnum.Hide.getId());
            updateArchive(archive);
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public int queryCountByCondition(String search) throws Exception {
        try {
            if(search!=null && search.equals("")) {
                search = null;
            }
            return archiveMapper.queryCountByCondition(search);
        } catch (Exception e) {
            LogClerk.errLog.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Archive> queryByCondition(String search, Pagination page) throws Exception {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            int pCurrent = 0, pSize = 10;
            if(page != null) {
                pCurrent = page.getCurrentFristPosition();
                pSize = page.getPageSize();
            }
            if(search!=null && search.equals("")) {
                search = null;
            }
            params.put("search", search);
            params.put("pCurrent", pCurrent);
            params.put("pSize", pSize);
            List<Archive> archiveList =  archiveMapper.queryByCondition(params);
            // 对createTime进行处理
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(Archive archive : archiveList) {
                archive.setCreateTimeStr(sdf.format(archive.getCreateTime()));
            }
            return archiveList;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw e;
        }
    }
}
