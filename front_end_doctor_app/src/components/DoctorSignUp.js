import React, { useState } from 'react';
import { useHistory } from "react-router-dom";
import DoctorService from '../service/DoctorService';
import '../Styles/SignUp.css';

const DoctorSignup = () => {
    const history = useHistory();
    const [values, setValues] = useState({
        user_full_name: '',
        user_address: '',
        user_phone_number: '',
        user_email: '',
        user_password: '',
        user_role: 'doctor',
        doctor_license_number: '',
        doctor_clinic_address: '',
        doctor_category: ''
    });

    const [errors, setErrors] = useState({});

    const handleChange = (e) => {
        const { name, value } = e.target;

        setValues({
            ...values,
            [name]: value
        });
    };

    const validateForm = () => {
        const errors = {};

        if (!values.user_full_name.trim()) {
            errors.user_full_name = 'Full Name is required';
        }

        if (!values.user_address.trim()) {
            errors.user_address = 'Address is required';
        }

        if (!values.user_phone_number.trim()) {
            errors.user_phone_number = 'Phone Number is required';
        }

        if (!values.user_email.trim()) {
            errors.user_email = 'Email is required';
        } else if (!/^\S+@\S+\.\S+$/.test(values.user_email)) {
            errors.user_email = 'Invalid email format';
        }

        if (!values.user_password.trim()) {
            errors.user_password = 'Password is required';
        }

        if (!values.doctor_license_number.trim()) {
            errors.doctor_license_number = "Doctor's License Number is required";
        }

        if (!values.doctor_clinic_address.trim()) {
            errors.doctor_clinic_address = 'Clinic Address is required';
        }

        setErrors(errors);

        return Object.keys(errors).length === 0;
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        if (validateForm()) {
            DoctorService.addDoctor(values).then((response) => {
                console.log("Doctor From Server " + response.data);
                alert("Registration Successful");
                history.push('/login');
            });
        }
    };

    const handleClose = () => {
        // Redirect to the home page ("/")
        history.push('/');
    };

    return (
        <div className='form-content-right'>
            <span className='close-btn' onClick={handleClose}>×</span>
            <h1 id='tag'></h1>
            <form className='form'>
                <h1>Get started with us today! Create your account by filling out the information below.</h1>
                <div className='form-inputs'>
                    <label className='form-label'>Full Name</label>
                    <input
                        className='form-input'
                        type='text'
                        name='user_full_name'
                        placeholder='Enter your username'
                        value={values.user_full_name}
                        onChange={handleChange}
                    />
                    {errors.user_full_name && <p className="error">{errors.user_full_name}</p>}
                </div>
                <div className='form-inputs'>
                    <label className='form-label'>Full Address</label>
                    <input
                        className='form-input'
                        type='text'
                        name='user_address'
                        placeholder='Enter your Address'
                        value={values.user_address}
                        onChange={handleChange}
                    />
                    {errors.user_address && <p className="error">{errors.user_address}</p>}
                </div>
                <div className='form-inputs'>
                    <label className='form-label'>Phone Number</label>
                    <input
                        className='form-input'
                        type='text'
                        name='user_phone_number'
                        placeholder='Enter your Phone Number'
                        value={values.user_phone_number}
                        onChange={handleChange}
                    />
                    {errors.user_phone_number && <p className="error">{errors.user_phone_number}</p>}
                </div>
                <div className='form-inputs'>
                    <label className='form-label'>Email</label>
                    <input
                        className='form-input'
                        type='email'
                        name='user_email'
                        placeholder='Enter your email'
                        value={values.user_email}
                        onChange={handleChange}
                    />
                    {errors.user_email && <p className="error">{errors.user_email}</p>}
                </div>
                <div className='form-inputs'>
                    <label className='form-label'>Password</label>
                    <input
                        className='form-input'
                        type='password'
                        name='user_password'
                        placeholder='Enter your password'
                        value={values.user_password}
                        onChange={handleChange}
                    />
                    {errors.user_password && <p className="error">{errors.user_password}</p>}
                </div>
                <div className='form-inputs'>
                    <label className='form-label'>Doctor's License Number</label>
                    <input
                        className='form-input'
                        type='text'
                        name='doctor_license_number'
                        placeholder="Enter your Doctor's License Number"
                        value={values.doctor_license_number}
                        onChange={handleChange}
                    />
                    {errors.doctor_license_number && <p className="error">{errors.doctor_license_number}</p>}
                </div>
                <div className='form-inputs'>
                    <label className='form-label'>Clinic Address</label>
                    <input
                        className='form-input'
                        type='text'
                        name='doctor_clinic_address'
                        placeholder='Enter your Clinic Address'
                        value={values.doctor_clinic_address}
                        onChange={handleChange}
                    />
                    {errors.doctor_clinic_address && <p className="error">{errors.doctor_clinic_address}</p>}
                </div>
                <div className='form-inputs'>
                    <label className='form-label'>Doctor's Specialization</label>
                    <select
                        className='form-input'
                        name='doctor_category'
                        placeholder='Select your Specialization'
                        value={values.doctor_category}
                        onChange={handleChange}
                    >
                        <option value="general">General Physician</option>
                        <option value="physiotherapist">Physiotherapist</option>
                        <option value="cardiologist">Cardiologist</option>
                        <option value="dentist">Dentist</option>
                        <option value="radiologist">Radiologist</option>
                        <option value="dermatologist">Dermatologist</option>
                        <option value="psychiatrist">Psychiatrist</option>
                        <option value="gynecologist">Gynecologist</option>
                        <option value="pediatrician">Pediatrician</option>
                        <option value="neurologist">Neurologist</option>
                        <option value="nephrologist">Nephrologist</option>
                        <option value="endocrinologist">Endocrinologist</option>
                    </select>
                </div>
                <button className='form-input-btn' onClick={handleSubmit}>
                    Sign Up
                </button>
                <span className='form-input-login'>
                    Already have an account? Login <a href='/login'>here</a>
                </span>
            </form>
        </div>
    );
};

export default DoctorSignup;






// import React, { useState } from 'react';
// import { useHistory } from "react-router-dom";
// // import validate from './validateinfo';
// // import useForm from './useForm';
// import '../Styles/SignUp.css';
// import DoctorService from '../service/DoctorService';

// const DoctorSignup = () => {
//   const history = useHistory();
//   const [values, setValues] = useState({

//     user_full_name: '',
//     user_address: '',
//     user_phone_number: '',
//     user_email: '',
//     user_password: '',
//     user_role: 'doctor',
//     doctor_license_number: '',
//     doctor_clinic_address: '',
//     doctor_category: ''

//   })


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
//     DoctorService.addDoctor(values).then((response) => {
//       console.log("Doctor From Server " + response.data);
//       alert("Registeration Successful")
//     history.push('/login');

//     })
//   };

//   return (
    


//     <div className='form-content-right'>
//       <h1 id='tag'></h1>
//       <form className='form' >
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
//           <label className='form-label'>Doctor's License Number</label>
//           <input
//             className='form-input'
//             type='text'
//             name='doctor_license_number'
//             placeholder='Enter your Doctors License Number '
//             value={values.doctor_license_number}
//             onChange={handleChange}
//           />

//         </div>

//         <div className='form-inputs'>
//           <label className='form-label'>Clinic Address</label>
//           <input
//             className='form-input'
//             type='text'
//             name='doctor_clinic_address'
//             placeholder='Enter your Clinic Address'
//             value={values.doctor_clinic_address}
//             onChange={handleChange}
//           />

//         </div>
//         <div className='form-inputs'>
//           <label className='form-label'>Doctor's Specialization</label>
//           <select
//             className='form-input'
//             name='doctor_category'
//             placeholder='Select your Specialization'
//             value={values.doctor_category}
//             onChange={handleChange}
//           >
//             <option value="general">General Physician</option>
//             <option value="physiotherapist">Physiotherapist</option>
//             <option value="cardiologist">Cardiologist</option>
//             <option value="dentist">Dentist</option>
//             <option value="radiologist">Radiologist</option>
//             <option value="dermatologist">Dermatologist</option>
//             <option value="psychiatrist">Psychiatrist</option>
//             <option value="gynecologist">Gynecologist</option>
//             <option value="pediatrician">Pediatrician</option>
//             <option value="neurologist">Neurologist</option>
//             <option value="nephrologist">Nephrologist</option>
//             <option value="endocrinologist">Endocrinologist</option>


//           </select>

//         </div>

//         <button className='form-input-btn' onClick={handleSubmit}>
//           Sign Up
//         </button>
//         <span className='form-input-login'>
//           Already have an account? Login <a href='/login'>here</a>
//         </span>
//       </form>
//     </div>
//   );
// };

// export default DoctorSignup;