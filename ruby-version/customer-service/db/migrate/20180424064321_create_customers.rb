class CreateCustomers < ActiveRecord::Migration[5.2]
  def change
    create_table :customers, id: false do |t|
      t.primary_key :customerId
      t.string :name
      t.string :email

      t.timestamps
    end
  end
end
