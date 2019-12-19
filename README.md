## JSON Log Parser
This project aims to parse the big json log files exported from GCloud in order to find
the required logs.

## Compiling
```
mvn clean compile assembly:single
```

## Running
```
java -jar <jar-file-name>.jar <log-file-name-1> <...> <search-term>
```

#### Note
Log files should be in the same directory as the Jar file.

## Licensing
Creative Commons BY-NC