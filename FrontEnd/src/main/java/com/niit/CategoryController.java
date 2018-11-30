package com.niit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;


@Controller
public class CategoryController {
	@Autowired
	CategoryDao categoryDao;
	 @RequestMapping(value="/admin/addCategory", method=RequestMethod.POST)
	 public ModelAndView Success(@ModelAttribute("Category")Category category)
	 {
		 categoryDao.addCategory(category);
		 ModelAndView model=new ModelAndView("AddCategory","Category",new Category());
		 return model;	 
	 }
	 @RequestMapping(value="/all/AddCategory",method=RequestMethod.GET)
	 public ModelAndView getLogin(@ModelAttribute("Category")Category category)	 
	 {
		 System.out.println("Add");
		 ModelAndView model=new ModelAndView("AddCategory");
		 return model;
	 }
	 @RequestMapping(value="/all/ViewCategory", method=RequestMethod.GET)
		public ModelAndView getViewCategoryForm(@ModelAttribute("ViewCategory")Category category)
		{
				System.out.println("view");	
				ModelAndView model = new ModelAndView();
		        model.addObject("categorylist", categoryDao.getAllCategory());
		        model.setViewName("ViewCategory");
		        return model;
		}
	 @RequestMapping(value="/all/DeleteCategory", method=RequestMethod.GET)
		public ModelAndView deleteCategory(Model m, @RequestParam int id)
		{
            categoryDao.deleteCategory(id);
            System.out.println("DeleteCategory");
		    ModelAndView model = new ModelAndView();
		    model.addObject("categorylist", categoryDao.getAllCategory());
	        model.setViewName("ViewCategory");
		    return model;

		}
	 @RequestMapping(value="/all/edit", method=RequestMethod.POST)
		public ModelAndView Edited(@ModelAttribute("cate")Category category)
		{
				categoryDao.updateCategory(category);
				ModelAndView model = new ModelAndView();
		        model.addObject("categorylist", categoryDao.getAllCategory());
		        model.setViewName("ViewCategory");
		        return model;
				
		}
		@RequestMapping(value="/all/EditCategory",method=RequestMethod.GET)
		public ModelAndView getUpdateCategoryForm(@RequestParam int id,Model m)
		{
			Category category=categoryDao.selectCategory(id);
		    m.addAttribute("cate",category);
			ModelAndView model = new ModelAndView("EditCategory","Category",new Category());
			return model;
		}

}
