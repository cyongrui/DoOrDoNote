import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class TaskClassAdapter<T>
    implements JsonSerializer<T>, JsonDeserializer<T> {

    @Override
    public final JsonElement serialize(final T object, final Type interfaceType, final JsonSerializationContext context) 
    {
        final JsonObject member = new JsonObject();

        member.addProperty("type", object.getClass().getName());

        member.add("data", context.serialize(object));

        return member;
    }

    @Override
    public final T deserialize(final JsonElement elem, final Type interfaceType, final JsonDeserializationContext context) 
            throws JsonParseException 
    {
        final JsonObject member = (JsonObject) elem;
        final JsonElement typeString = get(member, "type");
        final JsonElement data = get(member, "data");
        final Type actualType = typeForName(typeString);

        return context.deserialize(data, actualType);
    }

    private Type typeForName(final JsonElement typeElem) 
    {
        try 
        {
            return Class.forName(typeElem.getAsString());
        } 
        catch (ClassNotFoundException e) 
        {
            throw new JsonParseException(e);
        }
    }

    private JsonElement get(final JsonObject wrapper, final String memberName) 
    {
        final JsonElement elem = wrapper.get(memberName);

        if (elem == null) 
        {
            throw new JsonParseException(
                "no '" + memberName + "' member found in json file.");
        }
        return elem;
    }

}

/*import com.google.gson.*;

import java.lang.reflect.Type;

public class TaskClassAdapter implements JsonSerializer<Task>, 
JsonDeserializer<Task> {
	@Override
	public JsonElement serialize(Task src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject result = new JsonObject();
		result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
		result.add("properties", context.serialize(src, src.getClass()));

		return result;
	}

	@Override
	public Task deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject jsonObject = json.getAsJsonObject();
		String type = jsonObject.get("type").getAsString();
		JsonElement element = jsonObject.get("properties");

		try {
			return context.deserialize(element, Class.forName("Storage" + type));
		} catch (ClassNotFoundException cnfe) {
			throw new JsonParseException("Unknown element type: " + type, cnfe);
		}
	}
}
*/