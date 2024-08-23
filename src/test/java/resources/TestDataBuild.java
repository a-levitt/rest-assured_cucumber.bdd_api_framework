package resources;

import pojo.AddPlaceBase;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlaceBase addPlacePayload() {
        AddPlaceBase addPlaceBody = new AddPlaceBase();
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPlaceBody.setLocation(location);
        addPlaceBody.setAccuracy(50);
        addPlaceBody.setName("Frontline house");
        addPlaceBody.setPhone_number("(+91) 983 893 3937");
        addPlaceBody.setAddress("29, side layout, cohen 09");
        List<String> types = new ArrayList<>();
        types.add("shoe park");
        types.add("shop");
        addPlaceBody.setWebsite("https://rahulshettyacademy.com");
        addPlaceBody.setLanguage("French-IN");

        return addPlaceBody;
    }
}
