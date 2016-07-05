package util;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by hyunji on 16. 7. 5..
 */
public class Jelly {
    public static void main(String[] args) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        KukeModel user = realm.createObject(KukeModel.class); // Create a new object
        user.setInnerHack("jelly");
        user.setOuterHack("you look like mirro");
        // INSERT INTO tbl_kuke (inner_hack, outer_hack) VALUES ( "jelly", "you look like mirro");
        realm.commitTransaction();
        RealmQuery<KukeModel> kukeQuery = realm.where(KukeModel.class);
        kukeQuery
                .equalTo("innerHack", "jelly")
                .equalTo("outerHack", "you look like mirro");
        // SELECT * FROM tbl_kuke WHERE inner_hack = "jelly" AND outer_hack = "you look like mirro";
        RealmResults<KukeModel> result= kukeQuery.findAll();

        result.get(0);
        System.out.println(result.get(0).getInnerHack());
    }
}
