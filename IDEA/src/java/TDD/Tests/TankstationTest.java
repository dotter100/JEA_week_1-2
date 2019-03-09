package TDD.Tests;




import TDD.models.Tankstation;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.jupiter.api.Test;


import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class TankstationTest {

    @Rule
    public WireMockRule wiremockRule = new WireMockRule(8888);

    @Test
    public void CreateUser() {
        Tankstation mockstation = new Tankstation();

        WireMock wiremock = new WireMock(8888);

        wiremock.register(put(urlEqualTo("/testing/Createtankstation"))
                .withHeader("Content-Type", containing("json"))
                .withRequestBody(containing("TestName"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("")));


    }

}