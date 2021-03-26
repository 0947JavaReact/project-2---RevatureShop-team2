import React from 'react';
import { Link } from "react-router-dom";
import Logo from './logo.jpg';



//const ShowItems = (props)=>{

function ShowItems() {
    
    return (
        <div className="store_catalogue">
            {/* <Link to='./store_catalogue'>
            </Link> */}
            <div className='store_container'>
                <table>
                    <tr>
                        <th>Image of Product</th>
                        <th>Name of Product</th>
                        <th>Price</th>
                        <th>Add to Cart(with quantity)</th>
                        <th>Quantity</th>
                    </tr>
                    {/* //for each item, add the row:
                    React.createElement("tr",null,null);
                    React.createElement("td",img,)
                    React.createElement("td",name,)
                    React.createElement("td",description,)
                    React.createElement("td",price,)
                    React.createElement("td",quantity,) */}
                    {/* <tr>
                        <td>{props.img}</td>
                        <td>{props.name}</td>
                        <td>{props.description}</td>
                        <td>{props.price}</td>
                        <td>**counter**</td>
                    </tr> */}
                </table>
            </div>
            <div>
                <Link to="/add_new_item" >
                    <button className='login__registerButton'>Add New Item</button>
                </Link>
            </div>
        </div>
    )
}
export default ShowItems;