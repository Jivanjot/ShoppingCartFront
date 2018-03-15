package com.shopping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping("/supplier/save")
	public ModelAndView saveSupplier(@RequestBody Supplier supplier) {
		ModelAndView mv = new ModelAndView("home");
		if (supplierDao.save(supplier) == true) {
			mv.addObject("success", "Supplier added");
			return mv;
		} else {
			mv.addObject("error", "Supplier not added");
			return mv;
		}

	}

	@PostMapping("/supplier/update")
	public ModelAndView updateSupplier(@RequestBody Supplier supplier) {
		ModelAndView mv = new ModelAndView("home");
		if (supplierDao.update(supplier) == true) {
			mv.addObject("success", "Supplier updated");
			return mv;
		} else {
			mv.addObject("error", "Supplier not updated");
			return mv;
		}

	}

	@GetMapping("/supplier/select")
	public ModelAndView selectSupplier(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		supplier = supplierDao.select(id);
		mv.addObject("supplier", supplier);
		return mv;
	}

	@GetMapping("/supplier/delete")
	public ModelAndView deleteSupplier(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("home");
		if (supplierDao.delete(id) == true) {
			mv.addObject("success", "Supplier deleted");
			return mv;
		}

		else {
			mv.addObject("error1", "Supplier not deleted");
			return mv;
		}
	}

	@GetMapping("/supplier/getall")
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