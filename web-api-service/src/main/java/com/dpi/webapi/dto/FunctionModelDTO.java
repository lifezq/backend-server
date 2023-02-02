package com.dpi.webapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Package com.dpi.webapi.dto
 * @ClassName FunctionModelDto
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FunctionModelDTO {
    /**
     * id
     */
    @Schema(title = "ID", example = "1")
    private Long id;

    /**
     * 父级id
     */
    @Schema(title = "父级ID", example = "1")
    private Integer pid;

    /**
     * 功能模块名称
     */
    @Schema(title = "功能模块名称", example = "名称")
    private String name;

    /**
     * 类型;0虚体, 1实体
     */
    @Schema(title = "类型;0虚体, 1实体", example = "1")
    private Integer rtype;

    /**
     * 是否含有子目录;0否, 1是
     */
    @Schema(title = "是否含有子目录;0否, 1是", example = "0")
    private Integer hassubdirectory;

    /**
     * 排序;排序从小到大
     */
    @Schema(title = "排序;排序从小到大", example = "0")
    private Integer order;

    /**
     * 访问路径
     */
    @Schema(title = "访问路径", example = "")
    private String urlPath;

    /**
     * 备注
     */
    @Schema(title = "备注", example = "")
    private String remark;

    /**
     * 租户号
     */
    @Schema(title = "租户号", example = "")
    private Integer tenantId;

    /**
     * 可用状态;是否可用；1可用,0禁用
     */
    @Schema(title = "可用状态;是否可用；1可用,0禁用", example = "")
    private Integer state;

    /**
     * 是否删除;是否删除；1已删除, 0未删除
     */
    @Schema(title = "是否删除;是否删除；1已删除, 0未删除", example = "")
    private Integer isDelete;

    /**
     * 乐观锁
     */
    @Schema(title = "乐观锁", example = "")
    private String revision;

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
