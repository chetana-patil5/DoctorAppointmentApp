import React, { Component } from 'react';
import SlotService from '../service/SlotService';
import LoginNavbar from './LoginNavbar';

class AddSlot extends Component {
    constructor(props) {
        super(props);
        this.state = {
            slot_patient_id: null,
            slot_doctor_id: window.sessionStorage.getItem("docID"),
            slot_date: "",
            slot_start_time: "",
            slot_end_time: "",
            slot_status: false,
            msg: "",
            slotarr: [],
            dateError: "",
            startTimeError: "",
            endTimeError: "",
            showAlert: false, // Added state for showing alert
        };
    }

    componentDidMount() {
        SlotService.unCateredSlotById(this.state.slot_doctor_id).then(
            (response) => {
                this.setState({ slotarr: response.data });
                console.log(this.state.slotarr);
            }
        );
    }

    cancel() {
        this.props.history.push("/addSlot");
    }

    change_slot_date_handler = (event) => {
        console.log("in slot_date handler");
        this.setState({ slot_date: event.target.value });
    };

    change_slot_start_time_handler = (event) => {
        console.log("in slot_start_time handler");
        this.setState({ slot_start_time: event.target.value });
    };

    change_slot_end_time_handler = (event) => {
        console.log("in slot_end_time handler");
        this.setState({ slot_end_time: event.target.value });
    };

    viewProfile = (event) => {
        this.props.history.push("/doc");
    };

    AddNewSlot = (e) => {
        e.preventDefault();

        // Validation logic for date
        if (!this.state.slot_date) {
            this.setState({ dateError: "Please select a date" });
            return;
        }

        // Validation logic for start time
        if (!this.state.slot_start_time) {
            this.setState({ startTimeError: "Please select a start time" });
            return;
        }

        // Validation logic for end time
        if (!this.state.slot_end_time) {
            this.setState({ endTimeError: "Please select an end time" });
            return;
        }

        // If all fields are valid, proceed with slot creation
        let slot = {
            slot_patient_id: this.state.slot_patient_id,
            slot_doctor_id: this.state.slot_doctor_id,
            slot_date: this.state.slot_date,
            slot_start_time: this.state.slot_start_time + ":00",
            slot_end_time: this.state.slot_end_time + ":00",
            slot_status: this.state.slot_status
        };

        SlotService.addSlot(slot).then(
            (response) => {
                this.setState({ showAlert: true, msg: "Slot Added" });
                setTimeout(() => {
                    this.setState({ showAlert: false });
                }, 1000); // Show the alert for 1 second

                SlotService.unCateredSlotById(this.state.slot_doctor_id).then(
                    (response) => {
                        this.setState({ slotarr: response.data });
                        console.log(this.state.slotarr);
                    }
                );
            }
        );

        // Clear any previous error messages
        this.setState({ dateError: "", startTimeError: "", endTimeError: "" });
    };

    deleteSlot = (id) => {
        SlotService.deleteSlotById(id);
        SlotService.unCateredSlotById(this.state.slot_doctor_id).then(
            (response) => {
                this.setState({ slotarr: response.data });
                console.log(this.state.slotarr);
            }
        );
    };

    render() {
        return (
            <>
                <LoginNavbar />
                <div className="container">
                    <div className="row">
                        <div className="col-md-6 offset-md-3">
                            <div className="card">
                                <div className="card-body">
                                    <form>
                                        <div className="form-group">
                                            <label>Date:</label>
                                            <input
                                                type="date"
                                                name="slot_date"
                                                id="slot_date"
                                                className="form-control"
                                                value={this.state.slot_date}
                                                onChange={this.change_slot_date_handler}
                                                required
                                            />
                                            {this.state.dateError && (
                                                <p className="text-danger">{this.state.dateError}</p>
                                            )}
                                        </div>

                                        <div className="form-group">
                                            <label>Start Time:</label>
                                            <input
                                                type="time"
                                                name="slot_start_time"
                                                id="slot_start_time"
                                                className="form-control"
                                                value={this.state.slot_start_time}
                                                onChange={this.change_slot_start_time_handler}
                                                required
                                            />
                                            {this.state.startTimeError && (
                                                <p className="text-danger">{this.state.startTimeError}</p>
                                            )}
                                        </div>

                                        <div className="form-group">
                                            <label>End Time:</label>
                                            <input
                                                type="time"
                                                name="slot_end_time"
                                                id="slot_end_time"
                                                className="form-control"
                                                value={this.state.slot_end_time}
                                                onChange={this.change_slot_end_time_handler}
                                                required
                                            />
                                            {this.state.endTimeError && (
                                                <p className="text-danger">{this.state.endTimeError}</p>
                                            )}
                                        </div>

                                        <div className="text-center">
                                            <button className="btn btn-success" onClick={this.AddNewSlot}>Save</button>
                                            <button className="btn btn-primary" onClick={this.viewProfile} style={{ marginLeft: "10px" }}>Go to profile</button>
                                            <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>
                                        </div>
                                    </form>
                                    {this.state.showAlert && (
                                        <div className="alert alert-success mt-3" role="alert">
                                            {this.state.msg}
                                        </div>
                                    )}
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="row">
                        <div className="col-md-12">
                            <h2 className="text-center mt-4">Slot List</h2>
                            <div className="table-responsive">
                                <table className="table table-striped table-bordered">
                                    <thead className="thead-dark">
                                        <tr>
                                            <th>Slot Date</th>
                                            <th>Slot Start Time</th>
                                            <th>Slot End Time</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {this.state.slotarr.map(slot =>
                                            <tr key={slot.slotid}>
                                                <td>{slot.slot_date}</td>
                                                <td>{slot.slot_start_time}</td>
                                                <td>{slot.slot_end_time}</td>
                                                <td>
                                                    <button
                                                        className="btn btn-danger btn-sm"
                                                        onClick={() => this.deleteSlot(slot.slotid)}
                                                    >
                                                        Delete
                                                    </button>
                                                </td>
                                            </tr>
                                        )}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </>
        );
    }
}

export default AddSlot;
