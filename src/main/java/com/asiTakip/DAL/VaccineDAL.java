package com.asiTakip.DAL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asiTakip.models.Vaccine;
import com.asiTakip.repository.VaccineRepository;
@Repository
public class VaccineDAL implements IVaccineDAL {

	@Autowired
	private VaccineRepository vaccineRepository;
	@Override
	public Optional<List<Vaccine>> getVaccines(Integer id) {
		
		return Optional.ofNullable(vaccineRepository.findByOwnerId(id));
	}

}
