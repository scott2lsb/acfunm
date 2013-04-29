
package tv.avfun.adapter;

import java.util.List;

import tv.avfun.R;
import tv.avfun.R.id;
import tv.avfun.R.layout;
import tv.avfun.entity.Contents;
import tv.avfun.util.lzlist.ImageLoader;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChannelContentListAdaper extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Contents> data;
    public ImageLoader     imageLoader;

    public ChannelContentListAdaper(Context context, List<Contents> data) {
        this.mInflater = LayoutInflater.from(context);
        this.data = data;
        imageLoader = ImageLoader.getInstance();
    }

    public void setData(List<Contents> data) {
        this.data = data;
    }

    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public Object getItem(int arg0) {

        return data.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {

        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ListViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.channellist_content_item, null);
            holder = new ListViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.channellist_item_img);
            holder.title = (TextView) convertView.findViewById(R.id.channellist_content_item_title);
            holder.views = (TextView) convertView.findViewById(R.id.channelist_content_item_views);
            holder.upman = (TextView) convertView.findViewById(R.id.channelist_content_item_upman);
            holder.dr = (LinearLayout) convertView.findViewById(R.id.channelist_content_dr);
            convertView.setTag(holder);
        } else {
            holder = (ListViewHolder) convertView.getTag();
        }
        if (position == 9) {
            holder.dr.setVisibility(View.VISIBLE);
        } else {
            holder.dr.setVisibility(View.GONE);
        }

        final Contents art = data.get(position);
        holder.title.setText(art.getTitle());
        holder.views.setText(String.valueOf(art.getViews()));
        String up = art.getUsername();
        holder.upman.setText(TextUtils.isEmpty(up)?"无名氏":up);
        final String imageUrl = art.getTitleImg();
        if (imageUrl != "null" && !"".equals(imageUrl)) {
            holder.img.setTag(imageUrl);
            imageLoader.displayImage(imageUrl, holder.img);
        }
        return convertView;

    }

    static class ListViewHolder {

        ImageView    img;
        TextView     title;
        TextView     views;
        TextView     upman;
        LinearLayout dr;
    }

}