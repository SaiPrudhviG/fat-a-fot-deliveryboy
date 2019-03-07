package fat.ap.fatdeliveryboy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgetpasswordActivity extends Activity {

Button back;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpassword);
    back=(Button)findViewById(R.id.back);
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent bck=new Intent(ForgetpasswordActivity.this,LoginActivity.class);
            startActivity(bck);
        }
    });
    }
}