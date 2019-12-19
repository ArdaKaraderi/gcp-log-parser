package com.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.parser.dtos.TraceDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;


public class LogsJsonParser {

    /**
     * Global variable for storing all traces in one place.
     */
    private static ArrayList<TraceDto> traces = new ArrayList<>();

    /**
     * Handling application logic.
     * @param args Unlimited log file names and a search term at the end.
     */
    public static void main(String[] args) {
        // Getting file names and keyword.
        ArrayList<String> fileNames = new ArrayList<>();
        String targetId = args[args.length - 1];

        // Moving content to an ArrayList to use the ArrayList methods.
        Collections.addAll(fileNames, args);

        // Removing search term from the fileNames array.
        fileNames.remove(fileNames.size() - 1);

        // Extracting logs from each file.
        for(String file : fileNames) {
            streamJsonFromFile(targetId, file);
        }

        // Sorting the array.
        Collections.sort(traces, Collections.reverseOrder());

        // Printing array to the user.
        for (TraceDto trace : traces) {
            System.out.println(trace);
        }
    }

    /**
     * Streams JSON lines to TraceDto objects and stores them.
     * @param targetId is the search criteria. (keyword.)
     * @param fileName file that method searches the criteria in.
     */
    private static void streamJsonFromFile(String targetId, String fileName) {
        // Importing the file.
        String path = System.getProperty("user.dir") + "/" + fileName;

        // Creating a new GSON builder with correct date format.
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss*SSSZZZZ");
        Gson gson = gsonBuilder.create();

        // Streaming each line within the file in order to find the correct traces.
        // and adding them to the global array.
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(i -> {
                if (i.contains(targetId)) {
                    TraceDto trace = gson.fromJson(i, TraceDto.class);
                    traces.add(trace);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 