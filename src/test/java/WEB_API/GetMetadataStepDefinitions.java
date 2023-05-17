package WEB_API;

import DropBoxApi.DropBoxClient;
import URI.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class GetMetadataStepDefinitions {
    private HttpResponse response;
    @Given("file {string} exists in dropbox")
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

    @When("I get file's meta data")
    public void getMetaData(){
        response = DropBoxClient.getMetaData(Config.DROPBOX_FILEPATH);
        Assertions.assertTrue(DropBoxClient.isSuccessful(response));
    }

    @Then("I check if I received file's data")
    public void isMetaDataRight(){
        try {
            HttpEntity metaData = response.getEntity();
            String retSrc = EntityUtils.toString(metaData);
            JSONObject json = new JSONObject(retSrc);
            String fileNameReturned = json.getString("name");
            Assertions.assertEquals(Config.FILE_NAME, fileNameReturned);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
