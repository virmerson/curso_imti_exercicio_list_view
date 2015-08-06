package pmcg.imti.listasapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aluno on 05/08/15.
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.lista)
    ListView lista;

    ArrayAdapter<String> adapter = null;

    List<String> l = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,l);

        lista.setAdapter(adapter);


    }

    @OnClick(R.id.btn)
    public void onClickBtn() {
        Intent i = new Intent(MainActivity.this,AddNomeActivity.class);

        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && data.getExtras().containsKey("nome")) {
            l.add(data.getExtras().getString("nome"));

            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,l);

            lista.setAdapter(adapter);
        }
    }
}
