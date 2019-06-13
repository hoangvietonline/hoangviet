package hoangviet.ndhv.intentexplicit;

import java.io.Serializable;

public class Hocsinh implements Serializable {
    String name;
    int tuoi;

    public Hocsinh(String name, int tuoi) {
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
