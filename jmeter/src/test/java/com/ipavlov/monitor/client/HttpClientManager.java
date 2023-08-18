package com.ipavlov.monitor.client;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClientManager {

    public void httpClient() {
        var connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setValidateAfterInactivity(5000);
        // Increase max total connection to 1000
        connectionManager.setMaxTotal(1000); // connectionPoolSize
        // Increase default max connection per route to 20
        connectionManager.setDefaultMaxPerRoute(20);
    }

//    HttpClient httpClient = httpClient.execute(new HttpGet("uri"));
//    HttpResponse httpResponse = httpclient.execute(new HttpGet(uri));
//
//        if (httpResponse.getStatusLine().getStatusCode() != 200) {
//        throw new IOException("Error fetching file from " + uri + ": "
//                + httpResponse);
//    }

    PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
    PoolingHttpClientConnectionManager clientConnectionManager;
}