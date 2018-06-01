require 'customer_service_client'
require_relative 'pact_helper'

describe CustomerServiceClient, :pact => true do

  before do
    CustomerServiceClient.base_uri 'localhost:1234'
  end

  describe "get_customers" do

    before do
      customer_service.given("Get All Customers").
          upon_receiving("a request for customers").
          with(method: :get, path: '/api/v1/customers', query: '').
          will_respond_with(
              status: 200,
              headers: {'Content-Type' => 'application/json'},
              body: [
                  {
                      "customerId": 1,
                      "name": "Adam",
                      "email": "adam@boot.com"
                  },
                  {
                      "customerId": 2,
                      "name": "John",
                      "email": "john@boot.com"
                  },
                  {
                      "customerId": 3,
                      "name": "Smith",
                      "email": "smith@boot.com"
                  },
                  {
                      "customerId": 4,
                      "name": "Edgar",
                      "email": "edgar@boot.com"
                  },
                  {
                      "customerId": 5,
                      "name": "Martin",
                      "email": "martin@boot.com"
                  },
                  {
                      "customerId": 6,
                      "name": "Tom",
                      "email": "tom@boot.com"
                  },
                  {
                      "customerId": 7,
                      "name": "Sean",
                      "email": "sean@boot.com"
                  }
              ])
    end

    it "is successful" do
      all_customer = CustomerServiceClient.get_all_customer
      expect(all_customer.length).to eq(7)

      item_one = all_customer.first
      expect(item_one['customerId']).to eq(1)
      expect(item_one['name']).to eq('Adam')
      expect(item_one['email']).to eq('adam@boot.com')


    end

  end

end