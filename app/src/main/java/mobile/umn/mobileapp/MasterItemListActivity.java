package mobile.umn.mobileapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import adapter.MasterItemListAdapter;
import entity.MasterItem;
import model.MasterItemRestClient;

public class MasterItemListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_item_list);
        new HttpRequestAsk().execute();
    }

    private class HttpRequestAsk extends AsyncTask<Void, Void, List<MasterItem>>{

        @Override
        protected List<MasterItem> doInBackground(Void... voids) {
            MasterItemRestClient masterItemRestClient = new MasterItemRestClient();
            return masterItemRestClient.findAll();
        }

        @Override
        protected void onPostExecute(List<MasterItem> masterItems) {
            ListView listViewMasterItem = (ListView) findViewById(R.id.listViewMasterItem);
            listViewMasterItem.setAdapter(new MasterItemListAdapter(getApplicationContext(), masterItems));
        }
    }
}
