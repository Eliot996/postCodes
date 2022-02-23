public class PostCode {
    private int postCode;
    private String city;

    public PostCode(int postCode, String city) {
        this.postCode = postCode;
        this.city = city;
    }

    public boolean checkPostCode(int postCodeToCheck) {
        return postCode == postCodeToCheck;
    }

    @Override
    public String toString() {
        return  postCode + " - " + city;
    }
}
