## GCP Log Parser (Java)
This project aims to parse big JSON log files exported from Google Cloud to find the required logs.

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

## License
CC-BY-NC.
