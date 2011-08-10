package kioskfx;

public class KiAction {

    private String title;

    public KiAction() {
        title = "";
    }

    public KiAction title(String it) {
        this.title = it;
        return this;
    }
}
