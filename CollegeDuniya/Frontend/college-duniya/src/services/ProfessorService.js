import axios from 'axios';

const PROFESSOR_API_BASE_URL="http://localhost:8080/api/v1/professors";

class ProfessorService
{
    getAllProfessors()
    {
        return axios.get(PROFESSOR_API_BASE_URL + "/ListOfProfessors");
    }

    addProfessor(professor)
    {
        return axios.post(PROFESSOR_API_BASE_URL,professor);
    }

}

export default new ProfessorService();