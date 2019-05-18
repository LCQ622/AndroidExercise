package cn.mcandroid.test15.dao;

import java.util.List;

import cn.mcandroid.test15.db.Info;

public interface InfoDao {
    /**
     * 获得所有信息
     * @return
     */
    public List<Info> getALLInfo();

    /**
     * 获得根据信息查询信息
     * @param info
     * @return
     */
    public List<Info> getInfoByInfo(Info info);

    /**
     * 添加信息
     * @param info
     * @return 执行成功 返回true 否则返回false
     */
    public boolean addInfo(Info info);

    /**
     * 删除信息
     * @param info
     * @return 执行成功 返回true 否则返回false
     */
    public boolean delInfo(Info info);

    /**
    /**
     * 更新数据
     * @param info
     * @return 执行成功 返回true 否则返回false
     */
    public boolean updateInfo(Info info);
}
