package com.dpi.webapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dpi.common.dto.PageRequestDTO;
import com.dpi.common.dto.ResponseDTO;
import com.dpi.webapi.convert.MessageTemplateConvertor;
import com.dpi.webapi.convert.PushMessageConfigurationConvertor;
import com.dpi.webapi.dto.MessageTemplateDTO;
import com.dpi.webapi.dto.PushMessageConfigurationDTO;
import com.dpi.webapi.mapper.auto.entity.MessageTemplate;
import com.dpi.webapi.mapper.auto.entity.PushMessageConfiguration;
import com.dpi.webapi.mapper.auto.service.impl.MessageTemplateServiceImpl;
import com.dpi.webapi.mapper.auto.service.impl.PushMessageConfigurationServiceImpl;
import com.dpi.webapi.mapper.auto.service.impl.PushMessageTemplateConfigurationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @Package com.dpi.web.controller
 * @ClassName MessageController
 * @Description 平台消息配置接口
 * @Author Ryan
 * @Date 2022/12/27
 */
@Tag(name = "平台消息配置接口")
@RequestMapping("/message")
@RestController
public class MessageController {
    @Autowired
    private MessageTemplateServiceImpl messageTemplateService;
    @Autowired
    private PushMessageConfigurationServiceImpl pushMessageConfigurationService;
    @Autowired
    private PushMessageTemplateConfigurationServiceImpl pushMessageTemplateConfigurationService;

    @Operation(summary = "获取消息模板", method = "GET")
    @GetMapping("/template/{id}")
    public ResponseDTO<MessageTemplateDTO> getTemplate(@PathVariable Integer id) {
        return ResponseDTO.<MessageTemplateDTO>builder().data(MessageTemplateConvertor.INSTANCE.
                toMessageTemplateDTO(messageTemplateService.getBaseMapper().selectById(id))).build();
    }

    @Transactional
    @Operation(summary = "删除消息模板", method = "DELETE")
    @DeleteMapping("/template/{id}")
    public ResponseDTO<Integer> deleteTemplate(@PathVariable Integer id) {
        int data = messageTemplateService.getBaseMapper().deleteById(id);
        return ResponseDTO.<Integer>builder().data(data).build();
    }

    @Transactional
    @Operation(summary = "新增消息模板", method = "POST")
    @PostMapping("/template")
    public ResponseDTO<Integer> createTemplate(@RequestBody MessageTemplateDTO messageTemplateDTO) {
        int id = messageTemplateService.getBaseMapper().insert(
                MessageTemplateConvertor.INSTANCE.toMessageTemplate(messageTemplateDTO));
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @Transactional
    @Operation(summary = "编辑消息模板", method = "PUT")
    @PutMapping("/template")
    public ResponseDTO<Integer> updateTemplate(@RequestBody MessageTemplateDTO messageTemplateDTO) {
        UpdateWrapper<MessageTemplate> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", messageTemplateDTO.getId());
        int id = messageTemplateService.getBaseMapper().update(
                MessageTemplateConvertor.INSTANCE.toMessageTemplate(messageTemplateDTO), wrapper);
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @Operation(summary = "列表功能模块", method = "GET")
    @GetMapping("/template/list")
    public ResponseDTO<IPage<MessageTemplateDTO>> listTemplate(@RequestBody PageRequestDTO pageRequestDTO) {
        Page<MessageTemplate> page = new Page<>(pageRequestDTO.getPage(), pageRequestDTO.getSize());

        page = messageTemplateService.getBaseMapper().selectPage(page, new QueryWrapper<>());
        return ResponseDTO.<IPage<MessageTemplateDTO>>builder().data(
                page.convert(MessageTemplateConvertor.INSTANCE::toMessageTemplateDTO)).build();
    }

    @Operation(summary = "获取消息推送配置", method = "GET")
    @GetMapping("/push/{id}")
    public ResponseDTO<PushMessageConfigurationDTO> getPushMessage(@PathVariable Integer id) {
        return ResponseDTO.<PushMessageConfigurationDTO>builder().data(PushMessageConfigurationConvertor.INSTANCE.
                toMessageConfigurationDTO(pushMessageConfigurationService.getBaseMapper().selectById(id))).build();
    }

    @Transactional
    @Operation(summary = "删除消息推送配置", method = "DELETE")
    @DeleteMapping("/push/{id}")
    public ResponseDTO<Integer> deletePushMessage(@PathVariable Integer id) {
        int data = pushMessageConfigurationService.getBaseMapper().deleteById(id);
        return ResponseDTO.<Integer>builder().data(data).build();
    }

    @Transactional
    @Operation(summary = "新增消息推送配置", method = "POST")
    @PostMapping("/push")
    public ResponseDTO<Integer> createPushMessage(@RequestBody PushMessageConfigurationDTO pushMessageConfigurationDTO) {
        int id = pushMessageConfigurationService.getBaseMapper().insert(
                PushMessageConfigurationConvertor.INSTANCE.toMessageConfiguration(pushMessageConfigurationDTO));
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @Transactional
    @Operation(summary = "编辑消息推送配置", method = "PUT")
    @PutMapping("/push")
    public ResponseDTO<Integer> updatePushMessage(@RequestBody PushMessageConfigurationDTO pushMessageConfigurationDTO) {
        UpdateWrapper<PushMessageConfiguration> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", pushMessageConfigurationDTO.getId());
        int id = pushMessageConfigurationService.getBaseMapper().update(
                PushMessageConfigurationConvertor.INSTANCE.toMessageConfiguration(pushMessageConfigurationDTO), wrapper);
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @Operation(summary = "列表消息推送配置", method = "GET")
    @GetMapping("/push/list")
    public ResponseDTO<IPage<PushMessageConfigurationDTO>> listPushMessage(@RequestBody PageRequestDTO pageRequestDTO) {
        Page<PushMessageConfiguration> page = new Page<>(pageRequestDTO.getPage(), pageRequestDTO.getSize());

        page = pushMessageConfigurationService.getBaseMapper().selectPage(page, new QueryWrapper<>());
        return ResponseDTO.<IPage<PushMessageConfigurationDTO>>builder().data(
                page.convert(PushMessageConfigurationConvertor.INSTANCE::toMessageConfigurationDTO)).build();
    }
}
