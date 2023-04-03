For READMe and locally setting up the project in your device you can also refer to- https://docs.google.com/document/d/1onDVuxwurWbugKfPPWbA2NRwTjIRzzuKBI1RZGqqRNQ/edit?usp=sharing

 OR
 
Insurance Management Platform
This project is an insurance management platform that allows users to manage insurance policies, clients, and claims. The platform is built using Spring Boot and Java and uses an embedded database (H2) for data storage.

Installation
To run the application locally, you'll need to have the following tools installed:

1. Java 20
2. Maven 3.2 or later
3. Postman

Once you have these tools installed, follow these steps:

Clone the repository to your local machine: git clone https://github.com/your-username/insurance-management-platform.git
Navigate to the project directory: cd insurance-management-platform
Build the application: mvn clean install
Run the application: java -jar target/insurance-management-platform.jar
OR
Extract the Zip file at a particular location. You can get the Zip file along with the assignment or you can download  the same from git Repository(Steps to get Zip from github are mentioned below).
Open IntelliJ Idea on your device and open the project.
Before starting the project go to file option and select project structure and from there download java 20 for your device if not installed.
Run mvn clean install on terminal and then you can run the application.

Steps to get the zip file from github repository:
After opening github repository, you will see a green button where code will be written,
After that you will see an option of downloading ZIP from there you can download zip and follow the above mentioned steps.

The application will start up and be available at http://localhost:8080.

Usage
The application provides RESTful APIs for managing clients, insurance policies, and claims. Here are some example API endpoints:

GET /api/clients: Fetch all clients.
GET /api/clients/{id}: Fetch a specific client by ID.
POST /api/clients: Create a new client.
PUT /api/clients/{id}: Update a client's information.
DELETE /api/clients/{id}: Delete a client.
GET /api/policies: Fetch all insurance policies.
GET /api/policies/{id}: Fetch a specific insurance policy by ID.
POST /api/policies: Create a new insurance policy.
PUT /api/policies/{id}: Update an insurance policy.
DELETE /api/policies/{id}: Delete an insurance policy.
GET /api/claims: Fetch all claims.
GET /api/claims/{id}: Fetch a specific claim by ID.
POST /api/claims: Create a new claim.
PUT /api/claims/{id}: Update a claim's information.
DELETE /api/claims/{id}: Delete a claim.

You can use a tool like Postman to interact with these APIs and manage your insurance policies, clients, and claims.


Some prewritten JSON request Bodies for your reference:

Client request body
{
    "name":"Deepak",
    "dob":"1999-02-11",
    "address":"D-363/Vaishali nagar , Jaipur",
    "contactInformation":"Mobile no- 70144XXXX, email-deepak.devdd.97@gmail.com"
}


Insurance policy requestbody

{
    "policyNumber":"12344",
    "insuranceType":"HEALTH",
    "coverageAmount":500,
    "premiumAmount":10,
    "endDate":"2015-02-05",
    "clientId":3
}


Claim RequestBody

{
    "claimNumber":"12345",
    "description":"HeadLight brokei",
    "claimStatus":"Pending",
    "policyId":2
}

