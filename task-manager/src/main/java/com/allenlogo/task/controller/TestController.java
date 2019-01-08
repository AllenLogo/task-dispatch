package com.allenlogo.task.controller;

import com.allenlogo.task.vo.request.TestRequest;
import com.allenlogo.task.vo.response.MessageResponse;
import com.allenlogo.task.vo.response.TestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test/v2")
@Api(description = "测试")
public class TestController extends BaseController {

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
}
