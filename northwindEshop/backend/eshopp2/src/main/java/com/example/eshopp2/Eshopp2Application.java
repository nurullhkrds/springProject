package com.example.eshopp2;

import com.example.eshopp2.core.utilities.exception.BussinesException;
import com.example.eshopp2.core.utilities.exception.ProblemDetails;
import com.example.eshopp2.core.utilities.exception.ValidationProblemDetail;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;


@EntityScan("com.example.eshopp2")
@Configuration
@EnableJpaRepositories("com.example.eshopp2")
@SpringBootApplication
@RestControllerAdvice //AOP bu ve hata detayını saklamamıza yardımcı olur
public class Eshopp2Application {

    public static void main(String[] args) {
        SpringApplication.run(Eshopp2Application.class, args);
    }

    @ExceptionHandler //AOP bu ve hata detayını saklamamıza yardımcı olur
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) //AOP bu ve hata detayını saklamamıza yardımcı olur
    // TABİ exceptionhanlder,responseStatus,RestcontrollerAdvice bu üçü beraber olmak zorunda.
    public ProblemDetails handleBussinesException(BussinesException bussinesException){
        //burada ptoblemdetails tipinde bir clas dönecek ve BussinesException hatası gelirse çalışacak.
        ProblemDetails problemDetails=new ProblemDetails();
        problemDetails.setMessage(bussinesException.getMessage());
        return problemDetails;
    }
    @ExceptionHandler //AOP bu ve hata detayını saklamamıza yardımcı olur
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) //AOP bu ve hata detayını saklamamıza yardımcı olur
    // TABİ exceptionhanlder,responseStatus,RestcontrollerAdvice bu üçü beraber olmak zorunda.
    public ValidationProblemDetail handleBussinesssException(MethodArgumentNotValidException methodArgumentNotValidException){
        //burada ptoblemdetails tipinde bir clas dönecek ve BussinesException hatası gelirse çalışacak.
        ValidationProblemDetail validationProblemDetail=new ValidationProblemDetail();
        validationProblemDetail.setMessage("VALİDASYON HATASI!");
        validationProblemDetail.setValidationError(new HashMap<String,String>());
        for (FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            validationProblemDetail.getValidationError().put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return validationProblemDetail;
    }



    @Bean //IOC ye atar referans tutar
    public ModelMapper getModelMapper(){
        return new ModelMapper();

    }




}
