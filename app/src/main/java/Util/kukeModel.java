package util;

import io.realm.RealmObject;


/**
 * Created by hyunji on 16. 7. 5..
 */

public class KukeModel extends RealmObject {

    private String innerHack;
    private String outerHack;

    public String getOuterHack() {
        return outerHack;
    }

    public void setOuterHack(String outerHack) {
        this.outerHack = outerHack;
    }

    public String getInnerHack() {
        return innerHack;
    }

    public void setInnerHack(String innerHack) {
        this.innerHack = innerHack;
    }



}
