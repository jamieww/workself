import functools
import time


L = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]


def by_name(t):
    return t[0]


def by_score(t):
    return t[1]


def log(func):
    @functools.wraps(func)
    def wrapper(*args, **kw):
        print('%s executed in %s ms' % (func.__name__, time.time()))
        return func(*args, **kw)
    return wrapper


@log
def count():
    def f(j):
        return lambda: j * j
    fs = []
    for i in range(1, 4):
        fs.append(f(i))
    return fs


def createCounter():
    n = [0, 1]

    def counter():
        n[1] = n[1] + 1
        return n[1]
    return counter


ct = createCounter()

print(ct(), ct(), ct())
# L2 = sorted(L, key=by_name, reverse=True)
# print(L2)

# L3 = sorted(L, key=by_score)
# print(L3)

f1, f2, f3 = count()
print(f1(), f2(), f3())

# L1 = list(filter(lambda n: n % 2 == 1, range(1, 20)))
# print(L1)
