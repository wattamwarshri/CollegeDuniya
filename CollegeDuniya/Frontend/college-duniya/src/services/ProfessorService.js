import axios from 'axios';

const PROFESSOR_API_BASE_URL="http://localhost:8080/api/v1/professors";

class ProfessorService
{
    getAllProfessors()
    {
        return axios.get(PROFESSOR_API_BASE_URL + "/ListOfProfessors");
    }

}

export default new ProfessorService();