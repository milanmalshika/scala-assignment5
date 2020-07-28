object MyBank extends App{

	var customer1 = new Account("657483289v", 1000, 100000)
	var customer2 = new Account("546327839v", 1001, 15000)
	var customer3 = new Account("975634892v", 1002, -500)
	var customer4 = new Account("892312897v", 1003, -100)
	
	println("\nStart time bank details..")

	var Bank:List[Account] = List(customer1, customer2, customer3, customer4)

	for(customer <- Bank) {
		println(customer);
	}

	customer4.transfer(customer2, 3000)						
	println("\n2nd customer successfully transferred rs.3000 to 4th customer..")

	println("\nList of Accounts with negative balances: ")
	for (customer <- Bank) {
		customer.negetive()
	}

		
	var summ:Double  = 0
	for (customer <- Bank) {
		summ = summ + customer.sum().asInstanceOf[Double]
	}
	println("\nCalculate the sum of all account balances: "+summ)
	
	println("\nCalculate the final balances of all accounts after apply the interest: ") 
	for (customer <- Bank) {
		println(customer.inter())
	}

}

class Account(id:String, n:Int, b:Double){
	val nic:String = id
	val accnumber:Int = n
	var balance:Double = b

	def transfer(a:Account, b:Int) = { this.balance = this.balance + b;
					       a.balance = a.balance -b} 
	def negetive()  = {if(this.balance < 0) println("["+ this.nic +" : "+ this.accnumber +" : "+ this.balance+ "]")}
	
	def sum() = {this.balance }

	def inter() = new Account(this.nic,this.accnumber,if(this.balance>0) this.balance*0.05 + this.balance else this.balance*0.1 + this.balance)
	

	override def toString = "["+ nic +" : "+ accnumber +" : "+ balance+ "]"
}