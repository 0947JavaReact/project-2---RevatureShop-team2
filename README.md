# project-2---RevatureShop-team2

## Project Description:

Online store where users can view all items (and an image associated with each item) in the store, add those items to a cart, and then purchase items. Users can register an account, login with said account, recover a forgotten password, and update the account if needed. Users are also able to provide a mailing address to deliver the items which will be verified with the USPS API. A manager can add new items to the cart by providing an item name, price, and uploading an image of the item, all of which will then be updated in the store.

## Features:

The System:
- A list of Users
- A list of Items in Catalog 
- A list of Items in Cart
- A list of past orders

User:
- Username
- Password
- Email
- Delivery Address
- Type (customer or manager)
- List of past orders (if of customer type)
- Cart of current items they want to buy

Store:
- List of Items available

Item:
- Name
- ID
- Price
- Photo

Cart:
- List of items that were added to the cart
- Total price


![proj2userstories](https://user-images.githubusercontent.com/65792127/112054769-97144d00-8b1b-11eb-8471-5fec0e2cffe4.png)


## Technologies:

- Java 8
- PostgreSQL
- Apache Maven 3.6.3
- JavaScript
- Hibernate
- Lombok
- React.JS 17.0.2
- React Redux 7.2.3
- React Router 5.2.0
- HTML5
- CSS3
- Spring Boot 2.4.4
- Amazon AWS EC2
- Amazon AWS S3
- Amazon AWS RDS
- Amazon SDK 1.11.327
- Javax Mail 1.6.2
- Log4j API 1.2.17
- jUnit Testing
- Mockito
- Axios 0.21.1
- NodeJs 14.16.0

## Getting Started:

#### Step 1: Clone this repository

`git clone https://github.com/0947JavaReact/project-2---RevatureShop-team2.git`

### Front End

#### Step 2a: Install Node.JS with npm install if you don't already have it

Instructions can be found [here](https://phoenixnap.com/kb/install-node-js-npm-on-windows).

#### Step 2: Open `project-2---RevatureShop-team2/tree/main/project2frontend` with an IDE (Visual Studio Code is our preference) and install dependencies:

`npm install react`
`npm install react-redux`
`npm install react-router-dom`
`npm install react-scripts`
`npm install axios`
`npm install redux-thunk`

### Back End

1. Open `project-2---RevatureShop-team2/tree/main/Project2Backend`

2. Create an AWS S3 Bucket and AWS RDS

2. Replace credentials in application.yml with your own credentials

3. Run as a Spring Boot Application

## Contributors:

[Reynaldo Amaya](https://github.com/ReyA105)

[Lindsay Read](https://github.com/lindsayread)

[Estevan Mora](https://github.com/poraltic)

[Connor Smith](https://github.com/smithium)

[Nathanael Williams](https://github.com/nathanael567)
