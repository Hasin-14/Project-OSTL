class Student {
  var name = "Asin"
  var age = 20

  def display(): Unit = {
    println("Name = " + name)
    println("Age = " + age)
  }
}

object ClassObjectExample {
  def main(args: Array[String]): Unit = {
    val s = new Student()
    s.display()
  }
}