# ZKTeco_Task2_Spring_Boot_Updated

Sprint-Boot-Task-2: [To be finished by EOD 14-03-2023] </br>
    1.Create Spring boot application for User operations.</br>
    2.User will be having the properties such as id, first name, last name, gender, email, phone, password, date of birth and profile photo, create date and update date.</br>
    3.Id, email and phone are unique for each user.</br>
    4.Validations should be there for email(correct email format eg: user@xxx.in, user@xxx.com, user@xxx.net, user@xxx.orgs and etc.), phone(correct phone number format. eg: +91-7799551277 i.e. +country code-phone number).A password must have at least 8 characters, consists of only letters and digits, must contain at least two digits & at least one uppercase character.</br>
    5.Id, first name, email, phone & password are mandatory fields and the rest are optional while user creation.</br>
    6. The max field lengths' can be as follows</br>
        id: 36</br>
        first name: 50</br>
        last name: 50</br>
        gender : 1</br>
        password: min 8 and max 20</br>
    7.Application should have the following APIs for user operations</br>
            create user, </br>
            create batch users, </br>
            update user info by id, </br>
            fetch user details by id | email | phone</br>
            fetch all users</br>
            fetch all users created b/w to dates(from date & to date)</br>
            delete the user by id.</br>

    8.Custom & Global exceptions will be handled.</br>
    9.Loggers should be implemented.</br>
    10.Application should have actuator end points to verify applications' health, metrics & info</br>
    
    
### What Changes can be made-</br>
Implementing validations in service class but using methods to avoid code complexity. Like isValid() etc.,
