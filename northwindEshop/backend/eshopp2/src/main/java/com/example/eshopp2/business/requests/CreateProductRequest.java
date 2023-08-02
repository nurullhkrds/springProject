package com.example.eshopp2.business.requests;


import com.example.eshopp2.entities.concretes.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    @NotNull
    @NotBlank
    @Size(min = 5,max = 20)
    private String productName;

    private int category_id;
    private double unitPrice;
    private short unitsInStock;

}
