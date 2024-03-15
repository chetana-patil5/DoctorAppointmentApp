import React, { Component } from 'react';
import SlotService from '../service/SlotService';
import LoginNavbar from './LoginNavbar';

export default class viewSlot extends Component {
    constructor(props) {
        super(props);
        this.state = {
            slotarr: [],
            msg: ''
        };
    }

    componentDidMount() {
        console.log("Component did mount of Category DidMount");
        SlotService.getBookedSlot(window.sessionStorage.getItem("docID")).then(
            (response) => {
                if (response.data.length === 0) {
                    this.setState({
                        msg: "NO BOOKED SLOTS FOR TODAY"
                    });
                }
                this.setState({ slotarr: response.data });
                console.log(this.state.slotarr);
            }
        );
    }

    viewProfile = (event) => {
        this.props.history.push("/doc");
    };

    render() {
        return (
            <>
                <LoginNavbar />
                <div>
                    <div className="container">
                        <center>
                            <h2 className="text-center mt-4">Your Slots</h2>
                        </center>
                        <div className="text-center">
                            <h3>{this.state.msg}</h3>
                        </div>
                        <center>
                            <div className="row">
                                <table className="table table-striped table-bordered">
                                    <thead className="thead-dark">
                                        <tr>
                                            <th>Slot Date</th>
                                            <th>Slot Start Time</th>
                                            <th>Slot End Time</th>
                                            <th>Patient Id</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {this.state.slotarr.map(slot =>
                                            <tr key={slot.slot_id}>
                                                <td>{slot.slot_date}</td>
                                                <td>{slot.slot_start_time}</td>
                                                <td>{slot.slot_end_time}</td>
                                                <td>{slot.slot_patient_id}</td>
                                            </tr>
                                        )}
                                    </tbody>
                                </table>
                            </div>
                            <button className="btn btn-primary" onClick={this.viewProfile}>Go to Profile</button>
                        </center>
                    </div>
                </div>
            </>
        );
    }
}
