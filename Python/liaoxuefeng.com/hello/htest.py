#!/usr/bin/env python3
# -*- coding: utf-8 -*-
from info import person
from info import fib
from info import triangles

sum = 0
for x in range(101):
    sum = sum + x
print('sum:%d' % sum)

# person('jame',41,city='shenzhen',job='engineer')
# person('jame',41,'male','sofware',city='shenzhen',job='engineer')
person('jame', 41, 'male', 'sofware', city='shenzhen',
       job='engineer', district='nanshan', floor='third')

fib(6)

n = 0
results = []
for t in triangles():
    print(t)
    results.append(t)
    n = n + 1
    if n == 10:
        break
