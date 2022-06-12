package com.example.ihack.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ihack.model.*;


public interface ResumeRepository extends JpaRepository<Resume,Integer>{
List<Resume> findByUser(String user);

}
