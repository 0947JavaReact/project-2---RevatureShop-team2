import React, {useState,useEffect } from 'react';
import { Link } from "react-router-dom";
import Logo from './logo.jpg';
import './Store.css';
import { connect } from "react-redux"
import {fetchItems} from './actions/itemActions'
import { useDispatch, useSelector } from 'react-redux';


function ShowItems() {
    const currentItems = useSelector(state => state.item.items)
    const dispatch = useDispatch();
   
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
                                    <td><button>Add to Cart</button></td>
                                    {/* <td>add to cart button calls cart Services and updates user cart</td> */}
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
