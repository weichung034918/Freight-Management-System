package Constants;


public enum Data {
    account("accounts","src/xml/account.xml"),
    client("clients","src/xml/client.xml"),
    customer("customer","src/xml/customer.xml");
    String name;
    String path;
    Data(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
