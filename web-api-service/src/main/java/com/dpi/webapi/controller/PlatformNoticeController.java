package com.dpi.webapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dpi.common.dto.PageRequestDTO;
import com.dpi.common.dto.ResponseDTO;
import com.dpi.database.mapper.auto.entity.Notice;
import com.dpi.database.mapper.auto.service.impl.NoticeServiceImpl;
import com.dpi.webapi.convert.NoticeConvertor;
import com.dpi.webapi.dto.NoticeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @Package com.dpi.web.controller
 * @ClassName PlatformNoticeController
 * @Description 平台公告接口
 * @Author Ryan
 * @Date 2022/12/27
 */
@Tag(name = "平台公告接口")
@RequestMapping("/notice")
@RestController
public class PlatformNoticeController {
    @Autowired
    private NoticeServiceImpl noticeService;

    @Operation(summary = "获取公告", method = "GET")
    @GetMapping("/{id}")
    public ResponseDTO<NoticeDTO> get(@PathVariable Integer id) {
        return ResponseDTO.<NoticeDTO>builder().data(NoticeConvertor.INSTANCE.
                toNoticeDTO(noticeService.getBaseMapper().selectById(id))).build();
    }

    @Transactional
    @Operation(summary = "删除公告", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseDTO<Integer> delete(@PathVariable Integer id) {
        int data = noticeService.getBaseMapper().deleteById(id);
        return ResponseDTO.<Integer>builder().data(data).build();
    }

    @Transactional
    @Operation(summary = "新增公告", method = "POST")
    @PostMapping("")
    public ResponseDTO<Integer> create(@RequestBody NoticeDTO noticeDTO) {
        int id = noticeService.getBaseMapper().insert(
                NoticeConvertor.INSTANCE.toNotice(noticeDTO));
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @Transactional
    @Operation(summary = "编辑公告", method = "PUT")
    @PutMapping("")
    public ResponseDTO<Integer> update(@RequestBody NoticeDTO noticeDTO) {
        UpdateWrapper<Notice> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", noticeDTO.getId());
        int id = noticeService.getBaseMapper().update(
                NoticeConvertor.INSTANCE.toNotice(noticeDTO), wrapper);
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @Operation(summary = "列表公告", method = "GET")
    @GetMapping("/list")
    public ResponseDTO<IPage<NoticeDTO>> list(@RequestBody PageRequestDTO pageRequestDTO) {
        Page<Notice> page = new Page<>(pageRequestDTO.getPage(), pageRequestDTO.getSize());

        page = noticeService.getBaseMapper().selectPage(page, new QueryWrapper<>());
        return ResponseDTO.<IPage<NoticeDTO>>builder().data(
                page.convert(NoticeConvertor.INSTANCE::toNoticeDTO)).build();
    }
}
