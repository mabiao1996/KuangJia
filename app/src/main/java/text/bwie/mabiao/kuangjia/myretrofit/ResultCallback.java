package text.bwie.mabiao.kuangjia.myretrofit;

import com.google.gson.internal.$Gson$Types;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;

/**
 * Created by mabiao on 2017/11/29.
 */

public abstract class ResultCallback<T>
{
    Type type;
    static Type getSuperclassTypeParameter(Class<?> subclass){
        Type superclass =subclass.getGenericSuperclass();
        if(superclass instanceof Class){
            throw new RuntimeException("Missing type parameter");

        }
        ParameterizedType parameterized=(ParameterizedType)superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }
    public ResultCallback(){
        type=getSuperclassTypeParameter(getClass());
    }
    public abstract void onError(Throwable throwable);
    public abstract void onTokenFail();
    public abstract void onComplete();
    public abstract void onNext(ResponseBody responseBody, T t) throws IOException;
}
