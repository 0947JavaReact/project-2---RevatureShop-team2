import axios from 'axios';
import React, {Component} from 'react';
import { Link } from 'react-router-dom';
import './Checkout.css';
import Item from './Components/ItemComp/item';


const Checkout = () =>{

    let loggedUser = JSON.parse(localStorage.getItem("user"))
    console.log(loggedUser)
    const [itemList, setItemList] = React.useState([]);

    function removeFromCart(id){
        const newList = itemList.filter((item) => item.id !== id);
        setItemList(newList);
    }
    function addItemsToCart(){
        fetch('http://localhost:9025/cart/'+ loggedUser.userId).then(item => item.json())
        .then( item => {
            itemList.push(item.items);
            setItemList(itemList);
        })
    }
    addItemsToCart();

    let count = 0;
    console.log(itemList.length);
    return (
        <div className = "checkout">
            <div className = 'checkout_container'>
                <h3>Your Cart: </h3>
                <table>
                    <tr>
                        <th>Name of Product&nbsp;&nbsp;</th>
                        <th>Price&nbsp;&nbsp;</th>  
                    </tr>
                    <tbody>
                        {
                            itemList.map(function(currItem){
                            return(
                               
                                <tr id={currItem.[itemList.indexOf(currItem)].itemId}>
                                    <td>{currItem.[itemList.indexOf(currItem)].name}</td>
                                    <td>{currItem.[itemList.indexOf(currItem)].price}</td>
                                    <td><button onClick={ () => removeFromCart(currItem.id)}>remove from cart</button></td>
                                </tr>
                            )
                            })
                        }
                    </tbody>
                </table>
                <p>Total amount: </p>
                <button onClick = { () => axios.post("http://localhost:9025/order", {
        creator : loggedUser.userId, 
    })}>Checkout</button>
            </div>
        </div>
    )
}

export default Checkout;