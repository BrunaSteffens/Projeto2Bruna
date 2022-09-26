package com.example.projeto2bruna.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.projeto2bruna.R;
import com.example.projeto2bruna.model.User;
import com.example.projeto2bruna.repository.UserRepository;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Iniciando a MainActivity");
        setContentView(R.layout.activity_main);

        //buscando o usuário lá no repositório pelo ID e trazendo para cá para exibir o nome dele na tela de boas vindas
        //int id = getIntent().getIntExtra("userId", -1);
        //substituída pela de baixo devido ao parcelable  User user = UserRepository.getInstance().getUserById(id);
        //agora, em vez de mandar o id, vamos mandar o objeto inteiro
        User user = getIntent().getParcelableExtra("userObj");
        TextView tv = (TextView) findViewById(R.id.textView5);
        tv.setText(user.getName());
    }

}