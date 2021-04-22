import com.payment.service.NJPaymentService;

module MyFirstModule {
    requires MySecondModule;
    requires MyServiceProvider;
    requires NJPaymentServiceProvider;
    // specify the name of the service which the current module uses
    // It is Service Provider Interface ( interface or an abstract class which specifies your service)
    uses com.api.PaymentService;
    // maps service provider interface to implementation
    provides com.api.PaymentService with modular.PaymentServiceImpl;

    // compiler error: Duplicate implementation: modular.PaymentServiceImpl
    // we shouldn't provide same service provider more than once
//    provides com.api.PaymentService with modular.PaymentServiceImpl, modular.PaymentServiceImpl;

    //compiler error: Duplicate 'provides': com.api.PaymentService
    // we shouldn't declare same service more than once here com.api.PaymentService
    // it is already declared in line#9 above so declaring again here is an error
//    provides com.api.PaymentService with modular.PaymentServiceImpl;
}