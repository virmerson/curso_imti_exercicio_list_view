package pmcg.imti.listasapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aluno on 05/08/15.
 */
public class AddNomeActivity extends AppCompatActivity {

    @Bind(R.id.edit)
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnome);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn2)
    public void acaoIncluir() {
        if (edit.getText() != null && edit.getText().toString().length() > 0) {
            getIntent().putExtra("nome",edit.getText().toString());

            setResult(1,getIntent());

            finish();
        } else {
            Toast.makeText(this,"Nome Vazio!!!!",Toast.LENGTH_SHORT);
        }

    }


}
