package com.allenlogo.task.controller;

import com.allenlogo.task.service.TestService;
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

    @GetMapping(value = "/addTask")
    @ApiOperation(value = "添加Task",httpMethod = "GET",notes = "")
    @ApiImplicitParams({@ApiImplicitParam(name = "taskId",value = "任务ID",required = true)})
    public MessageResponse addTask(@RequestParam(name = "taskId") String taskId) {
        try {
            testService.addTask(taskId);
        }catch (Exception e){
            log.error(" TestController -> addTask Exception",e);
            return super.handleException(e);
        }
        return new MessageResponse();
    }
}
