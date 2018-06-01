require 'pact/consumer/rspec'

Pact.service_consumer "order-service" do
  has_pact_with "customer-service" do
    mock_service :customer_service do
      port 1234
    end
  end
end