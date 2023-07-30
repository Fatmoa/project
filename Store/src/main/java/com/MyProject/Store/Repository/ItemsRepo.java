package com.MyProject.Store.Repository;

// import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;
import com.MyProject.Store.Models.Items;

public interface ItemsRepo extends JpaRepository<Items, Integer> {
    @Query (value = "select * from items_received where item_name LIKE ?1% ;",nativeQuery = true)
    List<Items> getItemsForNames(String name);
    
    @Query (value = "select sum(qty) from items_received ;",nativeQuery = true)
    int countItemsQuantity();


      @Query (value = "select count(*) from items_received ;",nativeQuery = true)
    int countItems();
    
}














































 
