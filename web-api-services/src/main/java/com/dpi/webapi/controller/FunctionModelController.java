package com.dpi.webapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dpi.common.dto.PageRequestDTO;
import com.dpi.common.dto.ResponseDTO;
import com.dpi.webapi.convert.FunctionModelConvertor;
import com.dpi.webapi.dto.FunctionModelDTO;
import com.dpi.webapi.mapper.auto.entity.FunctionModel;
import com.dpi.webapi.mapper.auto.service.impl.FunctionModelServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @Package com.dpi.functionmodelservice.controller
 * @ClassName FunctionModelController
 * @Description 平台功能模块接口
 * @Author Ryan
 * @Date 2022/12/26
 */
@Api("平台功能模块接口")
@RequestMapping("/function-model")
@RestController
public class FunctionModelController {
    @Autowired
    private FunctionModelServiceImpl functionModelService;

    @ApiOperation(value = "获取功能模块", httpMethod = "GET", response = ResponseDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{id}")
    public ResponseDTO<FunctionModelDTO> get(@PathVariable Integer id) {
        return ResponseDTO.<FunctionModelDTO>builder().data(FunctionModelConvertor.INSTANCE.
                toFunctionModelDTO(functionModelService.getBaseMapper().selectById(id))).build();
    }

    @Transactional
    @ApiOperation(value = "删除功能模块", httpMethod = "DELETE", response = ResponseDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("/{id}")
    public ResponseDTO<Integer> delete(@PathVariable Integer id) {
        int data = functionModelService.getBaseMapper().deleteById(id);
        return ResponseDTO.<Integer>builder().data(data).build();
    }

    @Transactional
    @ApiOperation(value = "新增功能模块", httpMethod = "POST", response = ResponseDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("")
    public ResponseDTO<Integer> create(@RequestBody FunctionModelDTO functionModelDTO) {
        int id = functionModelService.getBaseMapper().insert(
                FunctionModelConvertor.INSTANCE.toFunctionModel(functionModelDTO));
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @Transactional
    @ApiOperation(value = "编辑功能模块", httpMethod = "PUT", response = ResponseDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("")
    public ResponseDTO<Integer> update(@RequestBody FunctionModelDTO functionModelDTO) {
        UpdateWrapper<FunctionModel> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", functionModelDTO.getId());
        int id = functionModelService.getBaseMapper().update(
                FunctionModelConvertor.INSTANCE.toFunctionModel(functionModelDTO), wrapper);
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @ApiOperation(value = "列表功能模块", httpMethod = "GET", response = ResponseDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/list")
    public ResponseDTO<IPage<FunctionModelDTO>> list(@RequestBody PageRequestDTO pageRequestDTO) {
        Page<FunctionModel> page = new Page<>(pageRequestDTO.getPage(), pageRequestDTO.getSize());

        page = functionModelService.getBaseMapper().selectPage(page, new QueryWrapper<>());
        return ResponseDTO.<IPage<FunctionModelDTO>>builder().data(
                page.convert(FunctionModelConvertor.INSTANCE::toFunctionModelDTO)).build();
    }
}
