package com.seminario.apiVision.controllers;

import com.google.protobuf.compiler.PluginProtos;
import com.seminario.apiVision.models.ApiVisionRequest;
import com.seminario.apiVision.models.Url;
import com.seminario.apiVision.services.ApiVisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/apiVision")
@CrossOrigin(origins = "*" , methods = {RequestMethod.GET, RequestMethod.POST})
public class ApiVisionController {
    @Autowired
    private ApiVisionService apiVisionService;

    @PostMapping("getRequest")
    public List<ApiVisionRequest> apiVisionRequest(@RequestBody final Url url) {
        System.out.println("HOla");
        return apiVisionService.apiVisionRequests(url);
    }
}
