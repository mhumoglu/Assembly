package com.example.assembly;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class ResponseTask extends AsyncTask<String, String, String>{

    @Override
    protected String doInBackground(String... uri) {
        String responseString = "";
        try {
            URL url = new URL(uri[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedReader in =
                        new BufferedReader(new InputStreamReader(url.openStream()));
                String inLine;

                while ((inLine = in.readLine()) != null) {
                    responseString += inLine;
                }
                return  responseString;

        } catch (Exception e) {
            return e.toString();
        }

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        //Do anything with response..
    }
}