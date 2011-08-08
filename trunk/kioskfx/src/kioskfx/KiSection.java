package kioskfx;

public class KiSection {

    private String title;

    public KiSection() {
        title = "";
    }

    public KiSection title(String it) {
        this.title = it;
        return this;
    }
}
