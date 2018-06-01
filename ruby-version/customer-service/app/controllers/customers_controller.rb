class CustomersController < ApplicationController
  def new
    @customer = Customer.new
  end

  def create
    @customer = Customer.new(customer_params)

    if Customer.find_by_name(params[:name])
      raise 'error'
    end

    if @customer.save
      redirect_to @customer
    else
      render 'new'
    end
  end

  def show
    @customer = Customer.find(params[:id])

    redirect_to customers_path
  end

  def index

    @customers = Customer.all
  end

  def destroy
    @article = Customer.find(params[:id])
    @article.destroy

    redirect_to customers_path
  end

  def get_customers
    response.headers['Content-Type'] = 'application/json'
    render  json: Customer.all
  end

  private
    def customer_params
      params.require(:customer).permit(:name, :email)
    end
end
