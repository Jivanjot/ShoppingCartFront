package com.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

	Logger log = LoggerFactory.getLogger(SupplierController.class);
	@Autowired
	HttpSession httpSession;

	@PostMapping("/suppliersave")
	public ModelAndView saveSupplier(@ModelAttribute Supplier supplier) {
		log.debug("starting of saveSupplier of SupplierController");
		ModelAndView mv = new ModelAndView("redirect:/managesuppliers");

		try {
			supplierDao.save(supplier);
			mv.addObject("success", "Supplier added");
			log.debug("ending of saveSupplier of SupplierController");
			return mv;
		} catch (Exception e) {
			mv.addObject("error1", "Supplier not added");
			return mv;
		}
	}

	@GetMapping("/supplierupdate")
	public ModelAndView updateSupplier(@RequestParam("id") String id) {
		log.debug(" starting of updateSupplier of SupplierController");
		ModelAndView mv = new ModelAndView("redirect:/managesuppliers");
		Supplier selectedsupplier = supplierDao.select(id);
		httpSession.setAttribute("selectedsupplier", selectedsupplier);
		log.debug("ending of updateSupplier of SupplierController");
		return mv;

	}

	@GetMapping("/supplierselect")
	public ModelAndView selectSupplier(@RequestParam("id") String id) {
		log.debug("starting of selectSupplier of SupplierController");
		ModelAndView mv = new ModelAndView("home");
		supplier = supplierDao.select(id);
		mv.addObject("supplier", supplier);
		log.debug("ending of selectSupplier of SupplierController");
		return mv;
	}

	@GetMapping("/supplierdelete{id}")
	public ModelAndView deleteSupplier(@RequestParam("id") String id) {
		log.debug("starting of deleteSupplier of SupplierController");
		ModelAndView mv = new ModelAndView("redirect:/managesuppliers");
		if (supplierDao.delete(id) == true) {
			mv.addObject("success", "Supplier deleted");

		}

		else {
			mv.addObject("error1", "Supplier not deleted");

		}
		log.debug("ending of deleteSupplier of SupplierController");
		return mv;
	}

	@GetMapping("/suppliergetall")
	public ModelAndView getAllSupplier(@RequestParam("id") int id) {
		log.debug("starting of getAllSupplier of SupplierController");
		ModelAndView mv = new ModelAndView("home");
		List<Supplier> c = supplierDao.getAll();
		if (c == null) {
			mv.addObject("error1", "Error");
			return mv;

		} else {
			mv.addObject("success", c);
			log.debug("ending of getAllSupplier of SupplierController");
			return mv;
		}

	}

}