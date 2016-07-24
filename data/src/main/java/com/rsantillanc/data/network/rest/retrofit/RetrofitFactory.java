package com.rsantillanc.data.network.rest.retrofit;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.rsantillanc.data.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Renzo D. Santillán Ch. on 22/04/2016.10:56 AM
 * http://rsantillanc.pe.hu/me/
 */
public class RetrofitFactory {
    private static final String TAG = RetrofitFactory.class.getSimpleName();
    private static Context context;

    private static Retrofit create(GsonConverterFactory factory) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        // Define the interceptor, add authentication headers
//        Interceptor interceptor = new Interceptor() {
//            @Override
//            public okhttp3.Response intercept(Chain chain) throws IOException {
//                Request newRequest = chain.request().newBuilder()
//                        .addHeader("User-Agent", "Retrofit-Sample-App").build();
//                return chain.proceed(newRequest);
//            }
//        };
//
//
//        // Agrega un OkHttpClient
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.interceptors().add(interceptor);
//        OkHttpClient client = builder.build();

        //Return a retrofit instance
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(factory)
                .client(client)
                .build();
    }

    /**
     * Retorna la url a conectarse, obtenida desde los recursos de android
     * para medidas de seguridad.
     *
     * @return url base
     */
    private static String getBaseUrl() {
        StringBuilder url = new StringBuilder();
        url.append(getProtocol());
        url.append(getHost());
        url.append(getPort());
        url.append(getVersion());
        url.append(getService());
        Log.d(TAG, "url_base: " + url.toString());
        return url.toString();
    }

    public static APIService getApi(GsonConverterFactory factory, Context c) {
        context = c;
        return create(factory).create(APIService.class);
    }


    public GsonConverterFactory buildConverter() {
        return GsonConverterFactory.create();
    }

    public GsonConverterFactory buildConverter(Gson gsonBody) {
        return GsonConverterFactory.create(gsonBody);
    }

    static String getProtocol() {
        return context.getString(R.string.protocolo);
    }

    static String getHost() {
        return context.getString(R.string.host);
    }

    static String getPort() {
        return "";
    }

    static String getVersion() {
        return context.getString(R.string.version);
    }

    static String getService() {
        return "";
    }


}
