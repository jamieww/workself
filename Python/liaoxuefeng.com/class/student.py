
class Student(object):
    count = 0

    def __init__(self, name, score):
        self.name = name
        self.score = score
        Student.count += 1

    def print_score(self):
        print('%s: %s' % (self.name, self.score))

    def get_grade(self):
        if self.score >= 90:
            return 'A'
        elif self.score >= 60:
            return 'B'
        else:
            return 'C'
