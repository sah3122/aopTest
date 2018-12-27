package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImplement implements DemoService{
    private DemoMapper demoMapper;

    @Autowired
    DemoServiceImplement(DemoMapper demoMapper) {
        this.demoMapper = demoMapper;
    }

    @Override
    public Map<String, Object> getDemoTest(){
        return demoMapper.getDemo();
    }

    @Override
    public int insertDemo() {
        return demoMapper.insertDemo();
    }
}
