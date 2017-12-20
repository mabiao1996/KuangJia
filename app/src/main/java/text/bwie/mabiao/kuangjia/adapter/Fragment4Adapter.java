package text.bwie.mabiao.kuangjia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import text.bwie.mabiao.kuangjia.R;

/**
 * Created by mabiao on 2017/12/19.
 */

public class Fragment4Adapter extends BaseExpandableListAdapter {
    private Context context;
    private  String group[];
    private  String child[][];

    public Fragment4Adapter(Context context, String[] group, String[][] child) {
        this.context = context;
        this.group = group;
        this.child = child;
    }

    /**
     *获取组的个数
     * @return
     */
    @Override
    public int getGroupCount() {
        return group.length;
    }

    /**
     * 获取子元素的个数
     * @param groupPosition
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return child[groupPosition].length;
    }
    /**
     * 获取组的内容
     * @param groupPosition
     * @return
     */
    @Override
    public Object getGroup(int groupPosition) {
        return group[groupPosition];
    }
    /**
     * 获取孩子的内容
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child[groupPosition][childPosition];
    }

    /**
     * 获取组的id
     * @param groupPosition
     * @return
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * 获取子元素的id
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    /**
     * 获取组的界面
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Houlder h=null;
        if(convertView==null){
            h=new Houlder();
            convertView= LayoutInflater.from(context).inflate(R.layout.group,null);
            h.mGroup_name=convertView.findViewById(R.id.group_text);
            convertView.setTag(h);
        }else{
            h= (Houlder) convertView.getTag();
        }
        h.mGroup_name.setText(group[groupPosition]);
        return convertView;
    }
    public class Houlder{
        public TextView mGroup_name;
    }
    /**
     * 获取子元素的界面
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       Houlders houlders;
       if(convertView==null){
           houlders=new Houlders();
           convertView=LayoutInflater.from(context).inflate(R.layout.child,null);
          houlders.mCilde_name=convertView.findViewById(R.id.child_text);
          convertView.setTag(houlders);
       }else{
           houlders= (Houlders) convertView.getTag();
       }
       houlders.mCilde_name.setText(child[groupPosition][childPosition]);
      return convertView;
    }
    public class Houlders{
        public TextView mCilde_name;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
