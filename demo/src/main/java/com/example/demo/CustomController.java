package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomController {

    @Autowired
    DemoService demoService;

    @GetMapping("/{field1}")
    public ResponseEntity<List<DemoEntityModel>> getProductById(@PathVariable("field1") String field1) {
        return demoService.getEntity(field1);
    }

    @PostMapping
    public int updateDemoField1(@RequestBody DemoEntityModel demoEntityModel) {
        return demoService.updateField1(demoEntityModel.getField1(),demoEntityModel.getVersion());
    }

    @PostMapping("/add")
    public @ResponseBody String addEntity(@RequestBody DemoEntityModel demoEntityModel){
        DemoEntityModel entity = new DemoEntityModel();
        entity.setField1(demoEntityModel.getField1());
        entity.setVersion(demoEntityModel.getVersion());
        demoService.createEntity(entity);
        return "OK";
    }
}
