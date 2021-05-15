package tests.apiTests;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class simpleHttpClientTests {
    @Test
    public void siteAvailability() throws IOException {
        String restURL = "http://reqres.in";

        HttpUriRequest request = new HttpGet(restURL);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

    }

    @Test
    public void checkSingleUserTest() throws IOException {
        String restURL = "http://reqres.in/api/users/2";

        String expectedValue = "{\"data\":{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\"," +
                "\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"},\"support\":{\"url\":" +
                "\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server " +
                "costs are appreciated!\"}}";

        HttpUriRequest request = new HttpGet(restURL);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        String actualResult = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(actualResult);

        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(actualResult, expectedValue);


    }
}
