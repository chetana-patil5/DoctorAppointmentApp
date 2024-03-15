import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../../Styles/App.css';
import Footer from '../Footer';
import { Button } from '../Button';
import LoginNavbar from '../LoginNavbar';
import '../../Styles/DocProfile.css';

function DocProfile() {
  const [user, setUser] = useState({
    doctor: {},
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(
          'http://localhost:8080/doctor/' +
            JSON.parse(window.sessionStorage.getItem('ruser-profile')).userId
        );
        setUser({ doctor: response.data });
      } catch (error) {
        console.log(error);
      }
    };

    fetchData();
  }, []);

  const handleLogout = () => {
    window.sessionStorage.clear();
  };

  return (
    <>
      <LoginNavbar />

      <div className="doc-profile-container">
        <div className="doc-profile-content">
          <h1 className="doc-profile-title ">Doctor Profile</h1>

          <div className="doc-info-container">
            <div className="doc-info-item">
              <label className="doc-info-label">Full Name:</label>
              <span className="doc-info-value text-white">{user.doctor.user_full_name}</span>
            </div>

            <div className="doc-info-item">
              <label className="doc-info-label">Address:</label>
              <span className="doc-info-value text-white">{user.doctor.user_address}</span>
            </div>

            <div className="doc-info-item">
              <label className="doc-info-label">Phone Number:</label>
              <span className="doc-info-value text-white">{user.doctor.user_phone_number}</span>
            </div>

            <div className="doc-info-item">
              <label className="doc-info-label">Email:</label>
              <span className="doc-info-value text-white">{user.doctor.user_email}</span>
            </div>

            <div className="doc-info-item">
              <label className="doc-info-label">Specialization:</label>
              <span className="doc-info-value text-white">{user.doctor.doctor_category}</span>
            </div>

            <div className="doc-info-item">
              <label className="doc-info-label">License Number:</label>
              <span className="doc-info-value text-white">{user.doctor.doctor_license_number}</span>
            </div>

            <div className="doc-info-item">
              <label className="doc-info-label">Clinic:</label>
              <span className="doc-info-value text-white">{user.doctor.doctor_clinic_address}</span>
            </div>
          </div>

          <div className="doc-profile-buttons">
            <Button
              variant="success"
              buttonStyle="btn-secondary"
              setPage="/addSlot"
            >
              Add Slot
            </Button>

            <Button buttonStyle="btn-secondary" setPage="/viewSlot">
              View Booked Slots
            </Button>
          </div>
        </div>
      </div>

      <Footer />
    </>
  );
}

export default DocProfile;
