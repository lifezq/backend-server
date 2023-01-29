package com.dpi.webapi.dto;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "ID", example = "1", required = false)
    private Long id;

    /**
     * 租户号
     */
    @ApiModelProperty(notes = "租户号", example = "1", required = false)
    private Integer tenantId;

    /**
     * 消息模板名称
     */
    @ApiModelProperty(notes = "消息模板名称", example = "名称", required = true)
    private String name;

    /**
     * 描述信息
     */
    @ApiModelProperty(notes = "消息描述信息", example = "描述信息", required = false)
    private String description;

    /**
     * 消息主题
     */
    @ApiModelProperty(notes = "消息主题", example = "", required = true)
    private String subject;

    /**
     * 消息正文
     */
    @ApiModelProperty(notes = "消息正文", example = "", required = true)
    private String content;

    /**
     * 状态;是否可用；1可用;0禁用
     */
    @ApiModelProperty(notes = "状态;是否可用；1可用;0禁用", example = "", required = false)
    private Integer state;

    /**
     * 是否删除;是否删除；1已删除;0未删除
     */
    @ApiModelProperty(notes = "是否删除;是否删除；1已删除;0未删除", example = "", required = false)
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
