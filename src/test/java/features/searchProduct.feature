Feature: Search and place order for products

@OffersPage
Scenario Outline: Search Experience for products search in home and offers page
Given User is on GreenCart Landing page
When user search with "<shortname>" and extract actual name of product
Then user search "<shortname>" in offers page 
And validate product name in offers page matches with Landing Page

Examples:
| shortname |
| tom |
| beet |