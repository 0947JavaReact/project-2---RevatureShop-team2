import React, {useState} from 'react';

import { Link } from "react-router-dom";
import Logo from './logo.jpg';
import ItemServices from './services/ItemService';

{/* NewItem! */}
function NewItem(props) {
    let [item, setItem] = useState({name:null, photo:null, price:null})
    //let formData = new FormData()
    //formData.append('imageUpload',imageUpload)
    //formData.append('fName',fName)

    // funtion handleChange(e){
    //     let val = e.target.value;
    //     console.log(val)
    //     console.log(e.target.name)
    // }
    const onChange = (e) => {
        //formData.append('imageUpload',item.photo);
        setItem({ ...item,[e.target.name]: e.target.value}) 
    }
    const addimage = (e) => {
        let formData = new FormData();
        formData.append('imageUpload',item.photo);
        console.log(formData);
        setItem({ ...item,[item.photo]: formData});
    }

    function submitItem(e) {
        //add item from state with itemservice
        console.log(item);
        //formData.append('imageUpload',item.photo);
        //formData.append(item.photo,'imageUpload',)
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
                            <button type="submit">Upload Image</button>
                        </form>
                    </div>
                    {/* <h5>Item Image</h5>
                    <input type='text' /> */}

                    <h5>Name of Item</h5>
                    <input name="name" value={item.name} onChange={onChange} type='text' />

                    <h5>Price of Item</h5>
                    <input name="price" value={item.price} onChange={onChange} type='number' />

                    {/* <h5>Type of Item</h5>
                    <select className="dropdown">
                        <option value="Electronics">Electronics</option>
                        <option value="Food">Food</option>
                        <option value="Clothing">Clothing</option>
                    </select> */}

                    <button type='submit' className='login__signInButton' onClick={submitItem} >Submit New Item to Store</button>

                </form>
            </div>
            
        </div>

    )
        
}
export default NewItem;