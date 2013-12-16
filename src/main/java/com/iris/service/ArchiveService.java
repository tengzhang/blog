package com.iris.service;

import com.iris.common.entity.Archive;
import com.iris.common.utils.Pagination;

import java.util.List;

/**
 * ArchiveService
 *
 * @author: zhangteng
 * @time: 13-12-6 下午2:55
 */
public interface ArchiveService {

    /**
     * 查询全部文章
     *
     * @return
     * @throws Exception
     */
    public List<Archive> queryAllArchive() throws Exception;

    /**
     * 根据文章id查询
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Archive queryArchiveById(Integer id) throws Exception;

    /**
     * 添加文章
     *
     * @param archive
     * @return
     * @throws Exception
     */
    public Archive insertArchive(Archive archive) throws Exception;

    /**
     * 更新文章
     *
     * @param archive
     * @throws Exception
     */
    public void updateArchive(Archive archive) throws Exception;

    /**
     * 删除文章
     *
     * @param id
     * @throws Exception
     */
    public void deleteArchiveById(Integer id) throws Exception;

    /**
     * 根据条件查询记录数
     *
     * @return
     * @throws Exception
     */
    public int queryCountByCondition(String search) throws Exception;

    /**
     * 根据条件进行分页查询
     *
     * @param search
     * @param page
     * @return
     * @throws Exception
     */
    public List<Archive> queryByCondition(String search, Pagination page) throws Exception;
}
