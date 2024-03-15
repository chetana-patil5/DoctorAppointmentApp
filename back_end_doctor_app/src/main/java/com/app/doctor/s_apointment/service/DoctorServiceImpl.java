package com.app.doctor.s_apointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.doctor.s_apointment.beans.Doctor;
import com.app.doctor.s_apointment.beans.Logins;
import com.app.doctor.s_apointment.repo.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	LoginsService logServ;


	@Override
	public Doctor addDoctor(Doctor d) {
		Doctor prev = doctorRepository.findFirstByOrderByUserIdDesc();	
		if(prev == null)
			d.setUserId("D-100");
		else {
			System.out.println("uid in service doctor  :"+prev.getUserId());
		      d.setUserId("D-"+(Integer.parseInt(prev.getUserId().substring(2))+1));
		}
			
		System.out.println("did ;"+d.getUserId());
		doctorRepository.save(d);
		Logins logs = new Logins(d.getUserId(),d.getUser_email(),d.getUser_password(),"Doctor");
		logServ.addLogins(logs);
		return d;
	}

	@Override
	 public List<Doctor> getBySpecialization(String category) {
        return doctorRepository.getBySpecialization(category);
    }

	@Override
	public Doctor deleteById(String doctor_id) {	
		Doctor doc = doctorRepository.findById(doctor_id).orElse(null);
		doctorRepository.deleteById(doctor_id);
//		logServ.deleteLogins(doctor_id);
		return doc;
	}

	@Override
	public Doctor updateDoctor(String doctorId, Doctor doc) {
		return doctorRepository.save(doc);
	}

	@Override
	public List<Doctor> getDrByLocation(String location) {
		 return doctorRepository.getDrByLocation(location);
	}

	@Override
	public List<Doctor> getDrByVerificationStatus(Boolean verificationStatus) {
		return doctorRepository.getDrByVerificationStatus(verificationStatus);
	}

	@Override
	public Doctor getDoctorById(String userId) {
		return doctorRepository.findById(userId).orElse(null);
	}

	@Override
	public List<Doctor> getAllDoctors(){
		return this.doctorRepository.findAll();
	}

	@Override
	 @Transactional
	    public String updateImage(String fileName, String user_id) {
	        System.out.println(fileName+"in service----------------------------------------------------"+user_id);
	        int x= doctorRepository.updateImage(fileName,user_id);
	        if(x > 0)
	            return fileName;
	        return "not updated";
	    }

}
