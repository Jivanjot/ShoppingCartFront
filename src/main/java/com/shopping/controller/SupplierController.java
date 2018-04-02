package com.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dao.SupplierDao;
import com.shopping.domain.Supplier;

@Controller
public class SupplierController {
	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDao supplierDao;
@Autowired
HttpSession httpSession;
	@PostMapping("/suppliersave")
	public ModelAndView saveSupplier(@ModelAttribute Supplier supplier) {
		ModelAndView mv = new ModelAndView("redirect:/managesuppliers");
		if (supplierDao.save(supplier) == true) {
	               
			mv.addObject("success", "Supplier added");
	
			return mv;
		} else {
			mv.addObject("error1", "Supplier not added");
			return mv;
		}

	}

	@GetMapping("/supplierupdate")
	public ModelAndView updateSupplier(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("redirect:/managesuppliers");
	Supplier	selectedsupplier=  supplierDao.select(id);
     httpSession.setAttribute("selectedsupplier",selectedsupplier);
     return mv;
		
		
		
	}

	@GetMapping("/supplierselect")
	public ModelAndView selectSupplier(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		supplier = supplierDao.select(id);
		mv.addObject("supplier", supplier);
		return mv;
	}

	@GetMapping("/supplierdelete{id}")
	public ModelAndView deleteSupplier(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("redirect:/managesuppliers");
		if (supplierDao.delete(id) == true) {
			mv.addObject("success", "Supplier deleted");
			
		}

		else {
			mv.addObject("error1", "Supplier not deleted");
		
		}
		return mv;
	}

	@GetMapping("/suppliergetall")
	public ModelAndView getAllSupplier(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		List<Supplier> c = supplierDao.getAll();
		if (c == null) {
			mv.addObject("error1", "Error");
			return mv;

		} else {
			mv.addObject("success", c);
			return mv;
		}

	}

}