package step.learning;
import java.util.*;

public class Dictionary {

    private static final  Map<String,String> _lang_dictionary = new HashMap<String, String>()
    {{
        put("Burger","Бургер");
        put("Car","Машина");
        put("Phone","Телефон");
        put("Monitor","Монитор");
        put("Object","Объект");
        put("Month","Месяц");
        put("Day","День");
        put("Data","Данные");
        put("Dictionary","Словарь");
    }};

    public Iterator<Map.Entry<String,String>> _iterator_lang_dictionary = _lang_dictionary.entrySet().iterator();

    public String TranslateEntoRu()
    {
        String word = WriteDownWord("[ENG]: [RU] ->");

        while(_iterator_lang_dictionary.hasNext())
        {
            Map.Entry<String,String> entry = _iterator_lang_dictionary.next();

            if(entry.getKey().equalsIgnoreCase(word))
                return  word + ": " + entry.getValue();

        }
        return "NOT FOUND";
    }

    public String TranslateRutoEn()
    {
        String word = WriteDownWord("[RU]: [ENG] -> ");

        while (_iterator_lang_dictionary.hasNext())
        {
            Map.Entry<String,String> entry = _iterator_lang_dictionary.next();

            if(entry.getValue().equalsIgnoreCase(word))
                return word + ": " + entry.getKey();
        }
        return "NOT FOUND";
    }


    private  String WriteDownWord(String type)
    {
        Scanner scann = new Scanner(System.in);
        System.out.print(type);
        return  scann.nextLine();
    }



}
