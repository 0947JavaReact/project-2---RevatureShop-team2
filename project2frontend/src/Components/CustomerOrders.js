import React, {useState,useEffect } from 'react';
import OrderServices from '../services/OrderServices'

//need to display order id, products, totalPrice statusShipping(either delivered or in progress), 
function CustomerOrders(props) {
   let [orders,setOrders] = useState([]) 

   useEffect(() => {
    const fetchData = async () => {
      OrderServices.getOrderByUserId(1).then(res => {
      let data = res.data
      setOrders(data) 
   })}
    fetchData();
    },[])
    return(
    <div>
      
      <br />
      <p>Takes in orders(past and current) as list and displays</p>
      <table>
        <tr>
          <th>OrderID &nbsp; </th>
          <th>Product List   &nbsp; </th>
          <th>Total Price   &nbsp;</th>
          <th>Shipping Status    &nbsp; </th> 
        </tr>
        <tbody>
            {
              orders.map(function(currOrder){
                  return(
                    <tr>
                      <td>{currOrder.orderNumber}</td>
                    <td><ul>{currOrder.items.map(function(currItem){return( <li>{currItem.name}</li>)})}  </ul></td>
                      <td>{currOrder.amount}</td>
                      <td>{ (currOrder.deliverTime == null) ? 'In progress': currOrder.deliverTime}</td> 
                    </tr>
                  )
              })
            }
        </tbody>
      </table>
    </div>
      )
    }
export default CustomerOrders