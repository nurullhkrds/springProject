package com.example.eshopp2.core.utilities.mappers;

import io.swagger.models.Model;
import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
