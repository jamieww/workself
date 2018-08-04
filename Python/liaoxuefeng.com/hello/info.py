#!/usr/bin/env python3
# -*- coding: utf-8 -*-


def person(name, age, *args, city, job, **kw):
    print(name, age, args, city, job, kw)


def fib(max):
    n, a, b = 0, 0, 1
    while n < max:
        print("a=%d, b=%d" % (a, b))
        a, b = b, a + b
        n = n + 1
    return 'done'


def triangles():
    n, a, b = 0, [], [1]

    while True:
        yield b
        n = 0
        a = []
        a.append(1)
        while n < len(b):
            if n >= 1:
                a.append(b[n - 1] + b[n])
            n = n + 1
        a.append(1)
        b = a
