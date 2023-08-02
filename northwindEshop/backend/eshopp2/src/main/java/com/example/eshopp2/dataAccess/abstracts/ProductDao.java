package com.example.eshopp2.dataAccess.abstracts;

import com.example.eshopp2.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProductDao extends JpaRepository<Product,Integer> {
    //Yukarıdaki extends JPAyı baz alır ve Product tipinde integer idli üzerinden işlem yapar.


    //Sql sorgusu yapar Product ismine göre product nesnesi getirir.
    Product getByProductName(String productName);
    Product getProductsByProductName(String productName);

    boolean existsByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    /*
    List<Product>getByProductNameOrCategory (String productName ,int categoryId);
    List<Product>getByCategoryIn(List<Integer>categories);
    List<Product>getByProductNameContains(String productName);
    List<Product>getByProductNameStartsWith(String productName);


    //Product getByProductNameAndCategory_CategoryId()

     */

    /*
    @Query(value = "select new com.example.eshopp2.entities.dtos.ProductWithCategoryDto"
            +" (p.id,p.productName)"
            +"from Product p)
    List<ProductWithCategoryDto>getProductWithCategoryDetails();


     */

}
