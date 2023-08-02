package com.example.eshopp2.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity //Entity demek sen veri tabanı nesnesisin demektir.
//burada normalde bir sınıfı implement etmemiz gerekirdi.//sahipsiz sınıf olmaz SOLİD Prensibi gereği
@Table(name="products") //hangi tabloya denk geldiğini gösterir buda.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    @GeneratedValue(strategy = GenerationType.IDENTITY)//id'nin birer birer artmasını belirtir.
    @Id//Primary key olduğunu söyleriz yani java bu id'ye göre işlemler yapar
    @Column(name="product_id")// hangi colona denk geldiği...
    private int id;

    @Column(name="product_name")
    private String productName;


    @Column(name="unit_price")
    private double unitPrice;
    @Column(name="units_in_stock")
    private short unitsInStock;
    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
