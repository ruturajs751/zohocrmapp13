package com.zohocrm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.Entities.Contact;
import com.zohocrm.Entities.Lead;
import com.zohocrm.Services.ContactService;
import com.zohocrm.Services.LeadService;

@Controller
public class LeadController {
	@Autowired
	private LeadService LeadService;
	
	@Autowired
	private ContactService contactservice;
	
	@GetMapping("/viewCreateLeadPage")
	public String viewCreateLeaPage() {
		return "create_new_lead";
	}
	@PostMapping("/save")
	public String saveLead(@ModelAttribute("lead") Lead lead,Model model) {
		model.addAttribute("lead", lead);
		LeadService.saveOneLead(lead);

		return "lead_info";
		
	}
	@PostMapping("/convertLead")
	public String ConvertLead(@RequestParam("id") Long id,Model model) {
		Lead lead=LeadService.findByLeadById(id);
		
		Contact contact=new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactservice.saveContact(contact);
		
		LeadService.deleteLeadById(id);
		List<Contact> contacts = contactservice.getAllContact();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
		
		
		
		
		
	}
	@RequestMapping("/listall")
	public String listAllLeads(Model model) {
		List<Lead> leads = LeadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id") long id,Model model) {
		
		Lead lead=LeadService.findByLeadById(id);

		model.addAttribute("lead", lead);
		return "lead_info";
		
	}
	
}