class BankAccount(object):
    balance = 0

    def __init__(self, name):
        self.name = name

    def __repr__(self):
        return "%s account. Balance: $%.2f" % (self.name, self.balance)

    def show_balance(self):
        print "Balance: $%.2f" % self.balance

    def deposit(self, amount):
        if amount <= 0:
            print "Invalid amount"
            return
        else:
            print "Deposit amount: $%.2f" % amount
            self.balance += amount
            self.show_balance()

    def withdraw(self, amount):
        if amount > self.balance:
            print "Cannot withdraw more than balance"
            return
        else:
            print "Withdraw amount: $%.2f" % amount
            self.balance -= amount
            self.show_balance()


mark = BankAccount("Mark")
print mark
mark.show_balance()
mark.deposit(2000)
mark.withdraw(1000)
print mark

print

ben = BankAccount("Ben")
print ben
ben.show_balance()
ben.deposit(3250.69)
ben.withdraw(864.35)
print ben
