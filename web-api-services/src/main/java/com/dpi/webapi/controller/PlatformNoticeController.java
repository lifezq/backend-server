package com.dpi.webapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dpi.common.dto.PageRequestDTO;
import com.dpi.common.dto.ResponseDTO;
import com.dpi.webapi.convert.NoticeConvertor;
import com.dpi.webapi.dto.NoticeDTO;
import com.dpi.webapi.mapper.auto.entity.Notice;
import com.dpi.webapi.mapper.auto.service.impl.NoticeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @Package com.dpi.web.controller
 * @ClassName PlatformNoticeController
 * @Description 平台公告接口
 * @Author Ryan
 * @Date 2022/12/27
 */
@Api("平台公告接口")
@RequestMapping("/notice")
@RestController
public class PlatformNoticeController {
    @Autowired
    private NoticeServiceImpl noticeService;

    @ApiOperation(value = "获取公告", httpMethod = "GET", response = ResponseDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{id}")
    public ResponseDTO<NoticeDTO> get(@PathVariable Integer id) {
        return ResponseDTO.<NoticeDTO>builder().data(NoticeConvertor.INSTANCE.
                toNoticeDTO(noticeService.getBaseMapper().selectById(id))).build();
    }

    @Transactional
    @ApiOperation(value = "删除公告", httpMethod = "DELETE", response = ResponseDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("/{id}")
    public ResponseDTO<Integer> delete(@PathVariable Integer id) {
        int data = noticeService.getBaseMapper().deleteById(id);
        return ResponseDTO.<Integer>builder().data(data).build();
    }

    @Transactional
    @ApiOperation(value = "新增公告", httpMethod = "POST", response = ResponseDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("")
    public ResponseDTO<Integer> create(@RequestBody NoticeDTO noticeDTO) {
        int id = noticeService.getBaseMapper().insert(
                NoticeConvertor.INSTANCE.toNotice(noticeDTO));
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @Transactional
    @ApiOperation(value = "编辑公告", httpMethod = "PUT", response = ResponseDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("")
    public ResponseDTO<Integer> update(@RequestBody NoticeDTO noticeDTO) {
        UpdateWrapper<Notice> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", noticeDTO.getId());
        int id = noticeService.getBaseMapper().update(
                NoticeConvertor.INSTANCE.toNotice(noticeDTO), wrapper);
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @ApiOperation(value = "列表公告", httpMethod = "GET", response = ResponseDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/list")
    public ResponseDTO<IPage<NoticeDTO>> list(@RequestBody PageRequestDTO pageRequestDTO) {
        Page<Notice> page = new Page<>(pageRequestDTO.getPage(), pageRequestDTO.getSize());

        page = noticeService.getBaseMapper().selectPage(page, new QueryWrapper<>());
        return ResponseDTO.<IPage<NoticeDTO>>builder().data(
                page.convert(NoticeConvertor.INSTANCE::toNoticeDTO)).build();
    }
}
