package com.MyProject.Store.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyProject.Store.Models.Items;
import com.MyProject.Store.Repository.ItemsRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/it")

public class ItemsCont {
    @Autowired
    public ItemsRepo itemsRepo;



    @PostMapping("/items")
    public ResponseEntity <Items> newItems(@RequestBody  Items items){
        Items newItems = itemsRepo.save(items);
        return new ResponseEntity<Items>(newItems,HttpStatus.CREATED);
    }

    //count items
    @GetMapping("/countItems")
     public int countItems(){
        int items = itemsRepo.countItems();
        return items;
      }
    

    @GetMapping("/items")
    public ResponseEntity<List<Items>> getAll(){
         List<Items> items = itemsRepo.findAll();
         return new ResponseEntity<>(items, HttpStatus.OK);
     }

     //Get byName
    @GetMapping("/items/search/{name}")
    public ResponseEntity<List<Items>> getAllBySearch(@PathVariable("name") String name){
         List<Items> items = itemsRepo.getItemsForNames(name);
         return new ResponseEntity<>(items, HttpStatus.OK);
     }




    @GetMapping("/items/{id}")
    public ResponseEntity<Items> getItemsById(@PathVariable("id") int id) {
        Optional<Items> items = itemsRepo.findById(id);
        return new ResponseEntity<>(items.get(),HttpStatus.OK);
        
    }

 
    //Sum items
     @GetMapping("/items/c")
     public int countItemsQt(){
        int itemCount = itemsRepo.countItemsQuantity();
        return itemCount;
      }


    // // Delete ById
     @DeleteMapping("/items/{id}")
     public ResponseEntity<String> delete(@PathVariable("id") int id){
     itemsRepo.deleteById(id);
      return new ResponseEntity<String>("Item deleted",HttpStatus.NO_CONTENT);
     }



    //Update ById
     @PutMapping("/items/{id}")
     public ResponseEntity<Items> update(@PathVariable("id") int id, @RequestBody Items items){
         items.setId(id);
        Items extingItems = itemsRepo.findById(items.getId()).get();
        extingItems.setItem_name(items.getItem_name());
        extingItems.setReceived(items.getReceived());
        extingItems.setQty(items.getQty());
        Items updateItems= itemsRepo.save(extingItems);
        return new ResponseEntity<>(updateItems,HttpStatus.OK);
     }
        // @DeleteMapping("/delete/{id}")
    // public ResponseEntity<String> deleteItem(@PathVariable("id") int id){
    //     itemsRepo.deleteById(id);
    //     return new ResponseEntity<String>("Item deleted", HttpStatus.OK);
    // }
        // @PostMapping("/")
    // public ResponseEntity <Items> newItems(@RequestBody  Items items){
    //     Items newItems = itemsRepo.save(new Items());
    //     return new ResponseEntity<Items>(newItems,HttpStatus.CREATED);
    // }
    // @GetMapping("")
    // public ResponseEntity<List<Items>> getAll(){
    //     List<Items> items = itemsRepo.findAll();
    //     return new ResponseEntity<List<Items>>(items, HttpStatus.OK);
    // }

 

 


}




















 