package step.learning.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import step.learning.ioc.Services.hash.HashService;
import step.learning.ioc.Services.hash.Md5HashService;
import step.learning.ioc.Services.hash.Sha1HashService;
import step.learning.ioc.Services.Random.RandomServices;
import step.learning.ioc.Services.Random.RandomServiceV1;
import step.learning.ioc.Services.Random.RandomServiceV2;

public class ConfigModule extends AbstractModule
{
    private RandomServices _random_services1;
    private RandomServices _random_services2;

    @Provides
    @Named("RandomService1")
    private RandomServices InjectRandomServices1()
    {
        if(_random_services1 == null)
        {
            _random_services1 = new RandomServiceV1();
            _random_services1.Seed("initial");
        }

        return _random_services1;
    }

    @Provides
    @Named("RandomService2")
    private RandomServices InjectRandomServices2()
    {
        if(_random_services2 == null)
        {
            _random_services2 = new RandomServiceV2();
            _random_services2.Seed("initial");
        }

        return _random_services2;
    }

    @Override
    protected void configure()
    {
        //bind(IHashService.class).to(Md5HashService.class);  // <-- MD5.
        // bind(IHashService.class).to(Sha1HashService.class);  // <-- SHA-1.
        // bind(IHashService.class).to(Sha256HashService.class);  // <-- SHA-256.
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        bind(HashService.class).annotatedWith(Names.named("Digest-hash")).to(Md5HashService.class);
        bind(HashService.class).annotatedWith(Names.named("Signature-hash")).to(Sha1HashService.class);
    }
}