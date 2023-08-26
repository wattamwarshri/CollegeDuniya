import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { Link } from "react-router-dom";
import StudentService from "../services/StudentService";

const ListStudentComponent = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    getAllStudents();
  }, []);


    const getAllStudents = () => 
    {
      StudentService.getStudents()
      .then((response) => {
        setStudents(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
    }

    const deleteStudent = (studentId) =>
    {
      console.log(studentId);
      StudentService.deleteStudent(studentId).then((response)=>{
        getAllStudents();
      }).catch(error => {console.log(error);})
    }

  return (
    <div>
      {/* JSX Code */}
      <h1 className="text-center">Student List </h1>
      <Link to="/add-student">
        <div className="row">
          <button className="btn btn-primary">Add Student</button>
        </div>{" "}
        <br />
      </Link>
      <div className="row">
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th> First Name</th>
              <th>Student Last Name</th>
              <th>Student Email Id</th>
              <th>Actions</th>
            </tr>
          </thead>

          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.firstName}</td>
                <td>{student.lastName}</td>
                <td>{student.emailId}</td>
                <center>
                  <td>
                    <Link className="btn btn-info btn-block mb-4" to={`/edit-student/${student.id}`}>Edit</Link>
                  
                    <button className="btn btn-danger btn-block mb-4" onClick={()=>deleteStudent(student.id)} style={{marginLeft : "10px"}}>Delete</button>
                    
                  </td>
                </center>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ListStudentComponent;
