Feature: UsedCars feature of the Trademe web page

  Scenario: Check there is at least one listing in the TradeMe UsedCars category
    Given : I am at the Trademe home page
    When : I click on the motors link
    Then : I should be at the Motors page
    And : I can see used_cars link with at least one listing

  Scenario: Check that the make ‘Kia’ exists.
    Given : I am at the used_cars page
    When : I click on the Advanced_car_search link
    Then : I should be at the Advanced_car_search form 
    And : Make list box should contains Kia 

  Scenario: Query any existing Used Car listing and confirm that the following details are shown for that car
    Given : I am at the used_cars page
    When : I click on any existing_listings 
    Then : I should be see the following Details on the listing page
    |Details|
    |Number plate|
		|Kilometres|
		|Body|
		|Seats|
		|Fuel type|
		|Engine|
		|Transmission|
		|History|
		|Registration expires|
		|WoF expires|
		|Model detail|
   