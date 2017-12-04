package text.bwie.mabiao.kuangjia.utils;

import android.content.Context;
import android.content.SharedPreferences;

import text.bwie.mabiao.kuangjia.app.Myapp;

/**
 * Created by mabiao on 2017/11/29.
 */

public class SPutils {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SPutils (String s){
        preferences = Myapp.context.getSharedPreferences(s, Context.MODE_PRIVATE);
        this.editor = preferences.edit();
    }

    /**
     * -----------------------------------向sp中添加数据--------------------------------------------
     * 向SP存入指定key对应的数据
     * 其中value可以是String、boolean、float、int、long等各种基本类型的值
     * @param key
     * @param v
     */

   public void putSting(String key,String v){
        editor.putString(key,v).commit();
   }
    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

/**
 * --------------------------------------清空sp里所有数据----------------------------------------
 */
public  void  clear(){
    editor.clear().commit();
}
/**
 * --------------------------------------删除sp里指定key对应的数据项----------------------------------------
 */

public void remover(String key){
    editor.remove(key);
    editor.commit();
}
/**
 * --------------------------------------获取sp里面的值-------------------------------------------------
 * 获取SP数据里指定key对应的value。如果key不存在，则返回默认值defValue。
 */
public String getString(String key,String defvalue){
    return preferences.getString(key,defvalue);
}
public boolean getBoolean(String key, boolean defValue) {
    return preferences.getBoolean(key, defValue);
}
public float getFloat(String key, float defValue) {
    return preferences.getFloat(key, defValue);
}
public int getInt(String key, int defValue) {
    return preferences.getInt(key, defValue);
}
public long getLong(String key, long defValue) {
    return preferences.getLong(key, defValue);
}
/**
 * --------------------------------判断sp是否包含特定key的数据--------------------------------------------
 */
public boolean contains(String key){
    return preferences.contains(key);
}


}
