package com.example.dev.toolbar;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SeachableResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seachable_result);

        Toolbar toolbar = (Toolbar) findViewById(R.id.search_result);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String query = new String();
        Intent searchIntent = getIntent();
        if(Intent.ACTION_SEARCH.equals(searchIntent.getAction())){
            query = searchIntent.getStringExtra(SearchManager.QUERY);
            getSupportActionBar().setTitle(query);
            Toast.makeText(SeachableResultActivity.this,query,Toast.LENGTH_SHORT).show();
        }

        String[] counties = getResources().getStringArray(R.array.countries);
        List<String> country = new ArrayList<>();
        for(int i=0;i<counties.length;i++)
            if(counties[i].toLowerCase().contains(query.toLowerCase()))
                country.add(counties[i]);

        ListView listView = (ListView) findViewById(R.id.listView_result);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,country);
        listView.setAdapter(adapter);
    }
}
