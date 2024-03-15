package com.app.doctor.s_apointment.beans;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Doctor")
public class Doctor extends User{

	@NotNull
    private String doctor_license_number;
    
    private String doctor_doctor_image;
   
    private String doctor_clinic_address;
    
    private String doctor_category;
    
    private boolean doctor_verification_status;

    public Doctor(){
        super();
    }
    
    public Doctor(String doctor_license_number, String doctor_doctor_image, int doctor_clinic_id,String doctor_clinic_address, String doctor_category, boolean doctor_verification_status) {
        this.doctor_license_number = doctor_license_number;
        this.doctor_doctor_image = doctor_doctor_image;
        this.doctor_clinic_address = doctor_clinic_address;
        this.doctor_category = doctor_category;
        this.doctor_verification_status = doctor_verification_status;
    }

	public Doctor(String doctor_license_number, String doctor_doctor_image, String doctor_clinic_address,
			String doctor_category, boolean doctor_verification_status) {
		super();
		this.doctor_license_number = doctor_license_number;
		this.doctor_doctor_image = doctor_doctor_image;
		this.doctor_clinic_address = doctor_clinic_address;
		this.doctor_category = doctor_category;
		this.doctor_verification_status = doctor_verification_status;
	}

	public String getDoctor_license_number() {
		return doctor_license_number;
	}

	public void setDoctor_license_number(String doctor_license_number) {
		this.doctor_license_number = doctor_license_number;
	}

	public String getDoctor_doctor_image() {
		return doctor_doctor_image;
	}

	public void setDoctor_doctor_image(String doctor_doctor_image) {
		this.doctor_doctor_image = doctor_doctor_image;
	}

	public String getDoctor_clinic_address() {
		return doctor_clinic_address;
	}

	public void setDoctor_clinic_address(String doctor_clinic_address) {
		this.doctor_clinic_address = doctor_clinic_address;
	}

	public String getDoctor_category() {
		return doctor_category;
	}

	public void setDoctor_category(String doctor_category) {
		this.doctor_category = doctor_category;
	}

	public boolean isDoctor_verification_status() {
		return doctor_verification_status;
	}

	public void setDoctor_verification_status(boolean doctor_verification_status) {
		this.doctor_verification_status = doctor_verification_status;
	}
}
