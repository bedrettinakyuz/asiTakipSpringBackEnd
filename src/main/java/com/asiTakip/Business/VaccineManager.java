package com.asiTakip.Business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asiTakip.repository.VaccineRepository;
import com.asiTakip.DAL.IVaccineDAL;
import com.asiTakip.models.*;
@Service
public class VaccineManager implements IVaccineManager {
	
	@Autowired
	private VaccineRepository repository;

	@Autowired
	private IVaccineDAL vaccineDal;
	

	@Override
	public String saveVaccine(Vaccine vaccine) {
		if (!repository.existsById(vaccine.getId()))
		{
		repository.save(vaccine);
		return "Vaccine added with id :" + vaccine.getId();
		} 
		else
		{
			return "Vaccine is already existing with id :" + vaccine.getId();
		}
		
			
		
	}



	@Override
	public Optional<List<Vaccine>> getVaccines(Integer id) {
		
		return vaccineDal.getVaccines(id);
	}



	@Override
	public Optional<Vaccine> getVaccineById(Integer id) {
		
		return repository.findById(id);
	}

}
