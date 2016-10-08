/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstocktrader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author HP
 */
@Controller
 
public class TestController {
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "/index.jsp";
    }
    
}
