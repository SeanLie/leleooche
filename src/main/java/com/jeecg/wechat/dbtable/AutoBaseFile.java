package com.jeecg.wechat.dbtable;

import javax.persistence.Table;

@Table(name = "auto_base_file")
public class AutoBaseFile extends HeadDbTable {

    /**
     * 使用者ID,t_s_user表主键
     */
    private String user_id;

    /**
     * 原文件名称
     */
    private String orgfile_name;

    /**
     * 文件名称
     */
    private String file_name;

    /**
     * 文件介绍
     */
    private String file_desc;

    /**
     * 文件保存路径
     */
    private String file_savePath;

    /**
     * 是否有效
     */
    private String isValid;

    /**
     * 是否上传有效
     */
    private String isUpValid;

    /**
     * 是否删除有效
     */
    private String isDelValid;

    /**
     * 响应信息
     */
    private String msg;

    /**
     *
     */
    public AutoBaseFile() {
        super();
    }

    public AutoBaseFile(String id, String user_id, String orgfile_name, String file_name, String file_desc,
                        String file_savePath, String isValid, String isUpValid, String isDelValid, String msg) {
        super();
        this.setId(id);
        this.user_id = user_id;
        this.orgfile_name = orgfile_name;
        this.file_name = file_name;
        this.file_desc = file_desc;
        this.file_savePath = file_savePath;
        this.isValid = isValid;
        this.isUpValid = isUpValid;
        this.isDelValid = isDelValid;
        this.msg = msg;
    }

    /**
     * @return the user_id
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the orgfile_name
     */
    public String getOrgfile_name() {
        return orgfile_name;
    }

    /**
     * @param orgfile_name the orgfile_name to set
     */
    public void setOrgfile_name(String orgfile_name) {
        this.orgfile_name = orgfile_name;
    }

    /**
     * @return the file_name
     */
    public String getFile_name() {
        return file_name;
    }

    /**
     * @param file_name the file_name to set
     */
    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    /**
     * @return the file_desc
     */
    public String getFile_desc() {
        return file_desc;
    }

    /**
     * @param file_desc the file_desc to set
     */
    public void setFile_desc(String file_desc) {
        this.file_desc = file_desc;
    }

    /**
     * @return the file_savePath
     */
    public String getFile_savePath() {
        return file_savePath;
    }

    /**
     * @param file_savePath the file_savePath to set
     */
    public void setFile_savePath(String file_savePath) {
        this.file_savePath = file_savePath;
    }

    /**
     * @return the isValid
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * @param isValid the isValid to set
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    /**
     * @return the isDelValid
     */
    public String getIsDelValid() {
        return isDelValid;
    }

    /**
     * @return the isUpValid
     */
    public String getIsUpValid() {
        return isUpValid;
    }

    /**
     * @param isUpValid the isUpValid to set
     */
    public void setIsUpValid(String isUpValid) {
        this.isUpValid = isUpValid;
    }

    /**
     * @param isDelValid the isDelValid to set
     */
    public void setIsDelValid(String isDelValid) {
        this.isDelValid = isDelValid;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AutoBaseFile [id=" + this.getId() + ", user_id=" + user_id + ", orgfile_name=" + orgfile_name + ", file_name="
                + file_name + ", file_desc=" + file_desc + ", file_savePath=" + file_savePath + ", isValid=" + isValid
                + ", isUpValid=" + isUpValid + ", isDelValid=" + isDelValid + ", msg=" + msg + "]";
    }

}
