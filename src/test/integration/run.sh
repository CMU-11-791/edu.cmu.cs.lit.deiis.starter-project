#!/usr/bin/env bash

target=`pwd`../../target

docker run -d -p 8080:8080 --name service -v $target:/var/lib/tomcat7/webapps