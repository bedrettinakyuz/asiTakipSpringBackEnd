package com.asiTakip.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

import com.asiTakip.repository.UserRepository;
import com.asiTakip.repository.VaccineRepository;
import com.asiTakip.Business.IUserManager;
import com.asiTakip.Business.IVaccineManager;
import com.asiTakip.Request.UserRequest;
import com.asiTakip.Service.SequenceGeneratorService;
import com.asiTakip.models.*;

@RestController
@RequestMapping("/api")
public class VaccineController {

	private IVaccineManager vaccineManager;
	private UserRepository userRepository;
	
    @Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
    @Autowired
	public VaccineController(IVaccineManager vaccineManager,UserRepository userRepository) {

		this.vaccineManager = vaccineManager;
		this.userRepository = userRepository;
	}
    
	@Autowired
	private IUserManager userManager;
	
	@Transactional
	@PostMapping("/addVaccine")
	public String saveVaccine(@RequestBody Vaccine vaccine) {
		
		vaccine.setOwnerId(getCurUserId());
		vaccine.setId(sequenceGeneratorService.getSequenceNumber(Vaccine.SEQUENCE_NAME));
		return vaccineManager.saveVaccine(vaccine);
		
	}
	
	@Transactional
	@GetMapping("/findAllVaccines")
	public Optional<List<Vaccine>> getVaccines(){
		
		
		
		return vaccineManager.getVaccines(getCurUserId());
	}
	@Transactional
	@GetMapping("/findAllVaccines/{username}")
	public User getVaccineById(@PathVariable String username){
		
		return userRepository.findByUsername(username);
	}
	

	public Integer getCurUserId() {
		
	return userManager.getUserID(
			SecurityContextHolder.getContext().getAuthentication().getName());	
		
	}
	
	/*
	@Transactional
	@GetMapping("/findAllVaccines/{u}")
	public Vaccine getVaccineById(@PathVariable int id){
		
		return vaccineManager.getVaccineById(id)
				.orElseThrow(()-> new ResourceN);
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
