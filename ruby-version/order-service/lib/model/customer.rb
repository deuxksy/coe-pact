class Customer

  attr_reader :customerId, :name, :email

  def initialize attributes
    @customerId = attributes[:customerId]
    @name = attributes[:name]
    @email = attributes[:email]
  end

  def == other
    other.is_a?(Customer) && other.customerId == self.customerId
  end

end
