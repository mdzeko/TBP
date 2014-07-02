package app.tbp.foi.aplikacijatbp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.couchbase.touchdb.TDServer;
import com.couchbase.touchdb.ektorp.TouchDBHttpClient;
import com.couchbase.touchdb.router.TDURLStreamHandlerFactory;

import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import java.io.IOException;


public class Glavna extends Activity {

    static
    {
        TDURLStreamHandlerFactory.registerSelfIgnoreError();
    }
    Button gmbtest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavna);

        TDServer server = null;
        String filesDir = getFilesDir().getAbsolutePath();
        try {
            server = new TDServer(filesDir);
        } catch (IOException e) {
            Log.e("TouchDB:", "Pogreska prilikom povezivanja", e);
        }

        HttpClient httpClient = new TouchDBHttpClient(server);
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
        //final TextView tekst = (TextView) findViewById(R.id.tekst1);
        gmbtest = (Button) findViewById(R.id.btntest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.glavna, menu);
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
}
