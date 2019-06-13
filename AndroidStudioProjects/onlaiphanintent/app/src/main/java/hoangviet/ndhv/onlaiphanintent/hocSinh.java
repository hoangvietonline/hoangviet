package hoangviet.ndhv.onlaiphanintent;

import java.io.Serializable;

public class hocSinh implements Serializable {
    private String name;
    private int tuoi;

    public hocSinh(String name, int tuoi) {
        this.name = name;
        this.tuoi = tuoi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
