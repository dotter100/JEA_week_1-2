package TDD.Tests;




import TDD.models.Tankstation;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class TankstationTest {

    @Rule
    public WireMockRule wiremockRule = new WireMockRule(8888);

    @Test
    public void CreateUser() {

        Tankstation mockstation = new Tankstation();

        WireMock wiremock = new WireMock(8888);
        wiremock.register(put(urlEqualTo("/testing/createtankstation"))
                .withHeader("Content-Type", containing("json"))
                .withRequestBody(containing("TestName"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("")));

        given()
                .port(8888)
                .contentType("application/json")
                .body(mockstation)
                .when().put("/testing/createtankstation").then()
                .statusCode(200);
        wiremock.verifyThat(WireMock.putRequestedFor(urlEqualTo("/testing/createtankstation")));


    }

}