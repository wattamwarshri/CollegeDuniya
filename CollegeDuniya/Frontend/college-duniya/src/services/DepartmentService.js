import axios from 'axios';

const DEPARTMENT_API_BASE_URL="http://localhost:8080/api/v1/department";

class DepartmentService
{
    getAllDepartments()
    {
        return axios.get(DEPARTMENT_API_BASE_URL + "/ListOfDepartments");
    }
}

export default new DepartmentService();