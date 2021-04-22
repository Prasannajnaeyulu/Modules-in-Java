package modular;

import com.api.PaymentService;
import good.GoodBye;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class HelloWorld {
    public static void main(String... args){
        System.out.println("modular Hello World!!");
        GoodBye.goodbye();

        // compiler error: ServiceLoader class has no zero args constructor so it is invalid
//        new ServiceLoader().load(PaymentService.class);
        // compiler error: the return type of ServiceLoader.load method is ServiceLoader<PaymentService> but not PaymentService :)
//        PaymentService paymentService = ServiceLoader.load(PaymentService.class);
        // compiler error: there is no get method on ServiceLoader class it is valid on ServiceLoader.Provider class
//        PaymentService paymentService = ServiceLoader.load(PaymentService.class).get();


//        PaymentService paymentService = ServiceLoader.load(PaymentService.class).findFirst().get();
        List<ServiceLoader.Provider<PaymentService>> lsServiceLoaderProvider = new ArrayList<>();
        // interesting: please note
        // 1. load method returns ServiceLoader<PaymentService>
        // 2. ServiceLoader class has its own stream method which finds all the service provider implementations of type
        // ServiceLoader.Provider<PaymentService> and it streams them one by one
        // So I am adding them to List<ServiceLoader.Provider<PaymentService>>
        ServiceLoader.load(PaymentService.class).stream().forEach(lsServiceLoaderProvider::add);
        lsServiceLoaderProvider.forEach(provider -> {
            // interesting: Note: provider is of type ServiceLoader.Provider<PaymentService>
            // we need to call get() method to retrieve PaymentService from ServiceLoader.Provider class
            provider.get().provider();
            provider.get().pay();
        });
    }
}
