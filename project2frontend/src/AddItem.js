import React from 'react';

import { Link } from "react-router-dom";
import Logo from './logo.jpg';
{/* NewItem! */}
function NewItem() {

    return (
        <div className='newitem'>
            <Link to='./login'>
                <img className='logo_login'
                    src={Logo} alt='logo' />
            </Link>
            <div className='new_item_container'>
                <h1>Add a New Item to the Store!</h1>

                <form>
                    <h5>Item Image</h5>
                    <input type='text' />

                    <h5>Name of Item</h5>
                    <input type='text' />

                    <h5>Price of Item</h5>
                    <input type='number' />

                    <h5>Type of Item</h5>
                    <select className="dropdown">
                        <option value="Electronics">Electronics</option>
                        <option value="Food">Food</option>
                        <option value="Clothing">Clothing</option>
                    </select>

                    <button type='submit' className='login__signInButton' onClick="/add_new_item" >Submit New Item to Store</button>

                </form>
            </div>
        </div>

    )

}
export default NewItem;