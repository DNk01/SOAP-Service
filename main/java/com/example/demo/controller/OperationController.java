package com.example.demo.controller;

import com.example.demo.model.Operation;
import com.example.demo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OperationController {

    private final OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService){
        this.operationService = operationService;
    }

    @GetMapping("")
    public String listOfActions(){
        return "actions";
    }

    @GetMapping("/operations")
    public String findAll(Model model){
        List<Operation> operation = operationService.findAll();
        model.addAttribute("operation", operation);
        return "operation-list";
    }

    @GetMapping("/operation-create")
    public String createOperationForm(Operation user){
        return "operation-create";
    }

    @PostMapping("/operation-create")
    public String createOperation(Operation operation){
        if (operation.getSum() == 0 || operation.getWrite_off() == "" || operation.getWrite_on() == "")
            return "redirect:";
        operationService.saveOperation(operation);
        return "redirect:/operations";
    }

    @GetMapping("operation-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        operationService.deleteById(id);
        return "redirect:/operations";
    }

    @GetMapping("operation-about/{id}")
    public String aboutUserForm(@PathVariable("id") Long id, Model model){
        Operation operation = operationService.findById(id);
        model.addAttribute("operation", operation);
        return "operation-Id";
    }

    @GetMapping("operation-update/{id}")
    public String updateOperationForm(@PathVariable("id") Long id, Model model){
        Operation operation = operationService.findById(id);
        model.addAttribute("operation", operation);
        return "operation-update";
    }

    @PostMapping("/operation-update")
    public String updateOperation(Operation operation){
        operationService.saveOperation(operation);
        return "redirect:/operations";
    }
}
