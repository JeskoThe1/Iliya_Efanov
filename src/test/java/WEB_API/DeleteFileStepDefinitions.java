package WEB_API;

import DropBoxApi.DropBoxClient;
import URI.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class DeleteFileStepDefinitions {
    private HttpResponse response;
    @Given("I check if {string} exists")
    public void ifFileExists(String fileName){
        HttpResponse isFile = null;
        try {
            isFile = DropBoxClient.checkFileExists(Config.DROPBOX_PATH);
            String jsonString = EntityUtils.toString(isFile.getEntity());
            JSONObject json = new JSONObject(jsonString);
            JSONArray entries = json.getJSONArray("entries");
            Assertions.assertEquals(fileName, entries.getJSONObject(0).getString("name"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @When("I delete file")
    public void deleteFile(){
        response = DropBoxClient.deleteFile(Config.DROPBOX_FILEPATH);
        Assertions.assertTrue(DropBoxClient.isSuccessful(response));
    }

    @Then("I check if file is deleted")
    public void isFileDeleted(){
        try {
            HttpResponse isFile = DropBoxClient.checkFileExists(Config.DROPBOX_PATH);
            String jsonString = EntityUtils.toString(isFile.getEntity());
            JSONObject json = new JSONObject(jsonString);
            JSONArray entries = json.getJSONArray("entries");
            //we work with only one file, so we are checking if array lenght is zero
            Assertions.assertEquals(0, entries.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
