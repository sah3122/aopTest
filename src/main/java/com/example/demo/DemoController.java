package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class DemoController {
    private DemoService demoService;

    @Autowired
    DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    public String aspectTest(@RequestParam(value = "game_id") String gameId,
                             @RequestParam(value = "search_type", required = false) Integer searchType,
                             @RequestParam(value = "search_value1", required = false) String searchValue1,
                             @RequestParam(value = "search_value2", required = false) String searchValue2,
                             @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                             @RequestParam(value = "count", required = false, defaultValue = "10") int count) {

        return null;
    }

    @GetMapping("demotest")
    public String aspectTest2() {
        Map<String, Object> test = demoService.getDemoTest();
        System.out.println(test);
        String demo = (String) test.get("TEST2");

        System.out.println(demo);
        return demo;
    }

    @PostMapping("insertDemo")
    public String insertTest() {
        int result = demoService.insertDemo();
        System.out.println(result);
        return null;
    }
}
