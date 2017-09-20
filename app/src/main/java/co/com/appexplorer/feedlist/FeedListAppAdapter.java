package co.com.appexplorer.feedlist;

/**
 * Created by Ricardo on 2/06/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import at.blogc.android.views.ExpandableTextView;
import co.com.appexplorer.ApplicationController;
import co.com.appexplorer.R;
import co.com.appexplorer.util.Constants;
import co.com.appexplorer.util.dto.Entry;
import co.com.appexplorer.util.dto.ImImage;

public class FeedListAppAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Entry> feedItems;

    ImageLoader imageLoader;

    public FeedListAppAdapter(Activity activity, List<Entry> feedItems) {
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

        if(imageLoader == null){
            imageLoader = ApplicationController.getInstance().getImageLoader();
        }

        Entry feedItem = feedItems.get(position);
        final FeedItemViewHolder viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item_layout, null);
            viewHolder = new FeedItemViewHolder();

            viewHolder.ivIconoApp = (NetworkImageView) convertView.findViewById(R.id.ivIconoApp);
            viewHolder.tvNombreApp = (TextView) convertView.findViewById(R.id.tvNombreApp);
            viewHolder.tvResumenApp = (ExpandableTextView) convertView.findViewById(R.id.tvResumenApp);
            viewHolder.tvPrecio = (TextView) convertView.findViewById(R.id.tvPrecio);
            viewHolder.tvCategoriaApp = (TextView) convertView.findViewById(R.id.tvCategoriaApp);
            viewHolder.tvExpandableAction = (TextView) convertView.findViewById(R.id.tvExpandableAction);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (FeedItemViewHolder) convertView.getTag();
        }

        viewHolder.ivIconoApp.setImageUrl(getAppImageURL(feedItem), imageLoader);
        viewHolder.tvNombreApp.setText(feedItem.getImName().getLabel());
        viewHolder.tvResumenApp.setText(feedItem.getSummary().getLabel());
        viewHolder.tvPrecio.setText(feedItem.getImPrice().getLabel());
        viewHolder.tvCategoriaApp.setText(feedItem.getCategory().getAttributes().getTerm());

        viewHolder.tvExpandableAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.tvResumenApp.toggle();
                viewHolder.tvExpandableAction.setText(viewHolder.tvResumenApp.isExpanded() ? R.string.ver_mas : R.string.ver_menos);
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