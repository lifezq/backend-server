package com.dpi.database.mapper.auto.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 功能模块表
 * @TableName pt_function_model
 */
@TableName(value ="pt_function_model")
@Data
public class FunctionModel implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 父级id
     */
    private Integer pid;

    /**
     * 功能模块名称
     */
    private String name;

    /**
     * 类型;0虚体, 1实体
     */
    private Integer rtype;

    /**
     * 是否含有子目录;0否, 1是
     */
    private Integer hassubdirectory;

    /**
     * 排序;排序从小到大
     */
    private Integer order;

    /**
     * 访问路径
     */
    private String urlPath;

    /**
     * 备注
     */
    private String remark;

    /**
     * 租户号
     */
    private Integer tenantId;

    /**
     * 可用状态;是否可用；1可用,0禁用
     */
    private Integer state;

    /**
     * 是否删除;是否删除；1已删除, 0未删除
     */
    private Integer isDelete;

    /**
     * 乐观锁
     */
    private String revision;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FunctionModel other = (FunctionModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getRtype() == null ? other.getRtype() == null : this.getRtype().equals(other.getRtype()))
            && (this.getHassubdirectory() == null ? other.getHassubdirectory() == null : this.getHassubdirectory().equals(other.getHassubdirectory()))
            && (this.getOrder() == null ? other.getOrder() == null : this.getOrder().equals(other.getOrder()))
            && (this.getUrlPath() == null ? other.getUrlPath() == null : this.getUrlPath().equals(other.getUrlPath()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getRevision() == null ? other.getRevision() == null : this.getRevision().equals(other.getRevision()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedBy() == null ? other.getUpdatedBy() == null : this.getUpdatedBy().equals(other.getUpdatedBy()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getRtype() == null) ? 0 : getRtype().hashCode());
        result = prime * result + ((getHassubdirectory() == null) ? 0 : getHassubdirectory().hashCode());
        result = prime * result + ((getOrder() == null) ? 0 : getOrder().hashCode());
        result = prime * result + ((getUrlPath() == null) ? 0 : getUrlPath().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getRevision() == null) ? 0 : getRevision().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedBy() == null) ? 0 : getUpdatedBy().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", name=").append(name);
        sb.append(", rtype=").append(rtype);
        sb.append(", hassubdirectory=").append(hassubdirectory);
        sb.append(", order=").append(order);
        sb.append(", urlPath=").append(urlPath);
        sb.append(", remark=").append(remark);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", state=").append(state);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", revision=").append(revision);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}