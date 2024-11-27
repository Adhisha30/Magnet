Feature: log in
 

Scenario: login in check with valid and invalid data
    Given Open the link
    Then Click on sigin 
    Then Enter email id  "<email-id>"
    And Enter passsword  "<Password>"
    Then Click on login button
    And then verify if logged in or not for valid users
    Then close the window

  

    Examples: 
      |email-id|Password|
      |athira30@gmail.com|Sharath@30| 
      |athira@gamil.com|Sharath@30 |
      |athira30@gmail.com|valu123@e| 
      |sharath@gmail.com|value44|
   