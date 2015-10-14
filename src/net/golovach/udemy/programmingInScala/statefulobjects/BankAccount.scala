package net.golovach.udemy.programmingInScala.statefulobjects

class BankAccount {

  private var bal: Int = 0

  def balance: Int = bal

  def deposit(amount: Int): Unit ={
    require(amount > 0)
    bal += amount
  }

  def withdraw(amount: Int): Boolean =
    if (amount > bal) false
    else {
      bal -= amount
      true
    }

}
