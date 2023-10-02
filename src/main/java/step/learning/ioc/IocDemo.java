package step.learning.ioc;

import step.learning.ioc.Services.HashService;

public class IocDemo
{
//    @Inject
    private HashService _hash_service;

    public void Run()
    {
        System.out.println("IOC demo!");
        System.out.println(_hash_service.Hash("IOC DEMO!"));
    }
}

// Инверсия управления -