package com.dpi.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package com.dpi.server.dto
 * @ClassName PageRequest
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/26
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    // current page, default 1
    @Schema(title = "分页当前页数", example = "1")
    @Builder.Default
    private Integer page = 1;
    // page size, default 10
    @Schema(title = "分页每页条数", example = "10")
    @Builder.Default
    private Integer size = 10;
}
