package com.betterworldbook.fakebook.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Books{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  Long id;
   private String name;
    private  String sku;
    private  String description;
    private  Double price;
    private  Integer inStock;
    private String image;

 public Books() {
 }

 @ManyToOne
    @JoinColumn(name = "category_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;


 public Books(Long id) {
  this.id = id;
 }

 public Category getCategory() {
  return category;
 }

 public void setCategory(Category category) {
  this.category = category;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getSku() {
  return sku;
 }

 public void setSku(String sku) {
  this.sku = sku;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public Double getPrice() {
  return price;
 }

 public void setPrice(Double price) {
  this.price = price;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long categoryId) {
  this.id = id;
 }

 public Integer getInStock() {
  return inStock;
 }

 public void setInStock(Integer amtAvailableInStock) {
  this.inStock = amtAvailableInStock;
 }

 public String getImage() {
  return image;
 }

 public void setImage(String image) {
  this.image = image;
 }

 @Override
 public String toString() {
  return "Books{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", sku='" + sku + '\'' +
          ", description='" + description + '\'' +
          ", price=" + price +
          ", inStock=" + inStock +
          ", image='" + image + '\'' +
          ", category=" + category +
          '}';
 }
}
