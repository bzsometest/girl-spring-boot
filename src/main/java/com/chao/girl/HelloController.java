package com.chao.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = {"/say", "/hi"}, method = RequestMethod.GET)
    public GirlProperties say() {
        return girlProperties;
    }

    @RequestMapping(value = {"/{id}/say"}, method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id) {
        return "id=" + id;
    }

    @RequestMapping(value = {"/saym"}, method = RequestMethod.GET)
    public String say2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id=" + id;
    }

    @GetMapping(value = {"/saym2"})
    public String say2(@RequestParam("name") String name) {
        return "name=" + name;
    }
    @PostMapping(value = {"/saym2"})
    public String say3(@RequestParam("name") String name) {
        return "name=" + name;
    }
}
