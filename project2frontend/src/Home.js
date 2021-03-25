import React from 'react';
import Logo from "./logo.jpg";
import Product from "./Product";
import "./Home.css";
{/* Home Page */}
function Home() {
    return (
        
        <div className = "home">
             {/*Home banner Revature!*/}
            <img 
                className= "home__image"
                src={Logo}
                alt="Banner"
            />
           
            
            <div className="home__row">
                 {/*Product id, title, price, rating, image. Dummy products!*/}
            <Product 
                id="1234"
                title= " Acer - Chromebook Spin 713 2-in-1 13.5in 2K VertiView 3:2 Touch - Intel i5-10210U - 8GB Memory - 128GB SSD – Steel Gray"
                price= {529.00}
                rating= {4}
                image = "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6416/6416477_sd.jpg"
            /> 
            <Product 
                id="1234"
                title= " Acer - Chromebook Spin 713 2-in-1 13.5in 2K VertiView 3:2 Touch - Intel i5-10210U - 8GB Memory - 128GB SSD – Steel Gray"
                price= {529.00}
                rating= {4}
                image = "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6416/6416477_sd.jpg"
            />     
            </div> 

            <div className="home__row">
            <Product 
                id="1234"
                title= " Acer - Chromebook Spin 713 2-in-1 13.5in 2K VertiView 3:2 Touch - Intel i5-10210U - 8GB Memory - 128GB SSD – Steel Gray"
                price= {529.00}
                rating= {4}
                image = "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6416/6416477_sd.jpg"
            />     
            <Product 
                id="1234"
                title= " Acer - Chromebook Spin 713 2-in-1 13.5in 2K VertiView 3:2 Touch - Intel i5-10210U - 8GB Memory - 128GB SSD – Steel Gray"
                price= {529.00}
                rating= {4}
                image = "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6416/6416477_sd.jpg"
            />     
            <Product 
                id="1234"
                title= " Acer - Chromebook Spin 713 2-in-1 13.5in 2K VertiView 3:2 Touch - Intel i5-10210U - 8GB Memory - 128GB SSD – Steel Gray"
                price= {529.00}
                rating= {4}
                image = "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6416/6416477_sd.jpg"
            />     
            </div>
            <div className="home__row">
            <Product 
                id="1234"
                title= " Acer - Chromebook Spin 713 2-in-1 13.5in 2K VertiView 3:2 Touch - Intel i5-10210U - 8GB Memory - 128GB SSD – Steel Gray"
                price= {529.00}
                rating= {4}
                image = "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6416/6416477_sd.jpg"
            />     
            </div>
        </div>
    )
}

export default Home
