package com.example.Engineer.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Engineer.entity.Engineer;

public interface EngineerRepository extends JpaRepository<Engineer, Integer>{




}
