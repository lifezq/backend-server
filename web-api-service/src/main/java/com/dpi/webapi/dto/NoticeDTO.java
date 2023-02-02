package com.dpi.webapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(title = "ID", example = "1")
    private Long id;

    /**
     * 租户号
     */
    @Schema(title = "租户ID", example = "1")
    private Integer tenantId;

    /**
     * 公告标题
     */
    @Schema(title = "公告标题", example = "标题")
    private String title;

    /**
     * 公告内容
     */
    @Schema(title = "公告内容", example = "内容")
    private String content;

    /**
     * 附件路径
     */
    @Schema(title = "附件上传", example = "附件文件")
    private String attachmentPath;

    /**
     * 推送对象 0未知,1平台角色,2指定用户,3全局
     */
    @Schema(title = "推送对象 0未知,1平台角色,2指定用户,3全局", example = "1")
    private Integer sendType;

    /**
     * 推送对象批量值
     */
    @Schema(title = "推送对象批量值", example = "")
    private String sendTypeValue;

    /**
     * 推送渠道 0未知, 1站内信,2短信,3邮件
     */
    @Schema(title = "推送渠道 0未知, 1站内信,2短信,3邮件", example = "1")
    private Integer sendChannel;

    /**
     * 推送时间
     */
    @Schema(title = "推送时间", example = "")
    private Date sendTime;

    /**
     * 状态;是否可用；1可用;0禁用
     */
    @Schema(title = "状态;是否可用；1可用;0禁用", example = "1")
    private Integer state;

    /**
     * 是否删除;是否删除；1已删除;0未删除
     */
    @Schema(title = "是否删除;是否删除；1已删除;0未删除", example = "0")
    private Integer isDelete;

    /**
     * 创建人
     */
    @Schema(title = "创建人", example = "")
    private String createdBy;

    /**
     * 创建时间
     */
    @Schema(title = "创建时间", example = "")
    private Date createdTime;

    /**
     * 更新人
     */
    @Schema(title = "更新人", example = "")
    private String updatedBy;

    /**
     * 更新时间
     */
    @Schema(title = "更新时间", example = "")
    private Date updatedTime;
}
