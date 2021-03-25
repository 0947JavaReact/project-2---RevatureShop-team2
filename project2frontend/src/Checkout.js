import React, {Component} from 'react';
import { Link } from 'react-router-dom';
import Logo from "./logo.jpg";
import './Checkout.css';
import Product from './Product';

const list = [
    {
        id: '1234',
        title: 'Acer - Chromebook Spin 713 2-in-1 13.5in 2K VertiView 3:2 Touch - Intel i5-10210U - 8GB Memory - 128GB SSD – Steel Gray',
        price: 529.00,
    },
    {
        id: '12',
        title: 'Acer - Chromebook',
        price: 529.00,
    },
    {
        id: '123',
        title: 'Macbook Pro',
        price: 999.00,
    }
];

const Checkout = () =>{
    const [itemList, setItemList] = React.useState(list);


    function removeFromCart(id){
        const newList = itemList.filter((item) => item.id !== id);

        setItemList(newList);
    }
    function addItemsToCart(){
        fetch('').then(item => item.json())
        .then( item => {
            itemList.push(item);
            setItemList(itemList);
        })
    }
    return (
        <div className = "checkout">
            <Link to = './'>
                <img  className='logo_checkout'
                    src={Logo} alt = 'logo' />
            </Link>
            <div className = 'checkout_container'>
                <h3>Your Cart: </h3>
                <ul>
                    {itemList.map((item) => (
                        <li key={itemList.indexOf(item)}>
                            <div className = "Product_row">
                                <Product
                                    id={item.id}
                                    title={item.title}
                                    price = {item.price}
                                />
                                <button onClick={ () => removeFromCart(item.id)}>remove from cart</button>
                            </div>
                        </li>
                    ))}
                </ul>
                <p>Total amount: </p>
                <button>Checkout</button>
            </div>
        </div>
    )
}

export default Checkout;