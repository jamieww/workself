# -*- coding: utf-8 -*-
import itertools


def PI(N):
    #  odds = itertools.count(1, 2)
    #  oddlimit = itertools.takewhile(lambda x: x < 2*N, odds)
    #  L = list(oddlimit)
    sum = 0
    L = list(range(1, 2*N, 2))
    for x in range(len(L)):
        if x % 2 == 0:
            L[x] = 4 / L[x]
        else:
            L[x] = -4 / L[x]
        sum += L[x]
        #  print(L[x])
    return sum


if __name__ == '__main__':
    print("PI(%s) is %s" % (10, PI(10)))
    print("PI(%s) is %s" % (100, PI(100)))
    print("PI(%s) is %s" % (1000, PI(1000)))
    #  print("PI(%s) is %s" % (10000, PI(10000)))
    #  print("PI(%s) is %s" % (10000000, PI(10000000)))
