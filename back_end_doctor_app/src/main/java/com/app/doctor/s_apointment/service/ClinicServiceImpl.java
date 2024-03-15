package com.app.doctor.s_apointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.doctor.s_apointment.beans.Clinic;
import com.app.doctor.s_apointment.repo.ClinicRepository;

@Service
public class ClinicServiceImpl implements ClinicService{

	@Autowired
	ClinicRepository clinicRepository;
	
	@Override
	public Clinic addClinic(Clinic c) {
		return clinicRepository.save(c);
	}

	@Override
	@Transactional
	public String updateImage(String fileName, int clinic_id,String doctor_id) {
		int x = clinicRepository.updateImage(fileName,clinic_id,doctor_id);
		if(x > 0)
			return fileName;
		return "not updated";
	}

	@Override
	public List<Clinic> getClinics(String doctorId) {
		return clinicRepository.findAllByDoctorId(doctorId);
	}

	@Override
	public void deleteClinicById(int clinicId) {
		Clinic clinic = clinicRepository.getById(clinicId);
		clinicRepository.delete(clinic);

	}

	@Override
	public void deleteClinic(String doctorId) {
		List<Clinic> lclinic = clinicRepository.deleteByDoctorId(doctorId);
		clinicRepository.deleteAll(lclinic);

	}

}
