package sg.gov.dev.csit.pcrmspcr.controller;

import sg.gov.dev.csit.pcrmspcr.model.Taskee;
import sg.gov.dev.csit.pcrmspcr.repository.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
public class AccountManagementController {

    @Autowired
    TaskeeRepository taskeeRepository;


}