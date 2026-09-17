package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.member;
import com.example.repository.memberrepository;

@Service
public class memberservice {

    private final memberrepository repository;

    public memberservice(memberrepository repository) {
        this.repository = repository;
    }

    public List<member> getAllMembers() {
        return repository.findAll();
    }

    public member addMember(member member) {
        return repository.save(member);
    }

    public member getMemberById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public member updateMember(Long id, member updatedMember) {
        member existingMember = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        existingMember.setName(updatedMember.getName());
        existingMember.setMail(updatedMember.getMail());
        existingMember.setPhonenumber(updatedMember.getPhonenumber());

        return repository.save(existingMember);
    }

    public void deleteMember(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Member not found");
        }

        repository.deleteById(id);
    }
}