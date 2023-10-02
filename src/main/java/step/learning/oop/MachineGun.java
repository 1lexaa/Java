package step.learning.oop;

import com.google.gson.JsonObject;

// MachineGun represents a specific implementation of a weapon, in this case a machine gun,
// and provides methods and attributes specific to that type of weapon. It also provides information about the weapon card and
// its classification level through methods defined in the IAutomatic and IClassified interfaces.
public class MachineGun extends Weapon implements Automatic, Classifield, Used
{
    private double _fire_rate;

    public MachineGun(String name, double fire_rate)
    {
        super.SetName(name);
        this._fire_rate = fire_rate;
    }

    public void SetFireRate(double fire_rate) { this._fire_rate = fire_rate; }

    public double GetFireRate() { return _fire_rate; }

    @JsonFactory
    public static MachineGun FromJSON(JsonObject json_object) throws IllegalAccessException
    {
        String [] required_fields = {"_name", "_fire_rate"};

        for (String field : required_fields)
        {
            if (!json_object.has(field))
                throw new IllegalAccessException("MachineGun construct error: Missing required filed - " + field);
        }

        return new MachineGun(json_object.get(required_fields[0]).getAsString(),  json_object.get(required_fields[1]).getAsInt());
    }

    @JsonParseCheck
    public static boolean IsParseableFromJSON(JsonObject json_object)
    {
        String[] required_fields = {"_name", "_fire_rate"};

        for (String field : required_fields)
        {
            if (!json_object.has(field))
                return false;
        }

        return true;
    }

    @Override
    public String GetCard()  // This method overrides the abstract GetCard() method from the Weapon class.
    {                       //  It returns a string describing the weapon of type MachineGun, including its name and rate of fire (in rounds per second).
        return String.format("Machine gun: '%s' (fire rate %1f bps)", super.GetName(), this.GetFireRate());
    }


    @Override
    public int GetYears() { return 10; }

    @Override
    public String getLevel() {
        return("For military");
    }

    @Override
    public String GetLevel() {
        return("For military");
    }
}