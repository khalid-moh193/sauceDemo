package Web.Util;

public enum URLs {


    SAUCE_DEMO_LOGIN("https://www.saucedemo.com/"),
    SAUCE_DEMO_HOMEPAGE("https://www.saucedemo.com/inventory.html");

    private String value;

    URLs(String value) {
        this.setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
