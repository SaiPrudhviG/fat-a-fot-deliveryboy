package fat.ap.fatdeliveryboy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoInternetConnectionActivity extends Activity {
Button bckfrmint;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nointernetconnection);
        bckfrmint=(Button)findViewById(R.id.backfrmint);
        bckfrmint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent bckfromint=new Intent(NoInternetConnectionActivity.this,HomeFragment.class);
startActivity(bckfromint);
            }
        });

    }
}
