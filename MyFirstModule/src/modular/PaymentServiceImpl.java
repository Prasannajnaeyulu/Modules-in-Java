package modular;

import com.api.PaymentService;

// https://docs.oracle.com/javase/specs/jls/se11/html/jls-7.html#jls-7.7.4
// If a service provider explicitly declares a public constructor with no formal parameters,
// or implicitly declares a public default constructor (§8.8.9), then that constructor is called
// the provider constructor.
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Payment successful!!");
    }

    @Override
    public void provider() {
        System.out.println("Default Provider of Payment service");
    }
}
