import React, {useState} from 'react';

import { Link } from "react-router-dom";
import Logo from './logo.jpg';
import ItemServices from './services/ItemService';

{/* NewItem! */}
function NewItem(props) {
    let [item, setItem] = useState({name:null, photo:null, price:null})
    
    const onChange = (e) => {
        
        setItem({ ...item,[e.target.name]: e.target.value}) 
        
    }
    const addimage = (e) => {
        let formData = new FormData();
        
        console.log(formData);

        setItem({ ...item,["item.photo"]: formData.append('imageUpload',item.photo)});
        console.log(formData);
    }

    function submitItem(e) {
        //add item from state with itemservice
        console.log(item);
        
        e.preventDefault();
        ItemServices.createItem(item)
    }
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
                    <div className="testingImage">
                        <form name="imageUpload" encType="multipart/form-data" method="post">
                            <input name="photo" value={item.photo} onChange={addimage} type="file" name="photo" id="imageUpload"></input>
                            {/* <button type="submit">Upload Image</button> */}
                        </form>
                    </div>

                    <h5>Name of Item</h5>
                    <input name="name" value={item.name} onChange={onChange} type='text' />

                    <h5>Price of Item</h5>
                    <input name="price" value={item.price} onChange={onChange} type='number' />

                    <button type='submit' className='login__signInButton' onClick={submitItem} >Submit New Item to Store</button>

                </form>
            </div>
            
        </div>

    )
        
}
export default NewItem;
