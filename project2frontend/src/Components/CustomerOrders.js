import { connect } from "react-redux"
import PropTypes from 'prop-types';
import React, {useState,useEffect } from 'react';
import {fetchOrders} from '../actions/orderActions'
import { useDispatch, useSelector } from 'react-redux';
//need to display order id, products, totalPrice statusShipping(either delivered or in progress), 
function CustomerOrders(props) {
  
  const currentOrders = useSelector(state => state.order.orders)
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(fetchOrders(6));
  }, [])
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
              currentOrders.map(function(currOrder){
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

export default connect(null,{fetchOrders})(CustomerOrders);