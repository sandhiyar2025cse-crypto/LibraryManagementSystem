package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.member;
import com.example.services.memberservice;

@RestController
@RequestMapping("/members")
public class memberController {

    private final memberservice service;

    public memberController(memberservice service) {
        this.service = service;
    }

    @GetMapping
    public List<member> getAllMembers() {
        return service.getAllMembers();
    }

    @PostMapping
    public member addMember(@RequestBody member member) {
        return service.addMember(member);
    }

    @GetMapping("/{id}")
    public member getMember(@PathVariable Long id) {
        return service.getMemberById(id);
    }

    @PutMapping("/{id}")
    public member updateMember(@PathVariable Long id,
                               @RequestBody member updatedMember) {
        return service.updateMember(id, updatedMember);
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        service.deleteMember(id);
        return "Member deleted successfully";
    }
}