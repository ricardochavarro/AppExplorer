package co.com.appexplorer.feedlist;

/**
 * Created by Ricardo on 2/06/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;
import java.util.Map;

import at.blogc.android.views.ExpandableTextView;
import co.com.appexplorer.ApplicationController;
import co.com.appexplorer.CategoryExplorerActivity;
import co.com.appexplorer.R;
import co.com.appexplorer.util.Constants;
import co.com.appexplorer.util.dto.Category;
import co.com.appexplorer.util.dto.Entry;
import co.com.appexplorer.util.dto.ImImage;

public class FeedListCategoryAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Category> feedItems;

    public FeedListCategoryAdapter(Activity activity, List<Category> feedItems) {
        this.activity = activity;
        this.feedItems = feedItems;
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return feedItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        final Category feedItem = feedItems.get(position);
        final FeedItemCategoriaViewHolder viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_categorias_layout, null);
            viewHolder = new FeedItemCategoriaViewHolder();

            viewHolder.tvNombreCategoria = (TextView) convertView.findViewById(R.id.tvNombreCategoria);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (FeedItemCategoriaViewHolder) convertView.getTag();
        }

        viewHolder.tvNombreCategoria.setText(feedItem.getAttributes().getLabel());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplicationController.setCategoriaExplora(feedItem);
                Intent intentExplorarCategoria = new Intent(activity, CategoryExplorerActivity.class);
                activity.startActivity(intentExplorarCategoria);
            }
        });

        return convertView;
    }

    private String getAppImageURL(Entry feedItem) {
        for(ImImage image : feedItem.getImImage()){
            if(image.getAttributes().getHeight().equals(Constants.IMG_HEIGHT_LIST)){
                return image.getLabel();
            }
        }
        return null;
    }

}