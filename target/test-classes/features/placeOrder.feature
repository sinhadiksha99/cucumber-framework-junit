Feature: place order for products

@PlaceOrder
Scenario Outline: Search Experience for products search in home and offers page
Given User is on GreenCart Landing page
When user search with "<Name>" and extract actual name of product
And Added "3" items of the selected product to cart
Then user proceeds to checkout and validate the "<Name>" items in the checkout page
And verify has ability to enter promo code and place the order

Examples:
| Name |
| tom |
| beet |
| bro |