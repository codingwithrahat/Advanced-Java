package org.trutlesltd.practicemidproductshop;

import jakarta.validation.Valid;
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
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping("/add")
    public String submit(@Valid @ModelAttribute Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }

        products.add(product);
        log.info("Product {} hase been saved", product);


        return "redirect:/product/add";

    }

    @GetMapping("/list")
    public String showlist(Model model){
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/list/remove/{id}")
    public String remove(@PathVariable String id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.remove(i);
                break;
            }
        }

        log.info("Product with ID {} removed", id);

        return "redirect:/product/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable String id, Model model){
        Product product = null;

        for(int i = 0; i<products.size(); i++){
            if(products.get(i).getId().equals(id)){
                product = products.get(i);
            }
        }

        model.addAttribute("product", product);
        model.addAttribute("isUpdate", true);
        return "form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable String id, @Valid @ModelAttribute Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }


        for(int i = 0; i<products.size(); i++){
            if(products.get(i).getId().equals(id)){
                products.set(i, product);
                break;
            }
        }

        return "redirect:/product/list";
    }


}
