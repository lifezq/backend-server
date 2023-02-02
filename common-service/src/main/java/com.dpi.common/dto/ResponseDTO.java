package com.dpi.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(title = "接口返回编码", example = "200")
    @Builder.Default
    private Integer code = 200;
    @Schema(title = "接口返回消息", example = "ok")
    @Builder.Default
    private String message = "ok";
    @Schema(title = "接口返回用户消息", example = "成功")
    @Builder.Default
    private String userMessage = "成功";
    @Schema(title = "接口返回数据对象", example = "Object")
    private T data;
}
