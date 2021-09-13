package com.asiTakip.Business;
import java.util.List;
import java.util.Optional;

import com.asiTakip.models.*;
public interface IVaccineManager {

	String saveVaccine(Vaccine vaccine);
	List<Vaccine> getVaccines();
	Optional<Vaccine> getVaccineById(Integer id);
}
