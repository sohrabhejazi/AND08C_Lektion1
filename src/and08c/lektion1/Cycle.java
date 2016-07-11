package and08c.lektion1;

//import and7.lektion2.components.R;
import and08c.lektion1.EditProjectDialogFragment.EditDialogListener;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.AlertDialog;
import android.app.Notification.Builder;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.app.AlertDialog;

public class Cycle extends Activity implements EditDialogListener{
	private final String TAG = Cycle.class.getSimpleName();
	private String dummy;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Log.e(TAG, "\"onCreate\" aufgerufen");
		Log.e(TAG, "savedInstanceState = " + (
				(savedInstanceState == null)?
				"null" : savedInstanceState.toString()));
		if(savedInstanceState != null)
			dummy = savedInstanceState.getString("dummy");
			else
			dummy = "eins, zwei, drei";
		Log.e(TAG, "Dummy-String in \"onCreate\" = " + dummy);
			EditText etHello = (EditText)
			findViewById(R.id.et_hello);
			etHello.setText(dummy);
			
			final Button btLeft = (Button) findViewById(R.id.bt);
			btLeft.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
				
					useProjectDialog();
					
					/*DialogFragment dialog = new EditProjectDialogFragment();
					android.app.FragmentManager fragmentManager = getFragmentManager();
					dialog.show(fragmentManager, "editProjectTag");*/
				}
			}); 
		
	}
	private void useProjectDialog(){
		
		  android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
	      builder.setTitle("AlertDialog zeigen ");
	      builder.setPositiveButton("OK", new  DialogInterface.OnClickListener()
			{
	  		
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
					return;
				}
		  	});
	      
	      AlertDialog dialog = builder.create();
	      dialog.show();
		
	}

	
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		if(newConfig.orientation ==
		Configuration.ORIENTATION_LANDSCAPE)
		Log.e(TAG, "@ Auf Landscape umgeschaltet");
		else if(newConfig.orientation ==
		Configuration.ORIENTATION_PORTRAIT)
		Log.e(TAG, "@ Auf Portrait umgeschaltet");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		Log.e(TAG, "onSaveInstanceState aufgerufen");
		outState.putString("dummy", "a very new string");
		super.onSaveInstanceState(outState);
	}
	@Override
	protected void onRestoreInstanceState(
	Bundle savedInstanceState)
	{
		Log.e(TAG, "onRestoreInstanceState aufgerufen");
		//dummy = savedInstanceState.getString("dummy");
		//super.onRestoreInstanceState(savedInstanceState);
	}
	@Override
	protected void onStart() {
		super.onStart();
		Log.e(TAG, "\"onStart\" aufgerufen");
	}
	
	@Override
	protected void onPause() {
		super.onStart();
		Log.e(TAG, "\"onPause\" aufgerufen");
	}
	
	@Override
	protected void onStop() {
		super.onStart();
		Log.e(TAG, "\"onStop\" aufgerufen");
	}
	
	@Override
	protected void onDestroy() {
		super.onStart();
		Log.e(TAG, "\"onDestroy\" aufgerufen");
	}
	
	@Override
	protected void onRestart() {
		super.onStart();
		Log.e(TAG, "\"onRestart\" aufgerufen");
	}
	
	
	@Override
	protected void onResume() {
		super.onStart();
		Log.e(TAG, "\"onResume\" aufgerufen");
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cycle, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onDialogPositiveClick(DialogFragment dialog)
	{
	String output = "";
	/*if (dialog instanceof EditProjectDialogFragment)
	{
	EditProjectDialogFragment fragment =
	(EditProjectDialogFragment) dialog;
	if(project != null) {
	project.appendToName(fragment.termToAdd);
	project.description = fragment.description;
	tvHello.setText("aktuelles Projekt: "
	+ project.getName());
	output="Projektname geändert, Projektbeschreibung: "
	+ ((project.description.equals(""))?
	"Keine" : project.description);
	} else
	output="Das Projekt muss vor Namenserweiterung mindestens eine Notiz enthalten";*/
	}
	
	@Override
	public void onDialogNegativeClick(DialogFragment dialog)
	{
	//tvOutput.setText(dialog.toString() + " abgebrochen");
	}
}
