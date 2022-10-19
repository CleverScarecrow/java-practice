package com.scarecrow.xml.construct;

public class ThingOne {

    private String test;

    public ThingOne(ThingTwo thingTwo, ThingThree thingThree, String four, String five) {
        System.out.println(11);
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
