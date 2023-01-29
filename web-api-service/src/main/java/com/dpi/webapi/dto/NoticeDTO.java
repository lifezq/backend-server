package com.dpi.webapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Package com.dpi.webapi.dto
 * @ClassName NoticeDTO
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {
    /**
     * id
     */
    @ApiModelProperty(notes = "ID", example = "1", required = false)
    private Long id;

    /**
     * 租户号
     */
    @ApiModelProperty(notes = "租户ID", example = "1", required = false)
    private Integer tenantId;

    /**
     * 公告标题
     */
    @ApiModelProperty(notes = "公告标题", example = "标题", required = true)
    private String title;

    /**
     * 公告内容
     */
    @ApiModelProperty(notes = "公告内容", example = "内容", required = true)
    private String content;

    /**
     * 附件路径
     */
    @ApiModelProperty(notes = "附件上传", example = "附件文件", required = false)
    private String attachmentPath;

    /**
     * 推送对象 0未知,1平台角色,2指定用户,3全局
     */
    @ApiModelProperty(notes = "推送对象 0未知,1平台角色,2指定用户,3全局", example = "1", required = true)
    private Integer sendType;

    /**
     * 推送对象批量值
     */
    @ApiModelProperty(notes = "推送对象批量值", example = "", required = false)
    private String sendTypeValue;

    /**
     * 推送渠道 0未知, 1站内信,2短信,3邮件
     */
    @ApiModelProperty(notes = "推送渠道 0未知, 1站内信,2短信,3邮件", example = "1", required = true)
    private Integer sendChannel;

    /**
     * 推送时间
     */
    @ApiModelProperty(notes = "推送时间", example = "", required = true)
    private Date sendTime;

    /**
     * 状态;是否可用；1可用;0禁用
     */
    @ApiModelProperty(notes = "状态;是否可用；1可用;0禁用", example = "1", required = false)
    private Integer state;

    /**
     * 是否删除;是否删除；1已删除;0未删除
     */
    @ApiModelProperty(notes = "是否删除;是否删除；1已删除;0未删除", example = "0", required = false)
    private Integer isDelete;

    /**
     * 创建人
     */
    @ApiModelProperty(notes = "创建人", example = "", required = false)
    private String createdBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(notes = "创建时间", example = "", required = false)
    private Date createdTime;

    /**
     * 更新人
     */
    @ApiModelProperty(notes = "更新人", example = "", required = false)
    private String updatedBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(notes = "更新时间", example = "", required = false)
    private Date updatedTime;
}
