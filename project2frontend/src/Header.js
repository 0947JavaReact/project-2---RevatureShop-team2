import React from 'react'
import './Header.css';
import { Link } from "react-router-dom";
import Logo from "./logo.jpg";
import SearchIcon from "@material-ui/icons/Search";
import ShoppingBasketIcon from "@material-ui/icons/ShoppingBasket"

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

        {/* Search box */}
        
        <div className="header__search">
           <input type = "text" className="header__searchInput"/>
        <SearchIcon className= "header__searchIcon"/>
        </div>
        
        
        {/* 3 Links */}
        <div className ="header__nav">
            {/* 1st link */}
            <Link to ="/login" className="header__link">
                <div className="header__option">
                    <span className = "header__optionLineOne">Hello!</span>
                    <span className = "header__optionLineTwo" > Sign In</span>
                </div>
            </Link>


            {/* 2nd link */}
            <Link to ="/orders" className="header__link">
                <div className="header__option">
                    <span className = "header__optionLineOne">Your</span>
                    <span className = "header__optionLineTwo">Orders</span>
                </div>
            </Link>

    

            {/* 3rd link */}
            <Link to ="/checkout" className= "header__link">
                <div className="header__optionBasket">
                    {/*Shopping basket icon */}
                    <ShoppingBasketIcon/>
                    <span className="header__optionLineTwo header__basketCount"></span>
                </div>
            </Link>
         </div>


    </nav>
);

}

export default Header
