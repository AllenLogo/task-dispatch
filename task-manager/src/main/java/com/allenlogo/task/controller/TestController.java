package com.allenlogo.task.controller;

import com.allenlogo.task.service.TestService;
import com.allenlogo.task.vo.request.TaskChangeRequest;
import com.allenlogo.task.vo.request.TaskRequest;
import com.allenlogo.task.vo.request.TestRequest;
import com.allenlogo.task.vo.response.MessageResponse;
import com.allenlogo.task.vo.response.TestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 测试用controller
 */
@RestController
@RequestMapping("test/v2")
@Api(description = "测试")
@Slf4j
public class TestController extends BaseController {
    @Autowired
    private TestService testService;

    @GetMapping(value = "/testGET")
    @ApiOperation(value = "测试接口-GET",httpMethod = "GET",notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "test",value = "测试参数",required = true)})
    public MessageResponse<String> testGET(@RequestParam("test")String test){
        return new MessageResponse<>(test);
    }

    @PostMapping(value = "/testPOST")
    @ApiOperation(value = "测试接口-POST",httpMethod = "POST", notes = "")
    public MessageResponse<TestResponse> testPOST(@RequestBody @Validated TestRequest test, BindingResult result){
        if (result.hasErrors()) {
            return parseErrors(result);
        }
        TestResponse testResponse = new TestResponse();
        testResponse.setTest(test.getTest());
        return new MessageResponse<>(testResponse);
    }

    @PostMapping(value = "/addTask")
    @ApiOperation(value = "添加Task",httpMethod = "POST",notes = "")
    public MessageResponse addTask(@RequestBody TaskRequest taskRequest, BindingResult result){
        if (result.hasErrors()) {
            return parseErrors(result);
        }
        try {
            testService.addTask(taskRequest);
        }catch (Exception e){
            log.error(" TestController -> addTask Exception",e);
            return super.handleException(e);
        }
        return new MessageResponse();
    }

    @PostMapping(value = "/removeTask")
    @ApiOperation(value = "删除Task",httpMethod = "POST",notes = "")
    public MessageResponse removeTask(@RequestBody TaskRequest taskRequest, BindingResult result){
        if (result.hasErrors()) {
            return parseErrors(result);
        }
        try {
            testService.removeTask(taskRequest);
        }catch (Exception e){
            log.error(" TestController -> removeTask Exception",e);
            return super.handleException(e);
        }
        return new MessageResponse();
    }

    @PostMapping(value = "/changeTask")
    @ApiOperation(value = "修改Task",httpMethod = "POST",notes = "")
    public MessageResponse changeTask(@RequestBody TaskChangeRequest taskChangeRequest, BindingResult result){
        if (result.hasErrors()) {
            return parseErrors(result);
        }
        try {
            testService.changeTask(taskChangeRequest);
        }catch (Exception e){
            log.error(" TestController -> removeTask Exception",e);
            return super.handleException(e);
        }
        return new MessageResponse();
    }

    @GetMapping(value = "/getTask")
    @ApiOperation(value = "获取Task",httpMethod = "GET",notes = "")
    public MessageResponse getTask() {
        try {
            testService.getActiveJob();
        }catch (Exception e){
            log.error(" TestController -> getTask Exception",e);
            return super.handleException(e);
        }
        return new MessageResponse();
    }

    @GetMapping(value = "/addTaskInfo")
    @ApiOperation(value = "新增TaskInfo",httpMethod = "GET",notes = "")
    public MessageResponse addTaskInfo(@RequestParam("name")String name) {
        try {
            testService.addTaskInfo(name);
        }catch (Exception e){
            log.error(" TestController -> addTaskInfo Exception",e);
            return super.handleException(e);
        }
        return new MessageResponse();
    }

    @GetMapping(value = "/selectTaskInfo")
    @ApiOperation(value = "新增TaskInfo",httpMethod = "GET",notes = "")
    public MessageResponse selectTaskInfo(@RequestParam("guid")Integer guid) {
        try {
            testService.selectTaskInfo(guid);
        }catch (Exception e){
            log.error(" TestController -> addTaskInfo Exception",e);
            return super.handleException(e);
        }
        return new MessageResponse();
    }

}
