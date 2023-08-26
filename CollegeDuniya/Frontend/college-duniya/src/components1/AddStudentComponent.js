import React, { useEffect, useState } from "react";
import StudentService from '../services/StudentService'
import { useNavigate,useParams } from "react-router-dom";
import { Link } from 'react-router-dom';

const AddStudentComponent = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [emailId, setEmailId] = useState("");
  const navigate = useNavigate();
  const {id} = useParams();


  const saveOrUpdateStudent = (e) =>
  {
    e.preventDefault();
    const student = {firstName,lastName,emailId}
    console.log(student);

  if(id)
  {
    StudentService.updateStudent(id,student).then((response)=> {
      navigate("/students")
    }).catch(error => {console.log(error);})
  }

  else{
    StudentService.addStudent(student).then((response)=>{console.log(response.data)
      navigate("/students")}).catch(error => {console.log(error);})
  }

    

    }
  
    useEffect(()=> {
      StudentService.getStudentById(id).then((response)=>{
        setFirstName(response.data.firstName)
        setLastName(response.data.lastName)
        setEmailId(response.data.emailId)
      }).catch(error =>
        {
          console.log(error);
        })
    }, [])


    const title = () =>
    {
      if(id)
      {
        return <h1 className="text-center">Update Student</h1>
      }
      else
      {
        return <h1 className="text-center">Add Student</h1>
      }
    }

  return (
    <div>
      {
        title()
      }
      <form>
        {/* <!-- 2 column grid layout with text inputs for the first and last names --> */}
        <div className="row mb-30">
          <div className="col">
            <div className="form-outline">
              <label className="form-label" for="firstName">
                First Name
              </label>
              <input type="text" id="firstName" className="form-control" value={firstName} 
              onChange={(e) => setFirstName(e.target.value)}/>
            </div>

          </div>
          <div className="col">
            <div className="form-outline">
              <label className="form-label" for="lastName">
                Last Name
              </label>
              <input type="text" id="lastName" className="form-control" value={lastName}
              onChange={(e)=> setLastName(e.target.value)} />
            </div>
          </div>
        </div>

        {/* <!-- Email input --> */}
        <div className="form-outline mb-4">
          <label className="form-label" for="email">
            Email
          </label>
          <input type="email" id="email" className="form-control" value={emailId} 
           onChange={(e) => setEmailId(e.target.value)} />
        </div>




        {/* <!-- Submit button --> */}
        <center>
          <button type="submit" className="btn btn-primary btn-block mb-4" onClick={(e)=>saveOrUpdateStudent(e)}>
            Submit
          </button>

        <Link to ="/students" className="btn btn-danger btn-block mb-4">Cancel</Link>
        </center>
      </form>
    </div>
  );
};

export default AddStudentComponent;
