import functools
import time


def _odd_iter():
    n = 1
    while True:
        n = n + 2
        yield n


def _not_divisible(n):
    return lambda x: x % n > 0


def log(func):
    @functools.wraps(func)
    def wrapper(*args, **kw):
        print('%s executed in %s ms' % (func.__name__, time.time()))
        return func(*args, **kw)
    return wrapper


@log
def primes():
    yield 2
    it = _odd_iter()
    while True:
        n = next(it)
        yield n
        it = filter(_not_divisible(n), it)


for n in primes():
    if n < 100:
        print(n)
