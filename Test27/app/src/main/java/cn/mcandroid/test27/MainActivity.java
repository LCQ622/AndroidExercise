package cn.mcandroid.test27;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private Button btn;
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.activity_main_btn);
        rg=(RadioGroup) findViewById(R.id.activity_main_radiogroup);
        btn.setOnClickListener(new MyOnClickListener());
    }
    private class  MyOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.activity_main_btn:
                    handleClick();
                    break;
                default:break;
            }
        }
    }

    private void handleClick() {
        for (int i = 0; i < rg.getChildCount(); i++) {
           RadioButton rb= (RadioButton) rg.getChildAt(i);
           if(rb.isChecked()){
               if(rb.getText().equals("B . 15")){
                   Toast.makeText(MainActivity.this,"回答正确",Toast.LENGTH_SHORT).show();
               }else {
                   AlertDialog.Builder a=new AlertDialog.Builder(this);
                   a.setTitle("回答错误！").setMessage("结果当然是15咯，不会算一下吗。").show();
               }

               break;
           }
            
        }

    }

}
