package com.MyProject.Store.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyProject.Store.Models.Issued;
import com.MyProject.Store.Repository.IssuedRepo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/is")
@CrossOrigin
public class IssuedCont {
    @Autowired
    public IssuedRepo issuedRepo;
    
    @PostMapping("/issued")
    public  ResponseEntity <Issued> newIssue(@RequestBody Issued issues) {
        Issued newIssue = issuedRepo.save(issues);
        return new ResponseEntity<Issued>(newIssue,HttpStatus.OK);
    }    

    @GetMapping("/issued")
    public ResponseEntity<List<Issued>> getAll(){
        List<Issued> issues = issuedRepo.findAll();
        return new ResponseEntity<>(issues, HttpStatus.OK);
     }

    
    @GetMapping("/issued/{id}")
    public ResponseEntity<Issued> getItemsById(@PathVariable("id") int id) {
        Optional<Issued> issues = issuedRepo.findById(id);
        return new ResponseEntity<>(issues.get(),HttpStatus.OK);
        
    }

    @DeleteMapping("/issued/{id}")
     public ResponseEntity<String> delete(@PathVariable("id") int id){
        issuedRepo.deleteById(id);
        return new ResponseEntity<String>("Isued deleted",HttpStatus.OK);
    }

    // @PutMapping("/issued/{id}")
    // public ResponseEntity<Issued> update(@PathVariable("id") int id, @RequestBody Issued issue){
    //     issue.getId();
    //     Issued issues=issuedRepo.findById(issue.getId()).get();
    //     issues.setItem_name(issue.getItem_name());
    //     issues.setQnty(issue.getQnty());
    //     issues.setResponsive(issue.getResponsive());
    //     issues.setRole(issue.getRole());
    //     Issued updatIssued = issuedRepo.save(issues);
    //     return new ResponseEntity<>(updatIssued,HttpStatus.OK);
    // }

      //Update ById
     @PutMapping("/issued/{id}")
     public ResponseEntity<Issued> update(@PathVariable("id") int id, @RequestBody Issued issued){
         issued.setId(id);
        Issued extingIssued = issuedRepo.findById(issued.getId()).get();
        extingIssued.setItem_name(issued.getItem_name());
        extingIssued.setQnty(issued.getQnty());
        extingIssued.setResponsive(issued.getResponsive());
        extingIssued.setRole(issued.getRole());
        Issued updateIssued =issuedRepo.save(extingIssued);
        return new ResponseEntity<>(updateIssued,HttpStatus.OK);
     }
}
