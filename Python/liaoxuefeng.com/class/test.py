from student import *
from types import MethodType

bart = Student('Bart Simpson', 59)


def print_score(std):
    print('%s: %s' % (std.name, std.get_grade()))


def set_age(self, age):
    self.age = age


bart.set_age = MethodType(set_age, bart)
bart.set_age(25)

print_score(bart)
print('student count: %s, age: %s' % (Student.count, bart.age))

curt = Student('Jamie Wang', 89)
print('student count: %s' % Student.count)
