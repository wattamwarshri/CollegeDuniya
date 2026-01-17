import axios from 'axios';

const USER_API_BASE_URL="http://localhost:8080/api/v1/user";
class UserService
{
    login(loginDto)
    {
        return axios.post(USER_API_BASE_URL+"/login",loginDto);
    }

    SignUp(user)
    {
        return axios.post(USER_API_BASE_URL+"/signup",user);
    }
}

export default new UserService();