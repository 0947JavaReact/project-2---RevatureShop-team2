import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:3000/users";

{/* User Services! */ }

class UserServices {

    getUsers(){
        return axios.get(USER_API_BASE_URL);
    }
    //email
    getEmail(){
        return axios.get(USER_API_BASE_URL + '/' + emailId);
    }

    createUser(user){
        return axios.post(USER_API_BASE_URL , user);
    }

    getUserById(userId){
        return axios.get(USER_API_BASE_URL + '/' + userId);
    }

    getUserLogin(emailId, password){
        return axios.get(USER_API_BASE_URL+"/user" + '?emailId=' + emailId+'&password='+password)
        .then(response => {
            if (response.data) {
                localStorage.setItem("user", JSON.stringify(response.data));
            }
            return response.data;
        });
    }
    
    updateUser(user){
        return axios.put(USER_API_BASE_URL + '/' + user);
    }

    deleteUser(userId){
        return axios.delete(USER_API_BASE_URL + '/' + userId);
    }
}

export default new UserServices()