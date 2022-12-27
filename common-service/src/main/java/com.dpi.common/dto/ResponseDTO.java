package com.dpi.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @Package com.dpi.server.dto
 * @ClassName ResponseDto
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponseDTO<T> {
    @ApiModelProperty(notes = "接口返回编码", example = "200", required = true)
    @Builder.Default
    private Integer code = 200;
    @ApiModelProperty(notes = "接口返回消息", example = "ok", required = true)
    @Builder.Default
    private String message = "ok";
    @ApiModelProperty(notes = "接口返回用户消息", example = "成功", required = false)
    @Builder.Default
    private String userMessage = "成功";
    @ApiModelProperty(notes = "接口返回数据对象", example = "Object", required = false)
    private T data;
}
