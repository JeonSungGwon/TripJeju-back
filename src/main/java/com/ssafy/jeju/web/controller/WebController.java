package com.ssafy.jeju.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/map")
    public String mapView() {
        return "jejumap";
    }

    @GetMapping("/cal")
    public String calView() {
        return "calmap";
    }
}
