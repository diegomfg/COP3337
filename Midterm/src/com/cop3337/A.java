package com.cop3337;
class A
{
    A(String x)
    {
        System.out.print(x);
    }
    A(int p)
    {
        this("Hi there ");
        System.out.println("p is " + p);
    }
}


class B extends A
{
    B(int p, int q)
    {
        super(p);
        System.out.println("and q is " + q);
    }
}