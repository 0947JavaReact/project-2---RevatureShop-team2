import axios from 'axios';

const USER_API_BASE_URL = "http://localhost:9025/user";

{/* User Services! */ }

class UserServices {

    // Get all users
    getUsers(){
        return axios.get(USER_API_BASE_URL);
    }
    // Get user's email
    getEmail(emailId){
        return axios.get(USER_API_BASE_URL + '/' + emailId);
    }
    // Create user
    createUser(user){
        return axios.post(USER_API_BASE_URL , user);
    }
    // Get user by ID
    getUserById(userId){
        return axios.get(USER_API_BASE_URL + '/' + userId);
    }
    // Get user's email and password to login
    getUserLogin(emailId, password){
        let user = axios.get(USER_API_BASE_URL+"/user/" + '?emailId=' + emailId+'&password='+password).then((response) => {
            localStorage.setItem("user", JSON.stringify(response.data))
          });
        return axios.get(USER_API_BASE_URL+"/user/" + '?emailId=' + emailId+'&password='+password)
    }
    // Update user
    updateUser(user, userId){
        return axios.put(USER_API_BASE_URL + '/' + userId, user);
    }
     // Update user address
     updateUserAddress(user, userId){
        return axios.put(USER_API_BASE_URL + '/address/' + userId, user);
    }
    // Delete user
    deleteUser(userId){
        return axios.delete(USER_API_BASE_URL + '/' + userId);
    }
    resetEmail(emailId){
        return axios.get(USER_API_BASE_URL + '/reset/' + emailId);
    }
}

export default new UserServices()