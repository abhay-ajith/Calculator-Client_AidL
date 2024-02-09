// IArithmeticService.aidl
package com.elektrobit.service.arithmeticservice;

// Declare any non-default types here with import statements

interface IArithmeticService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int add (int a, int b);
    int subtract (int a, int b);
    int multiply (int a, int b);
    int divide(int a,int b);
}