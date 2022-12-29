package com.dpi.software.controller;

import com.dpi.common.dto.ResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
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
@Api("软件应用接口")
@RequestMapping("/software")
@RestController
public class SoftwareController {

    @ApiOperation(value = "获取应用列表", httpMethod = "GET", response = ResponseDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{id}")
    public ResponseDTO<Integer> get(@PathVariable Integer id) {
        return ResponseDTO.<Integer>builder().data(0).build();
    }
}

