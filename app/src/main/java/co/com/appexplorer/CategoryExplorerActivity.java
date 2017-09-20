package co.com.appexplorer;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import co.com.appexplorer.feedlist.FeedListAppAdapter;
import co.com.appexplorer.util.dto.Category;
import co.com.appexplorer.util.dto.Entry;
import co.com.appexplorer.util.dto.Top;

public class CategoryExplorerActivity extends AppCompatActivity {

    private ListView lvFeed;
    private MenuItem miSearch;
    private List<Entry> aplicaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_explorer);

        lvFeed = (ListView) findViewById(R.id.lvFeed);

        cargarAplicacionesCategoria();
    }

    private void cargarAplicacionesCategoria() {
        Category categoriaSeleccionada = ApplicationController.getCategoriaExplora();

        setTitle(categoriaSeleccionada.getAttributes().getLabel());

        Map<String, List<Entry>> categoriasApplicaciones = ApplicationController.getCategoriasAplicaciones();

        aplicaciones = categoriasApplicaciones.get(categoriaSeleccionada.getAttributes().getImId());

        FeedListAppAdapter adapter = new FeedListAppAdapter(CategoryExplorerActivity.this, aplicaciones);
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
        List<Entry> itemsResultado = new ArrayList<>();
        for(Entry entry : aplicaciones){
            if(entry.getImName().getLabel().toLowerCase().contains(text.toLowerCase())){
                itemsResultado.add(entry);
            }
        }

        if(!itemsResultado.isEmpty()){
            FeedListAppAdapter adapter = new FeedListAppAdapter(CategoryExplorerActivity.this, itemsResultado);
            lvFeed.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
}
