import React, { Component } from 'react';
import DoctorService from '../service/DoctorService';
import { Link } from 'react-router-dom';
import LoginNavbar from './LoginNavbar';
import '../Styles/Category.css';

export default class Category extends Component {
    constructor(props) {
        super(props);
        this.state = {
            docarr: []
        };
    }

    componentDidMount() {
        console.log("Component did mount of Category DidMount");
        DoctorService.getDoctor(window.sessionStorage.getItem("category")).then(
            (response) => {
                this.setState({ docarr: response.data });
                console.log(this.state.docarr);
            }
        );
    }

    viewDoctor = (id) => {
        console.log("In viewDoctor")
        // window.sessionStorage.setItem("doc_slot_id", id)
        this.props.history.push(`/slot/${id}`)
    }

    render() {
        return (
            <div className="category-container">
                <LoginNavbar />
                <div className="category-content">
                    <h1>Doctor's List</h1>
                    <table className="doctor-table">
                        <thead>
                            <tr>
                                <th>Doctor's Name</th>
                                <th>Clinic Address</th>
                                <th>Mobile Number</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.docarr.map(doctor => (
                                <tr key={doctor.userId}>
                                    <td>{doctor.user_full_name}</td>
                                    <td>{doctor.doctor_clinic_address}</td>
                                    <td>{doctor.user_phone_number}</td>
                                    <td>
                                        <button className="view-button" onClick={() => this.viewDoctor(doctor.userId)}>View</button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}
