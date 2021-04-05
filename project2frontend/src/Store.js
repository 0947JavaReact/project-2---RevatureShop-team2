import React, {useState,useEffect } from 'react';
import axios from 'axios';
import { Link } from "react-router-dom";
import Logo from './logo.jpg';
import './Store.css';
import { connect } from "react-redux"
import {fetchItems} from './actions/itemActions'
import { useDispatch, useSelector } from 'react-redux';


function ShowItems() {
    const currentItems = useSelector(state => state.item.items)
    const dispatch = useDispatch();
   
    let loggedUser = JSON.parse(localStorage.getItem("user"))
    console.log(loggedUser)
    useEffect(() => {
         dispatch(fetchItems())
        },[])

    return (
        <div className="store_catalogue">
            {/* <Link to='./store_catalogue'>
            </Link> */}
            <div className='store_container'>
                <table>
                    <tr>
                        <th>Image of Product&nbsp;&nbsp;</th>
                        <th>Name of Product&nbsp;&nbsp;</th>
                        <th>Price&nbsp;&nbsp;</th>
                        <th>Add to Cart&nbsp;&nbsp;</th>  
                    </tr>
                    <tbody>
                        {
                            currentItems.map(function(currItem){
                            let photoString = "data:image/png;base64," + currItem.photo;
                            return(
                               
                                <tr id={currItem.itemId}>
                                    <td><img src={photoString}/></td>
                                    <td>{currItem.name}</td>
                                    <td>{currItem.price}</td>
<<<<<<< HEAD
                                    <td><button onClick = { () => axios.post("http://localhost:9025/cart/add", {
        userId : loggedUser.userId, 
        item : [{
            name : currItem.name,
            price : currItem.price, 
            itemId : currItem.itemId
        }]
    })}>Add to Cart</button></td>
=======
                                    <td><button>Add to Cart</button></td>
                                    {/* <td>add to cart button calls cart Services and updates user cart</td> */}
>>>>>>> 0aae443e9467cbd290e58355f7ac078e02ea0114
                                </tr>

                            )
                            })
                        }
                    </tbody>
                </table>
            </div>
            <div>
                <Link to="/add_new_item" >
                    <button className='addNewItem'>Add New Item</button>
                </Link>
            </div>
        </div>
    )
}
export default connect(null,{fetchItems})(ShowItems);