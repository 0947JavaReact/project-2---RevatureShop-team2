import React, {useState} from 'react';
//need to display order id, products, totalPrice statusShipping(either delivered or in progress), 
function CustomerOrders(props) {
    
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
            <tr>
              <td>1 </td>
              <td>testProduct</td>
              <td>10</td>
              <td>DELIVERED</td>
            </tr>
        </tbody>
      </table>
    </div>
      )
    }
export default CustomerOrders