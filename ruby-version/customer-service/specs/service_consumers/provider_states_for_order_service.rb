# require_relative '../../app/models/customer'

Pact.provider_states_for "order-service" do
  provider_state "Get All Customers" do
    set_up do
      # Your set up code goes here
      Customer.delete_all
      Customer.create({customerId: 1, name: "Adam", email: "adam@boot.com"})
      Customer.create({customerId: 2, name: "John", email: "john@boot.com"})
      Customer.create({customerId: 3, name: "Smith", email: "smith@boot.com"})
      Customer.create({customerId: 4, name: "Edgar", email: "edgar@boot.com"})
      Customer.create({customerId: 5, name: "Martin", email: "martin@boot.com"})
      Customer.create({customerId: 6, name: "Tom", email: "tom@boot.com"})
      Customer.create({customerId: 7, name: "Sean", email: "sean@boot.com"})
    end
  end

end