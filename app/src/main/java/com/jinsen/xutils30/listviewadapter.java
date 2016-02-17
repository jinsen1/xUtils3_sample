package com.jinsen.xutils30;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jinsen-a on 2016/1/5.
 * android studio 测试提交
 * 这个是一个adapter
 */
public class listviewadapter extends BaseAdapter {

    private List<String> mList;
    private String text;
    private LayoutInflater mlaLayoutInflater;

    public listviewadapter(Context context, List<String> mList) {
        this.mList = mList;
        mlaLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        text = mList.get(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mlaLayoutInflater.inflate(R.layout.layout, null);
            viewHolder.mTextvierw = (TextView) convertView.findViewById(R.id.tv_text);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (!TextUtils.isEmpty(text)){
            viewHolder.mTextvierw.setText(text);
            viewHolder.test();
        }
        return convertView;
    }


    static  class ViewHolder{
        TextView mTextvierw;
        int i = 0;
         void  test(){
             Log.e("jinsen","-=----------"+i+++"------------------" );
        }
    }

}
