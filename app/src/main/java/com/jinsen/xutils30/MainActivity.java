package com.jinsen.xutils30;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.jinsen.xutils30.view.CusListview;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 *这是一个测试类
 */
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.imageView)
    private ImageView imageView;
    @ViewInject(R.id.id_recyclerview)
    private CusListview mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        testDialog();
        x.Ext.init(getApplication());
        x.Ext.setDebug(true);
        x.view().inject(this);

//        xImage();
        List<String> mlist = new ArrayList<String>();
        for (int i = 0;i<100 ;i++){
            mlist.add("现在的数字是====>"+i);
        }
        listviewadapter mListviewadapter = new listviewadapter(this,mlist);
        mListView.setAdapter(mListviewadapter);

    }

    private void xImage() {
        ImageOptions imageOptions = new ImageOptions.Builder()
                .setSize(DensityUtil.dip2px(150), DensityUtil.dip2px(150))
                .setRadius(DensityUtil.dip2px(90)).setIgnoreGif(false)
                .setCrop(true).setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .build();

        x.image().bind(imageView, "http://hiphotos.baidu.com/exp/pic/item/d4239b35e5dde711c0676f80a5efce1b9c1661cb.jpg", imageOptions);
    }

    private void testDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Dialog");
        builder.setMessage("少数派客户端");
        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

}
