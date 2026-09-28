object ATM {

  var balance: Double = 10000.0

  def checkBalance(): Unit = {
    println(s"Current Balance: Rs. $balance")
  }

  def deposit(amount: Double): Unit = {
    if (amount <= 0)
      throw new IllegalArgumentException("Invalid deposit amount")

    balance += amount
    println(s"Amount deposited: Rs. $amount")
    println(s"Updated Balance: Rs. $balance")
  }

  def withdraw(amount: Double): Unit = {
    if (amount <= 0)
      throw new IllegalArgumentException("Invalid withdrawal amount")

    if (amount > balance)
      throw new IllegalArgumentException("Insufficient balance")

    balance -= amount
    println(s"Amount withdrawn: Rs. $amount")
    println(s"Remaining Balance: Rs. $balance")
  }

  def processChoice(choice: Int): Unit = {

    choice match {

      case 1 =>
        checkBalance()

      case 2 =>
        print("Enter amount to deposit: ")
        val amount = scala.io.StdIn.readDouble()
        deposit(amount)

      case 3 =>
        print("Enter amount to withdraw: ")
        val amount = scala.io.StdIn.readDouble()
        withdraw(amount)

      case 4 =>
        println("Thank you for using ATM!")

      case _ =>
        println("Invalid choice")
    }
  }

  def main(args: Array[String]): Unit = {

    var running = true

    while (running) {

      println("\n----- ATM MENU -----")
      println("1. Check Balance")
      println("2. Deposit")
      println("3. Withdraw")
      println("4. Exit")

      try {
        print("Enter your choice: ")
        val choice = scala.io.StdIn.readInt()

        processChoice(choice)

        if (choice == 4)
          running = false

      } catch {
        case e: Exception =>
          println(s"Error: ${e.getMessage}")
      }
    }
  }
}