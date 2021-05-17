#!/bin/bash

# Pull new changes
git pull

# Prepare Jar
mvn clean
mvn package

# Ensure, that docker-compose stopped
docker-compose stop

# Add environment variables
export BOT_NAME=jr_testBot
export BOT_TOKEN=1831832718:AAFI7tlkKasaE-_BcbEhDvICSAzrke2c6uw

# Start new deployment
docker-compose up --build -d