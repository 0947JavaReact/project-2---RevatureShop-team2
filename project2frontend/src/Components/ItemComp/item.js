import React from 'react';

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

           
            <button>Add to Cart</button>

        </div>
    )
}

export default Item
