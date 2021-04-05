import React from 'react'
import './header.css';
import { Link,withRouter} from "react-router-dom";
import Logo from "./logo.jpg";
import Logout from './Logout';
import Checkout from './Checkout';


{/* Banner Nav! */}
function Header() {
    return( 
    <nav className= "header">
        {/* logo on the left -> img */}
        <Link to = "/">
        <img 
            className="header__logo" 
            src={Logo}
            alt=""
        />

        </Link>

        <div className ="header__nav">
            {/* 1st link */}
            <Link to ="/store_catalogue" className="header__link">
                <div className="header__option">
                    <span className = "header__optionLineOne">Store</span>
                </div>
            </Link>


            {/* 2nd link */}
            <Link to ="/CustomerInformation" className="header__link">
                <div className="header__option">
                    <span className = "header__optionLineOne">Customer Information</span>
                </div>
            </Link>

            <Link to ="/cart" className= "header__link">
                <div className="header__optionBasket">
                <span className = "header__optionLineOne">Cart</span>
                </div>
            </Link>

            {/* 3rd link */}
            <Link to ="/checkout" className= "header__link">
                <div className="header__optionBasket">
                    <Logout/>
                </div>
            </Link>

            
         </div>


    </nav>
);

}

export default Header