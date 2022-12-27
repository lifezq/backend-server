package com.dpi.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Package com.dpi.web.dto
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
    @ApiModelProperty(notes = "ID", example = "1", required = false)
    private Long id;

    /**
     * 父级id
     */
    @ApiModelProperty(notes = "父级ID", example = "1", required = false)
    private Integer pid;

    /**
     * 功能模块名称
     */
    @ApiModelProperty(notes = "功能模块名称", example = "名称", required = true)
    private String name;

    /**
     * 类型;0虚体, 1实体
     */
    @ApiModelProperty(notes = "类型;0虚体, 1实体", example = "1", required = true)
    private Integer rtype;

    /**
     * 是否含有子目录;0否, 1是
     */
    @ApiModelProperty(notes = "是否含有子目录;0否, 1是", example = "0", required = false)
    private Integer hassubdirectory;

    /**
     * 排序;排序从小到大
     */
    @ApiModelProperty(notes = "排序;排序从小到大", example = "0", required = false)
    private Integer order;

    /**
     * 访问路径
     */
    @ApiModelProperty(notes = "访问路径", example = "", required = false)
    private String urlPath;

    /**
     * 备注
     */
    @ApiModelProperty(notes = "备注", example = "", required = false)
    private String remark;

    /**
     * 租户号
     */
    @ApiModelProperty(notes = "租户号", example = "", required = false)
    private Integer tenantId;

    /**
     * 可用状态;是否可用；1可用,0禁用
     */
    @ApiModelProperty(notes = "可用状态;是否可用；1可用,0禁用", example = "", required = false)
    private Integer state;

    /**
     * 是否删除;是否删除；1已删除, 0未删除
     */
    @ApiModelProperty(notes = "是否删除;是否删除；1已删除, 0未删除", example = "", required = false)
    private Integer isDelete;

    /**
     * 乐观锁
     */
    @ApiModelProperty(notes = "乐观锁", example = "", required = false)
    private String revision;

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
