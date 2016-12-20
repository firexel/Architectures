package com.example.myapplication;

import com.example.myapplication.vanilla.retrofit.ApiFactory;
import com.example.myapplication.vanilla.retrofit.ApiResponse;
import com.example.myapplication.vanilla.retrofit.ProfileRespBody;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.junit.Test;

import java.io.IOException;

import retrofit2.Call;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testApi() throws IOException {
        Gson gson = new Gson();
        Call<ApiResponse> call = ApiFactory.create("http://localhost:8080").getProfile("1");
        JsonObject result = call.execute().body().getResult();
        assertNotNull(result);
        assertEquals("Ivan", gson.fromJson(result, ProfileRespBody.class).getName());
    }
}