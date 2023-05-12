package Builders;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Map;

public class RequestBuilder {
    //інкапсуляція
    private HttpClient httpClient;
    private HttpPost postRequest;
    private HttpGet getRequest;
    private String method;
    private String URI;

    public RequestBuilder(String URI, String method){
        this.httpClient = HttpClientBuilder.create().build();
        this.URI = URI;
        this.method = method;
        if(this.method.equals("post"))
            postRequest = new HttpPost(this.URI);
        else
            getRequest = new HttpGet(this.URI);
    }

    public RequestBuilder addHeaders(Map<String, String> headers){
        for (Map.Entry<String, String> header: headers.entrySet()){
            if(this.method.equals("post"))
                postRequest.addHeader(header.getKey(), header.getValue());
            else
                getRequest.addHeader(header.getKey(), header.getValue());
        }
        return this;
    }

    public RequestBuilder addJsonBody(StringEntity body){
        postRequest.setEntity(body);
        return this;
    }

    public RequestBuilder addFileBody(FileEntity body){
        postRequest.setEntity(body);
        return this;
    }

    public HttpResponse execute() throws IOException {
        if(this.method.equals("post")){
            HttpResponse response = httpClient.execute(postRequest);
            System.out.println(response);
            return response;
        }
        else{
            HttpResponse response = httpClient.execute(getRequest);
            System.out.println(response);
            return response;
        }
    }
}
