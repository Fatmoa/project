package com.MyProject.Store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyProject.Store.Models.Items;

public interface ItemsRepo extends JpaRepository<Items, Integer> {
    
}
