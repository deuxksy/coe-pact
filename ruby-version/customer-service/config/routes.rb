Rails.application.routes.draw do
  resources :customers
  get '/api/v1/customers', to: 'customers#get_customers'
end
