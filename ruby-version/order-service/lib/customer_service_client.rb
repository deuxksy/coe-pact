require 'httparty'
require_relative 'model/customer'

class CustomerServiceClient
  include HTTParty
  base_uri 'http://localhost:3001'

  def self.get_all_customer()
    response = self.get("/api/v1/customers", :headers => {'Accept' => 'application/json'})
    if response.success?
      JSON.parse(response.body)
    elsif response.code == 404
      nil
    else
      raise response.body
    end
  end
end
