package com.dpi.software.controller;

import com.dpi.common.dto.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.dpi.software.controller
 * @ClassName SoftwareController
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
@Tag(name = "软件应用接口")
@RequestMapping("/software")
@RestController
public class SoftwareController {

    @Operation(summary = "获取应用列表", method = "GET")
    @GetMapping("/{id}")
    public ResponseDTO<Integer> get(@PathVariable Integer id) {
        return ResponseDTO.<Integer>builder().data(0).build();
    }
}

