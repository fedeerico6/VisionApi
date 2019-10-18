package com.seminario.apiVision.controllers;

import com.seminario.apiVision.models.ApiVisionRequest;
import com.seminario.apiVision.models.Url;
import com.seminario.apiVision.services.ApiVisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiVision")
public class ApiVisionController {
    @Autowired
    private ApiVisionService apiVisionService;

    @PostMapping("getRequest")
    public List<ApiVisionRequest> apiVisionRequest(@RequestBody final Url url) {
        return apiVisionService.apiVisionRequests(url);
    }

}
