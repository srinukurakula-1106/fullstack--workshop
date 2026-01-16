package collections_streams.optional;

import java.util.Optional;

public class Address {
    private String apartment;

    public Optional<String> getApartment() {
        return Optional.ofNullable(apartment);
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
