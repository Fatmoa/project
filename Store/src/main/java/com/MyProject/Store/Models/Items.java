package com.MyProject.Store.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Items_Received")

public class Items {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String item_name;
private String received;
private int qty;

}

// public Items(){ 

// }
// public Items(int id,String item_name,String received,int qty){
//     this.id = id;
//     this.item_name = item_name;
//     this.received= received;
//     this.qty = qty;
// } 
// public int getId() {
//     return id;
// }
// public void setId(int id) {
//     this.id = id;
// }
// public String getItem_name() {
//     return item_name;
// }
// public void setItem_name(String item_name) {
//     this.item_name = item_name;
// }
// public String getReceived() {
//     return received;
// }
// public void setReceived(String received) {
//     this.received = received;
// }
// public int getQty() {
//     return qty;
// }
// public void setQty(int qty) {
//     this.qty = qty;
// }

