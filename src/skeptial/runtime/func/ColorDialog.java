package skeptial.runtime.func;

import android.app.Activity;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class ColorDialog extends Activity {
	DrawViewColor dv;
	@Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colordialog);
        Bundle extras = getIntent().getExtras();

     	 if (extras != null)  {
     		 LinearLayout ContainerLayout = (LinearLayout) findViewById(R.id.button1x);
             ContainerLayout.addView(dv = new DrawViewColor(this, extras.getInt("color")));
        }

     	Button h= (Button)findViewById(R.id.button2);
        
        h.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent data = new Intent();
		    	data.setData(Uri.parse(String.valueOf(dv.color )) );
		    	setResult(RESULT_OK, data);
				finish();
			}
		});
	
	}
	@Override
	public void onBackPressed(){
		Intent data = new Intent();
    	data.setData(Uri.parse(String.valueOf(dv.color )) );
    	setResult(RESULT_OK, data);
		finish();
	}
	

}
