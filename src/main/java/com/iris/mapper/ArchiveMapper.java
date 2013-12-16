package com.iris.mapper;

import com.iris.common.entity.Archive;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ArchiveMapper
 *
 * @author: zhangteng
 * @time: 13-12-6 下午2:55
 */
@Repository
public interface ArchiveMapper {

    /**
     * 查询全部文章
     *
     * @return
     * @throws Exception
     */
    public List<Archive> queryAllArchive();

    /**
     * 根据文章id查询
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Archive queryArchiveById(@Param("id") Integer id);

    /**
     * 添加文章
     *
     * @param archive
     * @return
     * @throws Exception
     */
    public Integer insertArchive(@Param("archive") Archive archive);

    /**
     * 更新文章
     *
     * @param archive
     * @throws Exception
     */
    public void updateArchive(@Param("archive") Archive archive);

    /**
     * 根据条件查询记录数
     *
     * @return
     * @throws Exception
     */
    public int queryCountByCondition(@Param("search") String search) throws Exception;

    /**
     * 根据条件进行分页查询
     *
     * @param params
     * @return
     * @throws Exception
     */
    public List<Archive> queryByCondition(Map<String, Object> params) throws Exception;
}
