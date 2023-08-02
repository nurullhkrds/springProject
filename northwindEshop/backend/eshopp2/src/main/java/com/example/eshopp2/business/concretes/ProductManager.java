package com.example.eshopp2.business.concretes;

import com.example.eshopp2.business.abstracts.ProductService;
import com.example.eshopp2.business.requests.CreateProductRequest;
import com.example.eshopp2.business.requests.UpdateProductRequest;
import com.example.eshopp2.business.responses.GetAllProductsResponse;
import com.example.eshopp2.business.rules.ProductRules;
import com.example.eshopp2.core.utilities.mappers.ModelMapperService;
import com.example.eshopp2.core.utilities.results.DataResult;
import com.example.eshopp2.core.utilities.results.Result;
import com.example.eshopp2.core.utilities.results.SuccessDataResult;
import com.example.eshopp2.core.utilities.results.SuccessResult;
import com.example.eshopp2.dataAccess.abstracts.ProductDao;
import com.example.eshopp2.entities.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@NoArgsConstructor
@Service //Buradaki Service bizim bussines katmanımızdaki görevi üstlenecek.
//Yani dicek ki ben arkada productmanager nesnesini üretirim sen kafana göre takıl IOC.
public class ProductManager implements ProductService {
    private ProductDao productDao;
    private ModelMapperService modelMapperService;
    private ProductRules productRules;

    @Autowired
    public ProductManager(ProductDao productDao, ModelMapperService modelMapperService, ProductRules productRules) {
        this.productDao = productDao;
        this.modelMapperService = modelMapperService;
        this.productRules = productRules;
    }


    //Data acces tarafındaki DAO'ya erişmemiz lazım
    //bu yüzden productDao diye bir şey oluşturduk...

    /*
    @Autowired //Arkada hangi product olduğunu belirler.//Genellikle bir bağımlılık oluşturur.
    public ProductManager(ProductDao productDao,ModelMapperService modelMapperService,ProductBussinesRules productBussinesRules){

        this.productDao=productDao;
        this.modelMapperService=modelMapperService;
        this.productBussinesRules=productBussinesRules;
    }

     */
    @Override
    public DataResult<List<GetAllProductsResponse>> getAll() {

        List<Product> products=productDao.findAll();//önce products listesi olşturup veri tabanındakileri
        // buraya attık .


/*       List<GetAllProductsResponse> responseProducts=new ArrayList<>();//Boş bi GetALlProductResponse
        //tipinde bir listede oluşturduk..

        for (Product product:products){//oluşturdğmz products listesini gezip sırayla her producta bakarız.
            GetAllProductsResponse responseItem=new GetAllProductsResponse();//her döngüde GetAllProductResponse
            //tipinde bir nesne oluştururuz.

            responseItem.setProductName(product.getProductName());//olştrduğmz nesneye productun adını atar
            responseItem.setUnitPrice(product.getUnitPrice());//productun fiyatını atar
            responseProducts.add(responseItem);//iki özellikli nesnemizi şimdi yukarıda olşturduğumz
            //listeye atar...böylelikle sadeece name ve fiyatı gösteririrz kullanıcıya....

        }
        //Yukarıdaki kod çok uzun eklenen sayı 100 olursa 1000 olursa ne yapacağoz ?
        //bu yüzden modelMapper kullanıyoruz aşağıdaki gibi...
 */
        List<GetAllProductsResponse> responseProducts=products.stream()
                .map(product ->
                        this.modelMapperService
                        .forResponse().map(product,GetAllProductsResponse.class)).collect(Collectors.toList());


        return new SuccessDataResult<List<GetAllProductsResponse>>(responseProducts,"Data getirildi");

    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(CreateProductRequest createProductRequest) {
        productRules.CheckIfProductNameExists(createProductRequest.getProductName());
        Product product=this.modelMapperService.forRequest().map(createProductRequest,Product.class);
        this.productDao.save(product);
        return new Result(true);
    }

    @Override
    public Result update(UpdateProductRequest updateProductRequest) {
        Product product=this.modelMapperService.forRequest().map(updateProductRequest,Product.class);
        this.productDao.save(product);
        return new Result(true,"Data Güncellendi");
    }


    @Override
    public Result delete(int id) {
        this.productDao.deleteById(id);
        return new Result(true,"Data silindi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data Getirildi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Getirildi");
    }


/*


    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return null;
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return null;
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return null;
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return null;
    }

     */


}
