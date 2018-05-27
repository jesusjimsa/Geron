package jesusjimsa.geco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ImageView add_button = findViewById(R.id.add_button);

		add_button.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "This has to be changed with an Intent" , Toast.LENGTH_SHORT).show();
			}
		});

		GridView connected_devices_grid = findViewById(R.id.connected_devices);
		connected_devices_grid.setAdapter(new ImageAdapter(this));

		connected_devices_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public void onStart(){
		// call the superclass method first
		super.onStart();
	}

	@Override
	public void onResume() {
		// Always call the superclass method first
		super.onResume();
	}

	@Override
	public void onPause() {
		// Always call the superclass method first
		super.onPause();
	}

	@Override
	protected void onStop() {
		// Always call the superclass method first
		super.onStop();
	}

	@Override
	public void onDestroy(){
		// Always call the superclass method first
		super.onDestroy();
	}
}
