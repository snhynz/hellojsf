package com.example.hellojsf;


//Product crud işlemleri
//product model id, serinum, name, price

import com.example.hellojsf.model.Product;
import com.example.hellojsf.model.User;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
@SessionScoped
@ManagedBean
public class ProductBean {

    private Product product;

    private List<Product> productList;

    @PostConstruct
    public void init(){
       product = new Product();
       productList = new ArrayList<>();
    }

    public void addProduct(){
        productList.add(product);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Başarılı",  "Data Eklendi") );
        product= new Product();
    }
    public void clearProduct(){
        product = new Product();
    }
    public void editProduct(){
        /*Product editProduct = productList.stream()
                .filter(product1 ->product1.getModelId()== product.getModelId())
                .findFirst().get();
        productList.remove(editProduct);
        productList.add(product);*/
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Başarılı",  "Data Güncellendi") );
        product = new Product();
    }

    public void selectForEdit(Product editProduct){
        product=editProduct;
    }

    public void deleteproduct(Product deleteproduct){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Başarılı",  "Data Silindi") );
        productList.remove(deleteproduct);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
