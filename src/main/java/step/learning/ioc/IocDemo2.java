package step.learning.ioc;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import step.learning.ioc.Services.hash.HashService;
import step.learning.ioc.Services.Random.RandomServices;

public class IocDemo2
{
    private final HashService _digest_hash_service;
    private final HashService _signature_hash_service;
    private final RandomServices _random_service1;
    private final RandomServices _random_service2;

    @Inject @Named("Digest-hash")
    private HashService _digest_hash_service2;

    @Inject
    public IocDemo2(@Named("Digest-hash") HashService digest_hash_service, @Named("Signature-hash") HashService signature_hash_service,
                @Named("RandomService1") RandomServices random_service, @Named("RandomService2") RandomServices random_service2)
    {
        _digest_hash_service = digest_hash_service;
        _signature_hash_service = signature_hash_service;
        _random_service1 = random_service;
        _random_service2 = random_service2;
    }

    public void Run()
    {
        System.out.println("IOC2 demo!");
        System.out.println("IHashService(Digest-hash) --> " + _digest_hash_service.Hash("IOC2 demo!"));
        System.out.println("IHashService(Signature-hash) --> " + _signature_hash_service.Hash("IOC2 demo!"));
        System.out.println("IHashService(Digest-hash / Digest-hash2) --> " + _digest_hash_service.hashCode() + " / " +
                _digest_hash_service2.hashCode());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("IRandomServices(V1) --> " + _random_service1.RandomHex(6));
        System.out.println("IRandomServices(V2) --> " + _random_service2.RandomHex(6));
    }
}