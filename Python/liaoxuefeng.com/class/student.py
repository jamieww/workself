
class Student(object):
    count = 0

    def __init__(self, name, score):
        self.name = name
        self.score = score
        Student.count += 1

    def print_score(self):
        print('%s: %s' % (self.name, self.score))

    def get_grade(self):
        if self.score > 100:
            raise ValueError('invalid value: %s' % self.score)
        elif self.score >= 80:
            return 'A'
        elif self.score >= 60:
            return 'B'
        elif self.score >= 0:
            return 'C'
        else:
            raise ValueError('invalid value: %s' % self.score)
