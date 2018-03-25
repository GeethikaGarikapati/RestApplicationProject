# RestApplicationProject
* Gradle based Spring boot application which implements file upload using REST endpoint
* Input: 
  * key - file name; 
  * value - choose the file to upload
* Output:
  * Success: `{
    "fileName": "orders.JPG",
    "fileUploadResponse": "File has been SUCCESSFULLY uploaded!!"
}`
  * Failure: `{
    "fileName": "orders.JPG",
    "fileUploadResponse": "File upload has FAILED. Please check the path or try again later"
  }`
* Written JUnit test cases for Controller and Service classes.
* Tested the API (/api/upload/files) using POSTMAN. Attached screenshot in the project.
