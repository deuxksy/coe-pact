require 'pact/provider/rspec'

require_relative 'provider_states_for_order_service'

Pact.configure do |config|
  config.diff_formatter = :embedded
end

Pact.service_provider "customer-service" do
  honours_pact_with 'order-service' do
    pact_uri 'http://localhost/pacts/provider/customer-service/consumer/order-service/latest'
  end
end