package com.forsafe.prober.monitor.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.vondear.rxtool.RxImageTool;

/**
 * 针对 include_title_bar.xml 的 Toobar 中 RelativeLayout 布局中添加控件的 Manager
 * (简言之，Toobar添加标题和左右菜单的方法)
 *
 * @author Forsafe06
 *
 */
public class ToolBarManager {
    Context   context;
    ViewGroup parentView;
    int       viewGroupHeight;
    int       viewGroupWidth;


    public ToolBarManager(Context context, ViewGroup parentView) {
        this.context = context;
        this.parentView = parentView;
        getViewGroupHeightAndWidth();
    }

    private void getViewGroupHeightAndWidth() {
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        parentView.measure(w, h);
        viewGroupHeight = parentView.getMeasuredHeight();
        viewGroupWidth = parentView.getMeasuredWidth();
    }

    /**
     * 添加标题
     *
     * @param titleString
     */
    public TextView addTvCenter(String titleString) {
        return addTvCenter(titleString, null);
    }
    public TextView addTvCenter(String titleString, OnClickListener clickListener) {
        return addTvCenter(titleString,RxImageTool.dp2px(5),RxImageTool.dp2px(0),RxImageTool.dp2px(5),RxImageTool.dp2px(0),clickListener);
    }
    public TextView addTvCenter(String titleString,int pl,int pt,int pr,int pb , OnClickListener clickListener) {
        // 添加标题
        TextView tv_center = new TextView(context);
        tv_center.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                                                   LayoutParams.MATCH_PARENT)); // 设置图片宽高
        LayoutParams tv_center_params = (LayoutParams) tv_center.getLayoutParams();
        tv_center_params.addRule(RelativeLayout.CENTER_IN_PARENT);
        tv_center.setLayoutParams(tv_center_params);
        tv_center.setGravity(Gravity.CENTER);
        tv_center.setPadding(pl, pt, pr, pb);
        tv_center.setText(titleString);
        tv_center.setTextColor(Color.WHITE);
        tv_center.setTextSize(18);
        tv_center.setOnClickListener(clickListener);
        parentView.addView(tv_center);
        return tv_center;
    }

    /**
     * 添加左文字菜单
     *
     * @param leftString
     */
    public TextView addTvLeft(String leftString) {
        return addTvLeft(leftString, null);
    }
    public TextView addTvLeft(String leftString, OnClickListener clickListener) {
        return addTvLeft(leftString,RxImageTool.dp2px(5),RxImageTool.dp2px(0),RxImageTool.dp2px(5),RxImageTool.dp2px(0),clickListener);
    }
    public TextView addTvLeft(String leftString,int pl,int pt,int pr,int pb , OnClickListener clickListener) {
        // 添加左文字菜单
        TextView tv_left = new TextView(context);
        tv_left.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                                                 LayoutParams.MATCH_PARENT)); // 设置图片宽高
        LayoutParams tv_left_params = (LayoutParams) tv_left.getLayoutParams();
        tv_left_params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        tv_left_params.addRule(RelativeLayout.CENTER_VERTICAL);
        tv_left.setLayoutParams(tv_left_params);
        tv_left.setGravity(Gravity.CENTER);
        tv_left.setPadding(pl, pt, pr, pb);
        tv_left.setText(leftString);
        tv_left.setTextColor(Color.WHITE);
        tv_left.setTextSize(18);
        tv_left.setOnClickListener(clickListener);
        parentView.addView(tv_left);
        return tv_left;
    }

    /**
     * 添加右文字菜单
     *
     * @param rightString
     */
    public TextView addTvRight(String rightString) {
        return addTvRight(rightString,null);
    }
    public TextView addTvRight(String rightString, OnClickListener clickListener) {
        return addTvRight(rightString,RxImageTool.dp2px(5),RxImageTool.dp2px(0),RxImageTool.dp2px(5),RxImageTool.dp2px(0),clickListener);
    }
    public TextView addTvRight(String rightString,int pl,int pt,int pr,int pb , OnClickListener clickListener) {
        // 添加右文字菜单
        TextView tv_right = new TextView(context);
        tv_right.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                                                  LayoutParams.MATCH_PARENT)); // 设置图片宽高
        LayoutParams tv_right_params = (LayoutParams) tv_right.getLayoutParams();
        tv_right_params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        tv_right_params.addRule(RelativeLayout.CENTER_VERTICAL);
        tv_right.setLayoutParams(tv_right_params);
        tv_right.setGravity(Gravity.CENTER);
        tv_right.setPadding(pl, pt, pr, pb);
        tv_right.setText(rightString);
        tv_right.setTextColor(Color.WHITE);
        tv_right.setTextSize(18);
        tv_right.setOnClickListener(clickListener);
        parentView.addView(tv_right);
        return tv_right;
    }

    /**
     * 添加左图标
     *
     * @param resourceId
     */
    public ImageView addIvLeft(int resourceId) {
        return addIvLeft(resourceId, null);
    }
    public ImageView addIvLeft(int resourceId, OnClickListener clickListener) {
        return addIvLeft(resourceId,RxImageTool.dp2px(5),RxImageTool.dp2px(5),RxImageTool.dp2px(5),RxImageTool.dp2px(5),clickListener);
    }
    public ImageView addIvLeft(int resourceId,int pl,int pt,int pr,int pb , OnClickListener clickListener) {
        // 添加左图标
        ImageView iv_left = new ImageView(context);
        iv_left.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                                                 viewGroupHeight / 8 * 7)); // 设置图片宽高
        LayoutParams iv_left_params = (LayoutParams) iv_left.getLayoutParams();
        iv_left_params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        iv_left_params.addRule(RelativeLayout.CENTER_VERTICAL);
        iv_left.setLayoutParams(iv_left_params);
        iv_left.setScaleType(ScaleType.FIT_CENTER);
        iv_left.setPadding(pl, pt, pr, pb);
        iv_left.setImageResource(resourceId);
        iv_left.setOnClickListener(clickListener);
        parentView.addView(iv_left);
        return iv_left;
    }

    /**
     * 添加右图标
     *
     * @param resourceId
     */
    public ImageView addIvRight(int resourceId) {
        return addIvRight(resourceId, null);
    }

    public ImageView addIvRight(int resourceId, OnClickListener clickListener) {
        return addIvRight(resourceId,RxImageTool.dp2px(5),RxImageTool.dp2px(5),RxImageTool.dp2px(5),RxImageTool.dp2px(5),clickListener);
    }
    public ImageView addIvRight(int resourceId,int pl,int pt,int pr,int pb ,OnClickListener clickListener) {
        // 添加右图标
        ImageView iv_right = new ImageView(context);
        iv_right.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                viewGroupHeight / 8 * 7));
        LayoutParams iv_right_params = (LayoutParams) iv_right.getLayoutParams();
        iv_right_params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        iv_right_params.addRule(RelativeLayout.CENTER_VERTICAL);
        iv_right.setLayoutParams(iv_right_params);
        iv_right.setScaleType(ScaleType.FIT_CENTER);
        iv_right.setPadding(pl, pt, pr, pb);
        iv_right.setImageResource(resourceId);
        iv_right.setOnClickListener(clickListener);
        parentView.addView(iv_right);
        return iv_right;
    }

    /**
     *
     * @param v
     */
    public void removeViews(View v) {
        parentView.removeView(v);
    }

    public void removeAllViews() {
        parentView.removeAllViews();
    }
}
