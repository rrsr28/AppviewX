# Online Auction Platform

Welcome to the Online Auction Platform project. This platform allows users to create, view, and participate in auctions.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
    - [Clone the Repository](#clone-the-repository)
    - [Setup Database](#setup-database)
    - [Run the Application](#run-the-application)
    - [Configure Images Directory](#configure-images-directory)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) installed
- [Maven](https://maven.apache.org/download.cgi) installed
- [MySQL](https://www.mysql.com/downloads/) database installed and running

## Setup Database
Create a MySQL database for the project.
Open the application.properties file located in the src/main/resources directory.
Update the database connection properties in the application.properties file:

spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password

## Run the Application
mvn spring-boot:run
or just click the run button in your IDE

## Configure Images Directory

In the `CreateAuctionController` file, you might need to update the images directory based on your local setup. Follow these steps:

1. Open the `CreateAuctionController` file located in the `src/main/java/com/example/OnlineAuction/Controller` directory.

2. Navigate to line 71 where the images directory is specified.

3. Change the images directory path to match your local directory structure. Update the line that looks like this:

    ```java
    .addResourceLocations("file:/path/to/your/images/directory/");
    ```

   Replace "/path/to/your/images/directory/" with the absolute path to your images directory.

   For example:

    ```java
    .addResourceLocations("file:/Users/your-username/your-project/images/");
    ```

   Make sure to use the correct absolute path to your images directory.

4. Save the changes.
5. Also change the path in upload-dir in the application.properties file located in the src/main/resources directory.



## Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-username/online-auction-platform.git
cd online-auction-platform
