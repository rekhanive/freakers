package com.niit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	SupplierDao supplierDao;
	 @RequestMapping(value="/all/addSupplier", method=RequestMethod.POST)
	 public ModelAndView Success(@ModelAttribute("Supplier")Supplier supplier)
	 {
		 supplierDao.addSupplier(supplier);
		 ModelAndView model=new ModelAndView("AddSupplier","Supplier",new Supplier());
		 return model;	 
	 }
	 @RequestMapping(value="/all/AddSupplier",method=RequestMethod.GET)
	 public ModelAndView getLogin(@ModelAttribute("Supplier")Supplier supplier)	 
	 {
		 System.out.println("Add");
		 ModelAndView model=new ModelAndView("AddSupplier");
		 return model;
	 }
	 @RequestMapping(value="/all/ViewSupplier", method=RequestMethod.GET)
		public ModelAndView getViewSupplierForm(@ModelAttribute("ViewSupplier")Supplier supplier)
		{
				System.out.println("view");	
				ModelAndView model = new ModelAndView();
		        model.addObject("supplierlist", supplierDao.getAllSupplier());
		        model.setViewName("ViewSupplier");
		        return model;
		}
	 @RequestMapping(value="/all/DeleteSupplier", method=RequestMethod.GET)
		public ModelAndView deleteSupplier(Model m, @RequestParam int id)
		{
		 supplierDao.deleteSupplier(id);
         System.out.println("DeleteSupplier");
		    ModelAndView model = new ModelAndView();
		    model.addObject("supplierlist", supplierDao.getAllSupplier());
	        model.setViewName("ViewSupplier");
		    return model;
    }
	 @RequestMapping(value="/all/edits", method=RequestMethod.POST)
		public ModelAndView Edited(@ModelAttribute("suppl")Supplier supplier)
		{
		        supplierDao.updateSupplier(supplier);
				ModelAndView model = new ModelAndView();
		        model.addObject("supplierlist", supplierDao.getAllSupplier());
		        model.setViewName("ViewSupplier");
		        return model;
				
		}
		@RequestMapping(value="/all/EditSupplier",method=RequestMethod.GET)
		public ModelAndView getUpdateSupplierForm(@RequestParam int id,Model m)
		{
			Supplier supplier=supplierDao.selectSupplier(id);
		    m.addAttribute("suppl",supplier);
			ModelAndView model = new ModelAndView("EditSupplier","Supplier",new Supplier());
			return model;
		}
}
