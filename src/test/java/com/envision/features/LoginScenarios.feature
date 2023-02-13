Feature: Login Screen Test
    As a user I want to login to the application

    Background: required browser is opened
        #Given user opens Chrome browser
        And user launches the  url "https://demo.actitime.com/login.do"


    @one
    Scenario: Valid user test
        Given user enters "admin" as user id
        And user enters "manager" as password
        When user click on login button
        Then user can see the home page title as "actiTIME - Enter Time-Track"
    @two
    Scenario: InValid user test
        Given user enters "admin123" as user id
        And user enters "manager123" as password
        When user click on login button
        Then user can see the error message as "Username or Password is invalid. Please try again."


