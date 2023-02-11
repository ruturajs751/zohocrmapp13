package com.zohocrm.Services;

import java.util.List;

import com.zohocrm.Entities.Lead;

public interface LeadService {
	public void saveOneLead(Lead lead);

	public Lead findByLeadById(Long id);

	public void deleteLeadById(Long id);

	public List<Lead> getAllLeads();

}
