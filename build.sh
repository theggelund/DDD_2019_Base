#!/bin/bash

if [ "$1" = "--coverage" ]; then
    dotnet test -c debug -v normal TestProject -p:CollectCoverage=true -p:CoverletOutputFormat=teamcity -p:Exclude=[xunit*]* 
else
    dotnet test -c debug -v normal TestProject
fi

sleep 10