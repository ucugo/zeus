package com.mahull.zeus.controller.advert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/")
public class AdvertController {

    private final HttpServletRequest request;

    @Autowired
    public AdvertController(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping(path = "/pubId/{pubId}")
    public String handle(@PathVariable(value = "pubId") String pubId) {
        return "OK";
    }
}
