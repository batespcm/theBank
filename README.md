# theBank

A Basic demo backend using Java for Banking

An env.properties file is needed in your root directory and your chosen db name etc will need populating.

A sample env.properties file can be found in **src/main/resources/templates/env.template** and should be copied to the
root directory and renamed to env.properties.

Gmail can be used and credentials and passwords and port number added:

**Instructions for implementing Gmail email service:**

1. Open your gmail in the browser and choose the avatar in the top right corner and then choose **Manage Your Account**
2. Choose **Security** down the left hand side
3. In the search box type in **App Passwords**
4. Follow the steps to create an app password
5. Copy this password to the env file
6. The correct port is usually **587**
7. The correct host details for gmail are **smtp.gmail.com**
8. The mail **username** in the env properties is your chosen gmail email address

**Creating an account in the API:**

1. Start the app once you completed all the **env.properties** correctly and placed the file in your root
2. Sample create account body for postman has been added to **src/main/resources/templates/createCustomerRaw**
3. Open Postman once the app is running successfully and copy the template to the raw setting and go to the relevant
   endpoint (**http://localhost:8080/api/customer**) with a post request and create your first account.
4. Change come details and create a second account to allow use of the other endpoints for account transfers etc.