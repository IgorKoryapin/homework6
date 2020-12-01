package igorkorapin;

import java.io.IOException;
import java.net.http.HttpClient;

public class WeatherApp {
    private static final String API_KEY = "zPzATjlbZZ2jwrKx62HaQzGXd8u2ykdM";
    private static final String HOST = "dataservice.accuweather.com";
    private static final String LOCATION_KEY = "474212_PC";
    private static final String FORECAST = "forecasts";
    private static final String DAILY = "daily";
    private static final String DAYS = "5days";
    private static final String V = "v1";

    public static void main(String[] args) throws IOException {
        OkHttpClient Client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder();
                .scheme("http").host(HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(V)
                .addPathSegment(DAILY)
                .addPathSegment(DAYS)
                .addPathSegment(LOCATION_KEY)
                .addQueryParameter("apikey",API_KEY)
                .addQueryParameter("language","ru-ru")
                .addQueryParameter("metric","true")
                .build();
        Request request = new  Reqeest.Builder()
                .addHeader("accept", "Application/Json")
                .url(url)
                .build();
        String JsR = client.newCall(request).execute().body().string();
        System.out.println(JsR);
    }

}
