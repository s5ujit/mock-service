package com.appliedsni.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/rest/")
public class AMLController {
    @GetMapping(value="aml")
    public   String hello() {
		return "scusess";
    }
}
