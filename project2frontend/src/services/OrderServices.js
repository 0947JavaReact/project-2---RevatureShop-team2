import axios from 'axios';

const ORDER_API_BASE_URL = "http://localhost:9025/order";

class OrderServices{
        //getAll
        getOrders(){
            return axios.get(ORDER_API_BASE_URL+'/all');
        }
        createUser(order){
            return axios.post(ORDER_API_BASE_URL , order);
        }
        getOrderByUserId(userID){
            return axios.get(ORDER_API_BASE_URL + '/' + userId);
        }
        getOrderByOrderId(orderID){
            return axios.get(ORDER_API_BASE_URL + '/user/' + userId);
        }
}

export default new OrderServices()