package com.youfan.control;

import com.youfan.model.ProductType;
import com.youfan.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductControl {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "/insert_product_type", method = RequestMethod.POST)
    public void insertProductType(ProductType productType) {
        productTypeService.insertProductType(productType);
    }

    @RequestMapping(value = "/findProductTypeById", method = RequestMethod.GET)
    public String findProductTypeById(Integer id, Model model) {
        ProductType productType = productTypeService.findProductTypeById(id);
        if (null == productType) {
            productType = new ProductType();
            productType.setId(-1);
        }
        model.addAttribute("productType", productType);
        return "product_type_add";
    }
}