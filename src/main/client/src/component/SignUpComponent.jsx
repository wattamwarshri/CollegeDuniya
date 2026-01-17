import React, { useState } from 'react';
import UserService from '../services/UserService';
import { Navigate, useNavigate } from 'react-router-dom';


// import { ToastContainer, toast } from 'react-toastify';
const SignUpComponent = () => {

      // const showToastMessage = () => {
  //   toast.success('Success Notification !', {
  //     position: toast.POSITION.TOP_RIGHT
  //   });

  //   toast.error('Error Notification !', {
  //     position: toast.POSITION.TOP_CENTER
  //   });
  // };

  const [registerData, setRegisterData] =  useState({ name: "", email: "", username: "", password: "", address: "", contact: "" });
  const navigate = useNavigate();
  // const [message, setMessage] = useState("");

  const changeHandle = (event) => {
    const { name, value } = event.target
    setRegisterData({ ...registerData, [name]: value });
  }
  const addData = (event) => {
    event.preventDefault();

    if (registerData.name === "" || registerData.email === "" || registerData.username === "" || registerData.password === "" || registerData.address === "" || registerData.contact === "") {
      // setMessage("Plase enter valid data..");
    //   toast.error("Plase enter valid data..");//{ position: toast.POSITION.CENTER_LEFT });
      return;
    }
    let registerData1 = { name: registerData.name, email: registerData.email, username: registerData.username, password: registerData.password, address: registerData.address, contact: registerData.contact }
    UserService.SignUp(registerData1)
      .then((result) => {
        console.log(result);
        navigate("/");
        // setMessage("Registration successfull..");
        // toast.success("Registration successfull..");
      })
      .catch((error) => {
        console.log(error);
        // setMessage("Error 400/500..");
        // toast.error("Error 400/500..");
        
      });

    setRegisterData({ name: "", email: "", username: "", password: "", address: "", contact: ""});
  }


  return (
    <div className='container my-5 mx-auto border-4 border-dark p-2'>
      <div className='col-sm-6 offset-sm-3 border border-dark shadow p-3 rounded-2 register-bg'>
        {/* <ToastContainer></ToastContainer> */}
        <h3 className='m-3 text-danger'>SignUp Page</h3>
        <form action="/">
          {/* <p className='register-message'>{message}</p> */}
          <div className="mb-2 mt-5">
            <label for="name" className="form-label font-weight-bold text-left">Name</label>
            <input type="text" className="form-control" id="name" placeholder="Enter Name" name="name" value={registerData.name} onChange={changeHandle} />
          </div>

          <div className="mb-2 mt-2">
            <label for="email" className="form-label font-weight-bold text-left">Email</label>
            <input type="email" className="form-control" id="email" placeholder="Enter Email" name="email" value={registerData.email} onChange={changeHandle} />
          </div>

          <div className="mb-2 mt-2">
            <label for="text" className="form-label font-weight-bold text-left">Username</label>
            <input type="username" className="form-control" id="username" placeholder="Enter Username" name="username" value={registerData.username} onChange={changeHandle} />
          </div>

          <div className="mb-2 mt-2">
            <label for="text" className="form-label font-weight-bold text-left">Password</label>
            <input type="password" className="form-control" id="password" placeholder="Enter Password" name="password" value={registerData.password} onChange={changeHandle} />
          </div>

          <div className="mb-2 mt-2">
            <label for="address" className="form-label font-weight-bold text-left">Address</label>
            <input type="text" className="form-control" id="address" placeholder="Enter Address" name="address" value={registerData.address} onChange={changeHandle} />
          </div>

          <div className="mb-2 mt-2">
            <label for="contact" className="form-label font-weight-bold text-left">Contact</label>
            <input type="text" className="form-control" id="contact" placeholder="Enter Contact No" name="contact" value={registerData.contact} onChange={changeHandle} />
          </div>

        <center>
          <button type="button" className="btn btn-primary bg-danger p-2 px-5" onClick={addData}>Register</button></center>
        </form>
      </div>
    </div>
  )
}

export default SignUpComponent
