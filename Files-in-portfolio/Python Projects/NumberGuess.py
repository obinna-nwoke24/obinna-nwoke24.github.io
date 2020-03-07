"""
Rolling a pair of dice and ask the user to guess the sum!
This was practice from Codecademt/pro
"""
from random import randint
from time import sleep


def get_user_guess():
    guess = int(raw_input("Guess a number: "))
    return guess


def roll_dice(number_of_sides):
    first_roll = randint(1, number_of_sides)
    second_roll = randint(1, number_of_sides)
    max_val = number_of_sides * 2
    print "The maximum possible value: %d" % max_val
    guess = get_user_guess()
    if guess > max_val:
        print "Guess invalid"
    else:
        print "Rolling..."
        sleep(2)
        print "First roll: %d" % first_roll
        sleep(1)
        print "Second roll: %d" % second_roll
        sleep(1)
        total_roll = first_roll + second_roll
        print "Result..."
        sleep(1)
        if guess == total_roll:
            print "You won!"
        else:
            print "You have lost."


roll_dice(7)
