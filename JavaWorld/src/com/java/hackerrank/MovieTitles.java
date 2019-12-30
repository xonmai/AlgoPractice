package com.java.hackerrank;

//import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieTitles {

    public static void main(String[] args) throws IOException {

        String[] res = getMovieTitles("The");

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    static String[] getMovieTitles(String substr) {
        int total = 2;
        List<String> result = new ArrayList<>();
        HttpURLConnection conn ;
//        Gson gson = new Gson();

        for(int i = 1; i < total; i++) {
            try {
                URL request = new URL("https://jsonmock.hackerrank.com/api/movies/search?Title=" + substr + "&page=" + i);
                conn = (HttpURLConnection) request.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String output = br.readLine();
//                Result response = gson.fromJson(output, Result.class);
                Result response = null;

                if (response != null) {
                    total = response.total_pages;
                    for (Movie movie : response.data) {
                        if (movie.Title != null && !movie.Title.isEmpty()) {
                            result.add(movie.Title);
                        }
                    }
                }

                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Collections.sort(result);
        return result.stream().toArray(String[]::new);
    }

    public class Result {
        public int total_pages;
        public List<Movie> data;
    }

    public class Movie {
        public String Title;
        public String Year;
    }
}
