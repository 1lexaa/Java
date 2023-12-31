package step.learning.oop;

import com.google.gson.JsonObject;

@Serializable
public class Shotgun extends  Weapon implements Classifield, Used
{
    private int _shells;

    public Shotgun(String name, int shells)
    {
        super.SetName(name);
        this._shells = shells;
    }

    public void SetShells(int shells) { this._shells = shells; }

    public int GetShells() { return _shells; }

    @JsonFactory
    public static Shotgun FromJSON(JsonObject json_object) throws IllegalAccessException
    {
        String [] required_fields = {"_name", "_shells"};

        for (String field : required_fields)
        {
            if (!json_object.has(field))
                throw new IllegalAccessException("Shotgun construct error: Missing required filed - " + field);
        }
        return new Shotgun(json_object.get(required_fields[0]).getAsString(),  json_object.get(required_fields[1]).getAsInt());
    }

    @JsonParseCheck
    public static boolean IsParseableFromJSON(JsonObject json_object)
    {
        String[] required_fields = {"_name", "_shells"};

        for (String field : required_fields)
        {
            if (!json_object.has(field))
                return false;
        }
        return true;
    }

    @Override
    public String GetLevel() { return "For hunting"; }

    @Override
    public int GetYears() { return 2; }

    @Override
    public String GetCard() { return String.format("Shotgun: '%s' (shells %d)", super.GetName(), this.GetShells()); }

    @Override
    public String getLevel() {
        return "For hunting";
    }
}