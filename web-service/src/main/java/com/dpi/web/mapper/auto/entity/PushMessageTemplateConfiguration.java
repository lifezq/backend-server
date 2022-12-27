package com.dpi.web.mapper.auto.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 平台消息推送模板配置表
 * @TableName pt_push_message_template_configuration
 */
@TableName(value ="pt_push_message_template_configuration")
@Data
public class PushMessageTemplateConfiguration implements Serializable {
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
     * 推送消息配置id
     */
    private Integer pushMessageId;

    /**
     * 消息模板id
     */
    private Integer messageTemplateId;

    /**
     * 推送渠道 0未知, 1站内信,2短信,3邮件
     */
    private Integer sendChannel;

    /**
     * 重试次数
     */
    private Integer retryTimes;

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
        PushMessageTemplateConfiguration other = (PushMessageTemplateConfiguration) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getPushMessageId() == null ? other.getPushMessageId() == null : this.getPushMessageId().equals(other.getPushMessageId()))
            && (this.getMessageTemplateId() == null ? other.getMessageTemplateId() == null : this.getMessageTemplateId().equals(other.getMessageTemplateId()))
            && (this.getSendChannel() == null ? other.getSendChannel() == null : this.getSendChannel().equals(other.getSendChannel()))
            && (this.getRetryTimes() == null ? other.getRetryTimes() == null : this.getRetryTimes().equals(other.getRetryTimes()))
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
        result = prime * result + ((getPushMessageId() == null) ? 0 : getPushMessageId().hashCode());
        result = prime * result + ((getMessageTemplateId() == null) ? 0 : getMessageTemplateId().hashCode());
        result = prime * result + ((getSendChannel() == null) ? 0 : getSendChannel().hashCode());
        result = prime * result + ((getRetryTimes() == null) ? 0 : getRetryTimes().hashCode());
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
        sb.append(", pushMessageId=").append(pushMessageId);
        sb.append(", messageTemplateId=").append(messageTemplateId);
        sb.append(", sendChannel=").append(sendChannel);
        sb.append(", retryTimes=").append(retryTimes);
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