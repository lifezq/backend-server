package com.dpi.web.mapper.auto.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 平台消息推送任务配置表
 * @TableName pt_push_message_configuration
 */
@TableName(value ="pt_push_message_configuration")
@Data
public class PushMessageConfiguration implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 租户号
     */
    private Integer tenantId;

    /**
     * 消息任务名称
     */
    private String name;

    /**
     * 消息事件编码
     */
    private String eventCode;

    /**
     * 消息类型编码id
     */
    private Integer messageType;

    /**
     * 是否可订阅, 0否,1是
     */
    private Integer isSubscribe;

    /**
     * 消息模板id列表
     */
    private String messageTemplates;

    /**
     * 状态;是否可用；1可用;0禁用
     */
    private Integer state;

    /**
     * 是否删除;是否删除；1已删除;0未删除
     */
    private Integer isDelete;

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
        PushMessageConfiguration other = (PushMessageConfiguration) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getEventCode() == null ? other.getEventCode() == null : this.getEventCode().equals(other.getEventCode()))
            && (this.getMessageType() == null ? other.getMessageType() == null : this.getMessageType().equals(other.getMessageType()))
            && (this.getIsSubscribe() == null ? other.getIsSubscribe() == null : this.getIsSubscribe().equals(other.getIsSubscribe()))
            && (this.getMessageTemplates() == null ? other.getMessageTemplates() == null : this.getMessageTemplates().equals(other.getMessageTemplates()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
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
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getEventCode() == null) ? 0 : getEventCode().hashCode());
        result = prime * result + ((getMessageType() == null) ? 0 : getMessageType().hashCode());
        result = prime * result + ((getIsSubscribe() == null) ? 0 : getIsSubscribe().hashCode());
        result = prime * result + ((getMessageTemplates() == null) ? 0 : getMessageTemplates().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
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
        sb.append(", tenantId=").append(tenantId);
        sb.append(", name=").append(name);
        sb.append(", eventCode=").append(eventCode);
        sb.append(", messageType=").append(messageType);
        sb.append(", isSubscribe=").append(isSubscribe);
        sb.append(", messageTemplates=").append(messageTemplates);
        sb.append(", state=").append(state);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}