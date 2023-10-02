package step.learning.oop;

import com.google.gson.JsonObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// The Gun class represents a specific implementation of a weapon, in this case a pistol,
// and provides methods and attributes specific to that type of weapon. It also provides information about a weapon's card and
// its classification level through methods defined in the IClassified interface.
@Serializable
public class Gun extends Weapon implements Classifield, Used
{
    @Required
    private int _cartridge;

    public Gun(String name, int cartridge)
    {
        super.SetName(name);
        this._cartridge = cartridge;
    }

    public void SetCartrige(int cartrige) { this._cartridge = cartrige; }

    public int GetCatrige() { return _cartridge; }

    @JsonFactory
    public static Gun FromJSON(JsonObject json_object) throws IllegalArgumentException
    {
        List<String> requiredFields = GetRequiredFields(Gun.class);

        for (String field : requiredFields)
        {
            if (!json_object.has(field))
                throw new IllegalArgumentException("Gun construct error: Missing required field: " + field);
        }

        String[] required_fields = { "_name", "_cartridge" } ;

        for( String field : required_fields )
        {
            if(!json_object.has(field))
                throw new IllegalArgumentException( "Gun construct error: Missing required field: " + field ) ;
        }
        return new Gun(json_object.get(required_fields[0]).getAsString(), json_object.get(required_fields[1]).getAsInt()) ;
    }

    @JsonParseCheck
    public static boolean IsParseableFromJSON(JsonObject json_object)
    {
        List<String> requiredFields = GetRequiredFields(Gun.class);

        return requiredFields.stream().allMatch(field -> json_object.has(field));
    }

    private static List<String> GetRequiredFields(Class<?> clazz)
    {
        List<String> required_fileds = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields())
        {
            if (field.isAnnotationPresent(Required.class))
                required_fileds.add(field.getName());
        }

        return required_fileds;
    }

    @Override  // Returns a string describing the Gun, including its name and number of rounds.
    public String GetCard() { return String.format("Gun: '%s' (cartridge %d)", super.GetName(), this.GetCatrige()); }

    @Override
    public String getLevel() {
        return "For civil";
    }

    @Override
    public String GetLevel() {
        return null;
    }


    @Override
    public int GetYears() { return 1; }
}