package com.petrodevelopment.dice.rest;

/**
 * Created by andrey on 09/07/2015.
 */
/*
 * Copyright (C) 2012 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

        import java.io.IOException;
        import java.util.List;

        import retrofit.Callback;
        import retrofit.RestAdapter;
        import retrofit.RetrofitError;
        import retrofit.client.Response;
        import retrofit.http.GET;
        import retrofit.http.Path;

public final class SimpleService {
    public static final String API_URL = "https://api.github.com";

    public static class Contributor {
        public final String login;
        public final int contributions;

        public Contributor(String login, int contributions) {
            this.login = login;
            this.contributions = contributions;
        }
    }

    public interface GitHubService {
        @GET("/repos/{owner}/{repo}/contributors")
        void contributors(@Path("owner") String owner, @Path("repo") String repo, Callback<List<Contributor>> callback);
    }

    public static void getContributors() throws IOException {
        // Create a very simple REST adapter which points the GitHubService API.
        RestAdapter retrofit = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();

        // Create an instance of our GitHubService API interface.
        GitHubService github = retrofit.create(GitHubService.class);


        // Fetch and print a list of the contributors to the library.
        github.contributors("square", "retrofit", new Callback<List<Contributor>>() {
            @Override
            public void success(List<Contributor> contributors, Response response) {
                for (Contributor contributor : contributors) {
                    System.out.println(contributor.login + " (" + contributor.contributions + ")");
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }
}