class OrdersController < ApplicationController
  def new
  end

  def index
    @list = CustomerServiceClient.get_all_customer
    render  json: @list
  end
end
