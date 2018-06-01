package producer.customer;

import au.com.dius.pact.consumer.*;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Rule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ConsumerPactRuleTest extends ConsumerPactTestMk2 {
    private static String CUSTOMER_LIST = "[{\"customerId\":1,\"name\":\"DFam\",\"email\":\"adam@boot.com\"},{\"customerId\":2,\"name\":\"John\",\"email\":\"john@boot.com\"},{\"customerId\":3,\"name\":\"Smith\",\"email\":\"smith@boot.com\"},{\"customerId\":4,\"name\":\"Edgar\",\"email\":\"edgar@boot.com\"},{\"customerId\":5,\"name\":\"Martin\",\"email\":\"martin@boot.com\"},{\"customerId\":6,\"name\":\"Tom\",\"email\":\"tom@boot.com\"},{\"customerId\":7,\"name\":\"Sean\",\"email\":\"sean@boot.com\"}]";
    @Rule
    public PactProviderRuleMk2 pactProviderRuleMk2 = new PactProviderRuleMk2("customer_provider", "localhost", 8080, this);

    @Override
    @Pact(provider = "customer_provider", consumer = "order_consumer")
    protected RequestResponsePact createPact(PactDslWithProvider pactDslWithProvider) {
        Map<String, String> header = new HashMap<>();

        return pactDslWithProvider
                .given("test state")
                .uponReceiving("ConsumerPactRuleTest")
                .path("/api/v1/customers")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(CUSTOMER_LIST)
                .toPact();
    }

    @Override
    protected String providerName() {
        return "customer_provider";
    }

    @Override
    protected String consumerName() {
        return "order_consumer";
    }

    @Override
    protected void runTest(MockServer mockServer) throws IOException {
        List list = new ConsumerClient(mockServer.getUrl()).getAsList("/api/v1/customers");
        assertEquals(list, new ObjectMapper().readValue(CUSTOMER_LIST, ArrayList.class));
    }
}
