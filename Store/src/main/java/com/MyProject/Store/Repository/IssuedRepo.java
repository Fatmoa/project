package com.MyProject.Store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MyProject.Store.Models.Issued;

public interface IssuedRepo extends JpaRepository<Issued, Integer>{
    
}
