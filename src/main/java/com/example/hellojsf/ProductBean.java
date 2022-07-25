package com.example.hellojsf;


//Product crud işlemleri
//product model id, serinum, name, price

import com.example.hellojsf.model.Product;
import com.example.hellojsf.model.User;
import com.example.hellojsf.utils.MessageUtils;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
@SessionScoped
@ManagedBean
public class ProductBean {

    private Product product;

    private List<Product> productList;

    private Product selectedProduct;

    private Product selectedDropdownProduct;

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    private List<User> userList;

    private User selectedUser;

    @PostConstruct
    public void init(){
       product = new Product();
       productList = new ArrayList<>();
    }

    public void addProduct(){
        productList.add(product);
        product = new Product();
        MessageUtils.message(FacesMessage.SEVERITY_INFO, "Başarılı", "Kayıt Eklendi");
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
        product = new Product();
     MessageUtils.message(FacesMessage.SEVERITY_WARN, "Başarılı", "Kayıt Güncellendi");

    }

    public void selectForEdit(Product editProduct){
        product=editProduct;
    }

    public void deleteProduct(){
        productList.remove(this.selectedProduct);
        PrimeFaces current = PrimeFaces.current();
        current.executeScript("PF('DeleteModal').hide();");
        current.ajax().update("datatableId");
        MessageUtils.message(FacesMessage.SEVERITY_ERROR, "Başarılı", "Kayıt Silindi");

    }

    public void setProductForDelete (Product p) {
        this.selectedProduct=p ;
        PrimeFaces current = PrimeFaces.current();
        current.executeScript("PF('DeleteModal').show();");
    }

   public String productPage(){
    Product p = new Product();
    p.setModelId(5);
    p.setProductName("çay");
    p.setPrice(100);
    p.setSerialNum(789);
    productList.add(p);

    this.userList=userBean.getUserList();

    return "product.xhtml?faces-redirect=true";
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
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Product getSelectedDropdownProduct() {
        return selectedDropdownProduct;
    }

    public void setSelectedDropdownProduct(Product selectedDropdownProduct) {
        this.selectedDropdownProduct = selectedDropdownProduct;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
}
