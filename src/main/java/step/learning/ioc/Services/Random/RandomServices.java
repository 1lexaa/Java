package step.learning.ioc.Services.Random;

public interface RandomServices
{
    void Seed(String iv);
    String RandomHex(int char_length);
}