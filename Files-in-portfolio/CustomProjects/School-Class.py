from random import randint


class Student(object):
    homework = []
    quizzes = []
    tests = []

    def __init__(self, name):
        self.name = name
        self.homework = []
        self.quizzes = []
        self.tests = []

    def description(self):
        count_homework = 0
        count_quizzes = 0
        count_tests = 0

        for item in self.homework:
            count_homework += 1
        for item in self.quizzes:
            count_quizzes += 1
        for item in self.tests:
            count_tests += 1
        print "Student name: %s " % self.name
        print "Homework(s): %s" % count_homework
        print "Quizzes: %s" % count_quizzes
        print "Tests: %s \n" % count_tests

    def add_homework_score(self, score):
        if score > 0:

            self.homework.append(score)
            print "Grade added for homework \n"
        else:
            print "Invalid score \n"

    def add_quiz_score(self, score):
        if score > 0:
            self.quizzes.append(score)
            print "Graded added for quiz \n"
        else:
            print "Invalid score \n"

    def add_test_score(self, score):
        if score > 0:
            self.tests.append(score)
            print "Grade added for test \n"
        else:
            print "Invalid score \n"

    def print_homework_grades(self):
        if len(self.homework) > 0:
            print "Homework grade(s) for %s: %s \n" % (self.name, self.homework)
        else:
            print "%s doesn't have any homework submitted. \n" % self.name

    def print_quiz_grades(self):
        if len(self.quizzes) > 0:
            print "Quiz grade(s) for %s: %s \n" % (self.name, self.quizzes)
        else:
            print "%s doesn't have any quizzes submitted. \n" % self.name

    def print_test_grades(self):
        if len(self.tests) > 0:
            print "Test grade(s) for %s: %s \n" % (self.name, self.tests)
        else:
            print "%s doesn't have any tests submitted. \n" % self.name

    def average_hw_grade(self):
        sum = 0
        if len(self.homework) > 0:
            for grade in self.homework:
                sum += grade
            total = float(sum) / len(self.homework)
            total = round(total, 2)
            return total
        else:
            print "There were no grades for homework \n"

    def average_quiz_grade(self):
        sum = 0
        if len(self.quizzes) > 0:
            for grade in self.quizzes:
                sum += grade
            total = float(sum) / len(self.quizzes)
            total = round(total, 2)
            return total
        else:
            print "There were no grades for quizzes \n"

    def average_test_grade(self):
        sum = 0
        if len(self.tests) > 0:
            for grade in self.tests:
                sum += grade
            total = float(sum) / len(self.tests)
            total = round(total, 2)
            return total
        else:
            print "There were no grades for tests \n"

    def change_homework_grade(self, before, after):
        index = 0
        while self.homework[index] != before:
            index += 1
        self.homework[index] = after

    def change_quiz_grade(self, before, after):
        index = 0
        while self.quizzes[index] != before:
            index += 1
        self.quizzes[index] = after

    def change_test_grade(self, before, after):
        index = 0
        while self.tests[index] != before:
            index += 1
        self.tests[index] = after

    def grade_average(self):
        if len(self.homework) > 0 and len(self.quizzes) > 0 and len(self.tests) > 0:
            hwgrade = self.average_hw_grade()
            quizgrade = self.average_quiz_grade()
            testgrade = self.average_test_grade()

            average = (hwgrade * .20) + (quizgrade * .30) + (testgrade * .50)
            return average
        else:
            print "There was a problem calculating the grade"


class Class_system(Student):
    system = []

    def __init__(self, class_name):
        self.class_name = class_name
        self.system = []

    def print_roster(self):
        if len(self.system) > 0:
            names = []
            for student in self.system:
                names.append(student.name)
            print "%s class Roster: %s \n%s" % (self.class_name, len(self.system), names)
        else:
            print "\nThere were no students in the class"

    def get_class_name(self):
        return self.class_name

    def print_students(self):
        for student in self.system:
            student.description()

    def add_student(self, student):
        if self.system.__contains__(student):
            print "Cannot have duplicate classes"
        else:
            self.system.append(student)

    def remove_student(self, student):
        self.system.remove(student)

    def class_average(self):
        sum = 0
        if len(self.system) > 0:
            for student in self.system:
                sum += student.grade_average()
            total = float(sum) / len(self.system)
            total = round(total, 2)
            return total
        else:
            print "There was a problem calculating the class average"

    def classpop(self):
        return len(self.system)

    def class_loop(self):
        a1 = int(raw_input("""\nYou have entered the %s class
What would you like to do (Please choose a number)
1) View students
2) View student average
3) Get class average
0) Exit the %s class
Choice: """ % (self.get_class_name(), self.get_class_name())))
        if a1 == 1:
            if len(self.system) > 0:
                pass
            else:
                print "\nThere were no students in this %s class\n" % self.class_name
            self.class_loop()
        elif a1 == 2:
            self.class_loop()
        elif a1 == 3:
            self.class_loop()
        elif a1 == 0:
            pass


class School(Class_system):
    classes = []
    students = []
    school_code = 0

    def __init__(self, school_name, school_code):
        self.school_name = school_name
        self.school_code = school_code
        self.classes = []
        self.students = []

    def school_description(self):
        if len(self.classes) > 0:
            cnames = []
            for classx in self.classes:
                cnames.append(classx.class_name)
            print "\nRegistered classes for %s [Q%s] : %s\n%s" % (self.school_name, self.school_code, len(self.classes),
                                                                  cnames)
        else:
            print "\n%s [Q%s] has no registered classes" % (self.school_name, self.school_code)

    def add_class(self, class_name):
        if self.classes.__contains__(class_name):
            print "Cannot have duplicate classes"
        else:
            self.classes.append(class_name)

    def remove_class(self, class_name):
        if len(self.classes) > 0:
            self.classes.remove(class_name)
        else:
            print "There are no classes in %s" % self.school_name

    def get_school_code(self):
        return self.school_code

    def school_loop(self):
        a1 = int(raw_input("""\nWelcome to the %s Q[%s] system!
What would you like to do (Please choose a number)
1) View the classes
2) Add a class
3) Remove a class
4) Add a student to class
5) Remove a student from class
6) View Class
0) Exit the %s system
Choice: """ % (self.school_name, self.school_code, self.school_name)))
        if a1 == 1:
            self.school_description()
            self.school_loop()
        elif a1 == 2:
            answer = raw_input("What is the name of the class you want to add: ")
            self.add_class(Class_system(answer))
            print "\n%s class was added" % answer
            self.school_loop()
        elif a1 == 3:
            if len(self.classes) > 0:
                is_there = True
                cname = raw_input("What is the name of the class you want to remove: ")
                index = 0
                try:
                    while self.classes[index].class_name != cname:
                        index += 1
                    self.classes.remove(self.classes[index])
                    print "\nClass removed\n"
                    self.school_loop()
                except IndexError:
                    print "\n%s is not registered at %s\n" % (cname, self.school_name)
                    self.school_loop()
            else:
                print "\nThere are no classes to remove\n"
                self.school_loop()
        elif a1 == 4:
            if len(self.classes) > 0:
                i1 = 0
                i2 = 0
                is_here = False
                sname = raw_input("Enter the student's name: ")
                try:
                    while self.students[i2].name != sname:
                        i2 += 1
                    is_here = True
                except IndexError:
                    is_here = False
                    print "\n%s is a new student\n" % sname
                    self.students.append(Student(sname))
                nclass = raw_input("Enter the class they will be in: ")
                try:
                    if is_here == False:
                        i2 = 0
                        while self.classes[i1].class_name != nclass:
                            i1 += 1
                        try:
                            while self.students[i2].name != sname:
                                i2 += 1
                        except IndexError:
                            print "\nCould not find student\n"
                            self.school_loop()
                        self.classes[i1].add_student(self.students[i2])
                        print "\n%s was added to the %s class\n" % (self.students[i2].name, self.classes[i1].class_name)
                        self.school_loop()
                    else:
                        while self.classes[i1].class_name != nclass:
                            i1 += 1
                        self.classes[i1].add_student(self.students[i2])
                        print "\n%s was added to the %s class\n" % (self.students[i2].name, self.classes[i1].class_name)
                        self.school_loop()
                except IndexError:
                    print "\n%s is not a class in this school\n" % sname
                self.school_loop()
            else:
                print "\nThere are no classes to add a student to\n"
                self.school_loop()
        elif a1 == 5:
            self.school_loop()
        elif a1 == 6:
            i1 = 0
            cname = raw_input("Enter the class you want to view: ")
            try:
                while self.classes[i1].class_name != cname:
                    i1 += 1
                if self.classes[i1].classpop() == 0:
                    self.classes[i1].print_roster()
                    self.school_loop()
                else:
                    self.classes[i1].print_roster()
                    self.class_loop()
            except IndexError:
                print "\n%s is not a class at %s\n" % (cname, self.school_name)
                self.school_loop()
            self.school_loop()
        elif a1 == 0:
            print "\n"


class district(School):
    schools = []

    def __init__(self):
        self.schools = []

    def dis_description(self):
        if len(self.schools) > 0:
            name = []
            for school in self.schools:
                name.append(school.school_name + " [Q%s]" % school.school_code)
            print "Schools in the district \n %s" % name
        else:
            print "There were no schools in this district"

    def add_school(self, name):
        if self.schools.__contains__(name):
            print "This school is already in the system"
        else:
            self.schools.append(name)
            print "\nSchool added to the district\n"

    def run(self):
        print "Welcome to the School district"
        self.loop()

    def school_code_at_index(self, index):
        return self.schools[index].get_school_code()

    def loop(self):
        a1 = int(raw_input("""What would you like to do (Please choose a number)
1) View schools in district
2) View school
3) Add school
4) Remove School
0) Exit system
Choice: """))
        if a1 == 1:
            print "\n"
            self.dis_description()
            print "\n"
            self.loop()
        elif a1 == 2:
            if len(self.schools) > 0:
                a2 = int(raw_input("What is the school code for the school Q[  ] (three numbers): "))
                index = 0
                try:
                    while self.school_code_at_index(index) != a2:
                        index += 1
                    self.school_loop()
                    self.loop()
                except IndexError:
                    print "\nNo schools match this school code: --no such school--\nPress 1 to view the schools\n"
                    self.loop()
            else:
                print "\nThere are no schools in the district\n"
                self.loop()

        elif a1 == 3:
            name = raw_input("Name the school you want to add: ")
            self.school_name = name
            self.school_code = randint(100, 999)
            self.add_school(School(self.school_name, self.school_code))
            self.loop()
        elif a1 == 4:
            if len(self.schools) > 0:
                a2 = int(raw_input("What is the district code for the school Q[  ] (three numbers): "))
                index = 0
                try:
                    while self.school_code_at_index(index) != a2:
                        index += 1
                    self.schools.remove(self.schools[index])
                    print "\nSchool removed\n"
                    self.loop()
                except IndexError:
                    print "\nNo schools match this school code: --no such school--\nPress 1 to view the schools\n"
                    self.loop()
            else:
                print "\nThere are no schools in the district\n"
                self.loop()
        elif a1 == 0:
            print "\nGoodbye"
            exit()
        else:
            print "\nInvalid option (Please choose from options above)\n"
            self.loop()


d1 = district()
try:
    d1.run()
except KeyboardInterrupt:
    print "\n\n\nFinished test run"
