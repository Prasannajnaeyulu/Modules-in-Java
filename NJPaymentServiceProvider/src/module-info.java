module NJPaymentServiceProvider {
    exports com.payment.service;
    requires MyServiceProvider;
    uses com.api.PaymentService;
    provides com.api.PaymentService with com.payment.service.NJPaymentService;
}