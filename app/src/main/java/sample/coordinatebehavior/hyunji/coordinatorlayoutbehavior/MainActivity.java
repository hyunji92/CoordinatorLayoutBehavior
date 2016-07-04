package sample.coordinatebehavior.hyunji.coordinatorlayoutbehavior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import UI.RecyclerViewAdapter;
import butterknife.Bind;

public class MainActivity extends AppCompatActivity {

    @Bind(android.R.id.list)
    RecyclerView vRecyclerView;

    @Bind(R.id.toolbar)
    Toolbar vToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(vToolbar);
        vToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        vRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        vRecyclerView.setAdapter(new RecyclerViewAdapter());
        //vRecyclerView.setAdapter(new Dy
                //DynamicAdapter(Utils.getSampleData()));

    }
}
