package WEB_API;

import DropBoxApi.DropBoxClient;
import URI.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UploadFileStepDefinitions {
    private HttpResponse response;

    @Given("file {string} exists")
    public void fileExists(String fileName) {
        try {
            Assertions.assertEquals(fileName, "test.txt");
            //check if file exists on disk
            FileInputStream fis = new FileInputStream(Config.FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("i upload file")
    public void uploadFile(){
        response = DropBoxClient.uploadFile(Config.FILE_PATH, Config.DROPBOX_FILEPATH);
        Assertions.assertTrue(DropBoxClient.isSuccessful(response));
    }

    @Then("i check if file {string} is uploaded")
    public void ifFileUploaded(String fileName){
        try {
            HttpResponse isFile = DropBoxClient.checkFileExists(Config.DROPBOX_PATH);
            String jsonString = EntityUtils.toString(isFile.getEntity());
            JSONObject json = new JSONObject(jsonString);
            JSONArray entries = json.getJSONArray("entries");
            Assertions.assertEquals(fileName, entries.getJSONObject(0).getString("name"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
