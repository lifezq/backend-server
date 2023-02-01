package com.dpi.webapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Package com.dpi.webapi.dto
 * @ClassName MessageTemplateDTO
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageTemplateDTO {
    /**
     * id
     */
    @Schema(name = "ID", example = "1")
    private Long id;

    /**
     * 租户号
     */
    @Schema(name = "租户号", example = "1")
    private Integer tenantId;

    /**
     * 消息模板名称
     */
    @Schema(name = "消息模板名称", example = "名称")
    private String name;

    /**
     * 描述信息
     */
    @Schema(name = "消息描述信息", example = "描述信息")
    private String description;

    /**
     * 消息主题
     */
    @Schema(name = "消息主题", example = "")
    private String subject;

    /**
     * 消息正文
     */
    @Schema(name = "消息正文", example = "")
    private String content;

    /**
     * 状态;是否可用；1可用;0禁用
     */
    @Schema(name = "状态;是否可用；1可用;0禁用", example = "")
    private Integer state;

    /**
     * 是否删除;是否删除；1已删除;0未删除
     */
    @Schema(name = "是否删除;是否删除；1已删除;0未删除", example = "")
    private Integer isDelete;

    /**
     * 创建人
     */
    @Schema(name = "创建人", example = "")
    private String createdBy;

    /**
     * 创建时间
     */
    @Schema(name = "创建时间", example = "")
    private Date createdTime;

    /**
     * 更新人
     */
    @Schema(name = "更新人", example = "")
    private String updatedBy;

    /**
     * 更新时间
     */
    @Schema(name = "更新时间", example = "")
    private Date updatedTime;
}
