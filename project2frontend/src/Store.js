import React, {useState,useEffect } from 'react';
import { Link } from "react-router-dom";
import Logo from './logo.jpg';
import './Store.css';
import ItemServices from './services/ItemService'

//const ShowItems = (props)=>{

function ShowItems() {
    let [items,setItems] = useState([]) 
   
    useEffect(() => {
        const fetchData = async () => {
          ItemServices.getItems().then(res => {
          let data = res.data
          setItems(data) 
       })}
        fetchData();
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
                            items.map(function(currItem){
                            return(
                                <tr id={currItem.itemId}>
                                    <td>null</td>
                                    <td>{currItem.name}</td>
                                    <td>{currItem.price}</td>
                                    <td>add to cart button calls cart Services and updates user cart</td>
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
export default ShowItems;
