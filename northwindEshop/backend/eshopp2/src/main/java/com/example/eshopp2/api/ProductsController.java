package com.example.eshopp2.api;

import com.example.eshopp2.business.abstracts.ProductService;
import com.example.eshopp2.business.requests.CreateProductRequest;
import com.example.eshopp2.business.requests.UpdateProductRequest;
import com.example.eshopp2.business.responses.GetAllProductsResponse;
import com.example.eshopp2.core.utilities.results.DataResult;
import com.example.eshopp2.core.utilities.results.Result;
import com.example.eshopp2.core.utilities.results.SuccessDataResult;
import com.example.eshopp2.entities.concretes.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // sen bir kontrol elemanısın anlanında getirir.
@RequestMapping("/api/products") // böyle bir urlden istek gelirse bu class karşılayacak anlamında gelir...
public class ProductsController {//Product için diğer uygulamalarla anlaşsın diye bir kontrol sınıfı...


    private ProductService productService; //Apide oldğumuz için bussinesle ileişime geçeceğiz o yüzden onun
    // interfacesini çağırıyoruz (zayıf bağımlılık  yaratmak şart tabi :))...

    @Autowired // bu da önceki bilgilere dahil artı olarak bizim yerimize new yapar
    public ProductsController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/getall")
// /api/product/getall diye bi istek gelirse bu verileri gönderir.
    public DataResult<List<GetAllProductsResponse>> getAll(){
        return new SuccessDataResult<List<GetAllProductsResponse>>(this.productService.getAll().getData(),"Data Getirildi");

    }

    //Requestbody notasyonu arkada dolaşır product nesnesini bulur ve senin
    // productun budur der ve sana verir //postmapping ise eklemeyi yapar.
    @ResponseStatus(code = HttpStatus.CREATED) //bir nesne oluşturduğunu bildirir
    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateProductRequest createProductRequest){

        this.productService.add(createProductRequest);
        return new Result(true,"Data Eklendi");

    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        //RequestParam RequesBody gibidir ama farkı r.body nesne ararken param parametre arar.

        return new SuccessDataResult<Product>(this.productService.getByProductName(productName).getData(),"Data Getirildi");
    }

    @GetMapping("/getByProductNameAndCategory_CategoryId")
    public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam(name = "productName") String productName, @RequestParam(name = "categoryId")int categoryId) {
        return this.getByProductNameAndCategory_CategoryId(productName,categoryId);
    }

    @GetMapping("/getAllPage")
    public DataResult< List<Product>> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
        return this.productService.getAll(pageNo,pageSize);
    }

    @PutMapping("/update")
    public Result updatee(@RequestBody UpdateProductRequest updateProductRequest){

        return this.productService.update(updateProductRequest);

    }

    @DeleteMapping("/delete")
    public Result deletee(@RequestParam int id){

        return this.productService.delete(id);

    }




}
