package org.trutlesltd.mid_practice_product_shop_database;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping("/add")
    public String submit(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("isUpdate", false);
            return "form";
        }

        productService.saveProduct(product);

        log.info("Product {} hase been saved", product);

        return "redirect:/product/add";

    }

    @GetMapping("/list")
    public String showlist(Model model){
        model.addAttribute("products", productService.findAllProduct());
        return "list";
    }

    @GetMapping("/list/remove/{id}")
    public String remove(@PathVariable Long id){
        productService.deleteProductById(id);

        return "redirect:/product/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){

        Product product = productService.findProductById(id);

        model.addAttribute("product", product);
        model.addAttribute("isUpdate", true);
        return "form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute Product product, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("isUpdate", true);
            return "form";
        }

        productService.updateProduct(id, product);

        return "redirect:/product/list";
    }


}
