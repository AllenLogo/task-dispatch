package com.allenlogo.task.controller;

import com.allenlogo.task.service.TaskInfoService;
import com.allenlogo.task.vo.request.TIQutaAddReq;
import com.allenlogo.task.vo.request.TITimingAddReq;
import com.allenlogo.task.vo.response.MessageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author allenlogo
 * @Date 2019/1/13
 * @Time 23:01
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("taskinfo/v2")
@Api(description = "任务信息管理相关接口")
@Slf4j
public class TaskInfoController extends BaseController {

    @Autowired
    private TaskInfoService taskInfoService;

    @PostMapping(value = "/addTaskInfoQuta")
    @ApiOperation(value = "新增定时任务信息",httpMethod = "POST",notes = "")
    public MessageResponse addTaskInfoQuta(@RequestBody TIQutaAddReq tiQutaAddReq, BindingResult result){
        if (result.hasErrors()) {
            return parseErrors(result);
        }
        try {
            taskInfoService.addTashInfo(tiQutaAddReq);
        }catch (Exception e){
            log.error(" addTaskInfoQuta -> Exception",e);
            return super.handleException(e);
        }
        return new MessageResponse();
    }

    @PostMapping(value = "/addTaskInfoTiming")
    @ApiOperation(value = "新增定时任务信息",httpMethod = "POST",notes = "")
    public MessageResponse addTaskInfoTiming(@RequestBody TITimingAddReq tiTimingAddReq, BindingResult result){
        if (result.hasErrors()) {
            return parseErrors(result);
        }
        try {
            taskInfoService.addTashInfo(tiTimingAddReq);
        }catch (Exception e){
            log.error(" addTaskInfoTiming -> Exception",e);
            return super.handleException(e);
        }
        return new MessageResponse();
    }

}
