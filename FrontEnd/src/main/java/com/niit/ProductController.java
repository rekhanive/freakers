package com.niit;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.niit.dao.ProductDao;
import com.niit.model.Product;

@Controller
public class ProductController 
{	
	@Autowired
	ProductDao productDao;
	 @RequestMapping(value="/all/addProduct", method=RequestMethod.POST)
	 public ModelAndView Success(@ModelAttribute("Products")Product product,HttpServletRequest request)
	 {
		 productDao.addProduct(product);
		    MultipartFile img=product.getPimage();
			System.out.println(request.getServletContext().getRealPath("/"));
			
			//Defining a path
			Path path=Paths.get(request.getSession().getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getId()+".png");
			
			//Create a file in the path
			
			try {
				if(img!=null && !img.isEmpty()){
				File file=new File(path.toString());
				img.transferTo(file);
				}
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		ModelAndView model=new ModelAndView("AddProduct","Product", new Product());
		return model;
		 
	 }
	 @RequestMapping(value="/admin/AddProduct",method=RequestMethod.GET)
	 public ModelAndView getLogin(@ModelAttribute("Products")Product product)	 
	 {
		 
		 System.out.println("Add");
		 ModelAndView model=new ModelAndView("AddProduct");
		 return model;
	 }
	 
		@RequestMapping(value="/all/ViewProduct", method=RequestMethod.GET)
		public ModelAndView getViewProductForm(@ModelAttribute("ViewProduct") Product product)
		{
				System.out.println("view");	
				ModelAndView model = new ModelAndView();
		        model.addObject("productlist", productDao.getAllProduct());
		        model.setViewName("ViewProduct");
		        return model;
		}
		@RequestMapping(value="/all/Delete", method=RequestMethod.GET)
		public ModelAndView deleteProduct(Model m, @RequestParam int id)
		{

		    productDao.deleteProduct(id);
		    ModelAndView model = new ModelAndView();
		    model.addObject("productlist", productDao.getAllProduct());
	        model.setViewName("ViewProduct");
		    return model;

		}
		@RequestMapping(value="/all/Edit", method=RequestMethod.POST)
		public ModelAndView Edited(@ModelAttribute("prod") Product product,HttpServletRequest request)
		{
				productDao.updateProduct(product);
				   MultipartFile img=product.getPimage();
					System.out.println(request.getServletContext().getRealPath("/"));
					
					//Defining a path
					Path path=Paths.get(request.getSession().getServletContext().getRealPath("/")+"/WEB-INF/resources/images/"+product.getId()+".png");
					
					//Create a file in the path
					
					try {
						if(img!=null && !img.isEmpty()){
						File file=new File(path.toString());
						img.transferTo(file);
						}
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				ModelAndView model = new ModelAndView();
		        model.addObject("productlist", productDao.getAllProduct());
		        model.setViewName("ViewProduct");
		        return model;
				
		}
		@RequestMapping(value="/all/edit",method=RequestMethod.GET)
		public ModelAndView getUpdateProductForm(@RequestParam int id,Model m)
		{
			Product product=productDao.selectProduct(id);
		    m.addAttribute("prod",product);
			ModelAndView model = new ModelAndView("EditProduct","Product",new Product());
			return model;
		}
		@RequestMapping(value="/all/Info",method = RequestMethod.GET)
		public String getProduct(@RequestParam int id,Model model){
			Product product=productDao.selectProduct(id);
			  model.addAttribute("productAttr",product);
			  return "GetProduct";
		}
		 @RequestMapping(value="/all/Product",method = RequestMethod.GET)
		 public ModelAndView getProduct()
		 {
			 ModelAndView model = new ModelAndView();
		     model.addObject("productlist", productDao.getAllProduct());
		     model.setViewName("Product");
		     return model; 
		 }
		
		 @RequestMapping(value="/all/Cart",method = RequestMethod.GET)
		 public ModelAndView getCheckoutPage(@RequestParam int id)
		 {
			 ModelAndView model = new ModelAndView();
		     model.addObject("productlist", productDao.selectProduct(id));
		     model.setViewName("Cart");
		     return model;
		 }
}
		
		
	


