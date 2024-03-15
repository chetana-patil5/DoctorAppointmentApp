import React, { Component } from 'react';
import SlotService from '../service/SlotService';
import LoginNavbar from './LoginNavbar';
import '../Styles/Slot.css';

export default class Slot extends Component {
    constructor(props) {
        super(props);
        this.state = {
            doc_id: this.props.match.params.id,
            msg: '',
            slotarr: [],
        };
    }

    componentDidMount() {
        SlotService.unCateredSlotById(this.state.doc_id).then((response) => {
            this.setState({ slotarr: response.data });
        });
    }

    handleBookSlot = (id, time, date) => {
        const patient_id = window.sessionStorage.getItem("patID");
        SlotService.bookSlot(id, patient_id).then((response) => {
            if (response.data === "Updated") {
                alert(`Slot is booked\nSlot Details:\nTime: ${time}\nDate: ${date}`);
                SlotService.unCateredSlotById(this.state.doc_id).then((response) => {
                    this.setState({ slotarr: response.data });
                });
            } else {
                this.setState({ msg: "Sorry! Your Slot is not Booked! Try again." });
            }
        });
    };

    viewProfile = () => {
        this.props.history.push("/pat");
    };

    render() {
        return (
            <>
                <LoginNavbar />
                <div className="slot-container">
                    <h2 className="slot-heading">Slot List</h2>
                    <h3 className="error-msg">{this.state.msg}</h3>
                    <div className="table-responsive">
                        <table className="table table-bordered table-striped">
                            <thead className="thead-dark">
                                <tr>
                                    <th>Slot Date</th>
                                    <th>Slot Start Time</th>
                                    <th>Slot End Time</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.slotarr.map((slot) => (
                                    <tr key={slot.slotid} hidden={slot.slot_status}>
                                        <td>{slot.slot_date}</td>
                                        <td>{slot.slot_start_time}</td>
                                        <td>{slot.slot_end_time}</td>
                                        <td>
                                            <button className="btn btn-info" onClick={() => this.handleBookSlot(slot.slotid, slot.slot_start_time, slot.slot_date)}>Book</button>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                   <center>
                   <button className="btn btn-danger go-to-profile-btn" onClick={this.viewProfile}>Go to Profile</button>
                   </center>
                </div>
            </>
        );
    }
}






// import React, { Component } from 'react'
// import SlotService from '../service/SlotService';
// import LoginNavbar from './LoginNavbar';


// export default class slot extends Component {
//     constructor(props) {
//         super(props);
//         this.state = {
//             doc_id: this.props.match.params.id,
//             msg: '',
//             slotarr: []
//         }

//         console.log("in Slottttttttttttttttttttttttttttttttttt  ")

//     }

//     componentDidMount() {
//         console.log("Component did mount of slot DidMount");
//         SlotService.unCateredSlotById(this.state.doc_id).then(
//             (response) => {
//                 this.setState({ slotarr: response.data });
//                 console.log(this.state.slotarr);
//             }
//         )
//     }

//     handleBookSlot = (id, time, date) => {
//         const patient_id = window.sessionStorage.getItem("patID");
//          console.log("patient id : "+patient_id)
//         SlotService.bookSlot(id, patient_id).then(
//             (response) => {
//                 if (response.data === "Updated") {
//                     alert("Slot is booked" + "\nSlot Details:\nTime: " + time + "\nDate: " + date)
//                     SlotService.unCateredSlotById(this.state.doc_id).then(
//                         (response) => {
//                             this.setState({ slotarr: response.data });
//                             console.log(this.state.slotarr);
//                         }
//                     )
//                 }
//                 else {
//                     this.setState({ msg: "Sorry ! Your Slot is not Booked ! Try again." })
//                 }
//             }
//         )

//     }

//     viewProfile = (event) => {
//         this.props.history.push("/pat")
//     }

//     render() {
//         return (
//             <>
//              <LoginNavbar/>
//             <div>
               
//                 <div>
//                     <center><h2 className="text-center">Slot List</h2></center>
//                     <br />
//                     <h3>{this.state.msg}</h3>
//                     <center>
//                     <div className="Row">
//                         <table class="table" >
//                             <thead class="thead-dark">
//                                 <tr>
//                                     <th>Slot Date</th>
//                                     <th>Slot Start Time</th>
//                                     <th>Slot End Time</th>
//                                     <th>Book</th>

//                                 </tr>
//                             </thead>
//                             <tbody>
//                                 {
//                                     this.state.slotarr.map(slot =>
//                                         <tr hidden={slot.slot_status}> 
//                                             <td key={slot.slotid}>{slot.slot_date}</td>
//                                             <td>{slot.slot_start_time}</td>
//                                             <td>{slot.slot_end_time}</td>
                                            
//                                             <td>
//                                                 <button className="btn btn-info" onClick={() => this.handleBookSlot(slot.slotid, slot.slot_start_time, slot.slot_date)}>Book</button>
//                                             </td>
//                                         </tr>
//                                     )
//                                 }
//                             </tbody>
//                         </table>
//                     </div>
//                     <button className="btn btn-danger " onClick={this.viewProfile} style={{ marginLeft: "10px" }}>Go to profile</button>
//                     </center>
//                 </div>
//             </div>
//             </>
//         )
//     }
// }







