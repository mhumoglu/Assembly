package com.example.assembly;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class ResponseTask extends AsyncTask<String, String, String>{


    @Override
    protected String doInBackground(String... uri) {
        String responseString = "";
        BufferedReader in=null;
        try {

            URL url = new URL(uri[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if(uri.length>1)
            {
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                Map<String,String> params = new LinkedHashMap<>();
                for (int i=1;i<uri.length;i+=2)
                params.put(uri[i],uri[i+1]);

                StringBuilder postData = new StringBuilder();
                for (Map.Entry<String,String> param : params.entrySet()) {
                    if (postData.length() != 0) postData.append('&');
                    postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                    postData.append('=');
                    postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
                }
                byte[] postDataBytes = postData.toString().getBytes("UTF-8");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
                conn.setDoOutput(true);
                conn.getOutputStream().write(postDataBytes);
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            }else {
                in =new BufferedReader(new InputStreamReader(url.openStream()));
            }
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