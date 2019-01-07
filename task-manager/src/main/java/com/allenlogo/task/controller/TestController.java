package com.allenlogo.task.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test/v2")
@Api(description = "测试")
public class TestController {

    @GetMapping(value = "/test")
    @ApiOperation(value = "测试接口",httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "test",value = "测试参数",required = true)})
    public String test(@RequestParam("test")String test){
        return test;
    }
}
