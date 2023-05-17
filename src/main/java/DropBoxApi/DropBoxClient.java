package DropBoxApi;

import Builders.RequestBuilder;
import URI.Config;
import org.apache.http.HttpResponse;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class DropBoxClient {
    public static HttpResponse deleteFile(String fileName)  {
        RequestBuilder request = new RequestBuilder(Config.DELETE, "post");
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + Config.ACCESS_TOKEN);
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        StringEntity requestBody = null;
        try {
            requestBody = new StringEntity("{\"path\": \"/" + fileName + "\"}");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        request.addHeaders(headers).addJsonBody(requestBody);
        HttpResponse response = null;
        try {
            response = request.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public static HttpResponse uploadFile(String filePath, String fileName) {
        RequestBuilder request = new RequestBuilder(Config.UPLOAD, "post");
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + Config.ACCESS_TOKEN);
        headers.put("Dropbox-API-Arg", "{\"path\":\"/" + fileName + "\"}");
        headers.put("Content-type", "application/octet-stream");
        File fileToUpload = new File(filePath);
        request.addHeaders(headers).addFileBody(new FileEntity(fileToUpload));
        HttpResponse response = null;
        try {
            response = request.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public static HttpResponse getMetaData(String fileName) {
        RequestBuilder request = new RequestBuilder(Config.METADATA, "post");
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + Config.ACCESS_TOKEN);
        headers.put("Content-Type", "application/json");
        StringEntity body = null;
        try {
            body = new StringEntity("{\"path\":\"/" + fileName + "\", " +
                    "\"include_deleted\":false, \"include_has_explicit_shared_members\":false, " +
                    "\"include_media_info\":false}");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        request.addHeaders(headers).addJsonBody(body);
        HttpResponse response = null;
        try {
            response = request.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public static HttpResponse checkFileExists(String dropBoxFilePath) {
        RequestBuilder request = new RequestBuilder(Config.CHECK, "post");
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + Config.ACCESS_TOKEN);
        headers.put("Content-Type", "application/json");
        StringEntity body = null;
        try {
            body = new StringEntity("{\"path\": \"" + dropBoxFilePath + "\"}");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        request.addHeaders(headers).addJsonBody(body);
        HttpResponse response = null;
        try {
            response = request.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public static boolean isSuccessful(HttpResponse response){
        if(response.getStatusLine().getStatusCode() < 200 && response.getStatusLine().getStatusCode() >= 300)
            return false;
        return true;
    }
}