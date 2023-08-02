package com.example.eshopp2.business.rules;

import com.example.eshopp2.core.utilities.exception.BussinesException;
import com.example.eshopp2.dataAccess.abstracts.ProductDao;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ProductRules {


    ProductDao productDao;
    @Autowired
    public ProductRules(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void CheckIfProductNameExists(String productName){
        if (this.productDao.existsByProductName(productName)){
            throw new BussinesException("Böyle bir isim zaten mevcut!!");
            }

    }
}
