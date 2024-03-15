import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
import '../Styles/SignUp.css';
import PatientService from '../service/PatientService';

const PatientSignup = () => {
  const history = useHistory();
  const [values, setValues] = useState({
    user_full_name: '',
    user_address: '',
    user_phone_number: '',
    user_email: '',
    user_password: '',
    user_role: 'patient',
    patient_emergency_contact: '',
    patient_health_problem: '',
  });

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;

    setValues({
      ...values,
      [name]: value,
    });

    // Clear error message for the field when it's edited
    if (errors[name]) {
      setErrors({
        ...errors,
        [name]: '',
      });
    }
  };

  const validateForm = () => {
    let isValid = true;
    const newErrors = {};

    if (!values.user_full_name) {
      newErrors.user_full_name = 'Full name is required';
      isValid = false;
    }

    if (!values.user_email) {
      newErrors.user_email = 'Email is required';
      isValid = false;
    } else if (!/\S+@\S+\.\S+/.test(values.user_email)) {
      newErrors.user_email = 'Email is invalid';
      isValid = false;
    }

    if (!values.user_password) {
      newErrors.user_password = 'Password is required';
      isValid = false;
    } else if (values.user_password.length < 6) {
      newErrors.user_password = 'Password must be at least 6 characters';
      isValid = false;
    }

    if (!values.user_phone_number) {
      newErrors.user_phone_number = 'Phone number is required';
      isValid = false;
    } else if (!/^\d{10}$/.test(values.user_phone_number)) {
      newErrors.user_phone_number = 'Phone number must be 10 digits';
      isValid = false;
    }

    // Add more validation rules for other fields here

    setErrors(newErrors);
    return isValid;
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (validateForm()) {
      PatientService.addPatient(values);
      alert('Registration Successful');
      history.push('/login');
    }
  };

  const closeForm = () => {
    history.push('/');
  };

  return (
    <div className="form-content-right">
      <span className="close-btn" onClick={closeForm}>
        ×
      </span>
      <form className="form">
        <h1>
          Get started with us today! Create your account by filling out the
          information below.
        </h1>
        <div className="form-inputs">
          <label className="form-label">Full Name</label>
          <input
            className="form-input"
            type="text"
            name="user_full_name"
            placeholder="Enter your full name"
            value={values.user_full_name}
            onChange={handleChange}
          />
          {errors.user_full_name && (
            <p className="error-message">{errors.user_full_name}</p>
          )}
        </div>
        <div className="form-inputs">
          <label className="form-label">Address</label>
          <input
            className="form-input"
            type="text"
            name="user_address"
            placeholder="Enter your address"
            value={values.user_address}
            onChange={handleChange}
          />
          {errors.user_address && (
            <p className="error-message">{errors.user_address}</p>
          )}
        </div>
        <div className="form-inputs">
          <label className="form-label">Phone Number</label>
          <input
            className="form-input"
            type="text"
            name="user_phone_number"
            placeholder="Enter your phone number"
            value={values.user_phone_number}
            onChange={handleChange}
          />
          {errors.user_phone_number && (
            <p className="error-message">{errors.user_phone_number}</p>
          )}
        </div>
        <div className="form-inputs">
          <label className="form-label">Email</label>
          <input
            className="form-input"
            type="email"
            name="user_email"
            placeholder="Enter your email"
            value={values.user_email}
            onChange={handleChange}
          />
          {errors.user_email && (
            <p className="error-message">{errors.user_email}</p>
          )}
        </div>
        <div className="form-inputs">
          <label className="form-label">Password</label>
          <input
            className="form-input"
            type="password"
            name="user_password"
            placeholder="Enter your password"
            value={values.user_password}
            onChange={handleChange}
          />
          {errors.user_password && (
            <p className="error-message">{errors.user_password}</p>
          )}
        </div>
        <div className="form-inputs">
          <label className="form-label">Emergency Contact Number</label>
          <input
            className="form-input"
            type="text"
            name="patient_emergency_contact"
            placeholder="Enter your emergency contact number"
            value={values.patient_emergency_contact}
            onChange={handleChange}
          />
          {errors.patient_emergency_contact && (
            <p className="error-message">
              {errors.patient_emergency_contact}
            </p>
          )}
        </div>
        <div className="form-inputs">
          <label className="form-label">Health Problems (if any)</label>
          <input
            className="form-input"
            type="text"
            name="patient_health_problem"
            placeholder="Enter health problems (if any)"
            value={values.patient_health_problem}
            onChange={handleChange}
          />
          {errors.patient_health_problem && (
            <p className="error-message">{errors.patient_health_problem}</p>
          )}
        </div>
        <button className="form-input-btn" onClick={handleSubmit}>
          Sign Up
        </button>
        <span className="form-input-login">
          Already have an account? Login <a href="/login">here</a>
        </span>
      </form>
    </div>
  );
};

export default PatientSignup;






// import React, { useState } from 'react';
// import { useHistory } from "react-router-dom";
// // import validate from './validateinfo';
// // import useForm from './useForm';
// import '../Styles/SignUp.css';
// import PatientService from '../service/PatientService';

// const PatientSignup = () => {
//   const history = useHistory();
//   const [values, setValues] = useState({
    
//     user_full_name: '',
//     user_address:'',
//     user_phone_number:'',
//     user_email: '',
//     user_password: '',
//     user_role:'patient',
//     patient_emergency_contact: '',
//     patient_health_problem: ''
    
    
      
//     })
    
  
//   const handleChange = e => {
//     const { name, value } = e.target;
//     // console.log(name);
    
//     setValues({
//       ...values,
//       [name]: value
//     });

//   };
      
//   const handleSubmit = e => {
//     console.log(values);
//     e.preventDefault();
//     PatientService.addPatient(values);
//     alert("Registeration Successful")
//     history.push('/login');
//   };

//   return (
//     <div className='form-content-right'>
//       <form  className='form' >
//         <h1>
//           Get started with us today! Create your account by filling out the
//           information below.
//         </h1>
//         <div className='form-inputs'>
//           <label className='form-label'>Full Name</label>
//           <input
//             className='form-input'
//             type='text'
//             name='user_full_name'
//             placeholder='Enter your username'
//             value={values.user_full_name}
//             onChange={handleChange}
//           />
          
//         </div>
//         <div className='form-inputs'>
//           <label className='form-label'>Full Address</label>
//           <input
//             className='form-input'
//             type='text'
//             name='user_address'
//             placeholder='Enter your Address'
//             value={values.user_address}
//             onChange={handleChange}
//           />
          
//         </div>
//         <div className='form-inputs'>
//           <label className='form-label'>Phone Number</label>
//           <input
//             className='form-input'
//             type='text'
//             name='user_phone_number'
//             placeholder='Enter your Phone Number'
//             value={values.user_phone_number}
//             onChange={handleChange}
//           />
          
//         </div>
//         <div className='form-inputs'>
//           <label className='form-label'>Email</label>
//           <input
//             className='form-input'
//             type='email'
//             name='user_email'
//             placeholder='Enter your email'
//             value={values.user_email}
//             onChange={handleChange}
//           />
         
//         </div>
//         <div className='form-inputs'>
//           <label className='form-label'>Password</label>
//           <input
//             className='form-input'
//             type='password'
//             name='user_password'
//             placeholder='Enter your password'
//             value={values.user_password}
//             onChange={handleChange}
//           />
          
//         </div>
        
//         <div className='form-inputs'>
//           <label className='form-label'>Emergency Contact Number</label>
//           <input
//             className='form-input'
//             type='text'
//             name='patient_emergency_contact'
//             placeholder='Enter your Emergency Contact Number '
//             value={values.patient_emergency_contact}
//             onChange={handleChange}
//           />
          
//         </div>

//         <div className='form-inputs'>
//           <label className='form-label'>Health problems</label>
//           <input
//             className='form-input'
//             type='text'
//             name='patient_health_problem'
//             placeholder='Enter Health problems (If Any)'
//             value={values.patient_health_problem}
//             onChange={handleChange}
//           />
          
//         </div>

//         <button className='form-input-btn'  onClick={handleSubmit}>
//           Sign Up
//         </button>
//         <span className='form-input-login'>
//           Already have an account? Login <a href='/login'>here</a>
//         </span>
//       </form>
//     </div>
//   );
// };

// export default PatientSignup;