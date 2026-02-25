package com.example.complaint.controller;

import com.example.complaint.model.Complaint;
import com.example.complaint.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComplaintController {

    @Autowired
    private ComplaintRepository repository;

    @GetMapping("/")
    public String showForm() {
        return "complaint-form";
    }

    @PostMapping("/submit")
    public String submitComplaint(@ModelAttribute Complaint complaint) {
        repository.save(complaint);
        return "success";
    }

    @GetMapping("/admin")
    public String viewAllComplaints(Model model) {
        List<Complaint> complaints = repository.findAll();
        model.addAttribute("complaints", complaints);
        return "admin";
    }
}