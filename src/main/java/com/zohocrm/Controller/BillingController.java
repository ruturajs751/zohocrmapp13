package com.zohocrm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.Entities.Contact;
import com.zohocrm.Services.ContactService;

@Controller
public class BillingController {
	@Autowired
	private ContactService contactservice;
	
	@RequestMapping("/generateBill")
	public String viewBillingLeadPage(@RequestParam("id") long id,Model model) {
		Contact contact=contactservice.getContactById(id);
		model.addAttribute("contact", contact);
		return "generate_bill";
		
	}
	
		
}
