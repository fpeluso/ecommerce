package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DemoService {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    RequestRepositoryImpl requestRepositoryImpl;

    public ResponseEntity<List<DemoEntityModel>> getEntity(String field1){
        List<DemoEntityModel> models = new ArrayList<>();
//        models.addAll(requestRepository.findAllByField1(field1));
        models.addAll(requestRepositoryImpl.findAll());
        System.out.println(models.size());
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    public int createEntity(DemoEntityModel demoEntityModel){
        requestRepository.save(demoEntityModel);
        return 0;
    }

    public int updateField1(String field1, int version){
        return requestRepository.updateField1(field1,version);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public DemoEntityModel incrementAmount(UUID id, int amount) {
        DemoEntityModel item = requestRepository.getDemoEntityModelAndObtainPessimisticWriteLockingOnItById(id);
        item.setAmount(item.getAmount() + amount);
        return item;
    }
}
