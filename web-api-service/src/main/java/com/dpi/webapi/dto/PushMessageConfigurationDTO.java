package com.dpi.webapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Package com.dpi.webapi.dto
 * @ClassName PushMessageConfigurationDTO
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PushMessageConfigurationDTO {
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
     * 消息任务名称
     */
    @Schema(name = "消息任务名称", example = "")
    private String name;

    /**
     * 消息事件编码
     */
    @Schema(name = "消息事件编码", example = "")
    private String eventCode;

    /**
     * 消息类型编码id
     */
    @Schema(name = "消息类型编码id", example = "")
    private Integer messageType;

    /**
     * 是否可订阅, 0否,1是
     */
    @Schema(name = "是否可订阅, 0否,1是", example = "0")
    private Integer isSubscribe;

    /**
     * 消息模板id列表
     */
    @Schema(name = "消息模板id列表，多个以逗号分隔", example = "")
    private String messageTemplates;

    /**
     * 状态;是否可用；1可用;0禁用
     */
    @Schema(name = "状态;是否可用；1可用;0禁用", example = "1")
    private Integer state;

    /**
     * 是否删除;是否删除；1已删除;0未删除
     */
    @Schema(name = "是否删除;是否删除；1已删除;0未删除", example = "0")
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
