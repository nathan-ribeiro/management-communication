package com.management.managementorder.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private CompanyDTO company;
    private List<ProductDTO> products;


}
