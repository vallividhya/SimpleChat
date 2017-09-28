package com.vvv.simplechat;

import com.parse.Parse;
import com.parse.ParseObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by vidhya on 9/27/17.
 */

public class ChatApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Message.class);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("simplechat-client") // should correspond to APP_ID env variable
                .clientBuilder(builder)
                .server("https://codepath-chat-lab.herokuapp.com/parse/").build());
    }
}
