import axios from 'axios';
import React from 'react';
import * as ReactBootstrap from 'react-bootstrap';
import './item.css';
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

            <button onClick = { () => axios.post("http://localhost:9025/cart/add", localStorage.user, this.name, this.price, this.id)}>Add to Cart</button>

        </div>
    )
}

export default Item
