import axios from 'axios';

const ORDER_API_BASE_URL = "http://localhost:9025/order";

class OrderServices{
        //getAll
        getOrders(){
            return axios.get(ORDER_API_BASE_URL+'/all');
        }
        createOrder(order){
            return axios.post(ORDER_API_BASE_URL +'/', order);
        }
        getOrderByUserId(userID){
            return axios.get(ORDER_API_BASE_URL + '/user/' + userID);
        }
        getOrderByOrderId(orderID){
            return axios.get(ORDER_API_BASE_URL + '/' + orderID);
        }
        udpateByOrderId(orderID){
            return axios.put(ORDER_API_BASE_URL + '/update/' + orderID);
        }
}

export default new OrderServices()