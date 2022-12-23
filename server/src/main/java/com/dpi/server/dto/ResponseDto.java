package com.dpi.server.dto;

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
public class ResponseDto<T> {
    @Builder.Default
    private Integer code = 200;
    @Builder.Default
    private String message = "ok";
    @Builder.Default
    private String userMessage = "成功";
    
    private T data;
}
