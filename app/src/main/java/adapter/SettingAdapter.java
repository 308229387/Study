package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.activity.R;

import java.util.ArrayList;

import bean.Setting;

public class SettingAdapter extends BaseAdapter {
    private ArrayList<Setting> list;
    private Context context;
    private LayoutInflater inflater;

    public SettingAdapter(ArrayList<Setting> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.view_item_list_setting,
                    null);
            holder = new ViewHolder();
            holder.content_Layout = (LinearLayout) convertView
                    .findViewById(R.id.content_Layout);
            holder.title_TextView = (TextView) convertView
                    .findViewById(R.id.item_list_setting_title);
            holder.sub_TextView = (TextView) convertView
                    .findViewById(R.id.item_list_setting_sub);
            holder.tip_ImageView = (ImageView) convertView
                    .findViewById(R.id.item_list_setting_tip);
            holder.blank_View = (View) convertView
                    .findViewById(R.id.item_list_setting_blank);
            holder.loginout_ImageView = (ImageView) convertView
                    .findViewById(R.id.item_list_loginout);
            holder.up_View = (View) convertView.findViewById(R.id.item_list_up);
            holder.shortBottom_View = (View) convertView
                    .findViewById(R.id.item_list_shortBottom);
            holder.longBottom_View = (View) convertView
                    .findViewById(R.id.item_list_longBottom);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (list.get(position).isNeedBlank()) {
            holder.blank_View.setVisibility(View.VISIBLE);
        } else {
            holder.blank_View.setVisibility(View.GONE);
        }

        if (list.get(position).isNeedUp()) {
            holder.up_View.setVisibility(View.VISIBLE);
        } else {
            holder.up_View.setVisibility(View.GONE);
        }
        if (list.get(position).isShortOrLong()) {
            holder.longBottom_View.setVisibility(View.VISIBLE);
            holder.shortBottom_View.setVisibility(View.GONE);
        } else {
            holder.longBottom_View.setVisibility(View.GONE);
            holder.shortBottom_View.setVisibility(View.VISIBLE);
        }
        if (list.get(position).isNeedOut()) {
            holder.content_Layout.setVisibility(View.GONE);
            holder.loginout_ImageView.setVisibility(View.VISIBLE);
        } else {
            holder.content_Layout.setVisibility(View.VISIBLE);
            holder.loginout_ImageView.setVisibility(View.GONE);
        }
        if (list.get(position).getSub().equals("")) {
            holder.sub_TextView.setVisibility(View.GONE);
        } else {
            holder.sub_TextView.setVisibility(View.VISIBLE);
            holder.sub_TextView.setText(list.get(position).getSub());
        }
        if (list.get(position).isNeedTip()) {
            holder.tip_ImageView.setVisibility(View.VISIBLE);
        } else {
            holder.tip_ImageView.setVisibility(View.INVISIBLE);
        }
        holder.title_TextView.setText(list.get(position).getTitle());
        return convertView;
    }

    class ViewHolder {
        LinearLayout content_Layout;
        View blank_View;
        TextView title_TextView;
        TextView sub_TextView;
        ImageView tip_ImageView;
        ImageView loginout_ImageView;
        View up_View;
        View shortBottom_View;
        View longBottom_View;
    }

}
