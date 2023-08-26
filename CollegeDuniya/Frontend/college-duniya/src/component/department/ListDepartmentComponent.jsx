import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

import DepartmentService from "../../services/DepartmentService"

const ListDepartmentComponent = () => {

    const [departments, setDepartments] = useState([])

    useEffect(() => {
        getAllDepartments();
    }, [])


    const getAllDepartments = () => 
    {
        DepartmentService.getAllDepartments()
      .then((response) => {
        setDepartments(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
    }

  return (
    <div>
      {/* JSX Code */}
      <h1 className="text-center">Department List </h1>
      <Link to="/add-student">
        <div className="row">
          <button className="btn btn-primary">Add Department</button>
        </div>{" "}
        <br />
      </Link>

      <div className="row">
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th>Department Id</th>
              <th>Department Name</th>
              <th>Phone Number</th>
              <th>Actions</th>
            </tr>
          </thead>

          <tbody>
            {departments.map((department) => (
                <tr key={department.departmentId}>
                  <td>{department.departmentId}</td>
                <td>{department.departmentName}</td>
                <td>{department.phoneNo}</td>
                <center>
                  <td>
                     <Link className="btn btn-info btn-block mb-4" >Edit</Link> 
                     {/* to={`/edit-student/${student.id}`} */}

                     <button className="btn btn-danger btn-block mb-4" >Delete</button> 
                     {/* onClick={()=>deleteStudent(student.id)} style={{marginLeft : "10px"}} */}
                    
                  </td>
                </center>
              </tr> 
             ))}
          </tbody> 
        </table>
      </div>
    </div>
  )
}

export default ListDepartmentComponent
