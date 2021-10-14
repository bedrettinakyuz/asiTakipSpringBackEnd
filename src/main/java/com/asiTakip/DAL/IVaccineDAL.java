package com.asiTakip.DAL;

import java.util.List;
import java.util.Optional;

import com.asiTakip.models.Vaccine;

public interface IVaccineDAL {

	public Optional<List<Vaccine>> getVaccines(Integer id);
}
