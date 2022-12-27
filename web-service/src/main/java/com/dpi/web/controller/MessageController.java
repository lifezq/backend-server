package com.dpi.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dpi.common.dto.PageRequestDTO;
import com.dpi.common.dto.ResponseDTO;
import com.dpi.web.convert.MessageTemplateConvertor;
import com.dpi.web.convert.PushMessageConfigurationConvertor;
import com.dpi.web.dto.MessageTemplateDTO;
import com.dpi.web.dto.PushMessageConfigurationDTO;
import com.dpi.web.mapper.auto.entity.MessageTemplate;
import com.dpi.web.mapper.auto.entity.PushMessageConfiguration;
import com.dpi.web.mapper.auto.service.impl.MessageTemplateServiceImpl;
import com.dpi.web.mapper.auto.service.impl.PushMessageConfigurationServiceImpl;
import com.dpi.web.mapper.auto.service.impl.PushMessageTemplateConfigurationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @Package com.dpi.web.controller
 * @ClassName MessageController
 * @Description 平台消息配置接口
 * @Author Ryan
 * @Date 2022/12/27
 */
@Api("平台消息配置接口")
@RequestMapping("/message")
@RestController
public class MessageController {
    @Autowired
    private MessageTemplateServiceImpl messageTemplateService;
    @Autowired
    private PushMessageConfigurationServiceImpl pushMessageConfigurationService;
    @Autowired
    private PushMessageTemplateConfigurationServiceImpl pushMessageTemplateConfigurationService;

    @ApiOperation(value = "获取消息模板", httpMethod = "GET", response = ResponseDTO.class,
            tags = {"Message template"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/template/{id}")
    public ResponseDTO<MessageTemplateDTO> getTemplate(@PathVariable Integer id) {
        return ResponseDTO.<MessageTemplateDTO>builder().data(MessageTemplateConvertor.INSTANCE.
                toMessageTemplateDTO(messageTemplateService.getBaseMapper().selectById(id))).build();
    }

    @Transactional
    @ApiOperation(value = "删除消息模板", httpMethod = "DELETE", response = ResponseDTO.class,
            tags = {"Message template"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("/template/{id}")
    public ResponseDTO<Integer> deleteTemplate(@PathVariable Integer id) {
        int data = messageTemplateService.getBaseMapper().deleteById(id);
        return ResponseDTO.<Integer>builder().data(data).build();
    }

    @Transactional
    @ApiOperation(value = "新增消息模板", httpMethod = "POST", response = ResponseDTO.class,
            tags = {"Message template"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/template")
    public ResponseDTO<Integer> createTemplate(@RequestBody MessageTemplateDTO messageTemplateDTO) {
        int id = messageTemplateService.getBaseMapper().insert(
                MessageTemplateConvertor.INSTANCE.toMessageTemplate(messageTemplateDTO));
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @Transactional
    @ApiOperation(value = "编辑消息模板", httpMethod = "PUT", response = ResponseDTO.class,
            tags = {"Message template"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("/template")
    public ResponseDTO<Integer> updateTemplate(@RequestBody MessageTemplateDTO messageTemplateDTO) {
        UpdateWrapper<MessageTemplate> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", messageTemplateDTO.getId());
        int id = messageTemplateService.getBaseMapper().update(
                MessageTemplateConvertor.INSTANCE.toMessageTemplate(messageTemplateDTO), wrapper);
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @ApiOperation(value = "列表功能模块", httpMethod = "GET", response = ResponseDTO.class,
            tags = {"Message template"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/template/list")
    public ResponseDTO<IPage<MessageTemplateDTO>> listTemplate(@RequestBody PageRequestDTO pageRequestDTO) {
        Page<MessageTemplate> page = new Page<>(pageRequestDTO.getPage(), pageRequestDTO.getSize());

        page = messageTemplateService.getBaseMapper().selectPage(page, new QueryWrapper<>());
        return ResponseDTO.<IPage<MessageTemplateDTO>>builder().data(
                page.convert(MessageTemplateConvertor.INSTANCE::toMessageTemplateDTO)).build();
    }

    @ApiOperation(value = "获取消息推送配置", httpMethod = "GET", response = ResponseDTO.class,
            tags = {"Push message configuration"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/push/{id}")
    public ResponseDTO<PushMessageConfigurationDTO> getPushMessage(@PathVariable Integer id) {
        return ResponseDTO.<PushMessageConfigurationDTO>builder().data(PushMessageConfigurationConvertor.INSTANCE.
                toMessageConfigurationDTO(pushMessageConfigurationService.getBaseMapper().selectById(id))).build();
    }

    @Transactional
    @ApiOperation(value = "删除消息推送配置", httpMethod = "DELETE", response = ResponseDTO.class,
            tags = {"Push message configuration"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("/push/{id}")
    public ResponseDTO<Integer> deletePushMessage(@PathVariable Integer id) {
        int data = pushMessageConfigurationService.getBaseMapper().deleteById(id);
        return ResponseDTO.<Integer>builder().data(data).build();
    }

    @Transactional
    @ApiOperation(value = "新增消息推送配置", httpMethod = "POST", response = ResponseDTO.class,
            tags = {"Push message configuration"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/push")
    public ResponseDTO<Integer> createPushMessage(@RequestBody PushMessageConfigurationDTO pushMessageConfigurationDTO) {
        int id = pushMessageConfigurationService.getBaseMapper().insert(
                PushMessageConfigurationConvertor.INSTANCE.toMessageConfiguration(pushMessageConfigurationDTO));
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @Transactional
    @ApiOperation(value = "编辑消息推送配置", httpMethod = "PUT", response = ResponseDTO.class,
            tags = {"Push message configuration"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("/push")
    public ResponseDTO<Integer> updatePushMessage(@RequestBody PushMessageConfigurationDTO pushMessageConfigurationDTO) {
        UpdateWrapper<PushMessageConfiguration> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", pushMessageConfigurationDTO.getId());
        int id = pushMessageConfigurationService.getBaseMapper().update(
                PushMessageConfigurationConvertor.INSTANCE.toMessageConfiguration(pushMessageConfigurationDTO), wrapper);
        return ResponseDTO.<Integer>builder().data(id).build();
    }

    @ApiOperation(value = "列表消息推送配置", httpMethod = "GET", response = ResponseDTO.class,
            tags = {"Push message configuration"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/push/list")
    public ResponseDTO<IPage<PushMessageConfigurationDTO>> listPushMessage(@RequestBody PageRequestDTO pageRequestDTO) {
        Page<PushMessageConfiguration> page = new Page<>(pageRequestDTO.getPage(), pageRequestDTO.getSize());

        page = pushMessageConfigurationService.getBaseMapper().selectPage(page, new QueryWrapper<>());
        return ResponseDTO.<IPage<PushMessageConfigurationDTO>>builder().data(
                page.convert(PushMessageConfigurationConvertor.INSTANCE::toMessageConfigurationDTO)).build();
    }
}
