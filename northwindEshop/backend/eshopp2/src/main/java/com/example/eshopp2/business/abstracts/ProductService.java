package com.example.eshopp2.business.abstracts;

import com.example.eshopp2.business.requests.CreateProductRequest;
import com.example.eshopp2.business.requests.UpdateProductRequest;
import com.example.eshopp2.business.responses.GetAllProductsResponse;
import com.example.eshopp2.core.utilities.results.DataResult;
import com.example.eshopp2.core.utilities.results.Result;
import com.example.eshopp2.entities.concretes.Product;

import javax.xml.crypto.Data;
import java.util.List;

public interface ProductService {

    DataResult<List<GetAllProductsResponse>> getAll();
    DataResult<List<Product>> getAll(int pageNo,int pageSize);

    Result add(CreateProductRequest createProductRequest);
    Result update(UpdateProductRequest updateProductRequest);
    Result delete(int id);

    DataResult<Product>getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName,int categoryId);
    /*
    DataResult<List<Product>>getByProductNameOrCategory (String productName ,int categoryId);
    DataResult<List<Product>>getByCategoryIn(List<Integer>categories);
    DataResult<List<Product>>getByProductNameContains(String productName);
    DataResult<List<Product>>getByProductNameStartsWith(String productName);

     */


}
