package com.example.demo.service;

import com.example.demo.model.Operation;
import com.example.demo.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    private final OperationRepository operationRepository;

    @Autowired
    public OperationService(OperationRepository operationRepository){
        this.operationRepository = operationRepository;
    }
    public Operation findById(Long id){
        return operationRepository.getOne(id);
    }
    public List<Operation> findAll(){
        return operationRepository.findAll();
    }
    public Operation saveOperation(Operation operation){
        return operationRepository.save(operation);
    }
    public void deleteById(Long id){
        operationRepository.deleteById(id);
    }

}
