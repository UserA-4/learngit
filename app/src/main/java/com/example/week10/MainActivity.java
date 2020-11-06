package com.example.week10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=findViewById(R.id.button1);
        button1.setOnClickListener(this);
        replaceFragment(new RightFragment());
    }


    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.button1:
                    replaceFragment(new AnotherRightFragment());
                    break;
                default:
                    break;
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout,fragment);
        transaction.addToBackStack(null);/*点击返回键返回上一步的状态，而不是退出*/
        transaction.commit();
    }
}