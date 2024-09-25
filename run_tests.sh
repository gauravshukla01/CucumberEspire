#!/bin/bash

# Start containers
echo "Starting containers..."
docker-compose up -d

# Wait for containers to be ready (optional)
sleep 10  # Replace with proper health checks if needed

# Run the TestNG tests via Maven or Gradle
# You can adjust these commands depending on your build tool
# Maven
echo "Clean solution..."
mvn clean install -DskipTests
echo "Build solution..."
mvn package -DskipTests
echo "Running tests with Maven..."
mvn test -DsuiteXmlFile=CucumberEspire/testng.xml

# OR if you are using Gradle
# echo "Running tests with Gradle..."
# ./gradlew test

# Capture the exit code of the tests
TEST_EXIT_CODE=$?

# Stop containers
echo "Stopping containers..."
docker-compose down

# Exit with the test result code
exit $TEST_EXIT_CODE
