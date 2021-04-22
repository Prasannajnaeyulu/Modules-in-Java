package com.payment.service;

import com.api.PaymentService;

public class NJPaymentService{

    // https://docs.oracle.com/javase/specs/jls/se11/html/jls-7.html#jls-7.7.4
    // If a service provider explicitly declares a public static method called provider with no formal
    // parameters, then that method is called the provider method
    public static PaymentService provider(){
        // compiler error: if NJPaymentServiceImpl class is non-static then
        // getting compiler error NJPaymentServiceImpl.this can't be accessed from a static context
        // So changing class 'NJPaymentServiceImpl' to static
//        return new NJPaymentServiceImpl();

        // the other way to workaround this if the class 'NJPaymentServiceImpl' is non-static is
        // instantiate outerclass and then instantiate inner class. Then it should be OK
//        return new NJPaymentService().new NJPaymentServiceImpl();

        // For simplicity I made this nested class static so I can instantiate this directly as follows
        return new NJPaymentServiceImpl();
    }

    // Inorder to access this private nested class from a static method of outer class
    // it must be static otherwise, I have to create an instance for outer class first and then to this class.
    // So Just to avoid this lengthy thing I made this class static
    private static class NJPaymentServiceImpl implements PaymentService{

        @Override
        public void pay() {
            System.out.println("Payment Successful!!");
        }

        @Override
        public void provider() {
            System.out.println("NJ Payment Service Provider");
        }
    }
}
