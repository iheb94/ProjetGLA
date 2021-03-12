package fr.snapfood.rest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import fr.snapfood.model.Category;
import fr.snapfood.model.Product;
import fr.snapfood.repository.ProductRepository;
import fr.snapfood.service.ICategoryService;
import fr.snapfood.service.IPictureService;
import fr.snapfood.service.IProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProductRest {
	 private static final Logger log = LoggerFactory.getLogger(ProductRest.class);
     @Autowired
     ICategoryService iCategoryService;
     @Autowired
     ProductRepository pp;
 @Autowired
 IProductService iProductService;
 @Autowired IPictureService pic ;

 public ProductRest(IProductService iProductService, ICategoryService iCategoryService) {
     this.iProductService = iProductService;
     this.iCategoryService=iCategoryService;
 }

 @GetMapping("products")
 public Iterable<Product> getAll() {
		//Iterable<Product> listp =  iProductService.getAllProducts();
		//for (Product typePfe : listp) {
			//typePfe.setListP(typePfe.getListP());
			
		//}
		//return listp;
	//}
	 
     return iProductService.getAllProducts();
 }

 @GetMapping("product/{id}")
 public Optional<Product> getProductById(@PathVariable(name = "id") int id) {
     return iProductService.getProductById(id);
 }

 @GetMapping("products/{id}")
 public Iterable<Product> getProductByIdCategory(@PathVariable(name = "id") int id) {
     return iProductService.findAllByCategory(id);
 }
     @GetMapping("products/cat/{category}")
     public Iterable<Product> getProductByCategory(@PathVariable(name = "category") String category) {
         Optional<Category> categoryByName = iCategoryService.getCategoryByName(category);
         if (categoryByName.isPresent()){
             return iProductService.findAllByCategory(categoryByName.get().getId());
         }
         return getAll();
     }
 @PostMapping(value ="product",consumes = MediaType.APPLICATION_JSON_VALUE)
 public Product addProduct(@RequestBody Product product) {
     return iProductService.addProduct(product);
 }

 @PutMapping("product")
 public Product updateProduct(@RequestBody Product product) {
     return iProductService.updateProduct(product);
 }
 @PostMapping("productsave")
 public Product upd(@RequestBody Product product) {
	 
	 
     return iProductService.addProduct(product);
 }

 @DeleteMapping("product/{id}")
 public int deleteProduct(@PathVariable int id){
	 
    return iProductService.deleteProductById(id);
 }
 @PutMapping("/up/{id}")

 public ResponseEntity<Product> updateUclt(@PathVariable("id") int id, @RequestBody Product Ag) {
   System.out.println("Update type ID = " + id + "...");
    Optional<Product> AgData = pp.findById(id);
   if (AgData.isPresent()) {
    Product agg = AgData.get();
 
  agg.setName(Ag.getName());
  agg.setCategories(Ag.getCategories());
  agg.setDescription(Ag.getDescription());
  agg.setDetails(Ag.getDetails());
  agg.setPrice(Ag.getPrice());
 
     
    return new ResponseEntity<>(pp.save(agg), HttpStatus.OK);
   } else {
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   } }
 @GetMapping("pcat/{id}")
 List<Product> GetProductByCat(@PathVariable ("id") int id){
	return (List<Product>)iProductService.GetProductByCat(id);}


}