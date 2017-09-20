package co.com.appexplorer;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import co.com.appexplorer.feedlist.FeedListAppAdapter;
import co.com.appexplorer.feedlist.FeedListCategoryAdapter;
import co.com.appexplorer.util.Constants;
import co.com.appexplorer.util.dto.Category;
import co.com.appexplorer.util.dto.Entry;
import co.com.appexplorer.util.dto.Top;

public class MainActivity extends AppCompatActivity {

    ProgressDialog pDialog;
    ListView lvFeed;
    private MenuItem miSearch;
    private List<Category> categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pDialog = new ProgressDialog(this);
        lvFeed = (ListView) findViewById(R.id.lvFeed);

        pDialog.setMessage(getResources().getString(R.string.cargando));
        pDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                Constants.URL_API, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(Constants.TAG_JSON_ARRAY, response.toString());
                        pDialog.hide();

                        Gson gson = new Gson();
                        Top top = gson.fromJson(response.toString(), Top.class);

                        ApplicationController.setFeed(top);

                        cargarCategorias();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(Constants.TAG_JSON_ARRAY, "Error: " + error.getMessage());
                // hide the progress dialog
                pDialog.hide();
            }
        });

        ApplicationController.getInstance().addToRequestQueue(jsonObjReq, Constants.TAG_JSON_ARRAY);
    }

    private void cargarCategorias() {
        if(ApplicationController.getCategoriasAplicaciones() == null || categorias == null) {
            Top top = ApplicationController.getFeed();
            Map<String, List<Entry>> categoriasApplicaciones = new HashMap<>();
            categorias = new ArrayList<>();

            for (Entry entry : top.getFeed().getEntry()) {
                List<Entry> entradas = categoriasApplicaciones.get(entry.getCategory().getAttributes().getImId());
                if (entradas == null) {
                    List<Entry> entradasCategoria = new ArrayList<>();
                    entradasCategoria.add(entry);
                    categoriasApplicaciones.put(entry.getCategory().getAttributes().getImId(), entradasCategoria);
                } else {
                    entradas.add(entry);
                }

                if (!categorias.contains(entry.getCategory())) {
                    categorias.add(entry.getCategory());
                }
            }

            ApplicationController.setCategoriasAplicaciones(categoriasApplicaciones);
        }

        FeedListCategoryAdapter adapter = new FeedListCategoryAdapter(MainActivity.this, categorias);
        lvFeed.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        miSearch = menu.findItem(R.id.menu_item_search);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =  (SearchView) miSearch.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                buscarApp(newText);
                return false;
            }
        });

        return true;
    }

    private void buscarApp(String text) {
        if(text.isEmpty()){
            cargarCategorias();
            return;
        }

        List<Entry> itemsResultado = new ArrayList<>();
        Top top = ApplicationController.getFeed();
        for(Entry entry : top.getFeed().getEntry()){
            if(entry.getImName().getLabel().toLowerCase().contains(text.toLowerCase())){
                itemsResultado.add(entry);
            }
        }

        if(!itemsResultado.isEmpty()){
            FeedListAppAdapter adapter = new FeedListAppAdapter(MainActivity.this, itemsResultado);
            lvFeed.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
