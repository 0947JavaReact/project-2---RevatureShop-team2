import React from 'react';
import * as ReactBootstrap from 'react-bootstrap';
import './item.css';
import logo from './img.png'
import ItemButton from "./itembutton";

function Item({id, name, image, price}) {

    return (
        <div className = "product">
            <div className = "product__info">
                <p>{name}</p>
                <p className= "product__price">
                    <small>$</small>
                    <strong>{price}</strong>
                </p>
            </div>

            <img src ={logo} alt=""/>
            <button>Add to Cart</button>

        </div>
    )
}

export default Item
