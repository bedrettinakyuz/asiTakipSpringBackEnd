package com.asiTakip.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;



import com.asiTakip.repository.VaccineRepository;
import com.asiTakip.Business.IVaccineManager;
import com.asiTakip.Exception.ResourceNotFoundException;
import com.asiTakip.models.*;

@RestController
@RequestMapping("/api")
public class VaccineController {

	private IVaccineManager vaccineManager;
	
    @Autowired
	public VaccineController(IVaccineManager vaccineManager) {

		this.vaccineManager = vaccineManager;
	}
	@Transactional
	@PostMapping("/addVaccine")
	public String saveVaccine(@RequestBody Vaccine vaccine) {
		
		return vaccineManager.saveVaccine(vaccine);
		
	}
	
	@Transactional
	@GetMapping("/findAllVaccines")
	public List<Vaccine> getVaccines(){
		return vaccineManager.getVaccines();
	}

	@Transactional
	@GetMapping("/findAllVaccines/{id}")
	public Vaccine getVaccineById(@PathVariable int id){
		
		return vaccineManager.getVaccineById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Vaccine not found with id" + id));
	}
	/*
	@Transactional
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "Deleted book with id :" + id;
	}
	*/
}
